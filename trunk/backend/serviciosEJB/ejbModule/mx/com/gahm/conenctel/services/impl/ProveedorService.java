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
import mx.com.gahm.conenctel.entities.ProveedorSeleccionadoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IProveedorService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * @author lespinosa Session Bean implementation class ProveedorService
 */
@Stateless(mappedName = "ejb/ProveedorService")
public class ProveedorService implements IProveedorService {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private EntityManager entityManager;

	@Override
	public List<ProveedorSeleccionadoDO> getProveedoresSeleccionados() {
		TypedQuery<ProveedorSeleccionadoDO> query = entityManager
				.createNamedQuery("ProveedorSeleccionadoDO.findAll",
						ProveedorSeleccionadoDO.class);
		List<ProveedorSeleccionadoDO> proveedor = query.getResultList();// TODO
																		// Auto-generated
																		// method
																		// stub
		return proveedor;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ProveedorSeleccionadoDO getProveedor(Long id)
			throws ConectelException {
		ProveedorSeleccionadoDO proveedor = entityManager.find(
				ProveedorSeleccionadoDO.class, id);
		return proveedor;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProveedorSeleccionadoDO saveProveedorSeleccionado(
			ProveedorSeleccionadoDO proveedor) throws ConectelException {
		entityManager.persist(proveedor);
		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteProveedoresSeleccionados(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			ProveedorSeleccionadoDO current = entityManager.find(
					ProveedorSeleccionadoDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProductoDO updateProveedorSeleccionado(
			ProveedorSeleccionadoDO proveedor) throws ConectelException {
		entityManager.merge(proveedor);
		return null;
	}

}
