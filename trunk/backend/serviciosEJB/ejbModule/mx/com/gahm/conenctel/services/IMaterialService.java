package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.MaterialDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IMaterialService extends Serializable {

	public List<MaterialDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public MaterialDO save(MaterialDO item);

	public MaterialDO update(MaterialDO item);

	public MaterialDO getItem(Long id) throws ConectelException;

}
