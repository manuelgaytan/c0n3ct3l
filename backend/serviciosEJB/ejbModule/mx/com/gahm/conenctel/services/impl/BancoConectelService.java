package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.BancoConectelDO;
import mx.com.gahm.conenctel.services.IBancoConectelService;

@Stateless(mappedName = "ejb/BancoConectelService")
public class BancoConectelService implements IBancoConectelService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<BancoConectelDO> getAll() {
		List<BancoConectelDO> datos= null;
		TypedQuery<BancoConectelDO>  query =null;
		query = entityManager.createNamedQuery("BancoConectelDO.findAll",BancoConectelDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		BancoConectelDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public BancoConectelDO save(BancoConectelDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public BancoConectelDO update(BancoConectelDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public BancoConectelDO getItem(Integer id) {
		BancoConectelDO cotizacion = entityManager.find(BancoConectelDO.class,id);
		return cotizacion;
	}

}
