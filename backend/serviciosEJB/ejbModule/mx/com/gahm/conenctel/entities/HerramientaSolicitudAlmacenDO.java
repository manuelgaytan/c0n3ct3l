package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="HerramientaSolicitudAlmacen")
@NamedQueries({
	@NamedQuery(name = "HerramientaSolicitudAlmacenDO.findAll", query = "select ha from HerramientaSolicitudAlmacenDO ha where ha.solicitudAlmacen.id=:id")})
public class HerramientaSolicitudAlmacenDO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2433391980507471472L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="fk_solicitud_almacen")
	private SolicitudAlmacenDO solicitudAlmacen;
	@ManyToOne
	@JoinColumn(name="fk_herramienta")
	private HerramientaDO herramienta;
	@Column(name="cantidad_solicitada")
	private BigDecimal cantidadSolicitada;
	@Column(name="regreso_almacen")
	private Boolean regresoAlmacen;
	@Column(name="observacion")
	private String observacion;
	@Column(name="cantidad_devuelta")
	private BigDecimal cantidadDevuelta;
	@JoinColumn(name="fk_estatus_devolucion")
	private EstatusDevolucionDO estatusDevolucion;
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_devolucion")
	private Date fechaDevolucion;
	@Column(name="devuelto")
	private Boolean devuelto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SolicitudAlmacenDO getSolicitudAlmacen() {
		return solicitudAlmacen;
	}

	public void setSolicitudAlmacen(SolicitudAlmacenDO solicitudAlmacen) {
		this.solicitudAlmacen = solicitudAlmacen;
	}

	public HerramientaDO getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(HerramientaDO herramienta) {
		this.herramienta = herramienta;
	}

	public BigDecimal getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(BigDecimal cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public Boolean getRegresoAlmacen() {
		return regresoAlmacen;
	}

	public void setRegresoAlmacen(Boolean regresoAlmacen) {
		this.regresoAlmacen = regresoAlmacen;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public BigDecimal getCantidadDevuelta() {
		return cantidadDevuelta;
	}

	public void setCantidadDevuelta(BigDecimal cantidadDevuelta) {
		this.cantidadDevuelta = cantidadDevuelta;
	}

	public EstatusDevolucionDO getEstatusDevolucion() {
		return estatusDevolucion;
	}

	public void setEstatusDevolucion(EstatusDevolucionDO estatusDevolucion) {
		this.estatusDevolucion = estatusDevolucion;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	public Boolean getDevuelto() {
		return devuelto;
	}

	public void setDevuelto(Boolean devuelto) {
		this.devuelto = devuelto;
	}

}
