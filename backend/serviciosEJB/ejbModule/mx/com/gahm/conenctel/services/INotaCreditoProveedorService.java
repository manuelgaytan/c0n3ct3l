/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.NotaCreditoProveedorDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface INotaCreditoProveedorService {

	List<NotaCreditoProveedorDO> getAll();
	void deleteItems( List<Integer> idsItems);
	NotaCreditoProveedorDO save( NotaCreditoProveedorDO item );
	NotaCreditoProveedorDO update( NotaCreditoProveedorDO item );
	NotaCreditoProveedorDO getItem( Integer id );

}
