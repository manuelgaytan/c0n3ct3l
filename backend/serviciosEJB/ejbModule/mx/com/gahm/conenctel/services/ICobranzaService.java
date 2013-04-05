/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.CobranzaDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ICobranzaService {

	List<CobranzaDO> getAll();
	void deleteItems( List<Integer> idsItems);
	CobranzaDO save( CobranzaDO item );
	CobranzaDO update( CobranzaDO item );
	CobranzaDO getItem( Integer id );	
}
