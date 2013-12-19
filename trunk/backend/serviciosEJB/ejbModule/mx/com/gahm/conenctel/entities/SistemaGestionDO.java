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
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "SistemaGestion")
@NamedQueries({
	@NamedQuery(name = "SistemaGestionDO.findAll", query = "select rc from SistemaGestionDO rc")
	})
public class SistemaGestionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 794205831926418172L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_proyecto", nullable = false)
	private ProyectoDO proyecto;
	
	@Column(name = "aplicacion_auditoria")
	private Boolean aplicacionAuditoria;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_auditoria", nullable = false)
	private TipoAuditoriaDO tipoAuditoria;
	
	@ManyToOne
	@JoinColumn(name = "fk_forma_auditoria", nullable = false)
	private FormaAuditoriaDO formaAuditoria;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria", nullable = false, length = 10)
	private Date fechaAuditoria;
	
	@Column(name = "indice_calidad", nullable = false)
	private String indiceCalidad;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_envio", nullable = false, length = 10)
	private Date fechaEnvio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_recepcion", nullable = false, length = 10)
	private Date fechaRecepcion;
	
	@Column(name = "formato_auditoria", nullable = false)
	private String formatoAuditoria;
	
	@Column(name = "nombre_auditor", nullable = false)
	private String nombreAuditor;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_recepcion_correcciones_auditorias_internas", nullable = false, length = 10)
	private Date fechaRecepcionCorreccionesAuditoriasInternas;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_envio_correcciones", nullable = false, length = 10)
	private Date fechaEnvioCorrecciones;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_sistema_gestion", nullable = false)
	private EstadoSistemaGestionDO estadoSistemaGestion;
	
	@Column(name = "correcciones", nullable = false)
	private String correcciones;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_cierre_auditoria", nullable = false, length = 10)
	private Date fechaCierreAuditoria;
	
	@Column(name = "observaciones", nullable = false)
	private String observaciones;

	public SistemaGestionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SistemaGestionDO(Integer id,
			ProyectoDO proyecto,
			Boolean aplicacionAuditoria, TipoAuditoriaDO tipoAuditoria,
			FormaAuditoriaDO formaAuditoria, Date fechaEnvio,
			Date fechaRecepcion, String formatoAuditoria, String nombreAuditor,
			Date fechaEnvioCorrecciones,
			EstadoSistemaGestionDO estadoSistemaGestion, String correcciones,
			String observaciones) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.aplicacionAuditoria = aplicacionAuditoria;
		this.tipoAuditoria = tipoAuditoria;
		this.formaAuditoria = formaAuditoria;
		this.fechaEnvio = fechaEnvio;
		this.fechaRecepcion = fechaRecepcion;
		this.formatoAuditoria = formatoAuditoria;
		this.nombreAuditor = nombreAuditor;
		this.fechaEnvioCorrecciones = fechaEnvioCorrecciones;
		this.estadoSistemaGestion = estadoSistemaGestion;
		this.correcciones = correcciones;
		this.observaciones = observaciones;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProyectoDO getProyecto() {
		return proyecto;
	}

	public void setProyecto(
			ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public Boolean getAplicacionAuditoria() {
		return aplicacionAuditoria;
	}

	public void setAplicacionAuditoria(Boolean aplicacionAuditoria) {
		this.aplicacionAuditoria = aplicacionAuditoria;
	}

	public TipoAuditoriaDO getTipoAuditoria() {
		return tipoAuditoria;
	}

	public void setTipoAuditoria(TipoAuditoriaDO tipoAuditoria) {
		this.tipoAuditoria = tipoAuditoria;
	}

	public FormaAuditoriaDO getFormaAuditoria() {
		return formaAuditoria;
	}

	public void setFormaAuditoria(FormaAuditoriaDO formaAuditoria) {
		this.formaAuditoria = formaAuditoria;
	}

	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public String getIndiceCalidad() {
		return indiceCalidad;
	}

	public void setIndiceCalidad(String indiceCalidad) {
		this.indiceCalidad = indiceCalidad;
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}

	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	public String getFormatoAuditoria() {
		return formatoAuditoria;
	}

	public void setFormatoAuditoria(String formatoAuditoria) {
		this.formatoAuditoria = formatoAuditoria;
	}

	public String getNombreAuditor() {
		return nombreAuditor;
	}

	public void setNombreAuditor(String nombreAuditor) {
		this.nombreAuditor = nombreAuditor;
	}

	public Date getFechaRecepcionCorreccionesAuditoriasInternas() {
		return fechaRecepcionCorreccionesAuditoriasInternas;
	}

	public void setFechaRecepcionCorreccionesAuditoriasInternas(
			Date fechaRecepcionCorreccionesAuditoriasInternas) {
		this.fechaRecepcionCorreccionesAuditoriasInternas = fechaRecepcionCorreccionesAuditoriasInternas;
	}

	public Date getFechaEnvioCorrecciones() {
		return fechaEnvioCorrecciones;
	}

	public void setFechaEnvioCorrecciones(Date fechaEnvioCorrecciones) {
		this.fechaEnvioCorrecciones = fechaEnvioCorrecciones;
	}

	public EstadoSistemaGestionDO getEstadoSistemaGestion() {
		return estadoSistemaGestion;
	}

	public void setEstadoSistemaGestion(EstadoSistemaGestionDO estadoSistemaGestion) {
		this.estadoSistemaGestion = estadoSistemaGestion;
	}

	public String getCorrecciones() {
		return correcciones;
	}

	public void setCorrecciones(String correcciones) {
		this.correcciones = correcciones;
	}

	public Date getFechaCierreAuditoria() {
		return fechaCierreAuditoria;
	}

	public void setFechaCierreAuditoria(Date fechaCierreAuditoria) {
		this.fechaCierreAuditoria = fechaCierreAuditoria;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	

}
