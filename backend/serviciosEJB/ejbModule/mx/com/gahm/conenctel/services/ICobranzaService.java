/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.CobranzaDO;
import mx.com.gahm.conenctel.entities.InformacionFacturacionDO;
import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;

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
	List<NotaCreditoClienteDO> getAllByFiltro(long idCliente );
	List<InformacionFacturacionDO> getInformacionFacturacionByCliente(long idCliente );
}
