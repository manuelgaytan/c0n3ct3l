/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.InformacionConfidencialColaboradorDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IInformacionConfidencialColaboradorService {
	List<InformacionConfidencialColaboradorDO> getAll();
	void deleteItems( List<Integer> idsItems);
	InformacionConfidencialColaboradorDO save( InformacionConfidencialColaboradorDO item );
	InformacionConfidencialColaboradorDO update( InformacionConfidencialColaboradorDO item );
	InformacionConfidencialColaboradorDO getItem( Integer id );	
	
	
}
