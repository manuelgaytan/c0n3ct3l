package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.TelefoniaMovilSolicitudAlmacenDO;
import mx.com.gahm.conenctel.services.ITelefoniaMovilSolicitudAlmacenService;

@Stateless(mappedName = "ejb/TelefoniaMovilSolicitudAlmacenService")
public class TelefoniaMovilSolicitudAlmacenService implements
		ITelefoniaMovilSolicitudAlmacenService {

	@Inject
	private EntityManager entityManager;

	@Override
	public List<TelefoniaMovilSolicitudAlmacenDO> getAll(
			Integer idSolicitudalamacen) {
		List<TelefoniaMovilSolicitudAlmacenDO> datos = null;
		Query query = null;
		query = entityManager
				.createNamedQuery("TelefoniaMovilSolicitudAlmacenDO.findAll");
		query.setParameter("id", idSolicitudalamacen);

		datos = query.getResultList();

		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query = null;
		TelefoniaMovilSolicitudAlmacenDO TelefoniaMovilSolicitudAlmacenDO = null;
		for (Integer id : idsItems) {

			TelefoniaMovilSolicitudAlmacenDO = getItem(id);

			if (TelefoniaMovilSolicitudAlmacenDO != null) {
				entityManager.remove(TelefoniaMovilSolicitudAlmacenDO);
			}
		}

	}

	@Override
	public void save(List<TelefoniaMovilSolicitudAlmacenDO> items) {
		try {

			for (TelefoniaMovilSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(List<TelefoniaMovilSolicitudAlmacenDO> items) {
		
		if(items!=null &&items.size()>0){
			Long id = items.get(0).getSolicitudAlmacen().getId();
			
			List<TelefoniaMovilSolicitudAlmacenDO> datos = null;
			datos= getAll(id.intValue());
			
			for (TelefoniaMovilSolicitudAlmacenDO dato : datos) {
				entityManager.remove(dato);
			}
			
			for (TelefoniaMovilSolicitudAlmacenDO item : items) {
				entityManager.persist(item);
				entityManager.flush();
			}
			
		}
		
	}

	@Override
	public TelefoniaMovilSolicitudAlmacenDO getItem(Integer id) {
		TelefoniaMovilSolicitudAlmacenDO TelefoniaMovilSolicitudAlmacenDO = entityManager.find(
				TelefoniaMovilSolicitudAlmacenDO.class, id);
		return TelefoniaMovilSolicitudAlmacenDO;
	}

}
