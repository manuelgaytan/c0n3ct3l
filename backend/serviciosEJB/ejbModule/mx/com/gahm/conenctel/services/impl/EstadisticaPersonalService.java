/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.EstadisticaPersonalDO;
import mx.com.gahm.conenctel.services.IEstadisticaPersonalService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/EstadisticaPersonalService")
public class EstadisticaPersonalService implements IEstadisticaPersonalService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<EstadisticaPersonalDO> getAll() {
		List<EstadisticaPersonalDO> datos= null;
		TypedQuery<EstadisticaPersonalDO>  query =null;
		query = entityManager.createNamedQuery("EstadisticaPersonalDO.findAll",EstadisticaPersonalDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		EstadisticaPersonalDO dato = null;
		for (Integer id : idsItems) {
			dato =getItem(id);
			entityManager.remove(dato);
		}
		
	}

	@Override
	public EstadisticaPersonalDO save(EstadisticaPersonalDO item) {
		entityManager.persist(item);
		return item;
	}
	
	@Override
	public EstadisticaPersonalDO update(EstadisticaPersonalDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public EstadisticaPersonalDO getItem(Integer id) {
		EstadisticaPersonalDO dato = entityManager.find(EstadisticaPersonalDO.class,id);
		return dato;
	}

	
}
