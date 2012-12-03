package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IUsuarioService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

/**
 * Session Bean implementation class UsuarioService
 */
@Stateless(mappedName = "ejb/UsuarioService")
public class UsuarioService implements IUsuarioService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UsuarioDO> getAll() throws ConectelException {
		TypedQuery<UsuarioDO> query = entityManager.createNamedQuery(
				"UsuarioDO.findAll", UsuarioDO.class);
		List<UsuarioDO> userList;
		try {
			userList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Usuarios registrados.");
		}
		/*List<Usuario> responseList;
		try {
			responseList = transformacionService.mapList(userList,
					Usuario.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return userList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public UsuarioDO login(String user, String password) throws ConectelException {
		TypedQuery<UsuarioDO> query = entityManager.createNamedQuery(
				"UsuarioDO.findByName", UsuarioDO.class);
		query.setParameter("usuario", user);
		UsuarioDO userLogged;
		try {
			userLogged = query.getSingleResult();
		} catch(NoResultException e) {
			throw new ConectelException("El usuario no existe.");
		}
		if (!userLogged.getActivo()) {
			throw new ConectelException("El usuario no esta activo.");
		}
		if (!password.equals(userLogged.getContrasena())) {
			throw new ConectelException("La contraseña es incorrecta.");
		}
		/*Usuario response;
		try {
			response = transformacionService.map(userLogged, Usuario.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return userLogged;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UsuarioDO save(UsuarioDO user) throws ConectelException {
		/*try {
			UsuarioDO current = transformacionService
					.map(user, UsuarioDO.class);*/
			entityManager.persist(user);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public UsuarioDO update(UsuarioDO user) throws ConectelException {
		/*try {
			UsuarioDO current = transformacionService
					.map(user, UsuarioDO.class);*/
			entityManager.merge(user);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteUsuarios(List<Long> ids) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(ids);
		boolean response = true;
		for (Long id : idList) {
			UsuarioDO current = entityManager.find(UsuarioDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public UsuarioDO getUsuario(Long id) throws ConectelException {
		UsuarioDO user = entityManager.find(UsuarioDO.class, id);
		/*Usuario response;
		try {
			response = transformacionService.map(user, Usuario.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return user;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PerfilDO> getAllPerfiles() throws ConectelException {
		TypedQuery<PerfilDO> query = entityManager.createNamedQuery(
				"PerfilDO.findAll", PerfilDO.class);
		List<PerfilDO> perfilList = query.getResultList();
		/*List<Catalogo> responseList = new ArrayList<Catalogo>();
		Catalogo perfil;
		for (PerfilDO current:perfilList) {
			perfil = new Catalogo(current.getId(), current.getEtiqueta());
			responseList.add(perfil);
		}
		try {
			responseList = transformacionService.mapList(perfilList,
					Catalogo.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return perfilList;
	}

}
