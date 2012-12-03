package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.SoftwareDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.ISoftwareService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/SoftwareService")
public class SoftwareService implements ISoftwareService {

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<SoftwareDO> getAll() throws ConectelException {
		TypedQuery<SoftwareDO> query = entityManager.createNamedQuery(
				"SoftwareDO.findAll", SoftwareDO.class);
		List<SoftwareDO> softwareList;
		try {
			softwareList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Software registrado.");
		}
		return softwareList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			SoftwareDO current = entityManager.find(SoftwareDO.class, id);
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
	public SoftwareDO save(SoftwareDO item) {
		entityManager.persist(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public SoftwareDO update(SoftwareDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public SoftwareDO getItem(Long id) throws ConectelException {
		SoftwareDO software = entityManager.find(SoftwareDO.class, id);
		if (software == null) {
			throw new ConectelException("El Software no existe");
		}
		return software;
	}

}
