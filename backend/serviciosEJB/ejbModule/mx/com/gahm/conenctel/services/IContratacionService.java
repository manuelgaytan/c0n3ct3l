/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ContratacionDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IContratacionService {

	List<ContratacionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	ContratacionDO save( ContratacionDO item );
	ContratacionDO update( ContratacionDO item );
	ContratacionDO getItem( Integer id );	
}
