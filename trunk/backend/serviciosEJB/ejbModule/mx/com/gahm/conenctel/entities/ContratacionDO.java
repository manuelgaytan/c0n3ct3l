/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "Contratacion")
@NamedQueries({
	@NamedQuery(name = "ContratacionDO.findAll", query = "select rc from ContratacionDO rc"),
	@NamedQuery(name = "ContratacionDO.getContratacionByIdColaborador", query = "select rc from ContratacionDO rc where rc.colaborador=:idColaborador")
	})
public class ContratacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2241240783976362640L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
	@OneToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private ColaboradorDO colaborador; 
	
	@Column(name = "sueldo_inicial", nullable = false)
	private Double sueldoInicial;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_expedicion_certificado_medico", nullable = false, length = 10)
	private Date fechaExpedicionCertificadoMedico;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_vencimiento_certificado_medico", nullable = false, length = 10)
	private Date fechaVencimientoCertificadoMedico;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_contratacion", nullable = false)
	private TipoContratacionDO tipoContratacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_contrato", nullable = false)
	private TipoContratoDO tipoContrato;
	
	@Column(name = "vencimiento_contrato_eventual", nullable = false)
	private String vencimientoContratoEventual;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_contrato", nullable = false, length = 10)
	private Date fechaInicioContrato;
	
	@ManyToOne
	@JoinColumn(name = "fk_suspension", nullable = false)
	private SuspensionDO suspension;
	
	@Column(name = "motivo_suspension", nullable = false)
	private String motivoSuspension;
	
	public DocumentosContratacionDO getDocumentosContratacion() {
		return documentosContratacion;
	}

	public void setDocumentosContratacion(
			DocumentosContratacionDO documentosContratacion) {
		this.documentosContratacion = documentosContratacion;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino_contrato", nullable = false, length = 10)
	private Date fechaTerminoContrato;
	
	@ManyToOne
	@JoinColumn(name = "fk_motivo_termino_contrato", nullable = false)
	private MotivoTerminoContratoDO motivoTerminoContrato;
	
	@Column(name="finiquito")
	private Boolean finiquito;
	
	@Column(name="indemnizacion")
	private Boolean indemnizacion;
	
	@OneToOne(mappedBy="contratacion",cascade=CascadeType.ALL)
	private DocumentosContratacionDO documentosContratacion;
	

	public ContratacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContratacionDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			ColaboradorDO colaborador, Double sueldoInicial,
			Date fechaExpedicionCertificadoMedico,
			Date fechaVencimientoCertificadoMedico,
			TipoContratacionDO tipoContratacion, TipoContratoDO tipoContrato,
			String vencimientoContratoEventual, Date fechaInicioContrato,
			SuspensionDO suspension, String motivSuspension,
			Date fechaTerminoContrato,
			MotivoTerminoContratoDO motivoTerminoContrato, Boolean etiqueta,
			Boolean indemnizacion) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.colaborador = colaborador;
		this.sueldoInicial = sueldoInicial;
		this.fechaExpedicionCertificadoMedico = fechaExpedicionCertificadoMedico;
		this.fechaVencimientoCertificadoMedico = fechaVencimientoCertificadoMedico;
		this.tipoContratacion = tipoContratacion;
		this.tipoContrato = tipoContrato;
		this.vencimientoContratoEventual = vencimientoContratoEventual;
		this.fechaInicioContrato = fechaInicioContrato;
		this.suspension = suspension;
		this.motivoSuspension = motivSuspension;
		this.fechaTerminoContrato = fechaTerminoContrato;
		this.motivoTerminoContrato = motivoTerminoContrato;
		this.finiquito = etiqueta;
		this.indemnizacion = indemnizacion;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the reclutamientoSolicitudEmpleo
	 */
	public ReclutamientoSolicitudEmpleoDO getReclutamientoSolicitudEmpleo() {
		return reclutamientoSolicitudEmpleo;
	}

	/**
	 * @param reclutamientoSolicitudEmpleo the reclutamientoSolicitudEmpleo to set
	 */
	public void setReclutamientoSolicitudEmpleo(
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo) {
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
	}

	/**
	 * @return the colaborador
	 */
	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	/**
	 * @param colaborador the colaborador to set
	 */
	public void setColaborador(ColaboradorDO colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * @return the sueldoInicial
	 */
	public Double getSueldoInicial() {
		return sueldoInicial;
	}

	/**
	 * @param sueldoInicial the sueldoInicial to set
	 */
	public void setSueldoInicial(Double sueldoInicial) {
		this.sueldoInicial = sueldoInicial;
	}

	/**
	 * @return the fechaExpedicionCertificadoMedico
	 */
	public Date getFechaExpedicionCertificadoMedico() {
		return fechaExpedicionCertificadoMedico;
	}

	/**
	 * @param fechaExpedicionCertificadoMedico the fechaExpedicionCertificadoMedico to set
	 */
	public void setFechaExpedicionCertificadoMedico(
			Date fechaExpedicionCertificadoMedico) {
		this.fechaExpedicionCertificadoMedico = fechaExpedicionCertificadoMedico;
	}

	/**
	 * @return the fechaVencimientoCertificadoMedico
	 */
	public Date getFechaVencimientoCertificadoMedico() {
		return fechaVencimientoCertificadoMedico;
	}

	/**
	 * @param fechaVencimientoCertificadoMedico the fechaVencimientoCertificadoMedico to set
	 */
	public void setFechaVencimientoCertificadoMedico(
			Date fechaVencimientoCertificadoMedico) {
		this.fechaVencimientoCertificadoMedico = fechaVencimientoCertificadoMedico;
	}

	/**
	 * @return the tipoContratacion
	 */
	public TipoContratacionDO getTipoContratacion() {
		return tipoContratacion;
	}

	/**
	 * @param tipoContratacion the tipoContratacion to set
	 */
	public void setTipoContratacion(TipoContratacionDO tipoContratacion) {
		this.tipoContratacion = tipoContratacion;
	}

	/**
	 * @return the tipoContrato
	 */
	public TipoContratoDO getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * @param tipoContrato the tipoContrato to set
	 */
	public void setTipoContrato(TipoContratoDO tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	/**
	 * @return the vencimientoContratoEventual
	 */
	public String getVencimientoContratoEventual() {
		return vencimientoContratoEventual;
	}

	/**
	 * @param vencimientoContratoEventual the vencimientoContratoEventual to set
	 */
	public void setVencimientoContratoEventual(String vencimientoContratoEventual) {
		this.vencimientoContratoEventual = vencimientoContratoEventual;
	}

	/**
	 * @return the fechaInicioContrato
	 */
	public Date getFechaInicioContrato() {
		return fechaInicioContrato;
	}

	/**
	 * @param fechaInicioContrato the fechaInicioContrato to set
	 */
	public void setFechaInicioContrato(Date fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}

	/**
	 * @return the suspension
	 */
	public SuspensionDO getSuspension() {
		return suspension;
	}

	/**
	 * @param suspension the suspension to set
	 */
	public void setSuspension(SuspensionDO suspension) {
		this.suspension = suspension;
	}

	/**
	 * @return the motivSuspension
	 */
	public String getMotivoSuspension() {
		return motivoSuspension;
	}

	/**
	 * @param motivSuspension the motivSuspension to set
	 */
	public void setMotivoSuspension(String motivSuspension) {
		this.motivoSuspension = motivSuspension;
	}

	/**
	 * @return the fechaTerminoContrato
	 */
	public Date getFechaTerminoContrato() {
		return fechaTerminoContrato;
	}

	/**
	 * @param fechaTerminoContrato the fechaTerminoContrato to set
	 */
	public void setFechaTerminoContrato(Date fechaTerminoContrato) {
		this.fechaTerminoContrato = fechaTerminoContrato;
	}

	/**
	 * @return the motivoTerminoContrato
	 */
	public MotivoTerminoContratoDO getMotivoTerminoContrato() {
		return motivoTerminoContrato;
	}

	/**
	 * @param motivoTerminoContrato the motivoTerminoContrato to set
	 */
	public void setMotivoTerminoContrato(
			MotivoTerminoContratoDO motivoTerminoContrato) {
		this.motivoTerminoContrato = motivoTerminoContrato;
	}

	/**
	 * @return the etiqueta
	 */
	public Boolean getFiniquito() {
		return finiquito;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setFiniquito(Boolean etiqueta) {
		this.finiquito = etiqueta;
	}

	/**
	 * @return the indemnizacion
	 */
	public Boolean getIndemnizacion() {
		return indemnizacion;
	}

	/**
	 * @param indemnizacion the indemnizacion to set
	 */
	public void setIndemnizacion(Boolean indemnizacion) {
		this.indemnizacion = indemnizacion;
	}
	
	
	
	
	
	
}
