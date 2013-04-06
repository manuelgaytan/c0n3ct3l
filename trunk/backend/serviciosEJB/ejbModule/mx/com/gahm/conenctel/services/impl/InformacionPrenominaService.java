/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.InformacionPrenominaDO;
import mx.com.gahm.conenctel.services.IInformacionPrenominaService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/InformacionPrenominaService")
public class InformacionPrenominaService implements IInformacionPrenominaService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<InformacionPrenominaDO> getAll() {
		List<InformacionPrenominaDO> datos= null;
		TypedQuery<InformacionPrenominaDO>  query =null;
		query = entityManager.createNamedQuery("InformacionPrenominaDO.findAll",InformacionPrenominaDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		InformacionPrenominaDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public InformacionPrenominaDO save(InformacionPrenominaDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public InformacionPrenominaDO update(InformacionPrenominaDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public InformacionPrenominaDO getItem(Integer id) {
		InformacionPrenominaDO cotizacion = entityManager.find(InformacionPrenominaDO.class,id);
		return cotizacion;
	}

}
