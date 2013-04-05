/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.PagoOtraOperacionFinancieraDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IPagoOtraOperacionFinancieraService {
	List<PagoOtraOperacionFinancieraDO> getAll();
	void deleteItems( List<Integer> idsItems);
	PagoOtraOperacionFinancieraDO save( PagoOtraOperacionFinancieraDO item );
	PagoOtraOperacionFinancieraDO update( PagoOtraOperacionFinancieraDO item );
	PagoOtraOperacionFinancieraDO getItem( Integer id );	
}
