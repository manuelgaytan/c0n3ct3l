package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ConsumibleDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IConsumibleService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/ConsumibleService")
public class ConsumibleService implements IConsumibleService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ConsumibleDO> getAll() throws ConectelException {
		TypedQuery<ConsumibleDO> query = entityManager.createNamedQuery(
				"ConsumibleDO.findAll", ConsumibleDO.class);
		List<ConsumibleDO> consumibleList;
		try {
			consumibleList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Consumibles registrados.");
		}
		return consumibleList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			ConsumibleDO current = entityManager.find(ConsumibleDO.class, id);
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
	public ConsumibleDO save(ConsumibleDO item) {
		entityManager.persist(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConsumibleDO update(ConsumibleDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ConsumibleDO getItem(Long id) throws ConectelException {
		ConsumibleDO consumible = entityManager.find(ConsumibleDO.class, id);
		if (consumible == null) {
			throw new ConectelException("El Consumible no existe");
		}
		return consumible;
	}

}
