/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioMovimientoPagoContableServicioDO;
import mx.com.gahm.conenctel.entities.ComentarioPagoViaticosDO;
import mx.com.gahm.conenctel.entities.MovimientoPagoContableServicioDO;
import mx.com.gahm.conenctel.entities.PagoViaticosDO;
import mx.com.gahm.conenctel.services.IPagoViaticosService;

/**
 * @author Guillermo
 *
 */
@Stateless(mappedName = "ejb/PagoViaticosService")
public class PagoViaticosService implements IPagoViaticosService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<PagoViaticosDO> getAll() {
		List<PagoViaticosDO> datos= null;
		TypedQuery<PagoViaticosDO>  query =null;
		query = entityManager.createNamedQuery("PagoViaticosDO.findAll",PagoViaticosDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		PagoViaticosDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public PagoViaticosDO save(PagoViaticosDO item) {
		List<ComentarioPagoViaticosDO> comentarios =item.getComentariosPagoViaticos();
		item.setComentariosPagoViaticos(null);
		entityManager.persist(item);
		saveComentarios(item,comentarios);
		return item;
	}
	
	private void saveComentarios(PagoViaticosDO item,List<ComentarioPagoViaticosDO> comentarios){
		if( comentarios != null ){
			for (ComentarioPagoViaticosDO comentario : comentarios) {
				entityManager.persist(comentario.getComentarioTesoreria());
				comentario.setPagoViaticos(item);
				entityManager.persist(comentario);
			}
		}
		item.setComentariosPagoViaticos(comentarios);
	}

	@Override
	public PagoViaticosDO update(PagoViaticosDO item) {
		deleteComentarios(item.getId());
		List<ComentarioPagoViaticosDO> comentarios =item.getComentariosPagoViaticos();
		item.setComentariosPagoViaticos(null);
		entityManager.merge(item);
		saveComentarios(item, comentarios);
		return item;
	}
	
	private void deleteComentarios(Integer id){
		PagoViaticosDO item = getItem(id);
		List<ComentarioPagoViaticosDO> comentarios = item.getComentariosPagoViaticos();
		if( comentarios != null ){
			for (ComentarioPagoViaticosDO comentario : comentarios) {
				entityManager.remove(comentario);
			}
		}
	}

	@Override
	public PagoViaticosDO getItem(Integer id) {
		PagoViaticosDO cotizacion = entityManager.find(PagoViaticosDO.class,id);
		return cotizacion;
	}

}
