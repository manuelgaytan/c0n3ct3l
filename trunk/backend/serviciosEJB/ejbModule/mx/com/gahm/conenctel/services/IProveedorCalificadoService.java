/**
 * 
 */
package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.entities.ProveedorCalificadoDO;

import mx.com.gahm.conenctel.exceptions.ConectelException;

/**
 * @author lespinosa
 *
 */

@Remote
public interface IProveedorCalificadoService extends Serializable{

	public List<ProveedorCalificadoDO> getProveedoresCalificados();
	
	public ProveedorCalificadoDO getProveedorCalificado(Long id) throws ConectelException;
	
	public ProveedorCalificadoDO saveProveedorCalificado(ProveedorCalificadoDO proveedor) throws ConectelException ;
	
	public boolean deleteProveedoresCalificados(List<Long> ids) ;

	public ProductoDO updateProveedorCalificado(ProveedorCalificadoDO proveedor) throws ConectelException ;

}
