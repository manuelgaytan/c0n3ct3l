package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.EquipoTransporteDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IEquipoTransporteService;
import mx.com.gahm.conenctel.util.DataTypeUtil;

@Stateless(mappedName = "ejb/EquipoTransporteService")
public class EquipoTransporteService implements IEquipoTransporteService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EquipoTransporteDO> getAll() throws ConectelException {
		TypedQuery<EquipoTransporteDO> query = entityManager.createNamedQuery(
				"EquipoTransporteDO.findAll", EquipoTransporteDO.class);
		List<EquipoTransporteDO> equipoTransporteList;
		try {
			equipoTransporteList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Equipos de Transporte registrados.");
		}
		return equipoTransporteList;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public boolean deleteItems(List<Long> idsItems) {
		List<Long> idList = (List) DataTypeUtil.convertToLong(idsItems);
		boolean response = true;
		for (Long id : idList) {
			EquipoTransporteDO current = entityManager.find(EquipoTransporteDO.class, id);
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
	public EquipoTransporteDO save(EquipoTransporteDO item) {
		entityManager.persist(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public EquipoTransporteDO update(EquipoTransporteDO item) {
		entityManager.merge(item);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public EquipoTransporteDO getItem(Long id) throws ConectelException {
		EquipoTransporteDO equipoTransporte = entityManager.find(EquipoTransporteDO.class, id);
		if (equipoTransporte == null) {
			throw new ConectelException("El Equipo de Transporte no existe");
		}
		return equipoTransporte;
	}

}
