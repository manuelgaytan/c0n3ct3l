package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.HardwareDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IHardwareService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/HardwareService")
public class HardwareService implements IHardwareService {

	@Inject
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<HardwareDO> getAll() throws ConectelException {
		TypedQuery<HardwareDO> query = entityManager.createNamedQuery(
				"HardwareDO.findAll", HardwareDO.class);
		List<HardwareDO> hardwareList;
		try {
			hardwareList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existe Hardware registrado.");
		}
		return hardwareList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			HardwareDO current = entityManager.find(HardwareDO.class, id);
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
	public HardwareDO save(HardwareDO item) {
		entityManager.persist(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public HardwareDO update(HardwareDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public HardwareDO getItem(Long id) throws ConectelException {
		HardwareDO hardware = entityManager.find(HardwareDO.class, id);
		if (hardware == null) {
			throw new ConectelException("El Hardware no existe");
		}
		return hardware;
	}

}
