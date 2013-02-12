package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ValidacionProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IValidacionProyectoService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/ValidacionProyectoService")
public class ValidacionProyectoService implements IValidacionProyectoService {

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ValidacionProyectoDO> getAll() throws ConectelException {
		TypedQuery<ValidacionProyectoDO> query = entityManager.createNamedQuery(
				"ValidacionProyectoDO.findAll", ValidacionProyectoDO.class);
		List<ValidacionProyectoDO> solicitudAlmacenList;
		try {
			solicitudAlmacenList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Solicitud Almacen registrado.");
		}
		return solicitudAlmacenList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			ValidacionProyectoDO current = entityManager.find(ValidacionProyectoDO.class, id);
			if (current == null) {
				response = false;
			} else {
				entityManager.remove(current);
			}
		}
		// TODO
		return response;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ValidacionProyectoDO save(ValidacionProyectoDO item) {
		if (item != null) 
		entityManager.persist(item);
	
		return item;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ValidacionProyectoDO update(ValidacionProyectoDO item) {
		entityManager.merge(item);
		return item;
	}

	

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ValidacionProyectoDO getItem(Long id) throws ConectelException {
		ValidacionProyectoDO validacionProyecto = entityManager.find(ValidacionProyectoDO.class, id);
		if (validacionProyecto == null) {
			throw new ConectelException("El Solicitud Almacen no existe");
		}
		return validacionProyecto;
	}


}
