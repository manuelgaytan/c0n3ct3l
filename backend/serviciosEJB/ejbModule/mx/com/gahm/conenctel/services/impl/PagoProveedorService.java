/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioPagoProveedorDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorDO;
import mx.com.gahm.conenctel.entities.PagoProveedorDO;
import mx.com.gahm.conenctel.services.IPagoProveedorService;

/**
 * @author SEVEN
 *
 */
@Stateless(mappedName = "ejb/PagoProveedorService")
public class PagoProveedorService implements IPagoProveedorService{
	
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<PagoProveedorDO> getAll() {
		List<PagoProveedorDO> datos= null;
		TypedQuery<PagoProveedorDO>  query =null;
		query = entityManager.createNamedQuery("PagoProveedorDO.findAll",PagoProveedorDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		PagoProveedorDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public PagoProveedorDO save(PagoProveedorDO item) {
		List<ComentarioPagoProveedorDO> comentarios =item.getComentarioPagoProveedor();
		item.setComentarioPagoProveedor(null);
		entityManager.persist(item);
		if(comentarios!=null)
		saveComentarios(item,comentarios);
		return item;
	}
	
	private void saveComentarios(PagoProveedorDO item,List<ComentarioPagoProveedorDO> comentarios){
		
		for (ComentarioPagoProveedorDO dato : comentarios) {
			entityManager.persist(dato.getComentarioTesoreria());
			dato.setPagoProveedor(item);
			entityManager.persist(item);
		}
		
		item.setComentarioPagoProveedor(comentarios);
	}

	@Override
	public PagoProveedorDO update(PagoProveedorDO item) {
		deleteComentarios(item.getId());
		List<ComentarioPagoProveedorDO> comentarios =item.getComentarioPagoProveedor();
		item.setComentarioPagoProveedor(null);
		entityManager.merge(item);
		if(comentarios!=null)
			saveComentarios(item,comentarios);
		return item;
	}
	
	private void deleteComentarios(Integer idPago){
		
		PagoProveedorDO pago=getItem(idPago);
		
		for (ComentarioPagoProveedorDO dato :pago.getComentarioPagoProveedor()) {
			entityManager.remove(dato);
			entityManager.remove(dato.getComentarioTesoreria());
		}
		
	}

	@Override
	public PagoProveedorDO getItem(Integer id) {
		PagoProveedorDO cotizacion = entityManager.find(PagoProveedorDO.class,id);
		return cotizacion;
	}

	
	public List<FacturaProveedorDO> getFacturasByIdCalificado(Integer idCalificado){
	
	List<FacturaProveedorDO> datos= null;
	TypedQuery<FacturaProveedorDO>  query =null;
	query = entityManager.createNamedQuery("FacturaProveedorDO.getFacturacionByICalificado",FacturaProveedorDO.class);
	query.setParameter("idMaquilador", idCalificado);
	datos = query.getResultList();
	
	return datos;
	
	}
	
	public List<FacturaProveedorDO> getFacturasByIdMaquilador(Integer idMaquilador){
		
		List<FacturaProveedorDO> datos= null;
		TypedQuery<FacturaProveedorDO>  query =null;
		query = entityManager.createNamedQuery("FacturaProveedorDO.getFacturacionByIdMaquilador",FacturaProveedorDO.class);
		query.setParameter("idMaquilador", idMaquilador);
		datos = query.getResultList();
		
		return datos;
		
		}
	
	
}
