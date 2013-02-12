package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ValidacionProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface IValidacionProyectoService {

	public List<ValidacionProyectoDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public ValidacionProyectoDO save(ValidacionProyectoDO item);

	public ValidacionProyectoDO update(ValidacionProyectoDO item);

	public ValidacionProyectoDO getItem(Long id) throws ConectelException;

}
