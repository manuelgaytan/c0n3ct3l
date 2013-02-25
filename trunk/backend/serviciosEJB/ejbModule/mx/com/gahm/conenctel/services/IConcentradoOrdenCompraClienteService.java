package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ConcentradoOrdenCompraClienteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IConcentradoOrdenCompraClienteService {
	public List<ConcentradoOrdenCompraClienteDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public ConcentradoOrdenCompraClienteDO save(ConcentradoOrdenCompraClienteDO item);

	public ConcentradoOrdenCompraClienteDO update(ConcentradoOrdenCompraClienteDO item);

	public ConcentradoOrdenCompraClienteDO getItem(Long id) throws ConectelException;
}
