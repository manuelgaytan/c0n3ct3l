package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.FacturaProveedorDO;
import mx.com.gahm.conenctel.entities.NotaCreditoProveedorDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.services.INotaCreditoProveedorService;

@Stateless(mappedName = "ejb/NotaCreditoProveedorService")
public class NotaCreditoProveedorService implements INotaCreditoProveedorService{
	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NotaCreditoProveedorDO> getAll() {
		List<NotaCreditoProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("NotaCreditoProveedorDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		NotaCreditoProveedorDO NotaCreditoProveedorDO=null;
		for (Integer id : idsItems) {
			 NotaCreditoProveedorDO = entityManager.find(NotaCreditoProveedorDO.class, id);
			
			
			if(NotaCreditoProveedorDO!=null){
				entityManager.remove(NotaCreditoProveedorDO);
			}
		}
		
	}

	@Override
	public NotaCreditoProveedorDO save(NotaCreditoProveedorDO item) {
	    try {
	    	entityManager.persist(item);
	    	this.validarEnvioNotificaciones(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	return item;
	}

	private void validarEnvioNotificaciones(NotaCreditoProveedorDO notaCreditoProveedor) {
		if( notaCreditoProveedor == null ||
			(notaCreditoProveedor.getProveedorCalificado() == null &&
			 notaCreditoProveedor.getProveedorMaquilador() == null) ){
			return;
		}
		String mensaje = null;
		if( notaCreditoProveedor.getProveedorCalificado() != null ){
			mensaje = NotificacionDO.NOTA_CREDITO_PROVEEDOR_BIENES_SERVICIOS_TESORERIA + notaCreditoProveedor.getProveedorCalificado().getId();
		}
		if( notaCreditoProveedor.getProveedorMaquilador() != null ){
			mensaje = NotificacionDO.NOTA_CREDITO_PROVEEDOR_MAQUILADO_TESORERIA + notaCreditoProveedor.getProveedorMaquilador().getId();
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
	
	@Override
	public NotaCreditoProveedorDO update(NotaCreditoProveedorDO item) {
		entityManager.merge(item);
		
		return item;
	}

	@Override
	public NotaCreditoProveedorDO getItem(Integer id) {
		NotaCreditoProveedorDO NotaCreditoProveedorDO=null;
		try {
			NotaCreditoProveedorDO = entityManager.find(NotaCreditoProveedorDO.class, id);
		} catch (Exception e) {
			NotaCreditoProveedorDO =null;
		}
		
		return NotaCreditoProveedorDO;
	}
	
	public List<NotaCreditoProveedorDO> getAllByIdMaquilador(long idMaquilador) {
		List<NotaCreditoProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("NotaCreditoProveedorDO.getNotaCreditoByIdMaquilador");
		query.setParameter("idMaquilador", idMaquilador);
		datos = query.getResultList();
		return datos;
	}
	
	public List<NotaCreditoProveedorDO> getAllByIdCalificado(long idCalificado) {
		List<NotaCreditoProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("NotaCreditoProveedorDO.getNotaCreditoByIdCalificado");
		query.setParameter("idCalificado", idCalificado);
		datos = query.getResultList();
		return datos;
	}
}
