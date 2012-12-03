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
import mx.com.gahm.conenctel.entities.CategoriaDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.FiltroProyecto;
import mx.com.gahm.conenctel.services.IProyectoService;

@Stateless(mappedName = "ejb/ProyectoService")
public class ProyectoService implements IProyectoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;
	
	//TODO Solo devuelve proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProyectoDO> getAllByFiltro(FiltroProyecto projectFilter) throws ConectelException {
		TypedQuery<ProyectoDO> query = entityManager.createNamedQuery(
				"ProductoDO.findByFilter", ProyectoDO.class);
		query.setParameter("idConectel", projectFilter.getIdConectel());
		query.setParameter("idCategoria", projectFilter.getIdCategoria());
		query.setParameter("idCliente", projectFilter.getIdCliente());
		query.setParameter("tipoProyecto", projectFilter.getTipoProyecto());
		query.setParameter("tecnologia", projectFilter.getTecnologia());
		query.setParameter("equipo", projectFilter.getEquipo());
		query.setParameter("actividadRealizar", projectFilter.getActividadRealizar());
		query.setParameter("modelo", projectFilter.getModelo());
		query.setParameter("descripcionServicio", projectFilter.getDescripcionServicio());
		query.setParameter("tipoServicio", projectFilter.getTipoServicio());
		query.setParameter("costo", projectFilter.getCosto());
		List<ProyectoDO> projectList;
		try {
			projectList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Proyectos registrados.");
		}
		/*List<Proyecto> responseList;
		try {
			responseList = transformacionService.mapList(projectList,
					Proyecto.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return projectList;
	}

	//TODO Solo Cambia su estado, si consideras mejor solo tener un servicio en Proyecto Service y te mando la fase por mi esta bien
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void cancelarProyecto(long idProject) throws ConectelException {
		ProyectoDO project = entityManager.find(ProyectoDO.class, idProject);
		if (project == null) {
			throw new ConectelException("El proyecto no existe");
		}
		EstadoDO estado = new EstadoDO(EstadoProyecto.CANCELADO.getId());
		project.setEstado(estado);
		entityManager.merge(project);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProyectoDO save(ProyectoDO project) throws ConectelException {
		/*try {
			ProyectoDO current = transformacionService
					.map(project, ProyectoDO.class);*/
			entityManager.persist(project);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	//TODO tomando en cuenta que solo se modifican requisiciones y ovservaciones
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProyectoDO update(ProyectoDO project) throws ConectelException {
		/*try {
			ProyectoDO current = transformacionService
					.map(project, ProyectoDO.class);*/
			entityManager.merge(project);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CategoriaDO> getCategorias() throws ConectelException {
		TypedQuery<CategoriaDO> query = entityManager.createNamedQuery(
				"CategoriaDO.findAll", CategoriaDO.class);
		List<CategoriaDO> categoryList = query.getResultList();
		/*List<Catalogo> responseList;
		try {
			responseList = transformacionService.mapList(categoryList,
					Catalogo.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return categoryList;
	}

}
