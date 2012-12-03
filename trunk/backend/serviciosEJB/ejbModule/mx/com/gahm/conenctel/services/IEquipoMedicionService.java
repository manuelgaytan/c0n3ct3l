package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.EquipoMedicionDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IEquipoMedicionService extends Serializable {

	public List<EquipoMedicionDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public EquipoMedicionDO save(EquipoMedicionDO item);

	public EquipoMedicionDO update(EquipoMedicionDO item);

	public EquipoMedicionDO getItem(Long id) throws ConectelException;

}
