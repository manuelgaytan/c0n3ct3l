/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.EstadisticaPersonalDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IEstadisticaPersonalService {

	List<EstadisticaPersonalDO> getAll();
	void deleteItems( List<Integer> idsItems);
	EstadisticaPersonalDO save( EstadisticaPersonalDO item );
	EstadisticaPersonalDO update( EstadisticaPersonalDO item );
	EstadisticaPersonalDO getItem( Integer id );	
	
}
