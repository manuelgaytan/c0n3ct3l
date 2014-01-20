/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ComentarioCuentasPagarFacturacionDO;
import mx.com.gahm.conenctel.entities.ComentarioPagoProveedorDO;
import mx.com.gahm.conenctel.entities.ComentarioTesoreriaDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorPagoProveedorDO;
import mx.com.gahm.conenctel.entities.NotaCreditoProveedorPagoProveedorDO;
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
		List<ComentarioPagoProveedorDO> comentarios = item.getComentariosPagoProveedor();
		List<FacturaProveedorPagoProveedorDO> facturasProveedor = item.getFacturasProveedor();
		List<NotaCreditoProveedorPagoProveedorDO> notasCreditoProveedor = item.getNotasCreditoProveedor();
		item.setComentariosPagoProveedor(null);
		item.setFacturasProveedor(null);
		item.setNotasCreditoProveedor(null);
		entityManager.persist(item);
		if(comentarios != null){
			saveComentarios(item,comentarios);
		}
		saveFacturasProveedor(item, facturasProveedor);
		saveNotasCreditoProveedor(item, notasCreditoProveedor);
		return item;
	}
	
	private void saveNotasCreditoProveedor(PagoProveedorDO item,
			List<NotaCreditoProveedorPagoProveedorDO> notasCreditoProveedor) {
		if( notasCreditoProveedor == null ){
			return;
		}
		for (NotaCreditoProveedorPagoProveedorDO dato : notasCreditoProveedor) {
			dato.setPagoProveedor( item );
			entityManager.persist( dato );
		}
		item.setNotasCreditoProveedor(notasCreditoProveedor);
	}

	private void saveFacturasProveedor(PagoProveedorDO item,
			List<FacturaProveedorPagoProveedorDO> facturasProveedor) {
		if( facturasProveedor == null ){
			return;
		}
		for (FacturaProveedorPagoProveedorDO dato : facturasProveedor) {
			dato.setPagoProveedor( item );
			entityManager.persist( dato );
		}
		item.setFacturasProveedor(facturasProveedor);
	}

	private void saveComentarios(PagoProveedorDO item,List<ComentarioPagoProveedorDO> comentarios){
		if( comentarios == null ){
			return;
		}
		for (ComentarioPagoProveedorDO dato : comentarios) {
			ComentarioTesoreriaDO comentarioTesoreria = dato.getComentarioTesoreria();
			entityManager.persist( comentarioTesoreria );
			dato.setComentarioTesoreria( comentarioTesoreria );
			dato.setPagoProveedor( item );
			entityManager.persist( dato );
		}
		item.setComentariosPagoProveedor(comentarios);
	}

	@Override
	public PagoProveedorDO update(PagoProveedorDO item) {
		deleteComentarios(item.getId());
		deleteFacturasProveedor(item.getId());
		deleteNotasCreditoProveedor(item.getId());
		List<ComentarioPagoProveedorDO> comentarios =item.getComentariosPagoProveedor();
		List<FacturaProveedorPagoProveedorDO> facturasProveedor = item.getFacturasProveedor();
		List<NotaCreditoProveedorPagoProveedorDO> notasCreditoProveedor = item.getNotasCreditoProveedor();
		item.setComentariosPagoProveedor(null);
		item.setFacturasProveedor(null);
		item.setNotasCreditoProveedor(null);
		entityManager.merge(item);
		if( comentarios!=null ){
			saveComentarios(item,comentarios);
		}
		saveFacturasProveedor(item, facturasProveedor);
		saveNotasCreditoProveedor(item, notasCreditoProveedor);
		return item;
	}
	
	private void deleteNotasCreditoProveedor(Integer id) {
		PagoProveedorDO pagoProveedor = getItem(id);
		if( pagoProveedor != null && pagoProveedor.getNotasCreditoProveedor() != null ){
			for (NotaCreditoProveedorPagoProveedorDO dato : pagoProveedor.getNotasCreditoProveedor()) {
				entityManager.remove(dato);
			}
		}
	}

	private void deleteFacturasProveedor(Integer id) {
		PagoProveedorDO pagoProveedor = getItem(id);
		if( pagoProveedor != null && pagoProveedor.getFacturasProveedor() != null ){
			for (FacturaProveedorPagoProveedorDO dato : pagoProveedor.getFacturasProveedor()) {
				entityManager.remove(dato);
			}
		}
	}

	private void deleteComentarios(Integer idPago){
		PagoProveedorDO pago=getItem(idPago);
		if( pago.getComentariosPagoProveedor() != null ){
			for (ComentarioPagoProveedorDO dato :pago.getComentariosPagoProveedor()) {
				entityManager.remove(dato);
			}
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
