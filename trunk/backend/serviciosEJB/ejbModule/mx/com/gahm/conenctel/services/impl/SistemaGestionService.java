/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.SistemaGestionDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.services.ISistemaGestionService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/SistemaGestionService")
public class SistemaGestionService implements ISistemaGestionService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SistemaGestionDO> getAll() {
		List<SistemaGestionDO> datos= null;
		TypedQuery<SistemaGestionDO>  query =null;
		query = entityManager.createNamedQuery("SistemaGestionDO.findAll",SistemaGestionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SistemaGestionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public SistemaGestionDO save(SistemaGestionDO item) {
		entityManager.persist(item);
		this.actualizarClaveAuditoria(item);
		this.validarEnvioNotificaciones(item);
		return item;
	}
	
	private void actualizarClaveAuditoria(SistemaGestionDO item) {
		if( item != null ){
			ProyectoDO proyectoDO = entityManager.find(ProyectoDO.class, item.getProyecto().getId());
			proyectoDO.setTipoAuditoria( item.getTipoAuditoria() );
			entityManager.merge( proyectoDO );
		}
	}

	private void validarEnvioNotificaciones(SistemaGestionDO sistemaGestion) {
		if( sistemaGestion == null ||
			!sistemaGestion.getAplicacionAuditoria() ){
			return;
		}
		String mensaje = null;
		mensaje = NotificacionDO.AUDITORIA_PROYECTO_APLICAR + sistemaGestion.getProyecto().getId();
		this.enviarNotificacion(PerfilDO.ID_GERENTE_OPERATIVO, mensaje);
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
	public SistemaGestionDO update(SistemaGestionDO item) {
		entityManager.merge(item);
		actualizarClaveAuditoria(item);
		return item;
	}

	@Override
	public SistemaGestionDO getItem(Integer id) {
		SistemaGestionDO cotizacion = entityManager.find(SistemaGestionDO.class,id);
		return cotizacion;
	}

}
