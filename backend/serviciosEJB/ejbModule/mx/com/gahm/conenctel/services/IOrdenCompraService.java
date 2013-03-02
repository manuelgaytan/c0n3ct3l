/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.OrdenCompraDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IOrdenCompraService {
	List<OrdenCompraDO> getAll();
	void deleteItems( List<Integer> idsItems);
	OrdenCompraDO save( OrdenCompraDO item );
	OrdenCompraDO update( OrdenCompraDO item );
	OrdenCompraDO getItem( Integer id );
	List<OrdenCompraDO> getOrdenCompraByProveedor(Long idProveedor);
}
