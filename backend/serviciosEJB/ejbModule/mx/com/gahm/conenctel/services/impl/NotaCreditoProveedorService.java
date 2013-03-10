package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.NotaCreditoProveedorDO;
import mx.com.gahm.conenctel.services.INotaCreditoProveedorService;

@Stateless(mappedName = "ejb/NotaCreditoProveedorService")
public class NotaCreditoProveedorService implements INotaCreditoProveedorService{
	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NotaCreditoProveedorDO> getAll() {
		List<NotaCreditoProveedorDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("NotaCreditoProveedorDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		NotaCreditoProveedorDO NotaCreditoProveedorDO=null;
		for (Integer id : idsItems) {
			 NotaCreditoProveedorDO = entityManager.find(NotaCreditoProveedorDO.class, id);
			
			
			if(NotaCreditoProveedorDO!=null){
				entityManager.remove(NotaCreditoProveedorDO);
			}
		}
		
	}

	@Override
	public NotaCreditoProveedorDO save(NotaCreditoProveedorDO item) {
	    try {
	    	
	    	
	    	entityManager.persist(item);
	    	
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return item;
	}

	
	
	@Override
	public NotaCreditoProveedorDO update(NotaCreditoProveedorDO item) {
		entityManager.merge(item);
		
		return item;
	}

	@Override
	public NotaCreditoProveedorDO getItem(Integer id) {
		NotaCreditoProveedorDO NotaCreditoProveedorDO=null;
		try {
			NotaCreditoProveedorDO = entityManager.find(NotaCreditoProveedorDO.class, id);
		} catch (Exception e) {
			NotaCreditoProveedorDO =null;
		}
		
		return NotaCreditoProveedorDO;
	}
}
