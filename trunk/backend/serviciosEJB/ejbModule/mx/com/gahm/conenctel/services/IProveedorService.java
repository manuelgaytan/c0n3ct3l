/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.entities.ProveedorSeleccionadoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

/**
 * @author lespinosa
 * 
 */
@Remote
public interface IProveedorService extends Serializable {

	public List<ProveedorSeleccionadoDO> getProveedoresSeleccionados();

	public ProveedorSeleccionadoDO getProveedor(Long id)
			throws ConectelException;

	public ProveedorSeleccionadoDO saveProveedorSeleccionado(
			ProveedorSeleccionadoDO proveedor) throws ConectelException;

	public boolean deleteProveedoresSeleccionados(List<Long> ids);

	public ProductoDO updateProveedorSeleccionado(
			ProveedorSeleccionadoDO proveedor) throws ConectelException;
}
