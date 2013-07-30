package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrdenCompraCliente")
@NamedQueries({
		@NamedQuery(name = "OrdenCompraClienteDO.findAll", query = "select oc from OrdenCompraClienteDO oc"),
		@NamedQuery(name = "OrdenCompraClienteDO.findById", query = "select oc from OrdenCompraClienteDO oc where oc.id = :id ") })
public class OrdenCompraClienteDO implements java.io.Serializable {
	private static final long serialVersionUID = 2266679066287264065L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	@OneToOne
	@JoinColumn(name = "fk_proyecto", nullable = false)
	private ProyectoDO proyecto;
	@Column(name = "orden_compra", nullable = false)
	private Boolean ordenCompra;
	@Column(name = "numero_orden_compra", nullable = false)
	private String numeroOrdenCompra;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_orden_compra", nullable = false, length = 10)
	private Date fechaOrdenCompra;
	@Column(name = "costo_orden_compra", nullable = false)
	private Double costoOrdenCompra;
	@ManyToOne
	@JoinColumn(name = "fk_validacion_costo", nullable = false)
	private ValidacionCostoDO validacionCosto;
	@ManyToOne
	@JoinColumn(name = "fk_estado_orden_compra", nullable = false)
	private EstadoOrdenCompraDO estadoOrdenCompra;

	@OneToMany(mappedBy = "ordenCompraCliente", fetch = FetchType.EAGER)
	private List<ComentarioOrdenCompraClienteDO> comentarioOrdenCompraCliente;

	@OneToMany(mappedBy = "ordenCompraCliente", fetch = FetchType.EAGER)
	private List<ComentarioValidacionCostoOrdenCompraClienteDO> comentarioValidacionCostoOrdenCompraCliente;

	private String leyenda;
	
	/**
	 * 
	 */
	public OrdenCompraClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param proyecto
	 * @param ordenCompra
	 * @param numeroOrdenCompra
	 * @param fechaOrdenCompra
	 * @param costoOrdenCompra
	 * @param validacionCosto
	 * @param estadoOrdenCompra
	 */
	public OrdenCompraClienteDO(Long id, ProyectoDO proyecto,
			Boolean ordenCompra, String numeroOrdenCompra, Date fechaOrdenCompra,
			Double costoOrdenCompra, ValidacionCostoDO validacionCosto,
			EstadoOrdenCompraDO estadoOrdenCompra) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.ordenCompra = ordenCompra;
		this.numeroOrdenCompra = numeroOrdenCompra;
		this.fechaOrdenCompra = fechaOrdenCompra;
		this.costoOrdenCompra = costoOrdenCompra;
		this.validacionCosto = validacionCosto;
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProyectoDO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public Boolean getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(Boolean ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public String getNumeroOrdenCompra() {
		return numeroOrdenCompra;
	}

	public void setNumeroOrdenCompra(String numeroOrdenCompra) {
		this.numeroOrdenCompra = numeroOrdenCompra;
	}

	public Date getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}

	public void setFechaOrdenCompra(Date fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}

	public Double getCostoOrdenCompra() {
		return costoOrdenCompra;
	}

	public void setCostoOrdenCompra(Double costoOrdenCompra) {
		this.costoOrdenCompra = costoOrdenCompra;
	}

	public ValidacionCostoDO getValidacionCosto() {
		return validacionCosto;
	}

	public void setValidacionCosto(ValidacionCostoDO validacionCosto) {
		this.validacionCosto = validacionCosto;
	}

	public EstadoOrdenCompraDO getEstadoOrdenCompra() {
		return estadoOrdenCompra;
	}

	public void setEstadoOrdenCompra(EstadoOrdenCompraDO estadoOrdenCompra) {
		this.estadoOrdenCompra = estadoOrdenCompra;
	}

	public List<ComentarioValidacionCostoOrdenCompraClienteDO> getComentarioValidacionCostoOrdenCompraCliente() {
		return comentarioValidacionCostoOrdenCompraCliente;
	}

	public void setComentarioValidacionCostoOrdenCompraCliente(
			List<ComentarioValidacionCostoOrdenCompraClienteDO> comentarioValidacionCostoOrdenCompraCliente) {
		this.comentarioValidacionCostoOrdenCompraCliente = comentarioValidacionCostoOrdenCompraCliente;
	}

	public List<ComentarioOrdenCompraClienteDO> getComentarioOrdenCompraCliente() {
		return comentarioOrdenCompraCliente;
	}

	public void setComentarioOrdenCompraCliente(
			List<ComentarioOrdenCompraClienteDO> comentarioOrdenCompraCliente) {
		this.comentarioOrdenCompraCliente = comentarioOrdenCompraCliente;
	}

	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

}