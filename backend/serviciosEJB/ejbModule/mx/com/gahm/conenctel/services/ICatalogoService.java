package mx.com.gahm.conenctel.services;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import mx.com.gahm.conenctel.entities.*;
import mx.com.gahm.conenctel.exceptions.ConectelException;

@Remote
public interface ICatalogoService extends Serializable {

	public List<AplicaDO> getAplica() throws ConectelException;

	public List<SeguimientoDO> getSeguimiento() throws ConectelException;

	public List<ImputableDO> getImputable() throws ConectelException;

	public List<TipoAlmacenDO> getTipoAlmacen() throws ConectelException;

	public List<GrupoFamiliaADO> getGrupoFamiliaA() throws ConectelException;

	public List<UnidadADO> getUnidadA() throws ConectelException;

	public List<UbicacionADO> getUbicacionA() throws ConectelException;

	public List<ColaboradorDO> getColaborador() throws ConectelException;

	public List<EstatusADO> getEstatusA() throws ConectelException;

	public List<TipoMantenimientoDO> getTipoMantenimiento()
			throws ConectelException;

	public List<UbicacionBDO> getUbicacionB() throws ConectelException;

	public List<GrupoFamiliaBDO> getGrupoFamiliaB() throws ConectelException;

	public List<EstatusBDO> getEstatusB() throws ConectelException;

	public List<GrupoFamiliaCDO> getGrupoFamiliaC() throws ConectelException;

	public List<UnidadBDO> getUnidadB() throws ConectelException;

	public List<EstatusCDO> getEstatusC() throws ConectelException;

	public List<GrupoFamiliaDDO> getGrupoFamiliaD() throws ConectelException;

	public List<UbicacionCDO> getUbicacionC() throws ConectelException;

	public List<GrupoFamiliaEDO> getGrupoFamiliaE() throws ConectelException;

	public List<UnidadCDO> getUnidadC() throws ConectelException;

	public List<GrupoFamiliaFDO> getGrupoFamiliaF() throws ConectelException;

	public List<CompaniaDO> getCompania() throws ConectelException;

	public List<PrioridadDO> getPrioridad() throws ConectelException;

	public List<AreaSolicitanteDO> getAreaSolicitante()
			throws ConectelException;

	public List<ServicioSolicitadoDO> getServicioSolicitado()
			throws ConectelException;

	public List<DescripcionAlmacenDO> getDescripcionAlmacen()
			throws ConectelException;
	
	public List<TipoPersonaDO> getTipoPersona() throws ConectelException ;
	List<UnidadOrdenCompraDO> getUnidadOrdenCompra()
			throws ConectelException;
	
	List<EstatusRequisicionCompraDO> getEstadoRequiscionCompra()
	throws ConectelException;

	public List<FormaPagoDO> getFormaPago() throws ConectelException;

	public List<TipoPagoDO> getTipoPago() throws ConectelException;
	
	public List<TipoContratoDO> getTipoContrato() throws ConectelException;
	
	List<EstadoSolicitudServicioMaquiladoDO> getEstadoSolicitudServicioMaquilado() throws ConectelException;
	
	List<EstadoValidacionOperativaDO> getEstadoValidacionOperativa() throws ConectelException;
	
	List<EstadoSolicitudAlmacenDO> getEstadoSolicitudAlmacen() throws ConectelException;
	
	List<TipoEmpleadoDO> getTipoEmpleado() throws ConectelException;
	
	public List<ColaboradorDO> getColaboradorByTipoColaborador(Long idTipoColaborador) throws ConectelException;
	
	List<TipoColaboradorDO> getTipoColaborador() throws ConectelException;
	List<ProveedorDO> getProveedores() throws ConectelException;
	List<EstadoFinalValidacionDO> getEstadoFinalValidacion() throws ConectelException;
	List<EstadoValidacionCobroDO> getEstadoValidacionCobro() throws ConectelException;
	List<TipoValidacionAdministrativaDO> getTipoValidacionAdministrativa() throws ConectelException;
	List<EstadoValidacionAdministrativaDO> getEstadoValidacionAdministrativa() throws ConectelException;
	
	List<ValidacionCostoDO> getValidacionCosto() throws ConectelException;
	
	List<EstadoOrdenCompraDO> getEstadoOrdenCompra() throws ConectelException;
	
	List<EstadoInvestigacionCalidadDO> getEstadoInvestigacionCalidad() throws ConectelException;
	
	List<EstadoTesoreriaDO> getEstadoTesoreria() throws ConectelException;
	
	List<TipoOperacionDO> getTipoOperacion() throws ConectelException;
		
	List<DescripcionFondoFijoCajaChicaDO> getDescripcionFondoFijoCajaChica(Long idTipoOperacion) throws ConectelException;
	
	List<MedioTransporteDO> getMedioTransporte() throws ConectelException;
	
	List<EstadoComprobacionViaticosDO> getEstadoComprobacionViaticos() throws ConectelException;
	
	List<DescripcionPagoContableServicioDO> getDescripcionPagoContableServicio(Long idTipoOperacion) throws ConectelException;
	List<TipoContratacionDO> getTipoContratacion() throws ConectelException;
	List<SuspensionDO> getSuspension() throws ConectelException;
	List<MotivoTerminoContratoDO> getMotivoTerminoContrato() throws ConectelException;
	List<TipoCandidatoDO> getTipoCandidato() throws ConectelException;
	List<FaseContratacionDO> getFaseContratacion() throws ConectelException;
	List<ConceptoOtraOperacionFinancieraDO> getConceptoOtraOperacionFinanciera() throws ConectelException;
	List<BancoConectelDO> getBancoConectel() throws ConectelException;
	public List<NacionalidadDO> getNacionalidad() throws ConectelException ;
	public List<IdentificacionDO> getIdentificacion() throws ConectelException ;	
	public List<DocumentacionExtranjerosDO> getDocumentacionExtranjeros() throws ConectelException ;	
	public List<EstadoCivilDO> getEstadoCivil() throws ConectelException;	
	public List<SexoDO> getSexo() throws ConectelException ;	
	public List<TipoLicenciaDO> getTipoLicencia() throws ConectelException;
	public List<CartaAntecedentesPenalesDO> getCartaAntecedentesPenales() throws ConectelException ;	
	public List<EstadoSaludDO> getEstadoSalud() throws ConectelException ;	
	public List<ActividadTiempoLibreDO> getActividadTiempoLibre() throws ConectelException ;
	public List<ViveConDO> getViveCon() throws ConectelException ;	
	public List<DependientesDO> getDependientes() throws ConectelException ;	
	public List<UltimoGradoEstudiosDO> getUltimoGradoEstudios() throws ConectelException ;	
	public List<EstadoAcademicoDO> getEstadoAcademico() throws ConectelException ;	
	public List<FaseSeleccionDO> getFaseSeleccion() throws ConectelException ;
	public List<FuenteReclutamientoDO> getFuenteReclutamiento() throws ConectelException ;
	public List<DeduccionDO> getDeduccion() throws ConectelException ;
	public List<ClasificacionFaltaDO> getClasificacionFalta() throws ConectelException ;
	public List<ClasificacionPermisoDO> getClasificacionPermiso() throws ConectelException ;	
	public List<TipoSancionDO> getTipoSancion() throws ConectelException ;
	public List<FormaPagoPrenominaDO> getFormaPagoPrenomina() throws ConectelException ;
	public List<ClaseIncidenciaDO> getClaseIncidencia() throws ConectelException;
	public List<TipoIncapacidadDO> getTipoIncapacidad() throws ConectelException;
	public List<VariacionDO> getVariacion() throws ConectelException;
	public List<PercepcionDO> getPercepcion() throws ConectelException;
	public List<ResultadoImplementacionDO> getResultadoImplementacion() throws ConectelException;
	public List<TipoAccionDO> getTipoAccion() throws ConectelException; 	
	public List<FuenteNoConformidadDO> getFuenteNoConformidad() throws ConectelException;
	public List<EstadoAccionPreventivaCorrectivaDO> getEstadoAccionPreventivaCorrectiva() throws ConectelException; 
	public List<TipoFormacionDO> getTipoFormacion() throws ConectelException;
	public List<TipoCapacitacionDO> getTipoCapacitacion() throws ConectelException;
	public List<TipoAuditoriaDO> getTipoAuditoria() throws ConectelException;
	public List<FormaAuditoriaDO> getFormaAuditoria() throws ConectelException;
	public List<EstadoSistemaGestionDO> getEstadoSistemaGestion() throws ConectelException;
	public List<EstadoColaboradorDO> getEstadoColaborador() throws ConectelException;
	public List<AreaLevantaNoConformidadDO> getAreaLevantaNoConformidad() throws ConectelException;
	public List<ResponsableMinutaDO> getResponsableMinuta() throws ConectelException;
	public List<TipoDesarrolloProyectoDO> getTipoDesarrolloProyecto() throws ConectelException;
	public List<CalibracionDO> getCalibracion() throws ConectelException;
	public List<MantenimientoServicioDO> getMantenimientoServicio() throws ConectelException;
	public List<PagoDO> getPago() throws ConectelException;
	public List<TipoServicioDO> getTipoServicio() throws ConectelException;
	public List<PermisoSinGoceSueldoDO> getPermisoSinGoceSueldo() throws ConectelException;
	public List<PermisoConGoceSueldoDO> getPermisoConGoceSueldo() throws ConectelException;
	public List<TrimestreDO> getTrimestre() throws ConectelException;
	public List<AnoDO> getAno() throws ConectelException;
	public List<RangoEstadisticaPersonalDO> getRangoEstadisticaPersonal() throws ConectelException;
	public List<EstadoConcentradoCapacitacionDO> getEstadoConcentradoCapacitacion() throws ConectelException;
	public List<PerfilDO> getPerfiles() throws ConectelException;
	public List<EstatusConcentradoCapacitacionDO> getEstatusConcentradoCapacitacion() throws ConectelException;
	public List<TipoPagoDO> getTipoPagoChequeEfectivoTransferencia() throws ConectelException;
}
