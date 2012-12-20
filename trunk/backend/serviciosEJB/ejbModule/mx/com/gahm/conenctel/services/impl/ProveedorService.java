/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ProveedorSeleccionadoDO;
import mx.com.gahm.conenctel.services.IProveedorService;

/**
 * @author lespinosa
 *
 */
/**
 * Session Bean implementation class ClienteService
 */
@Stateless(mappedName = "ejb/ProveedorService")
public class ProveedorService implements IProveedorService {

	/* (non-Javadoc)
	 * @see mx.com.gahm.conenctel.services.IProveedorService#getProveedoresSeleccionados()
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;
	@Override
	public List<ProveedorSeleccionadoDO> getProveedoresSeleccionados() {
		TypedQuery<ProveedorSeleccionadoDO> query = entityManager.createNamedQuery(
				"ProveedorSeleccionadoDO.findAll", ProveedorSeleccionadoDO.class);
		List<ProveedorSeleccionadoDO> proveedor = query.getResultList();// TODO Auto-generated method stub
		return proveedor;
	}

}
