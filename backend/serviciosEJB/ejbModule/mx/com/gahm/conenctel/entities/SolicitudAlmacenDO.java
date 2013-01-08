package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Clase de persistencia para la tabla solicitudalmacen.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "SolicitudAlmacenDO.findAll", query = "select s from SolicitudAlmacenDO s") })
@Table(name="solicitudalmacen")
public class SolicitudAlmacenDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String autoriza;

	private Double cantidad;

	@Column(name="central_sitio")
	private String centralSitio;

	private String entrega;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_asignacion")
	private Date fechaAsignacion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_retorno")
	private Date fechaRetorno;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;

	private Double folio;

	private String motivo;

	private String observaciones;

	@Column(name="vale_abierto_cerrado")
	private String valeAbiertoCerrado;

	@OneToMany(mappedBy="fkSolicitudAlmacen", fetch = FetchType.EAGER)
	private List<NombreSolicitanteDO> nombresSolicitantes;

	@ManyToOne
	@JoinColumn(name="fk_unidad_b")
	private UnidadBDO unidadB;

	@ManyToOne
	@JoinColumn(name="fk_prioridad")
	private PrioridadDO prioridad;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_area_solicitante")
	private AreaSolicitanteDO areaSolicitante;

	@ManyToOne
	@JoinColumn(name="fk_servicio_solicitado")
	private ServicioSolicitadoDO servicioSolicitado;

	@ManyToOne
	@JoinColumn(name="descripcion")
	private DescripcionAlmacenDO descripcionAlmacen;

	public SolicitudAlmacenDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAutoriza() {
		return this.autoriza;
	}

	public void setAutoriza(String autoriza) {
		this.autoriza = autoriza;
	}

	public Double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getCentralSitio() {
		return this.centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public String getEntrega() {
		return this.entrega;
	}

	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	public Date getFechaAsignacion() {
		return this.fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	public Date getFechaRetorno() {
		return this.fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Double getFolio() {
		return this.folio;
	}

	public void setFolio(Double folio) {
		this.folio = folio;
	}

	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getValeAbiertoCerrado() {
		return this.valeAbiertoCerrado;
	}

	public void setValeAbiertoCerrado(String valeAbiertoCerrado) {
		this.valeAbiertoCerrado = valeAbiertoCerrado;
	}

	public List<NombreSolicitanteDO> getNombresSolicitantes() {
		return nombresSolicitantes;
	}

	public void setNombresSolicitantes(List<NombreSolicitanteDO> nombresSolicitantes) {
		this.nombresSolicitantes = nombresSolicitantes;
	}

	public UnidadBDO getUnidadB() {
		return unidadB;
	}

	public void setUnidadB(UnidadBDO unidadB) {
		this.unidadB = unidadB;
	}

	public PrioridadDO getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadDO prioridad) {
		this.prioridad = prioridad;
	}

	public TipoAlmacenDO getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacenDO tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	public AreaSolicitanteDO getAreaSolicitante() {
		return areaSolicitante;
	}

	public void setAreaSolicitante(AreaSolicitanteDO areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}

	public ServicioSolicitadoDO getServicioSolicitado() {
		return servicioSolicitado;
	}

	public void setServicioSolicitado(ServicioSolicitadoDO servicioSolicitado) {
		this.servicioSolicitado = servicioSolicitado;
	}

	public DescripcionAlmacenDO getDescripcionAlmacen() {
		return descripcionAlmacen;
	}

	public void setDescripcionAlmacen(DescripcionAlmacenDO descripcionAlmacen) {
		this.descripcionAlmacen = descripcionAlmacen;
	}

}