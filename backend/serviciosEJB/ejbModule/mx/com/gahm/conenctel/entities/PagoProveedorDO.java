/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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

/**
 * @author SEVEN
 *
 */
@Entity
@Table(name = "PagoProveedor")
@NamedQueries({
	@NamedQuery(name = "PagoProveedorDO.findAll", query = "select rc from PagoProveedorDO rc")
	})
public class PagoProveedorDO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -742241033806079868L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "fk_factura_proveedor", nullable = false)
	private FacturaProveedorDO facturaProveedor; 
	
	@Column(name = "folio_factura", nullable = false)
	private String folioFactura;
	
	@OneToOne
	@JoinColumn(name = "fk_nota_credito_proveedor", nullable = false)
	private NotaCreditoProveedorDO notaCreditoProveedor; 
	
	@Column(name = "subtotal", nullable = false)
	private Double subtotal;
	
	@Column(name = "iva", nullable = false)
	private Double iva;
	
	@Column(name = "total", nullable = false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "fk_banco_conectel", nullable = false)
	private BancoConectelDO bancoConectel;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_abono", nullable = false, length = 10)
	private Date fechaAbono;
	
	@Column(name = "monto", nullable = false)
	private Double monto;
	
	@Column(name = "referencia_abono", nullable = false)
	private Integer referenciaAbono;
	
	@OneToMany(mappedBy="pagoProveedor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)	
	private List<ComentarioPagoProveedorDO> comentariosPagoProveedor;

	public PagoProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagoProveedorDO(Integer id, FacturaProveedorDO facturaProveedor,
			String folioFactura, NotaCreditoProveedorDO notaCreditoProveedor,
			Double subtotal, Double iva, Double total,
			BancoConectelDO bancoConectel, Date fechaAbono, Double monto,
			Integer referenciaAbono) {
		super();
		this.id = id;
		this.facturaProveedor = facturaProveedor;
		this.folioFactura = folioFactura;
		this.notaCreditoProveedor = notaCreditoProveedor;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.bancoConectel = bancoConectel;
		this.fechaAbono = fechaAbono;
		this.monto = monto;
		this.referenciaAbono = referenciaAbono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FacturaProveedorDO getFacturaProveedor() {
		return facturaProveedor;
	}

	public void setFacturaProveedor(FacturaProveedorDO facturaProveedor) {
		this.facturaProveedor = facturaProveedor;
	}

	public String getFolioFactura() {
		return folioFactura;
	}

	public void setFolioFactura(String folioFactura) {
		this.folioFactura = folioFactura;
	}

	public NotaCreditoProveedorDO getNotaCreditoProveedor() {
		return notaCreditoProveedor;
	}

	public void setNotaCreditoProveedor(NotaCreditoProveedorDO notaCreditoProveedor) {
		this.notaCreditoProveedor = notaCreditoProveedor;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Double getIva() {
		return iva;
	}

	public void setIva(Double iva) {
		this.iva = iva;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public BancoConectelDO getBancoConectel() {
		return bancoConectel;
	}

	public void setBancoConectel(BancoConectelDO bancoConectel) {
		this.bancoConectel = bancoConectel;
	}

	public Date getFechaAbono() {
		return fechaAbono;
	}

	public void setFechaAbono(Date fechaAbono) {
		this.fechaAbono = fechaAbono;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Integer getReferenciaAbono() {
		return referenciaAbono;
	}

	public void setReferenciaAbono(Integer referenciaAbono) {
		this.referenciaAbono = referenciaAbono;
	}

	public List<ComentarioPagoProveedorDO> getComentariosPagoProveedor() {
		return comentariosPagoProveedor;
	}

	public void setComentariosPagoProveedor(
			List<ComentarioPagoProveedorDO> comentariosPagoProveedor) {
		this.comentariosPagoProveedor = comentariosPagoProveedor;
	}
		
}
