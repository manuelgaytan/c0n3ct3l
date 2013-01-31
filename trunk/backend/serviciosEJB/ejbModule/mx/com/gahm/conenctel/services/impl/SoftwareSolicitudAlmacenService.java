package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.SoftwareSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.ISoftwareSolicitudAlmacenService;

@Stateless(mappedName = "ejb/SoftwareSolicitudAlmacenService")
public class SoftwareSolicitudAlmacenService implements
		ISoftwareSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<SoftwareSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<SoftwareSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("SoftwareSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		SoftwareSolicitudAlmacenDO SoftwareSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			SoftwareSolicitudAlmacenDO = getItem(id);

			if (SoftwareSolicitudAlmacenDO != null) {
				entityManager.remove(SoftwareSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<SoftwareSolicitudAlmacenDO> items) {
		try {

			for (SoftwareSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<SoftwareSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<SoftwareSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (SoftwareSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (SoftwareSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public SoftwareSolicitudAlmacenDO getItem(Integer id) {
		SoftwareSolicitudAlmacenDO SoftwareSolicitudAlmacenDO = entityManager.find(
				SoftwareSolicitudAlmacenDO.class, id);
		return SoftwareSolicitudAlmacenDO;
	}

}
