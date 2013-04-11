/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.AccionPreventivaCorrectivaDO;
import mx.com.gahm.conenctel.services.IAccionPreventivaCorrectivaService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/AccionPreventivaCorrectivaService")
public class AccionPreventivaCorrectivaService implements IAccionPreventivaCorrectivaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<AccionPreventivaCorrectivaDO> getAll() {
		List<AccionPreventivaCorrectivaDO> datos= null;
		TypedQuery<AccionPreventivaCorrectivaDO>  query =null;
		query = entityManager.createNamedQuery("AccionPreventivaCorrectivaDO.findAll",AccionPreventivaCorrectivaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		AccionPreventivaCorrectivaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public AccionPreventivaCorrectivaDO save(AccionPreventivaCorrectivaDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public AccionPreventivaCorrectivaDO update(AccionPreventivaCorrectivaDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public AccionPreventivaCorrectivaDO getItem(Integer id) {
		AccionPreventivaCorrectivaDO cotizacion = entityManager.find(AccionPreventivaCorrectivaDO.class,id);
		return cotizacion;
	}

}
