/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ConcentradoCapacitacionDO;
import mx.com.gahm.conenctel.services.IConcentradoCapacitacionService;

/**
 * @author SEVEN
 *
 */
@Stateless(mappedName = "ejb/ConcentradoCapacitacionService")
public class ConcentradoCapacitacionService implements IConcentradoCapacitacionService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<ConcentradoCapacitacionDO> getAll() {
		List<ConcentradoCapacitacionDO> datos= null;
		TypedQuery<ConcentradoCapacitacionDO>  query =null;
		query = entityManager.createNamedQuery("ConcentradoCapacitacionDO.findAll",ConcentradoCapacitacionDO.class);
		datos = query.getResultList();
		
		return datos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConcentradoCapacitacionDO> getAllByPerfil( long idPerfil ) {
		List<ConcentradoCapacitacionDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("ConcentradoCapacitacionDO.findAllByPerfil");
		query.setParameter("idPerfil",idPerfil);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ConcentradoCapacitacionDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public ConcentradoCapacitacionDO save(ConcentradoCapacitacionDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public ConcentradoCapacitacionDO update(ConcentradoCapacitacionDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public ConcentradoCapacitacionDO getItem(Integer id) {
		ConcentradoCapacitacionDO cotizacion = entityManager.find(ConcentradoCapacitacionDO.class,id);
		return cotizacion;
	}
}
