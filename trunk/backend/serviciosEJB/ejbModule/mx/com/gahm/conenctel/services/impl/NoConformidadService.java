/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.NoConformidadDO;
import mx.com.gahm.conenctel.services.INoConformidadService;

/**
 * @author GUILLERMO
 *
 */
@Stateless(mappedName = "ejb/NoConformidadService")
public class NoConformidadService implements INoConformidadService {
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<NoConformidadDO> getAll() {
		List<NoConformidadDO> datos= null;
		TypedQuery<NoConformidadDO>  query =null;
		query = entityManager.createNamedQuery("NoConformidadDO.findAll",NoConformidadDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		NoConformidadDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public NoConformidadDO save(NoConformidadDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public NoConformidadDO update(NoConformidadDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public NoConformidadDO getItem(Integer id) {
		NoConformidadDO cotizacion = entityManager.find(NoConformidadDO.class,id);
		return cotizacion;
	}


}
