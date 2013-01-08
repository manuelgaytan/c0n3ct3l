package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.CotizacionDO;
import mx.com.gahm.conenctel.services.ICotizacionService;

@Stateless(mappedName = "ejb/CotizacionService")
public class CotizacionService implements ICotizacionService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<CotizacionDO> getAll() {
		List<CotizacionDO> datos= null;
		TypedQuery<CotizacionDO>  query =null;
		query = entityManager.createNamedQuery("CotizacionDO.findAll",CotizacionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		CotizacionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public CotizacionDO save(CotizacionDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public CotizacionDO update(CotizacionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public CotizacionDO getItem(Integer id) {
		CotizacionDO cotizacion = entityManager.find(CotizacionDO.class,id);
		return cotizacion;
	}

}
