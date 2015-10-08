package mx.com.gahm.conenctel.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import mx.com.gahm.conenctel.entities.*;
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
			throw new ConectelException("No existen Ubicaci�n A registrados.");
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
			throw new ConectelException("No existen Ubicaci�n B registrados.");
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
			throw new ConectelException("No existen Compa�ias registradas.");
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
			throw new ConectelException("No existen Descripci�n Almacen registrados.");
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
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstatusRequisicionCompraDO> getEstadoRequiscionCompra()
			throws ConectelException {

		List<EstatusRequisicionCompraDO> datos = null;

		TypedQuery<EstatusRequisicionCompraDO> query = entityManager
				.createNamedQuery("EstatusRequisicionCompraDO.findAll",
						EstatusRequisicionCompraDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
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
			throw new ConectelException("No existen informaci�n para mostrar.");
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
			throw new ConectelException("No existen informaci�n para mostrar.");
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
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	
	public List<EstadoSolicitudServicioMaquiladoDO> getEstadoSolicitudServicioMaquilado() throws ConectelException {

		List<EstadoSolicitudServicioMaquiladoDO> datos = null;

		TypedQuery<EstadoSolicitudServicioMaquiladoDO> query = entityManager
				.createNamedQuery("EstadoSolicitudServicioMaquiladoDO.findAll",
						EstadoSolicitudServicioMaquiladoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	
	public List<EstadoValidacionOperativaDO> getEstadoValidacionOperativa() throws ConectelException {

		List<EstadoValidacionOperativaDO> datos = null;

		TypedQuery<EstadoValidacionOperativaDO> query = entityManager
				.createNamedQuery("EstadoValidacionOperativaDO.findAll",
						EstadoValidacionOperativaDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	
	public List<EstadoSolicitudAlmacenDO> getEstadoSolicitudAlmacen() throws ConectelException {

		List<EstadoSolicitudAlmacenDO> datos = null;

		TypedQuery<EstadoSolicitudAlmacenDO> query = entityManager
				.createNamedQuery("EstadoSolicitudAlmacenDO.findAll",
						EstadoSolicitudAlmacenDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	
	public List<TipoColaboradorDO> getTipoColaborador() throws ConectelException {

		List<TipoColaboradorDO> datos = null;

		TypedQuery<TipoColaboradorDO> query = entityManager
				.createNamedQuery("TipoColaboradorDO.findAll",
						TipoColaboradorDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	public List<TipoEmpleadoDO> getTipoEmpleado() throws ConectelException {

		List<TipoEmpleadoDO> datos = null;

		TypedQuery<TipoEmpleadoDO> query = entityManager
				.createNamedQuery("TipoEmpleadoDO.findAll",
						TipoEmpleadoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ColaboradorDO> getColaboradorByTipoColaborador(Long idTipoColaborador) throws ConectelException {
		TypedQuery<ColaboradorDO> query = entityManager.createNamedQuery(
				"ColaboradorDO.getColaboradorByTipo", ColaboradorDO.class);
		
		query.setParameter("idTipoColaborado", idTipoColaborador);
		List<ColaboradorDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ProveedorDO> getProveedores() throws ConectelException {
		TypedQuery<ProveedorDO> query = entityManager.createNamedQuery(
				"ProveedorDO.findAll", ProveedorDO.class);
		
		List<ProveedorDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}
	
	///////
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoValidacionAdministrativaDO> getEstadoValidacionAdministrativa() throws ConectelException {
		TypedQuery<EstadoValidacionAdministrativaDO> query = entityManager.createNamedQuery(
				"EstadoValidacionAdministrativaDO.findAll", EstadoValidacionAdministrativaDO.class);
		
		List<EstadoValidacionAdministrativaDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoValidacionAdministrativaDO> getTipoValidacionAdministrativa() throws ConectelException {
		TypedQuery<TipoValidacionAdministrativaDO> query = entityManager.createNamedQuery(
				"TipoValidacionAdministrativaDO.findAll", TipoValidacionAdministrativaDO.class);
		
		List<TipoValidacionAdministrativaDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoValidacionCobroDO> getEstadoValidacionCobro() throws ConectelException {
		TypedQuery<EstadoValidacionCobroDO> query = entityManager.createNamedQuery(
				"EstadoValidacionCobroDO.findAll", EstadoValidacionCobroDO.class);
		
		List<EstadoValidacionCobroDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoFinalValidacionDO> getEstadoFinalValidacion() throws ConectelException {
		TypedQuery<EstadoFinalValidacionDO> query = entityManager.createNamedQuery(
				"EstadoFinalValidacionDO.findAll", EstadoFinalValidacionDO.class);
		
		List<EstadoFinalValidacionDO> colaboradorList;
		try {
			colaboradorList = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen Colaborador registrados.");
		}
		return colaboradorList;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ValidacionCostoDO> getValidacionCosto() throws ConectelException {
		TypedQuery<ValidacionCostoDO> query = entityManager.createNamedQuery(
				"ValidacionCostoDO.findAll", ValidacionCostoDO.class);
		
		List<ValidacionCostoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoOrdenCompraDO> getEstadoOrdenCompra() throws ConectelException {
		TypedQuery<EstadoOrdenCompraDO> query = entityManager.createNamedQuery(
				"EstadoOrdenCompraDO.findAll", EstadoOrdenCompraDO.class);
		
		List<EstadoOrdenCompraDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoInvestigacionCalidadDO> getEstadoInvestigacionCalidad() throws ConectelException {
		TypedQuery<EstadoInvestigacionCalidadDO> query = entityManager.createNamedQuery(
				"EstadoInvestigacionCalidadDO.findAll", EstadoInvestigacionCalidadDO.class);
		
		List<EstadoInvestigacionCalidadDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoTesoreriaDO> getEstadoTesoreria() throws ConectelException {
		TypedQuery<EstadoTesoreriaDO> query = entityManager.createNamedQuery(
				"EstadoTesoreriaDO.findAll", EstadoTesoreriaDO.class);
		
		List<EstadoTesoreriaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoOperacionDO> getTipoOperacion() throws ConectelException {
		TypedQuery<TipoOperacionDO> query = entityManager.createNamedQuery(
				"TipoOperacionDO.findAll", TipoOperacionDO.class);
		
		List<TipoOperacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DescripcionFondoFijoCajaChicaDO> getDescripcionFondoFijoCajaChica( Long idTipoOperacion) throws ConectelException {
		TypedQuery<DescripcionFondoFijoCajaChicaDO> query = entityManager.createNamedQuery(
				"DescripcionFondoFijoCajaChicaDO.getByTipoOperacion", DescripcionFondoFijoCajaChicaDO.class);
		query.setParameter("idTipoOperacion", idTipoOperacion);
		List<DescripcionFondoFijoCajaChicaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MedioTransporteDO> getMedioTransporte() throws ConectelException {
		TypedQuery<MedioTransporteDO> query = entityManager.createNamedQuery(
				"MedioTransporteDO.findAll", MedioTransporteDO.class);
		
		List<MedioTransporteDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoComprobacionViaticosDO> getEstadoComprobacionViaticos() throws ConectelException {
		TypedQuery<EstadoComprobacionViaticosDO> query = entityManager.createNamedQuery(
				"EstadoComprobacionViaticosDO.findAll", EstadoComprobacionViaticosDO.class);
		
		List<EstadoComprobacionViaticosDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DescripcionPagoContableServicioDO> getDescripcionPagoContableServicio(Long idTipoOperacion) throws ConectelException {
		TypedQuery<DescripcionPagoContableServicioDO> query = entityManager.createNamedQuery(
				"DescripcionPagoContableServicioDO.getByTipoOperacion", DescripcionPagoContableServicioDO.class);
		query.setParameter("idTipoOperacion", idTipoOperacion);
		List<DescripcionPagoContableServicioDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoContratacionDO> getTipoContratacion() throws ConectelException {
		TypedQuery<TipoContratacionDO> query = entityManager.createNamedQuery(
				"TipoContratacionDO.findAll", TipoContratacionDO.class);
		
		List<TipoContratacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<SuspensionDO> getSuspension() throws ConectelException {
		TypedQuery<SuspensionDO> query = entityManager.createNamedQuery(
				"SuspensionDO.findAll", SuspensionDO.class);
		
		List<SuspensionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MotivoTerminoContratoDO> getMotivoTerminoContrato() throws ConectelException {
		TypedQuery<MotivoTerminoContratoDO> query = entityManager.createNamedQuery(
				"MotivoTerminoContratoDO.findAll", MotivoTerminoContratoDO.class);
		
		List<MotivoTerminoContratoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoCandidatoDO> getTipoCandidato() throws ConectelException {
		TypedQuery<TipoCandidatoDO> query = entityManager.createNamedQuery(
				"TipoCandidatoDO.findAll", TipoCandidatoDO.class);
		
		List<TipoCandidatoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FaseContratacionDO> getFaseContratacion() throws ConectelException {
		TypedQuery<FaseContratacionDO> query = entityManager.createNamedQuery(
				"FaseContratacionDO.findAll", FaseContratacionDO.class);
		
		List<FaseContratacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ConceptoOtraOperacionFinancieraDO> getConceptoOtraOperacionFinanciera() throws ConectelException {
		TypedQuery<ConceptoOtraOperacionFinancieraDO> query = entityManager.createNamedQuery(
				"ConceptoOtraOperacionFinancieraDO.findAll", ConceptoOtraOperacionFinancieraDO.class);
		
		List<ConceptoOtraOperacionFinancieraDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<BancoConectelDO> getBancoConectel() throws ConectelException {
		TypedQuery<BancoConectelDO> query = entityManager.createNamedQuery(
				"BancoConectelDO.findAll", BancoConectelDO.class);
		
		List<BancoConectelDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<NacionalidadDO> getNacionalidad() throws ConectelException {
		TypedQuery<NacionalidadDO> query = entityManager.createNamedQuery(
				"NacionalidadDO.findAll", NacionalidadDO.class);
		
		List<NacionalidadDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<IdentificacionDO> getIdentificacion() throws ConectelException {
		TypedQuery<IdentificacionDO> query = entityManager.createNamedQuery(
				"IdentificacionDO.findAll", IdentificacionDO.class);
		
		List<IdentificacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DocumentacionExtranjerosDO> getDocumentacionExtranjeros() throws ConectelException {
		TypedQuery<DocumentacionExtranjerosDO> query = entityManager.createNamedQuery(
				"DocumentacionExtranjerosDO.findAll", DocumentacionExtranjerosDO.class);
		
		List<DocumentacionExtranjerosDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoCivilDO> getEstadoCivil() throws ConectelException {
		TypedQuery<EstadoCivilDO> query = entityManager.createNamedQuery(
				"EstadoCivilDO.findAll", EstadoCivilDO.class);
		
		List<EstadoCivilDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<SexoDO> getSexo() throws ConectelException {
		TypedQuery<SexoDO> query = entityManager.createNamedQuery(
				"SexoDO.findAll", SexoDO.class);
		
		List<SexoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoLicenciaDO> getTipoLicencia() throws ConectelException {
		TypedQuery<TipoLicenciaDO> query = entityManager.createNamedQuery(
				"TipoLicenciaDO.findAll", TipoLicenciaDO.class);
		
		List<TipoLicenciaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CartaAntecedentesPenalesDO> getCartaAntecedentesPenales() throws ConectelException {
		TypedQuery<CartaAntecedentesPenalesDO> query = entityManager.createNamedQuery(
				"CartaAntecedentesPenalesDO.findAll", CartaAntecedentesPenalesDO.class);
		
		List<CartaAntecedentesPenalesDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoSaludDO> getEstadoSalud() throws ConectelException {
		TypedQuery<EstadoSaludDO> query = entityManager.createNamedQuery(
				"EstadoSaludDO.findAll", EstadoSaludDO.class);
		
		List<EstadoSaludDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ActividadTiempoLibreDO> getActividadTiempoLibre() throws ConectelException {
		TypedQuery<ActividadTiempoLibreDO> query = entityManager.createNamedQuery(
				"ActividadTiempoLibreDO.findAll", ActividadTiempoLibreDO.class);
		
		List<ActividadTiempoLibreDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ViveConDO> getViveCon() throws ConectelException {
		TypedQuery<ViveConDO> query = entityManager.createNamedQuery(
				"ViveConDO.findAll", ViveConDO.class);
		
		List<ViveConDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DependientesDO> getDependientes() throws ConectelException {
		TypedQuery<DependientesDO> query = entityManager.createNamedQuery(
				"DependientesDO.findAll", DependientesDO.class);
		
		List<DependientesDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<UltimoGradoEstudiosDO> getUltimoGradoEstudios() throws ConectelException {
		TypedQuery<UltimoGradoEstudiosDO> query = entityManager.createNamedQuery(
				"UltimoGradoEstudiosDO.findAll", UltimoGradoEstudiosDO.class);
		
		List<UltimoGradoEstudiosDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoAcademicoDO> getEstadoAcademico() throws ConectelException {
		TypedQuery<EstadoAcademicoDO> query = entityManager.createNamedQuery(
				"EstadoAcademicoDO.findAll", EstadoAcademicoDO.class);
		
		List<EstadoAcademicoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FaseSeleccionDO> getFaseSeleccion() throws ConectelException {
		TypedQuery<FaseSeleccionDO> query = entityManager.createNamedQuery(
				"FaseSeleccionDO.findAll", FaseSeleccionDO.class);
		
		List<FaseSeleccionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FuenteReclutamientoDO> getFuenteReclutamiento() throws ConectelException {
		TypedQuery<FuenteReclutamientoDO> query = entityManager.createNamedQuery(
				"FuenteReclutamientoDO.findAll", FuenteReclutamientoDO.class);
		
		List<FuenteReclutamientoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<DeduccionDO> getDeduccion() throws ConectelException {
		TypedQuery<DeduccionDO> query = entityManager.createNamedQuery(
				"DeduccionDO.findAll", DeduccionDO.class);
		
		List<DeduccionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}

	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ClasificacionFaltaDO> getClasificacionFalta() throws ConectelException {
		TypedQuery<ClasificacionFaltaDO> query = entityManager.createNamedQuery(
				"ClasificacionFaltaDO.findAll", ClasificacionFaltaDO.class);
		
		List<ClasificacionFaltaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ClasificacionPermisoDO> getClasificacionPermiso() throws ConectelException {
		TypedQuery<ClasificacionPermisoDO> query = entityManager.createNamedQuery(
				"ClasificacionPermisoDO.findAll", ClasificacionPermisoDO.class);
		
		List<ClasificacionPermisoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoSancionDO> getTipoSancion() throws ConectelException {
		TypedQuery<TipoSancionDO> query = entityManager.createNamedQuery(
				"TipoSancionDO.findAll", TipoSancionDO.class);
		
		List<TipoSancionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FormaPagoPrenominaDO> getFormaPagoPrenomina() throws ConectelException {
		TypedQuery<FormaPagoPrenominaDO> query = entityManager.createNamedQuery(
				"FormaPagoPrenominaDO.findAll", FormaPagoPrenominaDO.class);
		
		List<FormaPagoPrenominaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ClaseIncidenciaDO> getClaseIncidencia() throws ConectelException {
		TypedQuery<ClaseIncidenciaDO> query = entityManager.createNamedQuery(
				"ClaseIncidenciaDO.findAll", ClaseIncidenciaDO.class);
		
		List<ClaseIncidenciaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoIncapacidadDO> getTipoIncapacidad() throws ConectelException {
		TypedQuery<TipoIncapacidadDO> query = entityManager.createNamedQuery(
				"TipoIncapacidadDO.findAll", TipoIncapacidadDO.class);
		
		List<TipoIncapacidadDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PercepcionDO> getPercepcion() throws ConectelException {
		TypedQuery<PercepcionDO> query = entityManager.createNamedQuery(
				"PercepcionDO.findAll", PercepcionDO.class);
		
		List<PercepcionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<VariacionDO> getVariacion() throws ConectelException {
		TypedQuery<VariacionDO> query = entityManager.createNamedQuery(
				"VariacionDO.findAll", VariacionDO.class);
		
		List<VariacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ResultadoImplementacionDO> getResultadoImplementacion() throws ConectelException {
		TypedQuery<ResultadoImplementacionDO> query = entityManager.createNamedQuery(
				"ResultadoImplementacionDO.findAll", ResultadoImplementacionDO.class);
		
		List<ResultadoImplementacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoAccionDO> getTipoAccion() throws ConectelException {
		TypedQuery<TipoAccionDO> query = entityManager.createNamedQuery(
				"TipoAccionDO.findAll", TipoAccionDO.class);
		
		List<TipoAccionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FuenteNoConformidadDO> getFuenteNoConformidad() throws ConectelException {
		TypedQuery<FuenteNoConformidadDO> query = entityManager.createNamedQuery(
				"FuenteNoConformidadDO.findAll", FuenteNoConformidadDO.class);
		
		List<FuenteNoConformidadDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoAccionPreventivaCorrectivaDO> getEstadoAccionPreventivaCorrectiva() throws ConectelException {
		TypedQuery<EstadoAccionPreventivaCorrectivaDO> query = entityManager.createNamedQuery(
				"EstadoAccionPreventivaCorrectivaDO.findAll", EstadoAccionPreventivaCorrectivaDO.class);
		
		List<EstadoAccionPreventivaCorrectivaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoFormacionDO> getTipoFormacion() throws ConectelException {
		TypedQuery<TipoFormacionDO> query = entityManager.createNamedQuery(
				"TipoFormacionDO.findAll", TipoFormacionDO.class);
		
		List<TipoFormacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoCapacitacionDO> getTipoCapacitacion() throws ConectelException {
		TypedQuery<TipoCapacitacionDO> query = entityManager.createNamedQuery(
				"TipoCapacitacionDO.findAll", TipoCapacitacionDO.class);
		
		List<TipoCapacitacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoAuditoriaDO> getTipoAuditoria() throws ConectelException {
		TypedQuery<TipoAuditoriaDO> query = entityManager.createNamedQuery(
				"TipoAuditoriaDO.findAll", TipoAuditoriaDO.class);
		
		List<TipoAuditoriaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<FormaAuditoriaDO> getFormaAuditoria() throws ConectelException {
		TypedQuery<FormaAuditoriaDO> query = entityManager.createNamedQuery(
				"FormaAuditoriaDO.findAll", FormaAuditoriaDO.class);
		
		List<FormaAuditoriaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoSistemaGestionDO> getEstadoSistemaGestion() throws ConectelException {
		TypedQuery<EstadoSistemaGestionDO> query = entityManager.createNamedQuery(
				"EstadoSistemaGestionDO.findAll", EstadoSistemaGestionDO.class);
		
		List<EstadoSistemaGestionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoColaboradorDO> getEstadoColaborador() throws ConectelException {
		TypedQuery<EstadoColaboradorDO> query = entityManager.createNamedQuery(
				"EstadoColaboradorDO.findAll", EstadoColaboradorDO.class);
		
		List<EstadoColaboradorDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AreaLevantaNoConformidadDO> getAreaLevantaNoConformidad() throws ConectelException {
		TypedQuery<AreaLevantaNoConformidadDO> query = entityManager.createNamedQuery(
				"AreaLevantaNoConformidadDO.findAll", AreaLevantaNoConformidadDO.class);
		
		List<AreaLevantaNoConformidadDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<ResponsableMinutaDO> getResponsableMinuta() throws ConectelException {
		TypedQuery<ResponsableMinutaDO> query = entityManager.createNamedQuery(
				"ResponsableMinutaDO.findAll", ResponsableMinutaDO.class);
		
		List<ResponsableMinutaDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoDesarrolloProyectoDO> getTipoDesarrolloProyecto() throws ConectelException {
		TypedQuery<TipoDesarrolloProyectoDO> query = entityManager.createNamedQuery(
				"TipoDesarrolloProyectoDO.findAll", TipoDesarrolloProyectoDO.class);
		
		List<TipoDesarrolloProyectoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<CalibracionDO> getCalibracion() throws ConectelException {
		TypedQuery<CalibracionDO> query = entityManager.createNamedQuery(
				"CalibracionDO.findAll", CalibracionDO.class);
		
		List<CalibracionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<MantenimientoServicioDO> getMantenimientoServicio() throws ConectelException {
		TypedQuery<MantenimientoServicioDO> query = entityManager.createNamedQuery(
				"MantenimientoServicioDO.findAll", MantenimientoServicioDO.class);
		
		List<MantenimientoServicioDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PagoDO> getPago()
			throws ConectelException {

		List<PagoDO> datos = null;

		TypedQuery<PagoDO> query = entityManager
				.createNamedQuery("PagoDO.findAll",
						PagoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TipoServicioDO> getTipoServicio() throws ConectelException {
		TypedQuery<TipoServicioDO> query = entityManager.createNamedQuery(
				"TipoServicioDO.findAll", TipoServicioDO.class);
		
		List<TipoServicioDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PermisoSinGoceSueldoDO> getPermisoSinGoceSueldo() throws ConectelException {
		TypedQuery<PermisoSinGoceSueldoDO> query = entityManager.createNamedQuery(
				"PermisoSinGoceSueldoDO.findAll", PermisoSinGoceSueldoDO.class);
		
		List<PermisoSinGoceSueldoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<PermisoConGoceSueldoDO> getPermisoConGoceSueldo() throws ConectelException {
		TypedQuery<PermisoConGoceSueldoDO> query = entityManager.createNamedQuery(
				"PermisoConGoceSueldoDO.findAll", PermisoConGoceSueldoDO.class);
		
		List<PermisoConGoceSueldoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<TrimestreDO> getTrimestre() throws ConectelException {
		TypedQuery<TrimestreDO> query = entityManager.createNamedQuery(
				"TrimestreDO.findAll", TrimestreDO.class);
		
		List<TrimestreDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<AnoDO> getAno() throws ConectelException {
		TypedQuery<AnoDO> query = entityManager.createNamedQuery(
				"AnoDO.findAll", AnoDO.class);
		
		List<AnoDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<RangoEstadisticaPersonalDO> getRangoEstadisticaPersonal() throws ConectelException {
		TypedQuery<RangoEstadisticaPersonalDO> query = entityManager.createNamedQuery(
				"RangoEstadisticaPersonalDO.findAll", RangoEstadisticaPersonalDO.class);
		
		List<RangoEstadisticaPersonalDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@TransactionAttribute(TransactionAttributeType.SUPPORTS)
	public List<EstadoConcentradoCapacitacionDO> getEstadoConcentradoCapacitacion() throws ConectelException {
		TypedQuery<EstadoConcentradoCapacitacionDO> query = entityManager.createNamedQuery(
				"EstadoConcentradoCapacitacionDO.findAll", EstadoConcentradoCapacitacionDO.class);
		
		List<EstadoConcentradoCapacitacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}

	@Override
	public List<PerfilDO> getPerfiles() throws ConectelException {
		TypedQuery<PerfilDO> query = entityManager.createNamedQuery(
				"PerfilDO.findAll", PerfilDO.class);
		
		List<PerfilDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@Override
	public List<EstatusConcentradoCapacitacionDO> getEstatusConcentradoCapacitacion() throws ConectelException {
		TypedQuery<EstatusConcentradoCapacitacionDO> query = entityManager.createNamedQuery(
				"EstatusConcentradoCapacitacionDO.findAll", EstatusConcentradoCapacitacionDO.class);
		
		List<EstatusConcentradoCapacitacionDO> list;
		try {
			list = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen elementos registrados.");
		}
		return list;
	}
	
	@Override
	public List<TipoPagoDO> getTipoPagoChequeEfectivoTransferencia()
			throws ConectelException {

		List<TipoPagoDO> datos = null;

		TypedQuery<TipoPagoDO> query = entityManager
				.createNamedQuery("TipoPagoDO.findChequeEfectivoTransferencia",
						TipoPagoDO.class);

		try {
			datos = query.getResultList();
		} catch (NoResultException e) {
			throw new ConectelException("No existen informaci�n para mostrar.");
		}
		return datos;
	}
}
