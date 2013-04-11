/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.NoConformidadDO;

/**
 * @author SEVEN
 *
 */
@Remote
public interface INoConformidadService {
	List<NoConformidadDO> getAll();
	void deleteItems( List<Integer> idsItems);
	NoConformidadDO save( NoConformidadDO item );
	NoConformidadDO update( NoConformidadDO item );
	NoConformidadDO getItem( Integer id );
}
