package mx.com.gahm.conenctel.services.impl;

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

import mx.com.gahm.conenctel.constants.EstadoProyecto;
import mx.com.gahm.conenctel.entities.ConfigPruebaEntregaDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.EstadoNotificacionDO;
import mx.com.gahm.conenctel.entities.NotificacionDO;
import mx.com.gahm.conenctel.entities.ObservacionDO;
import mx.com.gahm.conenctel.entities.PerfilDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.entities.ProyectoEntregableDO;
import mx.com.gahm.conenctel.entities.UsuarioDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IConfiguracionPruebaEntregaService;

@Stateless(mappedName = "ejb/ConfiguracionPruebaEntregaService")
public class ConfiguracionPruebaEntregaService implements IConfiguracionPruebaEntregaService {

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	//TODO Solo devuelve los datos generales de proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ConfigPruebaEntregaDO> getAll() throws ConectelException {
		TypedQuery<ConfigPruebaEntregaDO> query = entityManager.createNamedQuery(
				"ConfigPruebaEntregaDO.findAll", ConfigPruebaEntregaDO.class);
		//query.setParameter("idEstado", 4);
		List<ConfigPruebaEntregaDO> configList;
		try {
			configList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Configuraciones registrados.");
		}
		
		llenarProyectoEntregableList(configList);
		return configList;
	}

	private void llenarProyectoEntregableList(
			List<ConfigPruebaEntregaDO> configList) {
		for (ConfigPruebaEntregaDO config:configList) {
			config.setSiteSurvey(new ArrayList<ProyectoEntregableDO>());
			config.setPlanos(new ArrayList<ProyectoEntregableDO>());
			config.setIngenieria(new ArrayList<ProyectoEntregableDO>());
			config.setVisitaFactibilidad(new ArrayList<ProyectoEntregableDO>());
			config.setCarpetaAdministrativa(new ArrayList<ProyectoEntregableDO>());
			config.setProtocolo(new ArrayList<ProyectoEntregableDO>());
			config.setOt(new ArrayList<ProyectoEntregableDO>());
			config.setClienteSatisfecho(new ArrayList<ProyectoEntregableDO>());
			config.setChecklistInspeccion(new ArrayList<ProyectoEntregableDO>());
			config.setChecklistFotografico(new ArrayList<ProyectoEntregableDO>());
			config.setAsBuild(new ArrayList<ProyectoEntregableDO>());
			config.setEntregableX(new ArrayList<ProyectoEntregableDO>());
			config.setEntregableY(new ArrayList<ProyectoEntregableDO>());
			for (ProyectoEntregableDO current:config.getProyecto().getProyectoEntregables()) {
				switch(current.getEntregable().getIdTipoEntregable()) {
				case(1):
					config.getSiteSurvey().add(current);
					break;
				case(2):
					config.getPlanos().add(current);
					break;
				case(3):
					config.getIngenieria().add(current);
					break;
				case(4):
					config.getVisitaFactibilidad().add(current);
					break;
				case(5):
					config.getCarpetaAdministrativa().add(current);
					break;
				case(6):
					config.getProtocolo().add(current);
					break;
				case(7):
					config.getOt().add(current);
					break;
				case(8):
					config.getClienteSatisfecho().add(current);
					break;
				case(9):
					config.getChecklistInspeccion().add(current);
					break;
				case(10):
					config.getChecklistFotografico().add(current);
					break;
				case(11):
					config.getAsBuild().add(current);
					break;
				case(12):
					config.getEntregableX().add(current);
					break;
				case(13):
					config.getEntregableY().add(current);
					break;
				}
			}
		}
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
	public ConfigPruebaEntregaDO save(ConfigPruebaEntregaDO config)
			throws ConectelException {

		agregarProyectoEntregable(config.getSiteSurvey(), config.getProyecto());
		agregarProyectoEntregable(config.getPlanos(), config.getProyecto());
		agregarProyectoEntregable(config.getIngenieria(), config.getProyecto());
		agregarProyectoEntregable(config.getVisitaFactibilidad(),
				config.getProyecto());
		agregarProyectoEntregable(config.getCarpetaAdministrativa(),
				config.getProyecto());
		agregarProyectoEntregable(config.getProtocolo(), config.getProyecto());
		agregarProyectoEntregable(config.getOt(), config.getProyecto());
		agregarProyectoEntregable(config.getClienteSatisfecho(),
				config.getProyecto());
		agregarProyectoEntregable(config.getChecklistInspeccion(),
				config.getProyecto());
		agregarProyectoEntregable(config.getChecklistFotografico(),
				config.getProyecto());
		agregarProyectoEntregable(config.getAsBuild(), config.getProyecto());
		agregarProyectoEntregable(config.getEntregableX(), config.getProyecto());
		agregarProyectoEntregable(config.getEntregableY(), config.getProyecto());

		if (config.getProyecto().getObservaciones() != null) {
			for (ObservacionDO current : config.getProyecto()
					.getObservaciones()) {
				current.setProyecto(config.getProyecto());
				current.setEstado(config.getProyecto().getEstado());
				entityManager.persist(current);
			}
		}
		
		//actualizarClaveAuditoria(config);
		
		entityManager.persist(config);
		return null;
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConfigPruebaEntregaDO update(ConfigPruebaEntregaDO config)
			throws ConectelException {

		ConfigPruebaEntregaDO regConfig = entityManager.find(
				ConfigPruebaEntregaDO.class, config.getId());
		if (regConfig.getProyecto().getProyectoEntregables() != null) {
			for (ProyectoEntregableDO current : regConfig.getProyecto()
					.getProyectoEntregables()) {
				entityManager.remove(current.getEntregable());
				entityManager.remove(current);
			}
		}
		if( config.getSiteSurvey() != null ){
			for (ProyectoEntregableDO current : config.getSiteSurvey()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getPlanos() != null ){  
			for (ProyectoEntregableDO current : config.getPlanos()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getIngenieria() != null ){
			for (ProyectoEntregableDO current : config.getIngenieria()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getVisitaFactibilidad() != null ){
			for (ProyectoEntregableDO current : config.getVisitaFactibilidad()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getCarpetaAdministrativa() != null ){
			for (ProyectoEntregableDO current : config.getCarpetaAdministrativa()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getProtocolo() != null ){
			for (ProyectoEntregableDO current : config.getProtocolo()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getOt() != null ){
			for (ProyectoEntregableDO current : config.getOt()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getClienteSatisfecho() != null ){
			for (ProyectoEntregableDO current : config.getClienteSatisfecho()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getChecklistInspeccion() != null ){
			for (ProyectoEntregableDO current : config.getChecklistInspeccion()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getChecklistFotografico() != null ){
			for (ProyectoEntregableDO current : config.getChecklistFotografico()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getAsBuild() != null ){
			for (ProyectoEntregableDO current : config.getAsBuild()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getEntregableX() != null ){
			for (ProyectoEntregableDO current : config.getEntregableX()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}
		if( config.getEntregableY() != null ){
			for (ProyectoEntregableDO current : config.getEntregableY()) {
				current.getEntregable().setId(0l);
				current.setId(0l);
			}
		}

		agregarProyectoEntregable(config.getSiteSurvey(), config.getProyecto());
		agregarProyectoEntregable(config.getPlanos(), config.getProyecto());
		agregarProyectoEntregable(config.getIngenieria(), config.getProyecto());
		agregarProyectoEntregable(config.getVisitaFactibilidad(),
				config.getProyecto());
		agregarProyectoEntregable(config.getCarpetaAdministrativa(),
				config.getProyecto());
		agregarProyectoEntregable(config.getProtocolo(), config.getProyecto());
		agregarProyectoEntregable(config.getOt(), config.getProyecto());
		agregarProyectoEntregable(config.getClienteSatisfecho(),
				config.getProyecto());
		agregarProyectoEntregable(config.getChecklistInspeccion(),
				config.getProyecto());
		agregarProyectoEntregable(config.getChecklistFotografico(),
				config.getProyecto());
		agregarProyectoEntregable(config.getAsBuild(), config.getProyecto());
		agregarProyectoEntregable(config.getEntregableX(), config.getProyecto());
		agregarProyectoEntregable(config.getEntregableY(), config.getProyecto());

		if (config.getProyecto().getObservaciones() != null) {
			for (ObservacionDO current : regConfig.getProyecto()
					.getObservaciones()) {
				entityManager.remove(current);
			}
			for (ObservacionDO current : config.getProyecto()
					.getObservaciones()) {
				current.setProyecto(config.getProyecto());
				current.setEstado(config.getProyecto().getEstado());
				entityManager.persist(current);
			}
		}
		
		//actualizarClaveAuditoria(config);
		
		entityManager.merge(config);
		return null;
	}

	private void actualizarClaveAuditoria(ConfigPruebaEntregaDO config) {
		ProyectoDO proyectoDO = entityManager.find(ProyectoDO.class, config.getProyecto().getId());
		proyectoDO.setClaveAuditoria( config.getProyecto().getClaveAuditoria() );
		entityManager.merge( proyectoDO );
	}

	private void agregarProyectoEntregable(
			List<ProyectoEntregableDO> entregableList, ProyectoDO proyecto) {
		if (entregableList != null) {
			for (ProyectoEntregableDO current : entregableList) {
				entityManager.persist(current.getEntregable());
				current.setProyecto(proyecto);
				entityManager.persist(current);
			}
		}
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public ConfigPruebaEntregaDO getConfigPruebaEntrega(long idConfig)
			throws ConectelException {
		return entityManager.find(ConfigPruebaEntregaDO.class, idConfig);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void terminarProyecto(long idProject, String claveAuditoria) throws ConectelException {
		ProyectoDO project = entityManager.find(ProyectoDO.class, idProject);
		if (project == null) {
			throw new ConectelException("El proyecto no existe");
		}
		EstadoDO estado = new EstadoDO(EstadoProyecto.CERRADO.getId());
		project.setEstado(estado);
		project.setClaveAuditoria(claveAuditoria);
		entityManager.merge(project);
		this.validarEnvioNotificaciones( project );
	}

	private void validarEnvioNotificaciones(ProyectoDO project) {
		if( project == null ){
			return;
		}
		String mensaje = null;
		mensaje = NotificacionDO.PROYECTO_TERMINO + project.getId();
		this.enviarNotificacion(PerfilDO.ID_VALIDACION_ADMINISTRATIVA, mensaje);
		this.enviarNotificacion(PerfilDO.ID_FACTURACION, mensaje);
		this.enviarNotificacion(PerfilDO.ID_TESORERIA, mensaje);
		this.enviarNotificacion(PerfilDO.ID_COORDINADOR_OPERATIVO, mensaje);
		this.enviarNotificacion(PerfilDO.ID_GERENTE_OPERATIVO, mensaje);
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
}
