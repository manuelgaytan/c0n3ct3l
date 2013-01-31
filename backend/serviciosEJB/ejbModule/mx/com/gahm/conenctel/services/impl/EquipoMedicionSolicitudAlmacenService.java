package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.EquipoMedicionSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.IEquipoMedicionSolicitudAlmacenService;

@Stateless(mappedName = "ejb/EquipoMedicionSolicitudAlmacenService")
public class EquipoMedicionSolicitudAlmacenService implements
		IEquipoMedicionSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<EquipoMedicionSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<EquipoMedicionSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("EquipoMedicionSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		EquipoMedicionSolicitudAlmacenDO EquipoMedicionSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			EquipoMedicionSolicitudAlmacenDO = getItem(id);

			if (EquipoMedicionSolicitudAlmacenDO != null) {
				entityManager.remove(EquipoMedicionSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<EquipoMedicionSolicitudAlmacenDO> items) {
		try {

			for (EquipoMedicionSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<EquipoMedicionSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<EquipoMedicionSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (EquipoMedicionSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (EquipoMedicionSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public EquipoMedicionSolicitudAlmacenDO getItem(Integer id) {
		EquipoMedicionSolicitudAlmacenDO EquipoMedicionSolicitudAlmacenDO = entityManager.find(
				EquipoMedicionSolicitudAlmacenDO.class, id);
		return EquipoMedicionSolicitudAlmacenDO;
	}

}
