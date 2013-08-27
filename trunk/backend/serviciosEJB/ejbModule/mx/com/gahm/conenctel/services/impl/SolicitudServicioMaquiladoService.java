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

import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.RequisicionCompraDO;
import mx.com.gahm.conenctel.entities.SolicitudServicioMaquiladoDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.services.ISolicitudServicioMaquiladoService;

/**
 * @author MHDolores
 * 
 */
@Stateless(mappedName = "ejb/SolicitudServicioMaquiladoService")
public class SolicitudServicioMaquiladoService implements
		ISolicitudServicioMaquiladoService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<SolicitudServicioMaquiladoDO> getAll() {
		List<SolicitudServicioMaquiladoDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("SolicitudServicioMaquiladoDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		SolicitudServicioMaquiladoDO solicitudServicioMaquiladoDO = null;
		for (Integer id : idsItems) {
			query = entityManager.createNamedQuery("OrdenCompraDO.findById");
			query.setParameter("id", id);
			solicitudServicioMaquiladoDO = (SolicitudServicioMaquiladoDO) query
					.getSingleResult();
			if (solicitudServicioMaquiladoDO != null) {
				entityManager.remove(solicitudServicioMaquiladoDO);
			}
		}

	}

	@Override
	public SolicitudServicioMaquiladoDO save(SolicitudServicioMaquiladoDO item) {
		try {
			entityManager.persist(item);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.validarEnvioNotificaciones(item);
		return item;
	}
	
	private void validarEnvioNotificaciones(SolicitudServicioMaquiladoDO item) {
		if( item == null ){
			return;
		}
		String mensaje = null;
		mensaje = NotificacionDO.SOLICITUD_SERVICIO_MAQUILADO_CREACION + item.getId();
		this.enviarNotificacion(PerfilDO.ID_COMPRAS, mensaje);
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
	public SolicitudServicioMaquiladoDO update(SolicitudServicioMaquiladoDO item) {
		entityManager.merge(item);

		return item;
	}

	@Override
	public SolicitudServicioMaquiladoDO getItem(Integer id) {
		SolicitudServicioMaquiladoDO solicitudServicioMaquiladoDO=null;
		try {
			//solicitudServicioMaquiladoDO = entityManager.find(SolicitudServicioMaquiladoDO.class, id);
			Query query = null;
			query = entityManager.createNamedQuery("SolicitudServicioMaquiladoDO.findById");
			query.setParameter("id", id);
			solicitudServicioMaquiladoDO = (SolicitudServicioMaquiladoDO) query.getSingleResult();
		} catch (Exception e) {
			solicitudServicioMaquiladoDO =null;
		}
		
		return solicitudServicioMaquiladoDO;
	}

}
