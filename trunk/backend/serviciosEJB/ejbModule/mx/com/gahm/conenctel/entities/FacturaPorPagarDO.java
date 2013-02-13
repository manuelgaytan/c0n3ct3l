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

	public FacturaPorPagarDO() {
	}

	public FacturaPorPagarDO(String folio, Date fecha) {
		this.folio = folio;
		this.fecha = fecha;
	}

	public FacturaPorPagarDO(OrdenCompraDO ordenCompra,
			OrdenCompraMaquiladoDO ordenCompraMaquilado, String folio,
			Date fecha, Date fechaPago) {
		this.ordenCompra = ordenCompra;
		this.ordenCompraMaquilado = ordenCompraMaquilado;
		this.folio = folio;
		this.fecha = fecha;
		this.fechaPago = fechaPago;
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

}