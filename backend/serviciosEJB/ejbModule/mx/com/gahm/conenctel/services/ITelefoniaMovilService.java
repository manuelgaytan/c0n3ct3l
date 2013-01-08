package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.TelefoniaMovilDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface ITelefoniaMovilService {

	public List<TelefoniaMovilDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public TelefoniaMovilDO save(TelefoniaMovilDO item);

	public TelefoniaMovilDO update(TelefoniaMovilDO item);

	public TelefoniaMovilDO getItem(Long id) throws ConectelException;

}
