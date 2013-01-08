/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.CotizacionDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface ICotizacionService {

	List<CotizacionDO> getAll();
	void deleteItems( List<Integer> idsItems);
	CotizacionDO save( CotizacionDO item );
	CotizacionDO update( CotizacionDO item );
	CotizacionDO getItem( Integer id );
}
