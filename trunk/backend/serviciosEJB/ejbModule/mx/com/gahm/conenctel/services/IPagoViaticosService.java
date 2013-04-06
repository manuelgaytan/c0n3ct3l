/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.PagoViaticosDO;

/**
 * @author Guillermo
 *
 */
@Remote
public interface IPagoViaticosService {
	List<PagoViaticosDO> getAll();
	void deleteItems( List<Integer> idsItems);
	PagoViaticosDO save( PagoViaticosDO item );
	PagoViaticosDO update( PagoViaticosDO item );
	PagoViaticosDO getItem( Integer id );	
}
