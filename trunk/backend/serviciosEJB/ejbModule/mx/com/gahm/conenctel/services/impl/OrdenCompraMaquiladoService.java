package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.OrdenCompraMaquiladoDO;
import mx.com.gahm.conenctel.services.IOrdenCompraMaquiladoService;

@Stateless(mappedName = "ejb/OrdenCompraMaquiladoService")
public class OrdenCompraMaquiladoService implements IOrdenCompraMaquiladoService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<OrdenCompraMaquiladoDO> getAll() {
		List<OrdenCompraMaquiladoDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("OrdenCompraMaquiladoDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query =null;
		OrdenCompraMaquiladoDO ordenCompraMaquiladoDO=null;
		for (Integer id : idsItems) {
			query=entityManager.createNamedQuery("OrdenCompraMaquiladoDO.findById");
			query.setParameter("id", id);
			ordenCompraMaquiladoDO = (OrdenCompraMaquiladoDO)query.getSingleResult();
			if(ordenCompraMaquiladoDO!=null){
				entityManager.remove(ordenCompraMaquiladoDO);
			}
		}
		
	}

	@Override
	public OrdenCompraMaquiladoDO save(OrdenCompraMaquiladoDO item) {
		 try {
		    	entityManager.persist(item);
		    	entityManager.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return item;	
	}

	@Override
	public OrdenCompraMaquiladoDO update(OrdenCompraMaquiladoDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public OrdenCompraMaquiladoDO getItem(Integer id) {
		OrdenCompraMaquiladoDO ordenCompraMaquiladoDO=null;
		try {
			ordenCompraMaquiladoDO = entityManager.find(OrdenCompraMaquiladoDO.class, id);
		} catch (Exception e) {
			ordenCompraMaquiladoDO =null;
		}
		
		return ordenCompraMaquiladoDO;
	}
		

}
