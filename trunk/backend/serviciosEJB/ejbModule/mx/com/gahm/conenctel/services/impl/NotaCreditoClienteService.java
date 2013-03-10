package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.ComentarioNotaCreditoClienteDO;
import mx.com.gahm.conenctel.entities.NotaCreditoClienteDO;
import mx.com.gahm.conenctel.services.INotaCreditoClienteService;

@Stateless(mappedName = "ejb/NotaCreditoClienteService")
public class NotaCreditoClienteService implements INotaCreditoClienteService{


	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<NotaCreditoClienteDO> getAll() {
		List<NotaCreditoClienteDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("NotaCreditoClienteDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		NotaCreditoClienteDO notaCreditoClienteDO=null;
		for (Integer id : idsItems) {
			 notaCreditoClienteDO = entityManager.find(NotaCreditoClienteDO.class, id);
			
			
			if(notaCreditoClienteDO!=null){
				entityManager.remove(notaCreditoClienteDO);
			}
		}
		
	}

	@Override
	public NotaCreditoClienteDO save(NotaCreditoClienteDO item) {
	    try {
	    	
	    	List<ComentarioNotaCreditoClienteDO> comentarios = item.getComentariosNotaCreditoCliente();
	    	item.setComentariosNotaCreditoCliente(null);
	    	
	    	entityManager.persist(item);
	    	saveComentarios(item,comentarios);
	    	
	    	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return item;
	}

	public void saveComentarios(NotaCreditoClienteDO item,List<ComentarioNotaCreditoClienteDO> comentarios){
		
		
		
		for (ComentarioNotaCreditoClienteDO dato : comentarios) {
			dato.setNotaCreditoCliente(item);
			entityManager.persist(dato);
		}
		
		item.setComentariosNotaCreditoCliente(comentarios);
		
	}
	
	
	
	
	
	
	
	@Override
	public NotaCreditoClienteDO update(NotaCreditoClienteDO item) {
		entityManager.merge(item);
		
		return item;
	}

	@Override
	public NotaCreditoClienteDO getItem(Integer id) {
		NotaCreditoClienteDO notaCreditoClienteDO=null;
		try {
			notaCreditoClienteDO = entityManager.find(NotaCreditoClienteDO.class, id);
		} catch (Exception e) {
			notaCreditoClienteDO =null;
		}
		
		return notaCreditoClienteDO;
	}
}
