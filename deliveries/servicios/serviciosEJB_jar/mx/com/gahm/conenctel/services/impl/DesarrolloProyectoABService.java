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
import mx.com.gahm.conenctel.entities.DesarrolloProyectoABDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IDesarrolloProyectoABService;

@Stateless(mappedName = "ejb/DesarrolloProyectoABService")
public class DesarrolloProyectoABService implements IDesarrolloProyectoABService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	//TODO Solo devuelve los datos generales de proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DesarrolloProyectoABDO> getAll() throws ConectelException {
		TypedQuery<DesarrolloProyectoABDO> query = entityManager.createNamedQuery(
				"DesarrolloProyectoABDO.findAll", DesarrolloProyectoABDO.class);
		List<DesarrolloProyectoABDO> developmentProjectList;
		try {
			developmentProjectList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Desarrollos de Proyecto A y B registrados.");
		}
		/*List<DesarrolloProyectoAB> responseList;
		try {
			responseList = transformacionService.mapList(developmentProjectList,
					DesarrolloProyectoAB.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return developmentProjectList;
	}

	//TODO Solo Cambia su estado, si consideras mejor solo tener un servicio en Proyecto Service y te mando la fase por mi esta bien
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void hechoFase(long idProject) throws ConectelException {
		ProyectoDO project = entityManager.find(ProyectoDO.class, idProject);
		if (project == null) {
			throw new ConectelException("El proyecto no existe");
		}
		EstadoDO estado = new EstadoDO(EstadoProyecto.PROYECTO_AB.getId());
		project.setEstado(estado);
		entityManager.merge(project);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DesarrolloProyectoABDO save(
			DesarrolloProyectoABDO developmentProject) throws ConectelException {
		/*try {
			DesarrolloProyectoABDO current = transformacionService
					.map(developmentProject, DesarrolloProyectoABDO.class);*/
			entityManager.persist(developmentProject);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	//TODO tomando en cuenta que solo se modifican requisiciones y ovservaciones
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DesarrolloProyectoABDO update(
			DesarrolloProyectoABDO developmentProject) throws ConectelException {
		/*try {
			DesarrolloProyectoABDO current = transformacionService
					.map(developmentProject, DesarrolloProyectoABDO.class);*/
			entityManager.merge(developmentProject);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

}
