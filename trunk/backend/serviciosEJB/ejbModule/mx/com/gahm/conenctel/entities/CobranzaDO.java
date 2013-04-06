/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "Cobranza")
@NamedQueries({
	@NamedQuery(name = "CobranzaDO.findAll", query = "select rc from CobranzaDO rc")
	})
public class CobranzaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4407224017149976062L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_informacion_facturacion", nullable = false)
	private InformacionFacturacionDO informacionFacturacion;
	
	@Column(name = "folio_factura", nullable = false)
	private String folioFactura;
	
	@ManyToOne
	@JoinColumn(name = "fk_nota_credito_cliente", nullable = false)
	private NotaCreditoClienteDO notaCreditoCliente;
	
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
	
	@Column(name = "referenciaAbono", nullable = false)
	private Integer referenciaAbono;
	
	@OneToMany(mappedBy="cobranza", fetch = FetchType.EAGER)	
	private List<ComentarioCobranzaDO> comentariosCobranza;
	

	public List<ComentarioCobranzaDO> getComentariosCobranza() {
		return comentariosCobranza;
	}

	public void setComentariosCobranza(
			List<ComentarioCobranzaDO> comentariosCobranza) {
		this.comentariosCobranza = comentariosCobranza;
	}

	public CobranzaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CobranzaDO(Integer id,
			InformacionFacturacionDO informacionFacturacion,
			String folioFactura, NotaCreditoClienteDO notaCreditoCliente,
			Double subtotal, Double iva, Double total,
			BancoConectelDO bancoConectel, Date fechaAbono, Double monto,
			Integer referenciaAbono) {
		super();
		this.id = id;
		this.informacionFacturacion = informacionFacturacion;
		this.folioFactura = folioFactura;
		this.notaCreditoCliente = notaCreditoCliente;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.bancoConectel = bancoConectel;
		this.fechaAbono = fechaAbono;
		this.monto = monto;
		this.referenciaAbono = referenciaAbono;
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
	 * @return the informacionFacturacion
	 */
	public InformacionFacturacionDO getInformacionFacturacion() {
		return informacionFacturacion;
	}

	/**
	 * @param informacionFacturacion the informacionFacturacion to set
	 */
	public void setInformacionFacturacion(
			InformacionFacturacionDO informacionFacturacion) {
		this.informacionFacturacion = informacionFacturacion;
	}

	/**
	 * @return the folioFactura
	 */
	public String getFolioFactura() {
		return folioFactura;
	}

	/**
	 * @param folioFactura the folioFactura to set
	 */
	public void setFolioFactura(String folioFactura) {
		this.folioFactura = folioFactura;
	}

	/**
	 * @return the notaCreditoCliente
	 */
	public NotaCreditoClienteDO getNotaCreditoCliente() {
		return notaCreditoCliente;
	}

	/**
	 * @param notaCreditoCliente the notaCreditoCliente to set
	 */
	public void setNotaCreditoCliente(NotaCreditoClienteDO notaCreditoCliente) {
		this.notaCreditoCliente = notaCreditoCliente;
	}

	/**
	 * @return the subtotal
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the bancoConectel
	 */
	public BancoConectelDO getBancoConectel() {
		return bancoConectel;
	}

	/**
	 * @param bancoConectel the bancoConectel to set
	 */
	public void setBancoConectel(BancoConectelDO bancoConectel) {
		this.bancoConectel = bancoConectel;
	}

	/**
	 * @return the fechaAbono
	 */
	public Date getFechaAbono() {
		return fechaAbono;
	}

	/**
	 * @param fechaAbono the fechaAbono to set
	 */
	public void setFechaAbono(Date fechaAbono) {
		this.fechaAbono = fechaAbono;
	}

	/**
	 * @return the monto
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * @return the referenciaAbono
	 */
	public Integer getReferenciaAbono() {
		return referenciaAbono;
	}

	/**
	 * @param referenciaAbono the referenciaAbono to set
	 */
	public void setReferenciaAbono(Integer referenciaAbono) {
		this.referenciaAbono = referenciaAbono;
	}
	
	
	
	
}
