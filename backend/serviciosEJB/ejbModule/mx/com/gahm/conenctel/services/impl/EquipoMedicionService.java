package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.EquipoMedicionDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IEquipoMedicionService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/EquipoMedicionService")
public class EquipoMedicionService implements IEquipoMedicionService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EquipoMedicionDO> getAll() throws ConectelException {
		TypedQuery<EquipoMedicionDO> query = entityManager.createNamedQuery(
				"EquipoMedicionDO.findAll", EquipoMedicionDO.class);
		List<EquipoMedicionDO> equipoMedicionList;
		try {
			equipoMedicionList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Equipos de Medición registrados.");
		}
		return equipoMedicionList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			EquipoMedicionDO current = entityManager.find(EquipoMedicionDO.class, id);
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
	public EquipoMedicionDO save(EquipoMedicionDO item) {
		entityManager.persist(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EquipoMedicionDO update(EquipoMedicionDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EquipoMedicionDO getItem(Long id) throws ConectelException {
		EquipoMedicionDO equipoMedicion = entityManager.find(EquipoMedicionDO.class, id);
		if (equipoMedicion == null) {
			throw new ConectelException("El Equipo de Medición no existe");
		}
		return equipoMedicion;
	}

}
