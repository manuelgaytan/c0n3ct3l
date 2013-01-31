package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="HardwareSolicitudAlmacen")
@NamedQueries({
	@NamedQuery(name = "HardwareSolicitudAlmacenDO.findAll", query = "select ha from HardwareSolicitudAlmacenDO ha where ha.solicitudAlmacen.id=:id")})
public class HardwareSolicitudAlmacenDO implements Serializable {
	
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
	@JoinColumn(name="fk_hardware")
	private HardwareDO hardware;
	@Column(name="cantidad_solicitada")
	private BigDecimal cantidadSolicitada;
	@Column(name="regreso_almacen")
	private Boolean regresoAlmacen;
	@Column(name="observacion")
	private String observacion;

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

	public HardwareDO getHardware() {
		return hardware;
	}

	public void setHardware(HardwareDO hardware) {
		this.hardware = hardware;
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

}
