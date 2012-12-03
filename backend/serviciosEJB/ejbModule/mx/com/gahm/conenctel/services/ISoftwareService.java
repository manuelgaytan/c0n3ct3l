package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.SoftwareDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface ISoftwareService {

	public List<SoftwareDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public SoftwareDO save(SoftwareDO item);

	public SoftwareDO update(SoftwareDO item);

	public SoftwareDO getItem(Long id) throws ConectelException;

}
