/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.CobranzaDO;
import mx.com.gahm.conenctel.services.ICobranzaService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/CobranzaService")
public class CobranzaService implements ICobranzaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<CobranzaDO> getAll() {
		List<CobranzaDO> datos= null;
		TypedQuery<CobranzaDO>  query =null;
		query = entityManager.createNamedQuery("CobranzaDO.findAll",CobranzaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		CobranzaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public CobranzaDO save(CobranzaDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public CobranzaDO update(CobranzaDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public CobranzaDO getItem(Integer id) {
		CobranzaDO cotizacion = entityManager.find(CobranzaDO.class,id);
		return cotizacion;
	}

}
