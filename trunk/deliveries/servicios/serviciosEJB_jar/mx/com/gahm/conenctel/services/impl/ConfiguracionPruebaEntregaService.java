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
import mx.com.gahm.conenctel.entities.ConfigPruebaEntregaDO;
import mx.com.gahm.conenctel.entities.EstadoDO;
import mx.com.gahm.conenctel.entities.ProyectoDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.IConfiguracionPruebaEntregaService;

@Stateless(mappedName = "ejb/ConfiguracionPruebaEntregaService")
public class ConfiguracionPruebaEntregaService implements IConfiguracionPruebaEntregaService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

//	@EJB
//	private TransformacionServiceEJB transformacionService;

	//TODO Solo devuelve los datos generales de proyectos activos
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ConfigPruebaEntregaDO> getAll() throws ConectelException {
		TypedQuery<ConfigPruebaEntregaDO> query = entityManager.createNamedQuery(
				"ConfigPruebaEntregaDO.findAll", ConfigPruebaEntregaDO.class);
		List<ConfigPruebaEntregaDO> configList;
		try {
			configList = query.getResultList();
		} catch(NoResultException e) {
			throw new ConectelException("No existen Configuraciones registrados.");
		}
		/*List<ConfiguracionPruebaEntrega> responseList;
		try {
			responseList = transformacionService.mapList(configList,
					ConfiguracionPruebaEntrega.class);
		} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return configList;
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
	public ConfigPruebaEntregaDO save(
			ConfigPruebaEntregaDO config) throws ConectelException {
		/*try {
			ConfigPruebaEntregaDO current = transformacionService
					.map(config, ConfigPruebaEntregaDO.class);*/
			entityManager.persist(config);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

	//TODO tomando en cuenta que solo se modifican requisiciones y ovservaciones
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ConfigPruebaEntregaDO update(
			ConfigPruebaEntregaDO config) throws ConectelException {
		/*try {
			ConfigPruebaEntregaDO current = transformacionService
					.map(config, ConfigPruebaEntregaDO.class);*/
			entityManager.merge(config);
		/*} catch (ConectelMappingException e) {
			throw new ConectelException("Error de sistema.");
		}*/
		return null;
	}

}
