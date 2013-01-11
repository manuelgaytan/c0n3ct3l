/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.FacturaPorPagarDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IFacturaPorPagar {
	List<FacturaPorPagarDO> getAll();
	void deleteItems( List<Integer> idsItems);
	FacturaPorPagarDO save( FacturaPorPagarDO item );
	FacturaPorPagarDO update( FacturaPorPagarDO item );
	FacturaPorPagarDO getItem( Integer id );
}
