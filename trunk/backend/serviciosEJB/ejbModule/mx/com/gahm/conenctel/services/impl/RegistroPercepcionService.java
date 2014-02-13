package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.RegistroPercepcionDO;
import mx.com.gahm.conenctel.services.IRegistroPercepcionService;

@Stateless(mappedName = "ejb/RegistroPercepcionService")
public class RegistroPercepcionService implements IRegistroPercepcionService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<RegistroPercepcionDO> getAll() {
		List<RegistroPercepcionDO> datos= null;
		TypedQuery<RegistroPercepcionDO>  query =null;
		query = entityManager.createNamedQuery("RegistroPercepcionDO.findAll",RegistroPercepcionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		RegistroPercepcionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}
	
	@Override
	public Boolean saveList(List<RegistroPercepcionDO> items) {
		if( items == null || items.size() == 0 ){
			return false;
		}
		for (RegistroPercepcionDO registroPercepcion : items) {
			entityManager.persist( registroPercepcion );
		}
		return true;
	}
	
	@Override
	public RegistroPercepcionDO save(RegistroPercepcionDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public RegistroPercepcionDO update(RegistroPercepcionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public RegistroPercepcionDO getItem(Integer id) {
		RegistroPercepcionDO cotizacion = entityManager.find(RegistroPercepcionDO.class,id);
		return cotizacion;
	}
}
