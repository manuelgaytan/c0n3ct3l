package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.EquipoTransporteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IEquipoTransporteService extends Serializable {

	public List<EquipoTransporteDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public EquipoTransporteDO save(EquipoTransporteDO item);

	public EquipoTransporteDO update(EquipoTransporteDO item);

	public EquipoTransporteDO getItem(Long id) throws ConectelException;

}
