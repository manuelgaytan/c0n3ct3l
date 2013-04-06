/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.RegistroPercepcionDO;
import mx.com.gahm.conenctel.entities.RegistroPercepcionDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IRegistroPercepcionService {
	List<RegistroPercepcionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	RegistroPercepcionDO save( RegistroPercepcionDO item );
	RegistroPercepcionDO update( RegistroPercepcionDO item );
	RegistroPercepcionDO getItem( Integer id );	
}
