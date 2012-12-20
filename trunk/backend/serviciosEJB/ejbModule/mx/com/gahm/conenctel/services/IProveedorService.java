/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;
import mx.com.gahm.conenctel.entities.ProveedorSeleccionadoDO;

/**
 * @author lespinosa
 *
 */
@Remote
public interface IProveedorService extends Serializable {
	
	public List<ProveedorSeleccionadoDO> getProveedoresSeleccionados();

}
