package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ColaboradorDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IColaboradorService;

@Stateless(mappedName = "ejb/ColaboradorService")
public class ColaboradorService implements IColaboradorService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ColaboradorDO> getColaborador() throws ConectelException {
		TypedQuery<ColaboradorDO> query = entityManager.createNamedQuery(
				"ColaboradorDO.findAll", ColaboradorDO.class);
		List<ColaboradorDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaboradores registrados.");
		}
		return colaboradorList;
	}

}
