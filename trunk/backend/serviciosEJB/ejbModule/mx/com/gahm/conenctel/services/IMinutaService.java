/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.MinutaDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IMinutaService {
	List<MinutaDO> getAll();
	void deleteItems( List<Integer> idsItems);
	MinutaDO save( MinutaDO item );
	MinutaDO update( MinutaDO item );
	MinutaDO getItem( Integer id );	
}
