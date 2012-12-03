package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ClienteDO;
import mx.com.gahm.conenctel.entities.ProductoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IClienteService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * Session Bean implementation class ClienteService
 */
@Stateless(mappedName = "ejb/ClienteService")
public class ClienteService implements IClienteService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ClienteDO> getAll() throws ConectelException {
		TypedQuery<ClienteDO> query = entityManager.createNamedQuery(
				"ClienteDO.findAll", ClienteDO.class);
		List<ClienteDO> clientList;
		try {
			clientList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Usuarios registrados.");
		}
		/*List<Cliente> responseList;
		try {
			responseList = transformacionService.mapList(clientList,
					Cliente.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return clientList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ClienteDO save(ClienteDO client) throws ConectelException {
		/*try {
			ClienteDO current = transformacionService.map(client,
					ClienteDO.class);*/
			entityManager.persist(client.getDatosComerciales());
			entityManager.persist(client.getContacto());
			entityManager.persist(client);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ClienteDO update(ClienteDO client) throws ConectelException {
		/*try {
			ClienteDO current = transformacionService.map(client,
					ClienteDO.class);*/
			entityManager.merge(client.getDatosComerciales());
			entityManager.merge(client.getContacto());
			entityManager.merge(client);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteClientes(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			ClienteDO current = entityManager.find(ClienteDO.class, id);
			if (current == null) {
				response = false;
			} else {
				TypedQuery<ProductoDO> query = entityManager.createNamedQuery(
						"ProductoDO.findByFilter", ProductoDO.class);
				query.setParameter("idCliente", current.getId());
				query.setParameter("tipoProyecto", null);
				query.setParameter("tipoServicio", null);
				query.setParameter("equipo", null);
				List<ProductoDO> productList = query.getResultList();
				for (ProductoDO product:productList) {
					entityManager.remove(product);
				}
				entityManager.remove(current.getDatosComerciales());
				entityManager.remove(current.getContacto());
				entityManager.remove(current);
			}
		}
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ClienteDO getCliente(Long id) throws ConectelException {
		ClienteDO client = entityManager.find(ClienteDO.class, id);
		/*Cliente response;
		try {
			response = transformacionService.map(client, Cliente.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return client;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ClienteDO> getClientes() {
		TypedQuery<ClienteDO> query = entityManager.createNamedQuery(
				"ClienteDO.findAll", ClienteDO.class);
		List<ClienteDO> clientList = query.getResultList();
		/*List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo client;
		for (ClienteDO current : clientList) {
			client = new Catalogo();
			client.setId(current.getId());
			client.setEtiqueta(current.getNombreComercial());
			responseList.add(client);
		}*/
		return clientList;
	}

	@Override
	public void export() {
		// TODO Auto-generated method stub

	}
}
