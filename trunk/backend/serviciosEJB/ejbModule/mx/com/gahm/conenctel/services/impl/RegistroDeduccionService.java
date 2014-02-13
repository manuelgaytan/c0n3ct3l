/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.RegistroDeduccionDO;
import mx.com.gahm.conenctel.entities.RegistroPercepcionDO;
import mx.com.gahm.conenctel.services.IRegistroDeduccionService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/RegistroDeduccionService")
public class RegistroDeduccionService implements IRegistroDeduccionService{

	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<RegistroDeduccionDO> getAll() {
		List<RegistroDeduccionDO> datos= null;
		TypedQuery<RegistroDeduccionDO>  query =null;
		query = entityManager.createNamedQuery("RegistroDeduccionDO.findAll",RegistroDeduccionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		RegistroDeduccionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}
	
	@Override
	public Boolean saveList(List<RegistroDeduccionDO> items) {
		if( items == null || items.size() == 0 ){
			return false;
		}
		for (RegistroDeduccionDO registroDeduccion : items) {
			entityManager.persist( registroDeduccion );
		}
		return true;
	}

	@Override
	public RegistroDeduccionDO save(RegistroDeduccionDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public RegistroDeduccionDO update(RegistroDeduccionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public RegistroDeduccionDO getItem(Integer id) {
		RegistroDeduccionDO cotizacion = entityManager.find(RegistroDeduccionDO.class,id);
		return cotizacion;
	}

}
