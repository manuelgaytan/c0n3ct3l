package mx.com.gahm.conenctel.services.impl;

import java.util.Date;
import java.util.List;
//import java.util.Properties;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.constants.EstadoProyecto;
import mx.com.gahm.conenctel.entities.AplicaDO;
import mx.com.gahm.conenctel.entities.DatosGrlsProyectoDO;
import mx.com.gahm.conenctel.entities.DatosGrlsProyectoImplDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.ObservacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.ProyectoEntregableDO;
import mx.com.gahm.conenctel.entities.TipoColaboradorDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
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
	
	//TODO Devuelve los datos generales de proyectos
		@TransactionAttribute(TransactionAttributeType.SUPPORTS)
		public List<DatosGrlsProyectoDO> getAllAll() throws ConectelException {
			TypedQuery<DatosGrlsProyectoDO> query = entityManager.createNamedQuery(
					"DatosGrlsProyectoDO.findAllAll", DatosGrlsProyectoDO.class);
			List<DatosGrlsProyectoDO> dataProjectList;
			try {
				dataProjectList = query.getResultList();
			} catch(NoResultException e) {
				throw new ConectelException("No existen Datos Generales registrados.");
			}
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
		List<DatosGrlsProyectoImplDO> responsablesImplementacion = dataProject.getDatosGrlsProyectoImplList();
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
			dataProject.setDatosGrlsProyectoImplList( null );
			entityManager.persist(dataProject);
			dataProject.setDatosGrlsProyectoImplList( responsablesImplementacion );
			if (dataProject.getDatosGrlsProyectoImplList() != null) {
				for (DatosGrlsProyectoImplDO current:dataProject.getDatosGrlsProyectoImplList()) {
					current.setDatosgeneralesproyecto(dataProject);
					entityManager.persist(current);
				}
			}
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		this.validarEnvioNotificaciones( dataProject );
		return dataProject;
	}

	private void validarEnvioNotificaciones(DatosGrlsProyectoDO dataProject) {
		if( dataProject == null ){
			return;
		}
		//Properties prop = new Properties();
		String mensaje = null;
		//try{
		if( (dataProject.getMaterial().getId() == AplicaDO.ID_SI) ||
			(dataProject.getHerramienta().getId() == AplicaDO.ID_SI) ||
			(dataProject.getEquipo().getId() == AplicaDO.ID_SI) ||
			(dataProject.getUnidad().getId() == AplicaDO.ID_SI) ){
			//prop.load( getClass().getClassLoader().getResourceAsStream("/notificaciones.properties") );
			mensaje = NotificacionDO.PROYECTO_ALMACEN + dataProject.getProyecto().getId();
			this.enviarNotificacion(PerfilDO.ID_ALMACEN, mensaje);
		}
		if( dataProject.getViaticos().getId() == AplicaDO.ID_SI ){
			//prop.load( getClass().getClassLoader().getResourceAsStream("/notificaciones.properties") );
			mensaje = NotificacionDO.PROYECTO_VIATICOS + dataProject.getProyecto().getId();
			this.enviarNotificacion(PerfilDO.ID_TESORERIA, mensaje);
		}
		if( dataProject.getDatosGrlsProyectoImplList() != null ){
			mensaje = NotificacionDO.PROYECTO_COMPRAS;
			boolean nomina = false;
			boolean proveedores = false;
			for( DatosGrlsProyectoImplDO item : dataProject.getDatosGrlsProyectoImplList() ) {
				if( item.getColaborador().getTipoColaborador().getId() == TipoColaboradorDO.NOMINA ){
					nomina = true;
				}
				if( item.getColaborador().getTipoColaborador().getId() == TipoColaboradorDO.PROVEEDORES ){
					proveedores = true;
				}
			}
			if( nomina ){
				mensaje += TipoColaboradorDO.STR_NOMINA;
			}
			if( nomina && proveedores ){
				mensaje += " y " + TipoColaboradorDO.STR_PROVEEDORES;
			}
			if( !nomina && proveedores ){
				mensaje += TipoColaboradorDO.STR_PROVEEDORES;
			}
			mensaje += NotificacionDO.PROYECTO_COMPRAS_2 + dataProject.getProyecto().getId();
			this.enviarNotificacion(PerfilDO.ID_COMPRAS, mensaje);
		}
		//}catch(Exception e){
			//System.out.println("No se logro leer el properties de Notificaciones");
		//}
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
	public DatosGrlsProyectoDO update(
			DatosGrlsProyectoDO dataProject) throws ConectelException {
		List<DatosGrlsProyectoImplDO> responsablesImplementacion = dataProject.getDatosGrlsProyectoImplList();
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
			if( regDataProject.getDatosGrlsProyectoImplList() != null ) {
				for(DatosGrlsProyectoImplDO current:regDataProject.getDatosGrlsProyectoImplList() ){
					entityManager.remove(current);
				}
			}
			dataProject.setDatosGrlsProyectoImplList( null );
			boolean cambioParaNotificacion = this.cambioParaNotificacion(regDataProject, dataProject);
			entityManager.merge(dataProject);
			dataProject.setDatosGrlsProyectoImplList( responsablesImplementacion );
			if (dataProject.getDatosGrlsProyectoImplList() != null) {
				for (DatosGrlsProyectoImplDO current:dataProject.getDatosGrlsProyectoImplList()) {
					current.setDatosgeneralesproyecto(dataProject);
					entityManager.persist(current);
				}
			}
			if( cambioParaNotificacion ){
				this.validarEnvioNotificaciones( dataProject );
			}
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	private boolean cambioParaNotificacion(DatosGrlsProyectoDO anterior, DatosGrlsProyectoDO nuevo) {
		boolean noCambio = true;
		noCambio = noCambio && ( anterior.getMaterial().getId() == nuevo.getMaterial().getId() );
		noCambio = noCambio && ( anterior.getHerramienta().getId() == nuevo.getHerramienta().getId() );
		noCambio = noCambio && ( anterior.getEquipo().getId() == nuevo.getEquipo().getId() );
		noCambio = noCambio && ( anterior.getUnidad().getId() == nuevo.getUnidad().getId() );
		noCambio = noCambio && ( anterior.getViaticos().getId() == nuevo.getViaticos().getId() );
		noCambio = noCambio && ( anterior.getDatosGrlsProyectoImplList().size() == nuevo.getDatosGrlsProyectoImplList().size() );
		return !noCambio;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public DatosGrlsProyectoDO getDatosGrlsProyecto(long idDataProject)
			throws ConectelException {
		return entityManager.find(DatosGrlsProyectoDO.class, idDataProject);
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public DatosGrlsProyectoDO getByIdProyecto(long idProyecto) throws ConectelException {
		TypedQuery<DatosGrlsProyectoDO> query = entityManager.createNamedQuery(
				"DatosGrlsProyectoDO.getByIdProyecto", DatosGrlsProyectoDO.class);
		query.setParameter("idProyecto", idProyecto);
		List<DatosGrlsProyectoDO> dataProjectList;
		try {
			dataProjectList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Datos Generales registrados.");
		}
		return dataProjectList.size() > 0 ? dataProjectList.get(0) : null;
	}
}
