/**
 * 
 */
package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.ReclutamientoSolicitudEmpleoDO;
import mx.com.gahm.conenctel.services.IReclutamientoSolicitudEmpleoService;

/**
 * @author MHDolores
 *
 */
@Stateless(mappedName = "ejb/ReclutamientoSolicitudEmpleoService")
public class ReclutamientoSolicitudEmpleoService implements IReclutamientoSolicitudEmpleoService{
	@Inject
	private EntityManager entityManager;
	
	@Override
	public List<ReclutamientoSolicitudEmpleoDO> getAll() {
		List<ReclutamientoSolicitudEmpleoDO> datos= null;
		TypedQuery<ReclutamientoSolicitudEmpleoDO>  query =null;
		query = entityManager.createNamedQuery("ReclutamientoSolicitudEmpleoDO.findAll",ReclutamientoSolicitudEmpleoDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ReclutamientoSolicitudEmpleoDO cotizacion = null;
		for (Integer id : idsItems) {
			cotizacion =getItem(id);
			entityManager.remove(cotizacion);
		}
		
	}

	@Override
	public ReclutamientoSolicitudEmpleoDO save(ReclutamientoSolicitudEmpleoDO item) {
		entityManager.persist(item);
		return item;
	}

	@Override
	public ReclutamientoSolicitudEmpleoDO update(ReclutamientoSolicitudEmpleoDO item) {
		entityManager.merge(item);
		return item;
	}

	@Override
	public ReclutamientoSolicitudEmpleoDO getItem(Integer id) {
		ReclutamientoSolicitudEmpleoDO cotizacion = entityManager.find(ReclutamientoSolicitudEmpleoDO.class,id);
		return cotizacion;
	}

}
