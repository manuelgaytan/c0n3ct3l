package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.SolicitudViaticosDO;
import mx.com.gahm.conenctel.services.ISolicitudViaticosService;

@Stateless(mappedName = "ejb/SolicitudViaticosService")
public class SolicitudViaticosService implements ISolicitudViaticosService{

	@Inject
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SolicitudViaticosDO> getAll() {
		List<SolicitudViaticosDO> datos = null;
		Query query = null;
		query = entityManager.createNamedQuery("SolicitudViaticosDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SolicitudViaticosDO SolicitudViaticosDO = null;
		for (Integer id : idsItems) {
			SolicitudViaticosDO = entityManager.find(
					SolicitudViaticosDO.class, id);

			if (SolicitudViaticosDO != null) {
				entityManager.remove(SolicitudViaticosDO);
			}
		}

	}

	@Override
	public SolicitudViaticosDO save(SolicitudViaticosDO item) {
		try {

			entityManager.persist(item);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}


	@Override
	public SolicitudViaticosDO update(SolicitudViaticosDO item) {
		entityManager.merge(item);

		return item;
	}


	@Override
	public SolicitudViaticosDO getItem(Integer id) {
		SolicitudViaticosDO SolicitudViaticosDO = null;
		try {
			SolicitudViaticosDO = entityManager.find(
					SolicitudViaticosDO.class, id);
		} catch (Exception e) {
			SolicitudViaticosDO = null;
		}

		return SolicitudViaticosDO;
	}

}
