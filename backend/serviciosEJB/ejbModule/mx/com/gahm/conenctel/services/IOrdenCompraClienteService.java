package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.OrdenCompraClienteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

/**
 * @author GUILLERMOH
 *
 */
@Remote
public interface IOrdenCompraClienteService {
	public List<OrdenCompraClienteDO> getAll() throws ConectelException;
	public boolean deleteItems(List<Long> idsItems);
	public OrdenCompraClienteDO save(OrdenCompraClienteDO item);
	public OrdenCompraClienteDO update(OrdenCompraClienteDO item);
	public OrdenCompraClienteDO getItem(Long id) throws ConectelException;
}
