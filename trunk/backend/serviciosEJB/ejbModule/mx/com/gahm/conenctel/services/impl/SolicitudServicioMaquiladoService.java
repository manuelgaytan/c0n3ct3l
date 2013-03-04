/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.SolicitudServicioMaquiladoDO;
import mx.com.gahm.conenctel.services.ISolicitudServicioMaquiladoService;

/**
 * @author MHDolores
 * 
 */
@Stateless(mappedName = "ejb/SolicitudServicioMaquiladoService")
public class SolicitudServicioMaquiladoService implements
		ISolicitudServicioMaquiladoService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<SolicitudServicioMaquiladoDO> getAll() {
		List<SolicitudServicioMaquiladoDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("SolicitudServicioMaquiladoDO.findAll");
		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		SolicitudServicioMaquiladoDO solicitudServicioMaquiladoDO = null;
		for (Integer id : idsItems) {
			query = entityManager.createNamedQuery("OrdenCompraDO.findById");
			query.setParameter("id", id);
			solicitudServicioMaquiladoDO = (SolicitudServicioMaquiladoDO) query
					.getSingleResult();
			if (solicitudServicioMaquiladoDO != null) {
				entityManager.remove(solicitudServicioMaquiladoDO);
			}
		}

	}

	@Override
	public SolicitudServicioMaquiladoDO save(SolicitudServicioMaquiladoDO item) {
		try {
			entityManager.persist(item);
			entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return item;
	}

	@Override
	public SolicitudServicioMaquiladoDO update(SolicitudServicioMaquiladoDO item) {
		entityManager.merge(item);

		return item;
	}

	@Override
	public SolicitudServicioMaquiladoDO getItem(Integer id) {
		SolicitudServicioMaquiladoDO solicitudServicioMaquiladoDO=null;
		try {
			//solicitudServicioMaquiladoDO = entityManager.find(SolicitudServicioMaquiladoDO.class, id);
			Query query = null;
			query = entityManager.createNamedQuery("SolicitudServicioMaquiladoDO.findById");
			query.setParameter("id", id);
			solicitudServicioMaquiladoDO = (SolicitudServicioMaquiladoDO) query.getSingleResult();
		} catch (Exception e) {
			solicitudServicioMaquiladoDO =null;
		}
		
		return solicitudServicioMaquiladoDO;
	}

}
