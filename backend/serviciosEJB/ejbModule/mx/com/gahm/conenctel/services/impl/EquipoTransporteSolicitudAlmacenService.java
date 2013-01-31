package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.EquipoTransporteSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.IEquipoTransporteSolicitudAlmacenService;

@Stateless(mappedName = "ejb/EquipoTransporteSolicitudAlmacenService")
public class EquipoTransporteSolicitudAlmacenService implements
		IEquipoTransporteSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<EquipoTransporteSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<EquipoTransporteSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("EquipoTransporteSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		EquipoTransporteSolicitudAlmacenDO EquipoTransporteSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			EquipoTransporteSolicitudAlmacenDO = getItem(id);

			if (EquipoTransporteSolicitudAlmacenDO != null) {
				entityManager.remove(EquipoTransporteSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<EquipoTransporteSolicitudAlmacenDO> items) {
		try {

			for (EquipoTransporteSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<EquipoTransporteSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<EquipoTransporteSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (EquipoTransporteSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (EquipoTransporteSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public EquipoTransporteSolicitudAlmacenDO getItem(Integer id) {
		EquipoTransporteSolicitudAlmacenDO EquipoTransporteSolicitudAlmacenDO = entityManager.find(
				EquipoTransporteSolicitudAlmacenDO.class, id);
		return EquipoTransporteSolicitudAlmacenDO;
	}

}
