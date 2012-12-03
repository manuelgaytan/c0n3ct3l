package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ConsumibleDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IConsumibleService extends Serializable {

	public List<ConsumibleDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public ConsumibleDO save(ConsumibleDO item);

	public ConsumibleDO update(ConsumibleDO item);

	public ConsumibleDO getItem(Long id) throws ConectelException;

}
