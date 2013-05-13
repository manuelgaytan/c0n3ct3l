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

import com.sun.faces.config.DocumentOrderingWrapper;

import mx.com.gahm.conenctel.entities.DocumentoLiderProveedorMaquiladorDO;
import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.entities.ProveedorDO;
import mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IProveedorMaquiladorService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * @author lespinosa
 *Session Bean implementation class IProveedorMaquiladorService
 */

@Stateless(mappedName = "ejb/ProveedorMaquiladorService")
public class ProveedorMaquiladorService implements IProveedorMaquiladorService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager entityManager;

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProveedorMaquiladorDO> getProveedoresMaquiladores() {
		TypedQuery<ProveedorMaquiladorDO> query = entityManager
				.createNamedQuery("ProveedorMaquiladorDO.findAll",
						ProveedorMaquiladorDO.class);
		List<ProveedorMaquiladorDO> proveedor = query.getResultList();// TODO
																		// Auto-generated
																		// method
																		// stub
		return proveedor;	}

	@Override
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ProveedorMaquiladorDO getProveedorMaquilador(Long id)
			throws ConectelException {
		ProveedorMaquiladorDO proveedor = entityManager.find(
				ProveedorMaquiladorDO.class, id);		
		return proveedor;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProveedorMaquiladorDO saveProveedorMaquilador(
			ProveedorMaquiladorDO proveedor) throws ConectelException {
		// TODO Auto-generated method stub
		List<DocumentoLiderProveedorMaquiladorDO> documentos = proveedor.getDocumentosLiderProveedorMaquilador();
		
		for (DocumentoLiderProveedorMaquiladorDO documento : documentos) {
			documento.setProveedorMaquilador(proveedor);

		}
		
		entityManager.persist(proveedor);
		
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean deleteProveedoresMaquiladores(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			ProveedorMaquiladorDO current = entityManager.find(ProveedorMaquiladorDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

	@Override
	public ProductoDO updateProveedorMaquilador(ProveedorMaquiladorDO proveedor)
			throws ConectelException {
		// TODO Auto-generated method stub
		entityManager.merge(proveedor);
		return null;
	}

}
