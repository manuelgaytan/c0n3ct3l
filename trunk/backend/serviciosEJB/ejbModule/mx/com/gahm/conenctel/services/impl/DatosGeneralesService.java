package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.constants.EstadoProyecto;
import mx.com.gahm.conenctel.entities.DatosGrlsProyectoDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.ObservacionDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.ProyectoEntregableDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IDatosGeneralesService;

@Stateless(mappedName = "ejb/DatosGeneralesService")
public class DatosGeneralesService implements IDatosGeneralesService {

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	//TODO Solo devuelve los datos generales de proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DatosGrlsProyectoDO> getAll() throws ConectelException {
		TypedQuery<DatosGrlsProyectoDO> query = entityManager.createNamedQuery(
				"DatosGrlsProyectoDO.findAll", DatosGrlsProyectoDO.class);
		//query.setParameter("idEstado", 2);
		List<DatosGrlsProyectoDO> dataProjectList;
		try {
			dataProjectList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Datos Generales registrados.");
		}
		/*List<DatosGeneralesProyecto> responseList;
		try {
			responseList = transformacionService.mapList(dataProjectList,
					DatosGeneralesProyecto.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return dataProjectList;
	}

	//TODO Solo Cambia su estado, si consideras mejor solo tener un servicio en Proyecto Service y te mando la fase por mi esta bien
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void hechoFase(long idProject) throws ConectelException {
		ProyectoDO project = entityManager.find(ProyectoDO.class, idProject);
		if (project == null) {
			throw new ConectelException("El proyecto no existe");
		}
		EstadoDO estado = new EstadoDO(EstadoProyecto.DATOS_GRLS.getId());
		project.setEstado(estado);
		entityManager.merge(project);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DatosGrlsProyectoDO save(
			DatosGrlsProyectoDO dataProject) throws ConectelException {
		/*try {
			DatosGrlsProyectoDO current = transformacionService
					.map(dataProject, DatosGrlsProyectoDO.class);*/
			if (dataProject.getProyecto().getProyectoEntregables() != null) {
				for (ProyectoEntregableDO current:dataProject.getProyecto().getProyectoEntregables()) {
					entityManager.persist(current.getEntregable());
					current.setProyecto(dataProject.getProyecto());
					entityManager.persist(current);
				}
			}
			if (dataProject.getProyecto().getObservaciones() != null) {
				for (ObservacionDO current:dataProject.getProyecto().getObservaciones()) {
					current.setProyecto(dataProject.getProyecto());
					current.setEstado(dataProject.getProyecto().getEstado());
					entityManager.persist(current);
				}
			}
			entityManager.persist(dataProject);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DatosGrlsProyectoDO update(
			DatosGrlsProyectoDO dataProject) throws ConectelException {
		/*try {
			DatosGrlsProyectoDO current = transformacionService
					.map(dataProject, DatosGrlsProyectoDO.class);*/
			DatosGrlsProyectoDO regDataProject = entityManager.find(DatosGrlsProyectoDO.class, dataProject.getId());
			if (dataProject.getProyecto().getProyectoEntregables() != null) {
				for (ProyectoEntregableDO current:regDataProject.getProyecto().getProyectoEntregables()) {
					entityManager.remove(current.getEntregable());
					entityManager.remove(current);
				}
				for (ProyectoEntregableDO current:dataProject.getProyecto().getProyectoEntregables()) {
					entityManager.persist(current.getEntregable());
					current.setProyecto(dataProject.getProyecto());
					entityManager.persist(current);
				}
			}
			if (dataProject.getProyecto().getObservaciones() != null) {
				for (ObservacionDO current:regDataProject.getProyecto().getObservaciones()) {
					entityManager.remove(current);
				}
				for (ObservacionDO current:dataProject.getProyecto().getObservaciones()) {
					current.setProyecto(dataProject.getProyecto());
					current.setEstado(dataProject.getProyecto().getEstado());
					entityManager.persist(current);
				}
			}
			entityManager.merge(dataProject);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public DatosGrlsProyectoDO getDatosGrlsProyecto(long idDataProject)
			throws ConectelException {
		return entityManager.find(DatosGrlsProyectoDO.class, idDataProject);
	}

}
