/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.PagoMovimientoPagoContableServicioDO;

/**
 * @author SEVEN
 *
 */
@Remote
public interface IPagoMovimientoPagoContableServicioService {
	List<PagoMovimientoPagoContableServicioDO> getAll();
	void deleteItems( List<Integer> idsItems);
	PagoMovimientoPagoContableServicioDO save( PagoMovimientoPagoContableServicioDO item );
	PagoMovimientoPagoContableServicioDO update( PagoMovimientoPagoContableServicioDO item );
	PagoMovimientoPagoContableServicioDO getItem( Integer id );	
}
