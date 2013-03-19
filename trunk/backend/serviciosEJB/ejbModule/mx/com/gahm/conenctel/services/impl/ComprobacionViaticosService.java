package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComprobacionViaticosDO;
import mx.com.gahm.conenctel.services.IComprobacionViaticosService;

@Stateless(mappedName = "ejb/ComprobacionViaticosService")
public class ComprobacionViaticosService implements IComprobacionViaticosService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ComprobacionViaticosDO> getAll() {
		List<ComprobacionViaticosDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("ComprobacionViaticosDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ComprobacionViaticosDO ComprobacionViaticosDO = null;
		for (Integer id : idsItems) {
			ComprobacionViaticosDO = entityManager.find(
					ComprobacionViaticosDO.class, id);

			if (ComprobacionViaticosDO != null) {
				entityManager.remove(ComprobacionViaticosDO);
			}
		}

	}

	@Override
	public ComprobacionViaticosDO save(ComprobacionViaticosDO item) {
		try {

			entityManager.persist(item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}


	@Override
	public ComprobacionViaticosDO update(ComprobacionViaticosDO item) {
		entityManager.merge(item);

		return item;
	}


	@Override
	public ComprobacionViaticosDO getItem(Integer id) {
		ComprobacionViaticosDO comprobacionViaticosDO = null;
		try {
			comprobacionViaticosDO = entityManager.find(
					ComprobacionViaticosDO.class, id);
		} catch (Exception e) {
			comprobacionViaticosDO = null;
		}

		return comprobacionViaticosDO;
	}
}
