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

@Entity
@Table(name = "NotaCreditoCliente")
@NamedQueries({
	@NamedQuery(name = "NotaCreditoClienteDO.findAll", query = "select rc from NotaCreditoClienteDO rc"),
	@NamedQuery(name = "NotaCreditoClienteDO.NotasCrediByCliente",
					query = "select rc from NotaCreditoClienteDO rc where rc.cliente.id=:idCliente")
	})
public class NotaCreditoClienteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5760157495497708461L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "folio", nullable = false)
	private String folio;
	
	@Column(name = "factura", nullable = false)
	private String factura;
	
	@Column(name = "item", nullable = false)
	private String item;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	private Date fecha;
	
	@Column(name = "subtotal", nullable = false)
	private Double subtotal;
	
	@Column(name = "iva", nullable = false)
	private Double iva;
	
	@Column(name = "total", nullable = false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "fk_cliente", nullable = false)
	private ClienteDO cliente;
	
	@OneToMany(mappedBy="notaCreditoCliente", fetch = FetchType.EAGER)
	private List<ComentarioNotaCreditoClienteDO> comentariosNotaCreditoCliente;
	
	public NotaCreditoClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaCreditoClienteDO(Integer id, String folio, String factura,
			String item, Date fecha, Double subtotal, Double iva, Double total,
			ClienteDO cliente) {
		super();
		this.id = id;
		this.folio = folio;
		this.factura = factura;
		this.item = item;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.cliente = cliente;
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
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the factura
	 */
	public String getFactura() {
		return factura;
	}

	/**
	 * @param factura the factura to set
	 */
	public void setFactura(String factura) {
		this.factura = factura;
	}

	/**
	 * @return the item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
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
	 * @return the cliente
	 */
	public ClienteDO getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteDO cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the comentariosNotaCreditoCliente
	 */
	public List<ComentarioNotaCreditoClienteDO> getComentariosNotaCreditoCliente() {
		return comentariosNotaCreditoCliente;
	}

	/**
	 * @param comentariosNotaCreditoCliente the comentariosNotaCreditoCliente to set
	 */
	public void setComentariosNotaCreditoCliente(
			List<ComentarioNotaCreditoClienteDO> comentariosNotaCreditoCliente) {
		this.comentariosNotaCreditoCliente = comentariosNotaCreditoCliente;
	}
	
	
	
	
}
