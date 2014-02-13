/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.RegistroDeduccionDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IRegistroDeduccionService {
	List<RegistroDeduccionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	Boolean saveList(List<RegistroDeduccionDO> items);
	RegistroDeduccionDO save( RegistroDeduccionDO item );
	RegistroDeduccionDO update( RegistroDeduccionDO item );
	RegistroDeduccionDO getItem( Integer id );	
}
