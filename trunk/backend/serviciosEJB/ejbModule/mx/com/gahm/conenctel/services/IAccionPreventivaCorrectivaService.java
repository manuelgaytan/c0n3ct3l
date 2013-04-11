/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.AccionPreventivaCorrectivaDO;

/**
 * @author GUILLERMO
 *
 */
@Remote
public interface IAccionPreventivaCorrectivaService {
	List<AccionPreventivaCorrectivaDO> getAll();
	void deleteItems( List<Integer> idsItems);
	AccionPreventivaCorrectivaDO save( AccionPreventivaCorrectivaDO item );
	AccionPreventivaCorrectivaDO update( AccionPreventivaCorrectivaDO item );
	AccionPreventivaCorrectivaDO getItem( Integer id );	
}
