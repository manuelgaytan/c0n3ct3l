/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioPagoMovimientoPagoContableServicioDO;
import mx.com.gahm.conenctel.entities.PagoMovimientoPagoContableServicioDO;
import mx.com.gahm.conenctel.services.IPagoMovimientoPagoContableServicioService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/PagoMovimientoPagoContableServicioService")
public class PagoMovimientoPagoContableServicioService implements IPagoMovimientoPagoContableServicioService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<PagoMovimientoPagoContableServicioDO> getAll() {
		List<PagoMovimientoPagoContableServicioDO> datos= null;
		TypedQuery<PagoMovimientoPagoContableServicioDO>  query =null;
		query = entityManager.createNamedQuery("PagoMovimientoPagoContableServicioDO.findAll",PagoMovimientoPagoContableServicioDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		PagoMovimientoPagoContableServicioDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public PagoMovimientoPagoContableServicioDO save(PagoMovimientoPagoContableServicioDO item) {
		List<ComentarioPagoMovimientoPagoContableServicioDO> comentarios =item.getComentarioPagoMovimientoPagoContableServicio();
		item.setComentarioPagoMovimientoPagoContableServicio(null);
		entityManager.persist(item);
		if(comentarios!=null)
		saveComentarios(item,comentarios);
		
		return item;
	}
	
	private void saveComentarios(PagoMovimientoPagoContableServicioDO item,List<ComentarioPagoMovimientoPagoContableServicioDO> comentarios){
		
		for (ComentarioPagoMovimientoPagoContableServicioDO dato : comentarios) {
			entityManager.persist(dato.getComentarioTesoreria());
			dato.setPagoMovimientoPagoContableServicio(item);
			entityManager.persist(item);
		}
		
		item.setComentarioPagoMovimientoPagoContableServicio(comentarios);
	}

	@Override
	public PagoMovimientoPagoContableServicioDO update(PagoMovimientoPagoContableServicioDO item) {
		deleteComentarios(item.getId());
		List<ComentarioPagoMovimientoPagoContableServicioDO> comentarios =item.getComentarioPagoMovimientoPagoContableServicio();
		item.setComentarioPagoMovimientoPagoContableServicio(null);
		entityManager.merge(item);
		if(comentarios!=null)
			saveComentarios(item,comentarios);
		return item;
	}
	
	private void deleteComentarios(Integer idPago){
		
		PagoMovimientoPagoContableServicioDO pago=getItem(idPago);
		
		for (ComentarioPagoMovimientoPagoContableServicioDO dato :pago.getComentarioPagoMovimientoPagoContableServicio()) {
			entityManager.remove(dato);
			entityManager.remove(dato.getComentarioTesoreria());
		}
		
	}
	

	@Override
	public PagoMovimientoPagoContableServicioDO getItem(Integer id) {
		PagoMovimientoPagoContableServicioDO cotizacion = entityManager.find(PagoMovimientoPagoContableServicioDO.class,id);
		return cotizacion;
	}


}
