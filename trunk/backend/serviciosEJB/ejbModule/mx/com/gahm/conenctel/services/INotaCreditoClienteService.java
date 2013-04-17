/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;

/**
 * @author MHDolores
 *
 */
@Remote
public interface INotaCreditoClienteService {
	
	List<NotaCreditoClienteDO> getAll();
	void deleteItems( List<Integer> idsItems);
	NotaCreditoClienteDO save( NotaCreditoClienteDO item );
	NotaCreditoClienteDO update( NotaCreditoClienteDO item );
	NotaCreditoClienteDO getItem( Integer id );
	public List<NotaCreditoClienteDO> getAllByFiltro(Integer idCliente);

}
