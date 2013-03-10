package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
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
@Table(name = "NotaCreditoProveedor")
@NamedQueries({
	@NamedQuery(name = "NotaCreditoProveedorDO.findAll", query = "select rc from NotaCreditoProveedorDO rc")
	})
public class NotaCreditoProveedorDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7904088427116914444L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "folio", nullable = false)
	private String folio;
	
	@Column(name = "fecha", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name = "subtotal", nullable = false)
	private Double subtotal;
	
	@Column(name = "iva", nullable = false)
	private Double iva;
	
	@Column(name = "total", nullable = false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_calificado", nullable = false)
	private ProveedorCalificadoDO proveedorCalificado;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_maquilador", nullable = false)
	private ProveedorMaquiladorDO  proveedorMaquilador;

	public NotaCreditoProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaCreditoProveedorDO(Integer id, String folio, Date fecha,
			Double subtotal, Double iva, Double total,
			ProveedorCalificadoDO proveedorCalificado,
			ProveedorMaquiladorDO proveedorMaquilador) {
		super();
		this.id = id;
		this.folio = folio;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.proveedorCalificado = proveedorCalificado;
		this.proveedorMaquilador = proveedorMaquilador;
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
	 * @return the proveedorCalificado
	 */
	public ProveedorCalificadoDO getProveedorCalificado() {
		return proveedorCalificado;
	}

	/**
	 * @param proveedorCalificado the proveedorCalificado to set
	 */
	public void setProveedorCalificado(ProveedorCalificadoDO proveedorCalificado) {
		this.proveedorCalificado = proveedorCalificado;
	}

	/**
	 * @return the proveedorMaquilador
	 */
	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return proveedorMaquilador;
	}

	/**
	 * @param proveedorMaquilador the proveedorMaquilador to set
	 */
	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
	}
	
	
	
	
	
	
	
	
	
}
