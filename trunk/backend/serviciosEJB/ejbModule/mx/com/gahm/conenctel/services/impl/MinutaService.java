/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.MinutaDO;
import mx.com.gahm.conenctel.services.IMinutaService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/MinutaService")
public class MinutaService  implements IMinutaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<MinutaDO> getAll() {
		List<MinutaDO> datos= null;
		TypedQuery<MinutaDO>  query =null;
		query = entityManager.createNamedQuery("MinutaDO.findAll",MinutaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		MinutaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public MinutaDO save(MinutaDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public MinutaDO update(MinutaDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public MinutaDO getItem(Integer id) {
		MinutaDO cotizacion = entityManager.find(MinutaDO.class,id);
		return cotizacion;
	}

}
