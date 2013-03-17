/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.MovimientoPagoContableServicioDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IMovimientoPagoContableServicioService {

	List<MovimientoPagoContableServicioDO> getAll();
	void deleteItems( List<Integer> idsItems);
	MovimientoPagoContableServicioDO save( MovimientoPagoContableServicioDO item );
	MovimientoPagoContableServicioDO update( MovimientoPagoContableServicioDO item );
	MovimientoPagoContableServicioDO getItem( Integer id );
	
}
