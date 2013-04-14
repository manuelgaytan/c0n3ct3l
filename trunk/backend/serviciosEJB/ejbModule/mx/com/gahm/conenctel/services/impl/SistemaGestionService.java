/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.SistemaGestionDO;
import mx.com.gahm.conenctel.services.ISistemaGestionService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/SistemaGestionService")
public class SistemaGestionService implements ISistemaGestionService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SistemaGestionDO> getAll() {
		List<SistemaGestionDO> datos= null;
		TypedQuery<SistemaGestionDO>  query =null;
		query = entityManager.createNamedQuery("SistemaGestionDO.findAll",SistemaGestionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SistemaGestionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public SistemaGestionDO save(SistemaGestionDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public SistemaGestionDO update(SistemaGestionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public SistemaGestionDO getItem(Integer id) {
		SistemaGestionDO cotizacion = entityManager.find(SistemaGestionDO.class,id);
		return cotizacion;
	}

}
