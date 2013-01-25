package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.HerramientaSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.IHerramientaSolicitudAlmacenService;

@Stateless(mappedName = "ejb/HerramientaSolicitudAlmacenService")
public class HerramientaSolicitudAlmacenService implements
		IHerramientaSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<HerramientaSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<HerramientaSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("HerramientaSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		HerramientaSolicitudAlmacenDO herramientaSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			herramientaSolicitudAlmacenDO = getItem(id);

			if (herramientaSolicitudAlmacenDO != null) {
				entityManager.remove(herramientaSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<HerramientaSolicitudAlmacenDO> items) {
		try {

			for (HerramientaSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<HerramientaSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<HerramientaSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (HerramientaSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (HerramientaSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public HerramientaSolicitudAlmacenDO getItem(Integer id) {
		HerramientaSolicitudAlmacenDO herramientaSolicitudAlmacenDO = entityManager.find(
				HerramientaSolicitudAlmacenDO.class, id);
		return herramientaSolicitudAlmacenDO;
	}

}
