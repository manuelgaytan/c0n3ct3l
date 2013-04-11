/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.SugerenciaDO;
import mx.com.gahm.conenctel.services.ISugerenciaService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/SugerenciaService")
public class SugerenciaService implements ISugerenciaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SugerenciaDO> getAll() {
		List<SugerenciaDO> datos= null;
		TypedQuery<SugerenciaDO>  query =null;
		query = entityManager.createNamedQuery("SugerenciaDO.findAll",SugerenciaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SugerenciaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public SugerenciaDO save(SugerenciaDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public SugerenciaDO update(SugerenciaDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public SugerenciaDO getItem(Integer id) {
		SugerenciaDO cotizacion = entityManager.find(SugerenciaDO.class,id);
		return cotizacion;
	}

}
