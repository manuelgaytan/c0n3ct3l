/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ContratacionDO;
import mx.com.gahm.conenctel.services.IContratacionService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/ContratacionService")
public class ContratacionService implements IContratacionService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<ContratacionDO> getAll() {
		List<ContratacionDO> datos= null;
		TypedQuery<ContratacionDO>  query =null;
		query = entityManager.createNamedQuery("ContratacionDO.findAll",ContratacionDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ContratacionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public ContratacionDO save(ContratacionDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public ContratacionDO update(ContratacionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public ContratacionDO getItem(Integer id) {
		ContratacionDO cotizacion = entityManager.find(ContratacionDO.class,id);
		return cotizacion;
	}

}