package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.AplicaDO;
import mx.com.gahm.conenctel.entities.AreaSolicitanteDO;
import mx.com.gahm.conenctel.entities.ColaboradorDO;
import mx.com.gahm.conenctel.entities.CompaniaDO;
import mx.com.gahm.conenctel.entities.DescripcionAlmacenDO;
import mx.com.gahm.conenctel.entities.EstatusADO;
import mx.com.gahm.conenctel.entities.EstatusBDO;
import mx.com.gahm.conenctel.entities.EstatusCDO;
import mx.com.gahm.conenctel.entities.EstatusRequisicionCompraDO;
import mx.com.gahm.conenctel.entities.FormaPagoDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaADO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaBDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaCDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaDDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaEDO;
import mx.com.gahm.conenctel.entities.GrupoFamiliaFDO;
import mx.com.gahm.conenctel.entities.ImputableDO;
import mx.com.gahm.conenctel.entities.PrioridadDO;
import mx.com.gahm.conenctel.entities.SeguimientoDO;
import mx.com.gahm.conenctel.entities.ServicioSolicitadoDO;
import mx.com.gahm.conenctel.entities.TipoAlmacenDO;
import mx.com.gahm.conenctel.entities.TipoContratoDO;
import mx.com.gahm.conenctel.entities.TipoMantenimientoDO;
import mx.com.gahm.conenctel.entities.TipoPagoDO;
import mx.com.gahm.conenctel.entities.TipoPersonaDO;
import mx.com.gahm.conenctel.entities.UbicacionADO;
import mx.com.gahm.conenctel.entities.UbicacionBDO;
import mx.com.gahm.conenctel.entities.UbicacionCDO;
import mx.com.gahm.conenctel.entities.UnidadADO;
import mx.com.gahm.conenctel.entities.UnidadBDO;
import mx.com.gahm.conenctel.entities.UnidadCDO;
import mx.com.gahm.conenctel.entities.UnidadOrdenCompraDO;
import mx.com.gahm.conenctel.exceptions.ConectelException;
import mx.com.gahm.conenctel.services.ICatalogoService;

@Stateless(mappedName = "ejb/CatalogoService")
public class CatalogoService implements ICatalogoService {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager entityManager;

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AplicaDO> getAplica() throws ConectelException {
		TypedQuery<AplicaDO> query = entityManager.createNamedQuery(
				"AplicaDO.findAll", AplicaDO.class);
		List<AplicaDO> aplicaList;
		try {
			aplicaList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Aplica registrados.");
		}
		return aplicaList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<SeguimientoDO> getSeguimiento() throws ConectelException {
		TypedQuery<SeguimientoDO> query = entityManager.createNamedQuery(
				"SeguimientoDO.findAll", SeguimientoDO.class);
		List<SeguimientoDO> seguimientoList;
		try {
			seguimientoList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Seguimientos registrados.");
		}
		return seguimientoList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ImputableDO> getImputable() throws ConectelException {
		TypedQuery<ImputableDO> query = entityManager.createNamedQuery(
				"ImputableDO.findAll", ImputableDO.class);
		List<ImputableDO> imputableList;
		try {
			imputableList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Imputable registrados.");
		}
		return imputableList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoAlmacenDO> getTipoAlmacen() throws ConectelException {
		TypedQuery<TipoAlmacenDO> query = entityManager.createNamedQuery(
				"TipoAlmacenDO.findAll", TipoAlmacenDO.class);
		List<TipoAlmacenDO> tipoAlmacenList;
		try {
			tipoAlmacenList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Tipo Almacen registrados.");
		}
		return tipoAlmacenList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoFamiliaADO> getGrupoFamiliaA() throws ConectelException {
		TypedQuery<GrupoFamiliaADO> query = entityManager.createNamedQuery(
				"GrupoFamiliaADO.findAll", GrupoFamiliaADO.class);
		List<GrupoFamiliaADO> grupoFamiliaAList;
		try {
			grupoFamiliaAList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existen Grupo Familia A registrados.");
		}
		return grupoFamiliaAList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UnidadADO> getUnidadA() throws ConectelException {
		TypedQuery<UnidadADO> query = entityManager.createNamedQuery(
				"UnidadADO.findAll", UnidadADO.class);
		List<UnidadADO> unidadAList;
		try {
			unidadAList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Unidad A registrados.");
		}
		return unidadAList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UbicacionADO> getUbicacionA() throws ConectelException {
		TypedQuery<UbicacionADO> query = entityManager.createNamedQuery(
				"UbicacionADO.findAll", UbicacionADO.class);
		List<UbicacionADO> ubicacionAList;
		try {
			ubicacionAList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Ubicación A registrados.");
		}
		return ubicacionAList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ColaboradorDO> getColaborador() throws ConectelException {
		TypedQuery<ColaboradorDO> query = entityManager.createNamedQuery(
				"ColaboradorDO.findAll", ColaboradorDO.class);
		List<ColaboradorDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstatusADO> getEstatusA() throws ConectelException {
		TypedQuery<EstatusADO> query = entityManager.createNamedQuery(
				"EstatusADO.findAll", EstatusADO.class);
		List<EstatusADO> estatusAList;
		try {
			estatusAList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Estatus A registrados.");
		}
		return estatusAList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoMantenimientoDO> getTipoMantenimiento()
			throws ConectelException {
		TypedQuery<TipoMantenimientoDO> query = entityManager.createNamedQuery(
				"TipoMantenimientoDO.findAll", TipoMantenimientoDO.class);
		List<TipoMantenimientoDO> tipoMantenimientoList;
		try {
			tipoMantenimientoList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existen Tipo Mantenimiento registrados.");
		}
		return tipoMantenimientoList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UbicacionBDO> getUbicacionB() throws ConectelException {
		TypedQuery<UbicacionBDO> query = entityManager.createNamedQuery(
				"UbicacionBDO.findAll", UbicacionBDO.class);
		List<UbicacionBDO> ubicacionBList;
		try {
			ubicacionBList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Ubicación B registrados.");
		}
		return ubicacionBList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoFamiliaBDO> getGrupoFamiliaB() throws ConectelException {
		TypedQuery<GrupoFamiliaBDO> query = entityManager.createNamedQuery(
				"GrupoFamiliaBDO.findAll", GrupoFamiliaBDO.class);
		List<GrupoFamiliaBDO> grupoFamiliaBList;
		try {
			grupoFamiliaBList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existen Grupo Familia B registrados.");
		}
		return grupoFamiliaBList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstatusBDO> getEstatusB() throws ConectelException {
		TypedQuery<EstatusBDO> query = entityManager.createNamedQuery(
				"EstatusBDO.findAll", EstatusBDO.class);
		List<EstatusBDO> estatusBList;
		try {
			estatusBList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Estatus B registrados.");
		}
		return estatusBList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoFamiliaCDO> getGrupoFamiliaC() throws ConectelException {
		TypedQuery<GrupoFamiliaCDO> query = entityManager.createNamedQuery(
				"GrupoFamiliaCDO.findAll", GrupoFamiliaCDO.class);
		List<GrupoFamiliaCDO> grupoFamiliaCList;
		try {
			grupoFamiliaCList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existen Grupo Familia C registrados.");
		}
		return grupoFamiliaCList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UnidadBDO> getUnidadB() throws ConectelException {
		TypedQuery<UnidadBDO> query = entityManager.createNamedQuery(
				"UnidadBDO.findAll", UnidadBDO.class);
		List<UnidadBDO> unidadBList;
		try {
			unidadBList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Unidad B registrados.");
		}
		return unidadBList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstatusCDO> getEstatusC() throws ConectelException {
		TypedQuery<EstatusCDO> query = entityManager.createNamedQuery(
				"EstatusCDO.findAll", EstatusCDO.class);
		List<EstatusCDO> estatusCList;
		try {
			estatusCList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Estatus C registrados.");
		}
		return estatusCList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoFamiliaDDO> getGrupoFamiliaD() throws ConectelException {
		TypedQuery<GrupoFamiliaDDO> query = entityManager.createNamedQuery(
				"GrupoFamiliaDDO.findAll", GrupoFamiliaDDO.class);
		List<GrupoFamiliaDDO> grupoFamiliaDList;
		try {
			grupoFamiliaDList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existen Grupo Familia D registrados.");
		}
		return grupoFamiliaDList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UbicacionCDO> getUbicacionC() throws ConectelException {
		TypedQuery<UbicacionCDO> query = entityManager.createNamedQuery(
				"UbicacionCDO.findAll", UbicacionCDO.class);
		List<UbicacionCDO> ubicacionCList;
		try {
			ubicacionCList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Ubicacion C registrados.");
		}
		return ubicacionCList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoFamiliaEDO> getGrupoFamiliaE() throws ConectelException {
		TypedQuery<GrupoFamiliaEDO> query = entityManager.createNamedQuery(
				"GrupoFamiliaEDO.findAll", GrupoFamiliaEDO.class);
		List<GrupoFamiliaEDO> grupoFamiliaEList;
		try {
			grupoFamiliaEList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Grupo Familia E registrados.");
		}
		return grupoFamiliaEList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UnidadCDO> getUnidadC() throws ConectelException {
		TypedQuery<UnidadCDO> query = entityManager.createNamedQuery(
				"UnidadCDO.findAll", UnidadCDO.class);
		List<UnidadCDO> unidadCList;
		try {
			unidadCList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Unidades C registradas.");
		}
		return unidadCList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<GrupoFamiliaFDO> getGrupoFamiliaF() throws ConectelException {
		TypedQuery<GrupoFamiliaFDO> query = entityManager.createNamedQuery(
				"GrupoFamiliaFDO.findAll", GrupoFamiliaFDO.class);
		List<GrupoFamiliaFDO> grupoFamiliaFList;
		try {
			grupoFamiliaFList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Grupo Familia F registrados.");
		}
		return grupoFamiliaFList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CompaniaDO> getCompania() throws ConectelException {
		TypedQuery<CompaniaDO> query = entityManager.createNamedQuery(
				"CompaniaDO.findAll", CompaniaDO.class);
		List<CompaniaDO> companiaList;
		try {
			companiaList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Compañias registradas.");
		}
		return companiaList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PrioridadDO> getPrioridad() throws ConectelException {
		TypedQuery<PrioridadDO> query = entityManager.createNamedQuery(
				"PrioridadDO.findAll", PrioridadDO.class);
		List<PrioridadDO> prioridadList;
		try {
			prioridadList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Prioridades registradas.");
		}
		return prioridadList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AreaSolicitanteDO> getAreaSolicitante()
			throws ConectelException {
		TypedQuery<AreaSolicitanteDO> query = entityManager.createNamedQuery(
				"AreaSolicitanteDO.findAll", AreaSolicitanteDO.class);
		List<AreaSolicitanteDO> areaSolicitanteList;
		try {
			areaSolicitanteList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Areas Solicitante registradas.");
		}
		return areaSolicitanteList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ServicioSolicitadoDO> getServicioSolicitado()
			throws ConectelException {
		TypedQuery<ServicioSolicitadoDO> query = entityManager.createNamedQuery(
				"ServicioSolicitadoDO.findAll", ServicioSolicitadoDO.class);
		List<ServicioSolicitadoDO> servicioSolicitadoList;
		try {
			servicioSolicitadoList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Servicios Solicitados registrados.");
		}
		return servicioSolicitadoList;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DescripcionAlmacenDO> getDescripcionAlmacen()
			throws ConectelException {
		TypedQuery<DescripcionAlmacenDO> query = entityManager.createNamedQuery(
				"DescripcionAlmacenDO.findAll", DescripcionAlmacenDO.class);
		List<DescripcionAlmacenDO> descripcionAlmacenList;
		try {
			descripcionAlmacenList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Descripción Almacen registrados.");
		}
		return descripcionAlmacenList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoPersonaDO> getTipoPersona() throws ConectelException {
		TypedQuery<TipoPersonaDO> query = entityManager.createNamedQuery(
				"TipoPersonaDO.findAll", TipoPersonaDO.class);
		List<TipoPersonaDO> tipoPersonaList;
		try {
			tipoPersonaList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException(
					"No existen TipoPersona.");
		}
		return tipoPersonaList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UnidadOrdenCompraDO> getUnidadOrdenCompra()
			throws ConectelException {
		List<UnidadOrdenCompraDO> datos=null;
		
		TypedQuery<UnidadOrdenCompraDO> query = entityManager.createNamedQuery(
				"UnidadOrdenCompraDO.findAll", UnidadOrdenCompraDO.class);
		
		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci˜n para mostrar.");
		}
		return datos;
	}

	public List<EstatusRequisicionCompraDO> getEstadoRequiscionCompra()
			throws ConectelException {

		List<EstatusRequisicionCompraDO> datos = null;

		TypedQuery<EstatusRequisicionCompraDO> query = entityManager
				.createNamedQuery("EstatusRequisicionCompraDO.findAll",
						EstatusRequisicionCompraDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci˜n para mostrar.");
		}
		return datos;
	}
	
	public List<TipoPagoDO> getTipoPago()
			throws ConectelException {

		List<TipoPagoDO> datos = null;

		TypedQuery<TipoPagoDO> query = entityManager
				.createNamedQuery("TipoPagoDO.findAll",
						TipoPagoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci˜n para mostrar.");
		}
		return datos;
	}
	
	public List<FormaPagoDO> getFormaPago()
			throws ConectelException {

		List<FormaPagoDO> datos = null;

		TypedQuery<FormaPagoDO> query = entityManager
				.createNamedQuery("FormaPagoDO.findAll",
						FormaPagoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci˜n para mostrar.");
		}
		return datos;
	}
	
	public List<TipoContratoDO> getTipoContrato()
			throws ConectelException {

		List<TipoContratoDO> datos = null;

		TypedQuery<TipoContratoDO> query = entityManager
				.createNamedQuery("TipoContratoDO.findAll",
						TipoContratoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci˜n para mostrar.");
		}
		return datos;
	}
	
	
	
	
	
}
