/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.CursoDO;
import mx.com.gahm.conenctel.services.ICursoService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/CursoService")
public class CursoService implements ICursoService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<CursoDO> getAll() {
		List<CursoDO> datos= null;
		TypedQuery<CursoDO>  query =null;
		query = entityManager.createNamedQuery("CursoDO.findAll",CursoDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		CursoDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public CursoDO save(CursoDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public CursoDO update(CursoDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public CursoDO getItem(Integer id) {
		CursoDO cotizacion = entityManager.find(CursoDO.class,id);
		return cotizacion;
	}

}
