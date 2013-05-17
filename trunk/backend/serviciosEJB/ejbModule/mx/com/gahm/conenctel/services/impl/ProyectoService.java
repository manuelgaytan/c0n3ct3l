package mx.com.gahm.conenctel.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.swing.table.TableModel;

import mx.com.gahm.conenctel.constants.EstadoProyecto;
import mx.com.gahm.conenctel.entities.CategoriaDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.ObservacionDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.RequisicionDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.FiltroProyecto;
import mx.com.gahm.conenctel.services.IProyectoService;
import mx.com.gahm.conenctel.util.CSVParser;

@Stateless(mappedName = "ejb/ProyectoService")
public class ProyectoService implements IProyectoService {

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;
	
	//TODO Solo devuelve proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProyectoDO> getAllByFiltro(FiltroProyecto projectFilter) throws ConectelException {
		
		String queryString ="select p from ProyectoDO p " +
				"where ((:idProyecto is null or :idProyecto = 0) or p.id = :idProyecto) and ((:idCategoria is null or :idCategoria = 0)" +
				" or p.categoria.id = :idCategoria) and ((:idCliente is null or :idCliente = 0) or p.producto.cliente.id = :idCliente) and " +
				"((:tipoProyecto is null or :tipoProyecto = '') or p.producto.tipoProyecto = :tipoProyecto) and ((:tecnologia is null or :tecnologia = '') " +
				"or p.producto.teconologia = :tecnologia) and ((:equipo is null or :equipo = '') or p.producto.equipo = :equipo) and ((:actividadRealizar is null " +
				"or :actividadRealizar = '') or p.producto.actividadRealizar = :actividadRealizar) and ((:modelo is null or :modelo = '') or p.producto.modelo = " +
				":modelo) and ((:descripcionServicio is null or :descripcionServicio = '') or p.producto.descripcionServicio = :descripcionServicio) and " +
				"((:tipoServicio is null or :tipoServicio = '') or p.producto.tipoServicio = :tipoServicio) " ;
			
				if(projectFilter.getProyectoPadre()!=null && !projectFilter.getProyectoPadre().isEmpty())
					queryString+=" or p.proyectoPadreHijo.proyectoPadre.id in(select pp.id from ProyectoPadreDO pp where pp.descripcion like :proyectoPadre)";
		
		
		TypedQuery<ProyectoDO> query = entityManager.createQuery(
				queryString, ProyectoDO.class);
		query.setParameter("idProyecto", projectFilter.getIdConectel());
		query.setParameter("idCategoria", projectFilter.getIdCategoria());
		query.setParameter("idCliente", projectFilter.getIdCliente());
		query.setParameter("tipoProyecto", projectFilter.getTipoProyecto());
		query.setParameter("tecnologia", projectFilter.getTecnologia());
		query.setParameter("equipo", projectFilter.getEquipo());
		query.setParameter("actividadRealizar", projectFilter.getActividadRealizar());
		query.setParameter("modelo", projectFilter.getModelo());
		query.setParameter("descripcionServicio", projectFilter.getDescripcionServicio());
		query.setParameter("tipoServicio", projectFilter.getTipoServicio());
		
		if(projectFilter.getProyectoPadre()!=null && !projectFilter.getProyectoPadre().isEmpty()){
			query.setParameter("proyectoPadre","%"+ projectFilter.getProyectoPadre()+"%");
		}
		
		//query.setParameter("costo", projectFilter.getCosto());
		//query.setParameter("idEstado", 1);
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
		project.getProyectoPadreHijo().setProyecto(project);
		entityManager.persist(project);
		/*
		entityManager.persist(project.getProyectoPadreHijo());
		*//*
		 * 	entityManager.persist(project);
		 */
		return null;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProyectoDO update(ProyectoDO project) throws ConectelException {
		ProyectoDO regProject = entityManager.find(ProyectoDO.class, project.getId());
		
		if (project.getRequisiciones() != null) {
			List<RequisicionDO> requisiciones = regProject.getRequisiciones();
			for (RequisicionDO current:requisiciones) {
				entityManager.remove(current);
			}
			for (RequisicionDO current:requisiciones) {
				current.setProyecto(project);
			}
		}
		if (project.getObservaciones() != null) {
			List<ObservacionDO> observaciones=project.getObservaciones(); 
			for (ObservacionDO current:observaciones) {
				entityManager.remove(current);
			}
			for (ObservacionDO current:observaciones) {
				current.setProyecto(project);
				current.setEstado(project.getEstado());
			}
		}
		regProject.setObservaciones(project.getObservaciones());
		regProject.setRequisiciones(project.getRequisiciones());
		entityManager.merge(regProject);
		entityManager.flush();
		return regProject;
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

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ProyectoDO getProyecto(long idProject) throws ConectelException {
		ProyectoDO proyecto = entityManager.find(ProyectoDO.class, idProject);
		proyecto.setObservaciones(proyecto.getObservaciones());
		
		return proyecto;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public void importProyectos(String rutaArchivo) throws ConectelException {
		TableModel t = null;
		try {
			t = CSVParser.parse(new File(rutaArchivo));
		} catch (FileNotFoundException e) {
			throw new ConectelException("No se encontro el archivo con la ruta"
					+ rutaArchivo);
		}
		ProyectoDO proyecto = null;
		for (int x = 0; x < t.getRowCount(); x++) {
			proyecto = new ProyectoDO();
			// TODO
			//proyecto.setCategoria(categoria);
			//proyecto.setProducto(producto);
			proyecto.setCentralSitio((String) t.getValueAt(x, 2));
			//proyecto.setEstado(estado);
			proyecto.setFechaCaptura(new Date());
			
			entityManager.persist(proyecto);
		}
	}

	public List<ProyectoDO> getAllByEstado(Long idEstado){
		TypedQuery<ProyectoDO> query = entityManager.createNamedQuery(
				"ProyectoDO.getProyectosByEstado", ProyectoDO.class);
		query.setParameter("idEstado",idEstado);
		List<ProyectoDO> categoryList = query.getResultList();
		
		return categoryList;
	} 


}
