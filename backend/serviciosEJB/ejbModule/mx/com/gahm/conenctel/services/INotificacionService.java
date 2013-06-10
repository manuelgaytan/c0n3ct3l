/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.NotificacionDO;

/**
 * @author Manuel Gaytan
 *
 */
@Remote
public interface INotificacionService {
	List<NotificacionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	NotificacionDO save( NotificacionDO item );
	NotificacionDO update( NotificacionDO item );
	NotificacionDO getItem( Integer id );	
}
