/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.SeleccionReclutamientoDO;
import mx.com.gahm.conenctel.services.ISeleccionReclutamientoService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/SeleccionReclutamientoService")
public class SeleccionReclutamientoService implements ISeleccionReclutamientoService {
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<SeleccionReclutamientoDO> getAll() {
		List<SeleccionReclutamientoDO> datos= null;
		TypedQuery<SeleccionReclutamientoDO>  query =null;
		query = entityManager.createNamedQuery("SeleccionReclutamientoDO.findAll",SeleccionReclutamientoDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		SeleccionReclutamientoDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public SeleccionReclutamientoDO save(SeleccionReclutamientoDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public SeleccionReclutamientoDO update(SeleccionReclutamientoDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public SeleccionReclutamientoDO getItem(Integer id) {
		SeleccionReclutamientoDO cotizacion = entityManager.find(SeleccionReclutamientoDO.class,id);
		return cotizacion;
	}
}
