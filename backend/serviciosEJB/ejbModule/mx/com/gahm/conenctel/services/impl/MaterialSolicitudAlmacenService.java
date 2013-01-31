package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.MaterialSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.IMaterialSolicitudAlmacenService;

@Stateless(mappedName = "ejb/MaterialSolicitudAlmacenService")
public class MaterialSolicitudAlmacenService implements
		IMaterialSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<MaterialSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<MaterialSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("MaterialSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		MaterialSolicitudAlmacenDO MaterialSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			MaterialSolicitudAlmacenDO = getItem(id);

			if (MaterialSolicitudAlmacenDO != null) {
				entityManager.remove(MaterialSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<MaterialSolicitudAlmacenDO> items) {
		try {

			for (MaterialSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<MaterialSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<MaterialSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (MaterialSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (MaterialSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public MaterialSolicitudAlmacenDO getItem(Integer id) {
		MaterialSolicitudAlmacenDO MaterialSolicitudAlmacenDO = entityManager.find(
				MaterialSolicitudAlmacenDO.class, id);
		return MaterialSolicitudAlmacenDO;
	}

}
