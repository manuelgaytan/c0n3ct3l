package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.HardwareSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.IHardwareSolicitudAlmacenService;

@Stateless(mappedName = "ejb/HardwareSolicitudAlmacenService")
public class HardwareSolicitudAlmacenService implements
		IHardwareSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<HardwareSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<HardwareSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("HardwareSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		HardwareSolicitudAlmacenDO HardwareSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			HardwareSolicitudAlmacenDO = getItem(id);

			if (HardwareSolicitudAlmacenDO != null) {
				entityManager.remove(HardwareSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<HardwareSolicitudAlmacenDO> items) {
		try {

			for (HardwareSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<HardwareSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<HardwareSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (HardwareSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (HardwareSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public HardwareSolicitudAlmacenDO getItem(Integer id) {
		HardwareSolicitudAlmacenDO HardwareSolicitudAlmacenDO = entityManager.find(
				HardwareSolicitudAlmacenDO.class, id);
		return HardwareSolicitudAlmacenDO;
	}

}
