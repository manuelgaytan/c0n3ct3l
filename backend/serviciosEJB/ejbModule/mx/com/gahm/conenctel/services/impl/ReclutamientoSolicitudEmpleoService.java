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
	public List<ReclutamientoSolicitudEmpleoDO> getAllSeleccionFase() {
		List<ReclutamientoSolicitudEmpleoDO> datos= null;
		TypedQuery<ReclutamientoSolicitudEmpleoDO>  query =null;
		query = entityManager.createNamedQuery("ReclutamientoSolicitudEmpleoDO.findAllSeleccionFase",ReclutamientoSolicitudEmpleoDO.class);
		datos = query.getResultList();
		
		return datos;
	}

	@Override
	public void deleteItems(List<Integer> idsItems) {
		ReclutamientoSolicitudEmpleoDO item = null;
		for (Integer id : idsItems) {
			item =getItem(id);
			
			entityManager.remove(item.getDatosPrincipalesSolicitante());
			entityManager.remove(item.getDatosGeneralesSolicitante());
			entityManager.remove(item.getDatosFamiliaresSolicitante());
			entityManager.remove(item.getDatosEscolaresHabilidades());
			entityManager.remove(item.getDatosUltimoEmpleoSolicitante());
			entityManager.remove(item.getDatosSobreConectelSolicitante());
			//entityManager.remove(item.getSeleccionReclutamiento());
			
			entityManager.remove(item);
		}
		
	}

	@Override
	public ReclutamientoSolicitudEmpleoDO save(ReclutamientoSolicitudEmpleoDO item) {
		
		item.setDescripcion("descripcion");
		entityManager.persist(item);
		
		item.getDatosPrincipalesSolicitante().setReclutamientoSolicitudEmpleo(item);
		entityManager.persist(item.getDatosPrincipalesSolicitante());
		
		
		item.getDatosGeneralesSolicitante().setReclutamientoSolicitudEmpleo(item);
		entityManager.persist(item.getDatosGeneralesSolicitante());
		
		item.getDatosFamiliaresSolicitante().setReclutamientoSolicitudEmpleo(item);
		entityManager.persist(item.getDatosFamiliaresSolicitante());
		
		item.getDatosEscolaresHabilidades().getEquipoOficinaDomina().setDatosEscolaresHabilidades(item.getDatosEscolaresHabilidades());
		item.getDatosEscolaresHabilidades().getPaqueteria().setDatosEscolaresHabilidades(item.getDatosEscolaresHabilidades());
		
		item.getDatosEscolaresHabilidades().setReclutamientoSolicitudEmpleo(item);
		entityManager.persist(item.getDatosEscolaresHabilidades());
		
		item.getDatosUltimoEmpleoSolicitante().setReclutamientoSolicitudEmpleo(item);
		entityManager.persist(item.getDatosUltimoEmpleoSolicitante());
		
		item.getDatosSobreConectelSolicitante().setReclutamientoSolicitudEmpleo(item);
		entityManager.persist(item.getDatosSobreConectelSolicitante());
		
		//item.getSeleccionReclutamiento().setReclutamientoSolicitudEmpleo(item);
		//entityManager.persist(item.getSeleccionReclutamiento());
		return item;
	}

	@Override
	public ReclutamientoSolicitudEmpleoDO update(ReclutamientoSolicitudEmpleoDO item) {
		entityManager.merge(item);
		
		
		
		item.getDatosPrincipalesSolicitante().setReclutamientoSolicitudEmpleo(item);
		item.getDatosGeneralesSolicitante().setReclutamientoSolicitudEmpleo(item);
		item.getDatosFamiliaresSolicitante().setReclutamientoSolicitudEmpleo(item);
		item.getDatosEscolaresHabilidades().getEquipoOficinaDomina().setDatosEscolaresHabilidades(item.getDatosEscolaresHabilidades());
		item.getDatosEscolaresHabilidades().getPaqueteria().setDatosEscolaresHabilidades(item.getDatosEscolaresHabilidades());
		item.getDatosEscolaresHabilidades().setReclutamientoSolicitudEmpleo(item);
		item.getDatosUltimoEmpleoSolicitante().setReclutamientoSolicitudEmpleo(item);
		item.getDatosSobreConectelSolicitante().setReclutamientoSolicitudEmpleo(item);
		//item.getSeleccionReclutamiento().setReclutamientoSolicitudEmpleo(item);
		
		entityManager.merge(item.getDatosPrincipalesSolicitante());
		entityManager.merge(item.getDatosGeneralesSolicitante());
		entityManager.merge(item.getDatosFamiliaresSolicitante());
		entityManager.merge(item.getDatosEscolaresHabilidades().getEquipoOficinaDomina());
		entityManager.merge(item.getDatosEscolaresHabilidades().getPaqueteria());
		entityManager.merge(item.getDatosEscolaresHabilidades());
		entityManager.merge(item.getDatosUltimoEmpleoSolicitante());
		entityManager.merge(item.getDatosSobreConectelSolicitante());
		//entityManager.merge(item.getSeleccionReclutamiento());
		return item;
	}

	@Override
	public ReclutamientoSolicitudEmpleoDO getItem(Integer id) {
		ReclutamientoSolicitudEmpleoDO cotizacion = entityManager.find(ReclutamientoSolicitudEmpleoDO.class,id);
		return cotizacion;
	}

}
