package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.HardwareDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IHardwareService {

	public List<HardwareDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public HardwareDO save(HardwareDO item);

	public HardwareDO update(HardwareDO item);

	public HardwareDO getItem(Long id) throws ConectelException;

}
