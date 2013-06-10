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
import mx.com.gahm.conenctel.services.INotificacionService;

/**
 * @author Manuel Gaytan
 *
 */
@Stateless(mappedName = "ejb/NotificacionService")
public class NotificacionService  implements INotificacionService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<NotificacionDO> getAll() {
		List<NotificacionDO> datos= null;
		TypedQuery<NotificacionDO>  query =null;
		query = entityManager.createNamedQuery("NotificacionDO.findAll",NotificacionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		NotificacionDO notificacion = null;
		for (Integer id : idsItems) {
			notificacion = getItem(id);
			entityManager.remove(notificacion);
		}
		
	}

	@Override
	public NotificacionDO save(NotificacionDO item) {
		Date fechaHoraCreacion = new Date();
		item.setFechaHoraCreacion(fechaHoraCreacion );
		EstadoNotificacionDO estado = new EstadoNotificacionDO();
		estado.setId( EstadoNotificacionDO.ID_PENDIENTE );
		item.setEstado( estado  );
		item.setFechaHoraModificacion( null );
		item.setUsuarioModificacion( null );
		entityManager.persist(item);
		return item;
	}
	
	@Override
	public NotificacionDO update(NotificacionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public NotificacionDO getItem(Integer id) {
		NotificacionDO notificacion = entityManager.find(NotificacionDO.class,id);
		return notificacion;
	}

}
