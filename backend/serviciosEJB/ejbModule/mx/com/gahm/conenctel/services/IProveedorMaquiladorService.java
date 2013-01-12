package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;

/**
 * @author lespinosa
 *
 */

@Remote
public interface IProveedorMaquiladorService extends Serializable {

	public List<ProveedorMaquiladorDO> getProveedoresMaquiladores();
	
	public ProveedorMaquiladorDO getProveedorMaquilador(Long id) throws ConectelException;
	
	public ProveedorMaquiladorDO saveProveedorMaquilador(ProveedorMaquiladorDO proveedor) throws ConectelException ;
	
	public boolean deleteProveedoresMaquiladores(List<Long> ids) ;

	public ProductoDO updateProveedorMaquilador(ProveedorMaquiladorDO proveedor) throws ConectelException ;


}
