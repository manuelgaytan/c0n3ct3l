/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioCuentasPagarFacturacionDO;
import mx.com.gahm.conenctel.entities.ComentarioFacturaProveedorDO;
import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.SistemaGestionDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.services.IFacturaProveedorService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/FacturaProveedorService")
public class FacturaProveedorService implements  IFacturaProveedorService{

	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FacturaProveedorDO> getAll() {
		List<FacturaProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("FacturaProveedorDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		FacturaProveedorDO FacturaProveedorDO=null;
		for (Integer id : idsItems) {
			 FacturaProveedorDO = entityManager.find(FacturaProveedorDO.class, id);
			
			
			if(FacturaProveedorDO!=null){
				entityManager.remove(FacturaProveedorDO);
			}
		}
		
	}

	@Override
	public FacturaProveedorDO save(FacturaProveedorDO item) {
		if( item != null ){
	    	List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor = item.getComentariosFacturaProveedor();
	    	item.setComentariosFacturaProveedor(null);
	    	entityManager.persist(item);
	    	saveComentariosFacturaProveedor(item,comentariosFacturaProveedor);
	    	this.validarEnvioNotificaciones(item);
		}
		return item;
	}
	
	private void saveComentariosFacturaProveedor(FacturaProveedorDO item,List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor) {
		if( comentariosFacturaProveedor == null ){
			return;
		}
    	for (ComentarioFacturaProveedorDO dato : comentariosFacturaProveedor) {
    		ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion = dato.getComentarioCuentasPagarFacturacion();
			entityManager.persist( comentarioCuentasPagarFacturacion );
			dato.setComentarioCuentasPagarFacturacion( comentarioCuentasPagarFacturacion );
			dato.setFacturaProveedor(item);
			entityManager.persist(dato);
		}
	}
	
	@Override
	public FacturaProveedorDO update(FacturaProveedorDO item) {
		deleteComentariosFacturaProveedor(item);
		List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor = item.getComentariosFacturaProveedor();
		item.setComentariosFacturaProveedor(null);
		this.colocarFacturaProveedor( item );
		entityManager.merge(item);
		saveComentariosFacturaProveedor(item, comentariosFacturaProveedor);
		item.setComentariosFacturaProveedor(comentariosFacturaProveedor);
		return item;
	}

	private void validarEnvioNotificaciones(FacturaProveedorDO facturacionProveedor) {
		if( facturacionProveedor == null ||
			(facturacionProveedor.getProveedorCalificado() == null &&
			 facturacionProveedor.getProveedorMaquilador() == null) ){
			return;
		}
		String mensaje = null;
		if( facturacionProveedor.getProveedorCalificado() != null ){
			mensaje = NotificacionDO.FACTURA_PROVEEDOR_BIENES_SERVICIOS_TESORERIA + facturacionProveedor.getProveedorCalificado().getId();
		}
		if( facturacionProveedor.getProveedorMaquilador() != null ){
			mensaje = NotificacionDO.FACTURA_PROVEEDOR_MAQUILADO_TESORERIA + facturacionProveedor.getProveedorMaquilador().getId();
		}
		this.enviarNotificacion(PerfilDO.ID_TESORERIA, mensaje);
	}
	
	private void enviarNotificacion(int idPerfil, String mensaje) {
		PerfilDO perfil = entityManager.find(PerfilDO.class, idPerfil);
		UsuarioDO usuario = entityManager.find(UsuarioDO.class, UsuarioDO.ID_AUTOMATICO);
		EstadoNotificacionDO estado = entityManager.find(EstadoNotificacionDO.class, EstadoNotificacionDO.ID_PENDIENTE);
		NotificacionDO notificacion = new NotificacionDO();
		notificacion.setPerfil(perfil);
		notificacion.setNotificacion(mensaje);
		notificacion.setUsuarioCreacion(usuario);
		notificacion.setFechaHoraCreacion(new Date());
		notificacion.setEstado(estado);
		entityManager.persist(notificacion);
	}
	
	private void colocarFacturaProveedor(FacturaProveedorDO item) {
		List<ComentarioFacturaProveedorDO> comentarios = item.getComentariosFacturaProveedor();
		if(comentarios!=null){
			for (ComentarioFacturaProveedorDO comentario : comentarios) {
				comentario.setFacturaProveedor( item );
			}
		}
	}

	private void deleteComentariosFacturaProveedor(FacturaProveedorDO itemParam) {
		FacturaProveedorDO item = entityManager.find(FacturaProveedorDO.class, itemParam.getId());
		if( item == null || item.getComentariosFacturaProveedor() == null){
			return;
		}
		for (ComentarioFacturaProveedorDO comentario : item.getComentariosFacturaProveedor()) {
			if(comentario!=null){
				entityManager.remove(comentario);
			}
		}
	}

	@Override
	public FacturaProveedorDO getItem(Integer id) {
		FacturaProveedorDO FacturaProveedorDO=null;
		try {
			FacturaProveedorDO = entityManager.find(FacturaProveedorDO.class, id);
		} catch (Exception e) {
			FacturaProveedorDO =null;
		}
		
		return FacturaProveedorDO;
	}
	
	public List<FacturaProveedorDO> getAllByIdMaquilador(long idMaquilador) {
		List<FacturaProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("FacturaProveedorDO.getFacturacionByIdMaquilador");
		query.setParameter("idMaquilador", idMaquilador);
		datos = query.getResultList();
		return datos;
	}
	
	public List<FacturaProveedorDO> getAllByIdCalificado(long idCalificado) {
		List<FacturaProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("FacturaProveedorDO.getFacturacionByIdCalificado");
		query.setParameter("idCalificado", idCalificado);
		datos = query.getResultList();
		return datos;
	}
}
