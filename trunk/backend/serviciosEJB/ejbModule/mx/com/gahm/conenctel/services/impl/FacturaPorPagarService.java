package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import mx.com.gahm.conenctel.entities.FacturaPorPagarDO;
import mx.com.gahm.conenctel.services.IFacturaPorPagar;

@Stateless(mappedName = "ejb/FacturaPorPagarService")
public class FacturaPorPagarService  implements IFacturaPorPagar{
	
	@Inject
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FacturaPorPagarDO> getAll() {
		List<FacturaPorPagarDO> datos= null;
		Query query =null;
		query = entityManager.createNamedQuery("FacturaPorPagarDO.findAll");
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		Query query =null;
		FacturaPorPagarDO FacturaPorPagarDO=null;
		for (Integer id : idsItems) {
			query=entityManager.createNamedQuery("FacturaPorPagarDO.findById");
			query.setParameter("id", id);
			FacturaPorPagarDO = (FacturaPorPagarDO)query.getSingleResult();
			if(FacturaPorPagarDO!=null){
				entityManager.remove(FacturaPorPagarDO);
			}
		}
		
	}

	@Override
	public FacturaPorPagarDO save(FacturaPorPagarDO item) {
	    try {
	    	entityManager.persist(item);
	    	entityManager.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return item;
	}

	@Override
	public FacturaPorPagarDO update(FacturaPorPagarDO item) {
		entityManager.merge(item);
		
		return item;
	}

	@Override
	public FacturaPorPagarDO getItem(Integer id) {
		FacturaPorPagarDO FacturaPorPagarDO=null;
		try {
			 FacturaPorPagarDO = entityManager.find(FacturaPorPagarDO.class, id);
		} catch (Exception e) {
			FacturaPorPagarDO =null;
		}
		
		return FacturaPorPagarDO;
	}
}
