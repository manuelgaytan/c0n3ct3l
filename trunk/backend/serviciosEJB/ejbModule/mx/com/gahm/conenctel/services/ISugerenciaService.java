/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SugerenciaDO;

/**
 * @author GUILLERMO
 *
 */
@Remote
public interface ISugerenciaService {
	List<SugerenciaDO> getAll();
	void deleteItems( List<Integer> idsItems);
	SugerenciaDO save( SugerenciaDO item );
	SugerenciaDO update( SugerenciaDO item );
	SugerenciaDO getItem( Integer id );	
}
