/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SistemaGestionDO;

/**
 * @author GUILLERMO
 *
 */
@Remote
public interface ISistemaGestionService {
	List<SistemaGestionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	SistemaGestionDO save( SistemaGestionDO item );
	SistemaGestionDO update( SistemaGestionDO item );
	SistemaGestionDO getItem( Integer id );	
}
