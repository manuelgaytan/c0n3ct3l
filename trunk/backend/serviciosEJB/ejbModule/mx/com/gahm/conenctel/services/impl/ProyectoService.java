package mx.com.gahm.conenctel.services.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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
import mx.com.gahm.conenctel.entities.AplicaDO;
import mx.com.gahm.conenctel.entities.CategoriaDO;
import mx.com.gahm.conenctel.entities.ConfigPruebaEntregaDO;
import mx.com.gahm.conenctel.entities.DatosGeneralesProyectoDO;
import mx.com.gahm.conenctel.entities.DatosGrlsProyectoDO;
import mx.com.gahm.conenctel.entities.DesarrolloProyectoABDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.ObservacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.RequisicionDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.model.ConsultaGeneralOperacion;
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
			/*
				if(projectFilter.getProyectoPadre()!=null && !projectFilter.getProyectoPadre().isEmpty())
					queryString+=" or p.proyectoPadreHijo.proyectoPadre.id in(select pp.id from ProyectoPadreDO pp where pp.descripcion like :proyectoPadre)";
			*/
		if(projectFilter.getProyectoPadre()!=null && !projectFilter.getProyectoPadre().isEmpty())
			queryString=" select p from ProyectoDO p where p.proyectoPadreHijo.proyectoPadre.descripcion like (:proyectoPadre)";	
			
		
		TypedQuery<ProyectoDO> query = entityManager.createQuery(
				queryString, ProyectoDO.class);
		
		if(projectFilter.getProyectoPadre()!=null && !projectFilter.getProyectoPadre().isEmpty()){
			query.setParameter("proyectoPadre","%"+ projectFilter.getProyectoPadre()+"%");
		}else{
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
		
		List<RequisicionDO> requisiciones = project.getRequisiciones();
		List<ObservacionDO> observaciones = project.getObservaciones();
		
		project.setRequisiciones(null);
		project.setObservaciones(null);
		
		project.getProyectoPadreHijo().setProyecto(project);
		
		entityManager.persist(project);
		if (requisiciones != null) {
			for (RequisicionDO current:requisiciones) {
				current.setProyecto(project);
				entityManager.persist(current);
			}
		}
		if (observaciones != null) {
			for (ObservacionDO current:observaciones) {
				current.setProyecto(project);
				current.setEstado(project.getEstado());
				entityManager.persist(current);
			}
		}
		/*
		entityManager.flush();
		System.out.println("-> proyecto id: "+project.getId());
		this.validarEnvioNotificaciones( project );
		
		project.setRequisiciones(requisiciones);
		project.setObservaciones(observaciones);
		
		this.update(project);
		*/
		/*
		entityManager.persist(project.getProyectoPadreHijo());
		*//*
		 * 	entityManager.persist(project);
		 */
		return project;
	}
	
	private void validarEnvioNotificaciones(ProyectoDO project) {
		if( project == null ){
			return;
		}
		String mensaje = null;
		mensaje = NotificacionDO.PROYECTO_CREACION + project.getId();
		this.enviarNotificacion(PerfilDO.ID_TESORERIA, mensaje);
		this.enviarNotificacion(PerfilDO.ID_FACTURACION, mensaje);
		this.enviarNotificacion(PerfilDO.ID_VALIDACION_ADMINISTRATIVA, mensaje);
	}
	
	private void enviarNotificacion(int idPerfil, String mensaje) {
		PerfilDO perfil = entityManager.find(PerfilDO.class, idPerfil);
		UsuarioDO usuario = entityManager.find(UsuarioDO.class, UsuarioDO.ID_AUTOMATICO);
		EstadoNotificacionDO estado = entityManager.find(EstadoNotificacionDO.class, EstadoNotificacionDO.ID_PENDIENTE);
		NotificacionDO notificacion = new NotificacionDO();
		notificacion.setPerfil(perfil);
		notificacion.setNotificacion(mensaje);
		notificacion.setUsuarioCreacion(usuario);
		notificacion.setFechaHoraCreacion(new Date());
		notificacion.setEstado(estado);
		entityManager.persist(notificacion);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ProyectoDO update(ProyectoDO project) throws ConectelException {
		// almacena temporalmente
		List<RequisicionDO> requisiciones = project.getRequisiciones();
		List<ObservacionDO> observaciones = project.getObservaciones();
		// borra las anteriores
		ProyectoDO regProject = entityManager.find(ProyectoDO.class, project.getId());
		if (regProject.getRequisiciones() != null) {
			for (RequisicionDO current:regProject.getRequisiciones()) {
				entityManager.remove(current);
			}
		}
		if (regProject.getObservaciones() != null) {
			for (ObservacionDO current:regProject.getObservaciones()) {
				entityManager.remove(current);
			}
		}
		if( regProject.getProyectoPadreHijo() != null ){
			entityManager.remove( regProject.getProyectoPadreHijo() );
		}
		// guarda las nuevas
		if (requisiciones != null) {
			for (RequisicionDO current:requisiciones) {
				current.setProyecto(project);
				entityManager.persist(current);
			}
		}
		if (observaciones != null) {
			for (ObservacionDO current:observaciones) {
				current.setProyecto(project);
				current.setEstado(project.getEstado());
				entityManager.persist(current);
			}
		}
		project.setRequisiciones(requisiciones);
		project.setObservaciones(observaciones);
		project.getProyectoPadreHijo().setProyecto(project);
		entityManager.merge(project);
		return project;
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

	public List<ProyectoDO> getAllByEstado(Long idEstado) throws ConectelException{
		TypedQuery<ProyectoDO> query = entityManager.createNamedQuery(
				"ProyectoDO.getProyectosByEstado", ProyectoDO.class);
		query.setParameter("idEstado",idEstado);
		List<ProyectoDO> categoryList = query.getResultList();
		
		return categoryList;
	} 
	
	public List<ProyectoDO> getAllByWithOutMaquilaRequest() throws ConectelException{
		TypedQuery<ProyectoDO> query = entityManager.createNamedQuery(
				"ProyectoDO.getAllByWithOutMaquilaRequest", ProyectoDO.class);
		List<ProyectoDO> categoryList = query.getResultList();		
		return categoryList;
	}
	
	public List<ConsultaGeneralOperacion> getProyectosAndDerivatesByID( Long idProyecto) throws ConectelException{
		ProyectoDO proyectoDO = this.getProyecto( idProyecto );
		if( proyectoDO == null ){
			return null;
		}
		List<ProyectoDO> proyectos = new ArrayList<ProyectoDO>();
		proyectos.add( proyectoDO );
		return this.getDerivates( proyectos );
	}
	
	public List<ConsultaGeneralOperacion> getProyectosAndDerivates() throws ConectelException{
		TypedQuery<ProyectoDO> query = entityManager.createNamedQuery(
				"ProyectoDO.getAll", ProyectoDO.class);
		List<ProyectoDO> proyectos = query.getResultList();
		return this.getDerivates( proyectos );
	}
	
	private List<ConsultaGeneralOperacion> getDerivates(List<ProyectoDO> proyectos){
		TypedQuery<DatosGrlsProyectoDO> queryDGP = entityManager.createNamedQuery(
				"DatosGrlsProyectoDO.findAllAll", DatosGrlsProyectoDO.class);
		List<DatosGrlsProyectoDO> datosgeneralesproyecto = queryDGP.getResultList();
		TypedQuery<DesarrolloProyectoABDO> queryDP = entityManager.createNamedQuery(
				"DesarrolloProyectoABDO.findAllAll", DesarrolloProyectoABDO.class);
		List<DesarrolloProyectoABDO> desarrolloproyectoab = queryDP.getResultList();
		TypedQuery<ConfigPruebaEntregaDO> queryCPE = entityManager.createNamedQuery(
				"ConfigPruebaEntregaDO.findAllAll", ConfigPruebaEntregaDO.class);
		List<ConfigPruebaEntregaDO> configpruebaentrega = queryCPE.getResultList();
		List<ConsultaGeneralOperacion> list = new ArrayList<ConsultaGeneralOperacion>();
		ConsultaGeneralOperacion consultaGeneralOperacion = null;
		for (ProyectoDO proyecto : proyectos) {
			consultaGeneralOperacion = new ConsultaGeneralOperacion();
			consultaGeneralOperacion.setProyecto(proyecto);
			for (DatosGrlsProyectoDO datosGeneralesProyecto : datosgeneralesproyecto) {
				if( !(datosGeneralesProyecto == null) &&
					!(datosGeneralesProyecto.getProyecto() == null) &&
					datosGeneralesProyecto.getProyecto().getId() == proyecto.getId() ){
					consultaGeneralOperacion.setDatosGeneralesProyecto(datosGeneralesProyecto);
					break;
				}
			}
			for (DesarrolloProyectoABDO desarrolloProyectoAB : desarrolloproyectoab) {
				if( !(desarrolloProyectoAB == null) &&
					!(desarrolloProyectoAB.getProyecto() == null) &&
					desarrolloProyectoAB.getProyecto().getId() == proyecto.getId() ){
					consultaGeneralOperacion.setDesarrolloProyecto(desarrolloProyectoAB);
					break;
				}
			}
			for (ConfigPruebaEntregaDO configuracionPruebaEntrega : configpruebaentrega) {
				if( !(configuracionPruebaEntrega == null) &&
					!(configuracionPruebaEntrega.getProyecto() == null) &&
					configuracionPruebaEntrega.getProyecto().getId() == proyecto.getId() ){
					consultaGeneralOperacion.setConfiguracionPruebaEntrega(configuracionPruebaEntrega);
					break;
				}
			}
			list.add(consultaGeneralOperacion);
		}
		return list;
	}
	
	public List<ProyectoDO> getAllByWithOutCustomerPurchaseOrder() throws ConectelException{
		TypedQuery<ProyectoDO> query = entityManager.createNamedQuery(
				"ProyectoDO.getAllByWithOutCustomerPurchaseOrder", ProyectoDO.class);
		List<ProyectoDO> categoryList = query.getResultList();		
		return categoryList;
	}
}
