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
			entityManager.remove(cotizacion.getColaborador());
		}
		
	}

	@Override
	public ContratacionDO save(ContratacionDO item) {
		item.getDocumentosContratacion().setContratacion(item);
		item.getPrestaciones().setContratacion(item);
		entityManager.persist(item);
		return item;
	}

	@Override
	public ContratacionDO update(ContratacionDO item) {
		item.getDocumentosContratacion().setContratacion(item);
		item.getPrestaciones().setContratacion(item);
		entityManager.merge(item.getColaborador());
		entityManager.merge(item);
		return item;
	}

	@Override
	public ContratacionDO getItem(Integer id) {
		ContratacionDO cotizacion = entityManager.find(ContratacionDO.class,id);
		return cotizacion;
	}
	
	@Override
	public List<ContratacionDO> getContratacionByIdColaborador(Integer idColaborador ){
	
		List<ContratacionDO> datos= null;
		TypedQuery<ContratacionDO>  query =null;
		query = entityManager.createNamedQuery("ContratacionDO.getContratacionByIdColaborador",ContratacionDO.class);
		query.setParameter("idColaborador", idColaborador);
		datos = query.getResultList();
		
		return datos;
	}  
	
	
}
