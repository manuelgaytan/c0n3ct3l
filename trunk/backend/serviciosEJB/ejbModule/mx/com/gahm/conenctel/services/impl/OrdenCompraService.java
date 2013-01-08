package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.OrdenCompraDO;
import mx.com.gahm.conenctel.services.IOrdenCompraService;

@Stateless(mappedName = "ejb/OrdenCompraService")
public class OrdenCompraService  implements IOrdenCompraService{
	
	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDO> getAll() {
		List<OrdenCompraDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("OrdenCompraDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query =null;
		OrdenCompraDO ordenCompraDO=null;
		for (Integer id : idsItems) {
			query=entityManager.createNamedQuery("OrdenCompraDO.findById");
			query.setParameter("id", id);
			ordenCompraDO = (OrdenCompraDO)query.getSingleResult();
			if(ordenCompraDO!=null){
				entityManager.remove(ordenCompraDO);
			}
		}
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public OrdenCompraDO save(OrdenCompraDO item) {
	    try {
	    	entityManager.persist(item);
	    	entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return item;
	}

	@Override
	public OrdenCompraDO update(OrdenCompraDO item) {
		entityManager.merge(item);
		
		return item;
	}

	@Override
	public OrdenCompraDO getItem(Integer id) {
		OrdenCompraDO ordenCompraDO=null;
		try {
			 ordenCompraDO = entityManager.find(OrdenCompraDO.class, id);
		} catch (Exception e) {
			ordenCompraDO =null;
		}
		
		return ordenCompraDO;
	}

}
