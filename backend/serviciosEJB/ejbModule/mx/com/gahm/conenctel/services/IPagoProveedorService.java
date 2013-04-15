/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.PagoProveedorDO;

/**
 * @author SEVEN
 *
 */
@Remote
public interface IPagoProveedorService{
	
	List<PagoProveedorDO> getAll();
	void deleteItems( List<Integer> idsItems);
	PagoProveedorDO save( PagoProveedorDO item );
	PagoProveedorDO update( PagoProveedorDO item );
	PagoProveedorDO getItem( Integer id );	
}
