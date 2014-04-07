/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ValidacionAdministrativaDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

/**
 * @author MHDolores
 *
 */
@Remote
public interface IValidacionAdministrativaService {

	public List<ValidacionAdministrativaDO> getAll() throws ConectelException;

	public boolean deleteItems(List<Long> idsItems);

	public ValidacionAdministrativaDO save(ValidacionAdministrativaDO item);

	public ValidacionAdministrativaDO update(ValidacionAdministrativaDO item) throws ConectelException;

	public ValidacionAdministrativaDO getItem(Long id) throws ConectelException;

}
