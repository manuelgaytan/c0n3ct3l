package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ConsumibleSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.IConsumibleSolicitudAlmacenService;

@Stateless(mappedName = "ejb/ConsumibleSolicitudAlmacenService")
public class ConsumibleSolicitudAlmacenService implements
		IConsumibleSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<ConsumibleSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<ConsumibleSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("ConsumibleSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ConsumibleSolicitudAlmacenDO ConsumibleSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			ConsumibleSolicitudAlmacenDO = getItem(id);

			if (ConsumibleSolicitudAlmacenDO != null) {
				entityManager.remove(ConsumibleSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<ConsumibleSolicitudAlmacenDO> items) {
		try {

			for (ConsumibleSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<ConsumibleSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<ConsumibleSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (ConsumibleSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (ConsumibleSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public ConsumibleSolicitudAlmacenDO getItem(Integer id) {
		ConsumibleSolicitudAlmacenDO ConsumibleSolicitudAlmacenDO = entityManager.find(
				ConsumibleSolicitudAlmacenDO.class, id);
		return ConsumibleSolicitudAlmacenDO;
	}

}
