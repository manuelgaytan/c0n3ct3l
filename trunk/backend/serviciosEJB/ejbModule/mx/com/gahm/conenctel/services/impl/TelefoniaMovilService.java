package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.TelefoniaMovilDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.ITelefoniaMovilService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/TelefoniaMovilService")
public class TelefoniaMovilService implements ITelefoniaMovilService {

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TelefoniaMovilDO> getAll() throws ConectelException {
		TypedQuery<TelefoniaMovilDO> query = entityManager.createNamedQuery(
				"TelefoniaMovilDO.findAll", TelefoniaMovilDO.class);
		List<TelefoniaMovilDO> telefoniaMovilList;
		try {
			telefoniaMovilList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Telefonia Movil registrada.");
		}
		return telefoniaMovilList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			TelefoniaMovilDO current = entityManager.find(TelefoniaMovilDO.class, id);
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
	public TelefoniaMovilDO save(TelefoniaMovilDO item) {
		entityManager.persist(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public TelefoniaMovilDO update(TelefoniaMovilDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public TelefoniaMovilDO getItem(Long id) throws ConectelException {
		TelefoniaMovilDO telefoniaMovil = entityManager.find(TelefoniaMovilDO.class, id);
		if (telefoniaMovil == null) {
			throw new ConectelException("El Telefonia Movil no existe");
		}
		return telefoniaMovil;
	}

}
