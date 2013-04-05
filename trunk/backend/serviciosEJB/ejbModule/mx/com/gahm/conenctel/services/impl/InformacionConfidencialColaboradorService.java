/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.InformacionConfidencialColaboradorDO;
import mx.com.gahm.conenctel.services.IInformacionConfidencialColaboradorService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/InformacionConfidencialColaboradorService")
public class InformacionConfidencialColaboradorService implements IInformacionConfidencialColaboradorService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<InformacionConfidencialColaboradorDO> getAll() {
		List<InformacionConfidencialColaboradorDO> datos= null;
		TypedQuery<InformacionConfidencialColaboradorDO>  query =null;
		query = entityManager.createNamedQuery("InformacionConfidencialColaboradorDO.findAll",InformacionConfidencialColaboradorDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		InformacionConfidencialColaboradorDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public InformacionConfidencialColaboradorDO save(InformacionConfidencialColaboradorDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public InformacionConfidencialColaboradorDO update(InformacionConfidencialColaboradorDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public InformacionConfidencialColaboradorDO getItem(Integer id) {
		InformacionConfidencialColaboradorDO cotizacion = entityManager.find(InformacionConfidencialColaboradorDO.class,id);
		return cotizacion;
	}

}
