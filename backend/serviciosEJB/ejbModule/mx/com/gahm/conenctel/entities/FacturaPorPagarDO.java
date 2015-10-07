package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name = "FacturaPorPagar")
@NamedQueries({
		@NamedQuery(name = "FacturaPorPagarDO.findAll", query = "select oc from FacturaPorPagarDO oc"),
		@NamedQuery(name = "FacturaPorPagarDO.findById", query = "select oc from FacturaPorPagarDO oc where oc.id = :id") })
public class FacturaPorPagarDO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4807084501274541986L;
	private Integer id;
	private OrdenCompraDO ordenCompra;
	private OrdenCompraMaquiladoDO ordenCompraMaquilado;
	private String folio;
	private Date fecha;
	private Date fechaPago;
	private Date fechaPago1;
	private String porcentajePago1;
	private Date fechaPago2;
	private String porcentajePago2;

	public FacturaPorPagarDO() {
	}

	public FacturaPorPagarDO(String folio, Date fecha) {
		this.folio = folio;
		this.fecha = fecha;
	}

	public FacturaPorPagarDO(OrdenCompraDO ordenCompra,
			OrdenCompraMaquiladoDO ordenCompraMaquilado, String folio,
			Date fecha, Date fechaPago, 
			Date fechaPago1, String porcentajePago1,
			Date fechaPago2, String porcentajePago2) {
		this.ordenCompra = ordenCompra;
		this.ordenCompraMaquilado = ordenCompraMaquilado;
		this.folio = folio;
		this.fecha = fecha;
		this.fechaPago = fechaPago;
		this.fechaPago1 = fechaPago1;
		this.porcentajePago1 = porcentajePago1;
		this.fechaPago2 = fechaPago2;
		this.porcentajePago2 = porcentajePago2;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "fk_orden_compra")
	public OrdenCompraDO getOrdenCompra() {
		return this.ordenCompra;
	}

	public void setOrdenCompra(OrdenCompraDO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	@ManyToOne
	@JoinColumn(name = "fk_orden_compra_maquilado")
	public OrdenCompraMaquiladoDO getOrdenCompraMaquilado() {
		return this.ordenCompraMaquilado;
	}

	public void setOrdenCompraMaquilado(
			OrdenCompraMaquiladoDO ordenCompraMaquilado) {
		this.ordenCompraMaquilado = ordenCompraMaquilado;
	}

	@Column(name = "folio", nullable = false)
	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_pago", length = 10)
	public Date getFechaPago() {
		return this.fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_pago1", length = 10)
	public Date getFechaPago1() {
		return fechaPago1;
	}

	public void setFechaPago1(Date fechaPago1) {
		this.fechaPago1 = fechaPago1;
	}

	@Column(name = "porcentaje_pago1")
	public String getPorcentajePago1() {
		return porcentajePago1;
	}

	public void setPorcentajePago1(String porcentajePago1) {
		this.porcentajePago1 = porcentajePago1;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_pago2", length = 10)
	public Date getFechaPago2() {
		return fechaPago2;
	}

	public void setFechaPago2(Date fechaPago2) {
		this.fechaPago2 = fechaPago2;
	}

	@Column(name = "porcentaje_pago2")
	public String getPorcentajePago2() {
		return porcentajePago2;
	}

	public void setPorcentajePago2(String porcentajePago2) {
		this.porcentajePago2 = porcentajePago2;
	}

}