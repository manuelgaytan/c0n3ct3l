/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ConcentradoCapacitacionDO;

/**
 * @author GUILLERMO
 *
 */
@Remote
public interface IConcentradoCapacitacionService {
	List<ConcentradoCapacitacionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	ConcentradoCapacitacionDO save( ConcentradoCapacitacionDO item );
	ConcentradoCapacitacionDO update( ConcentradoCapacitacionDO item );
	ConcentradoCapacitacionDO getItem( Integer id );	
}
