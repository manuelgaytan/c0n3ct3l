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
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IDatosGeneralesService;

@Stateless(mappedName = "ejb/DatosGeneralesService")
public class DatosGeneralesService implements IDatosGeneralesService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	//TODO Solo devuelve los datos generales de proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DatosGrlsProyectoDO> getAll() throws ConectelException {
		TypedQuery<DatosGrlsProyectoDO> query = entityManager.createNamedQuery(
				"DatosGrlsProyectoDO.findAll", DatosGrlsProyectoDO.class);
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
			entityManager.persist(dataProject);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	//TODO tomando en cuenta que solo se modifican requisiciones y ovservaciones
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DatosGrlsProyectoDO update(
			DatosGrlsProyectoDO dataProject) throws ConectelException {
		/*try {
			DatosGrlsProyectoDO current = transformacionService
					.map(dataProject, DatosGrlsProyectoDO.class);*/
			entityManager.merge(dataProject);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

}
