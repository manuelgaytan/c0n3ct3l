/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.entities.ProveedorCalificadoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IProveedorCalificadoService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * @author lespinosa
 *Session Bean implementation class IProveedorCalificadoService
 */


@Stateless(mappedName = "ejb/ProveedorCalificadoService")
public class ProveedorCalificadoService implements IProveedorCalificadoService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see mx.com.gahm.conenctel.services.IProveedorCalificadoService#getProveedoresCalificados()
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProveedorCalificadoDO> getProveedoresCalificados() {
		TypedQuery<ProveedorCalificadoDO> query = entityManager
				.createNamedQuery("ProveedorCalificadoDO.findAll",
						ProveedorCalificadoDO.class);
		List<ProveedorCalificadoDO> proveedor = query.getResultList();// TODO
																		// Auto-generated
																		// method
																		// stub
		return proveedor;
	}
	

	/* (non-Javadoc)
	 * @see mx.com.gahm.conenctel.services.IProveedorCalificadoService#getProveedor(java.lang.Long)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ProveedorCalificadoDO getProveedorCalificado(Long id) throws ConectelException {
		ProveedorCalificadoDO proveedor = entityManager.find(
				ProveedorCalificadoDO.class, id);		
		return proveedor;
	}

	/* (non-Javadoc)
	 * @see mx.com.gahm.conenctel.services.IProveedorCalificadoService#saveProveedorCalificado(mx.com.gahm.conenctel.entities.ProveedorCalificadoDO)
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProveedorCalificadoDO saveProveedorCalificado(
			ProveedorCalificadoDO proveedor) throws ConectelException {
		// TODO Auto-generated method stub
		entityManager.persist(proveedor);
		return null;
	}

	/* (non-Javadoc)
	 * @see mx.com.gahm.conenctel.services.IProveedorCalificadoService#deleteProveedoresCalificados(java.util.List)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteProveedoresCalificados(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			ProveedorCalificadoDO current = entityManager.find(ProveedorCalificadoDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see mx.com.gahm.conenctel.services.IProveedorCalificadoService#updateProveedorCalificado(mx.com.gahm.conenctel.entities.ProveedorCalificadoDO)
	 */
	@Override
	public ProductoDO updateProveedorCalificado(ProveedorCalificadoDO proveedor)
			throws ConectelException {
		// TODO Auto-generated method stub
		entityManager.merge(proveedor);
		return null;
	}

}
