/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SEVEN
 *
 */
@Entity
@Table(name = "NotaCreditoProveedorPagoProveedor")
@NamedQueries({
	@NamedQuery(name = "NotaCreditoProveedorPagoProveedorDO.findAll", query = "select rc from NotaCreditoProveedorPagoProveedorDO rc")
	})
public class NotaCreditoProveedorPagoProveedorDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5755609436310428396L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "fk_pago_proveedor", nullable = false)
	private PagoProveedorDO pagoProveedor; 
	
	@OneToOne
	@JoinColumn(name = "fk_nota_credito_proveedor", nullable = false)
	private NotaCreditoProveedorDO notaCreditoProveedor;

	public NotaCreditoProveedorPagoProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaCreditoProveedorPagoProveedorDO(Integer id, PagoProveedorDO pagoProveedor,
			NotaCreditoProveedorDO notaCreditoProveedor) {
		super();
		this.id = id;
		this.pagoProveedor = pagoProveedor;
		this.notaCreditoProveedor = notaCreditoProveedor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PagoProveedorDO getPagoProveedor() {
		return pagoProveedor;
	}

	public void setPagoProveedor(PagoProveedorDO pagoProveedor) {
		this.pagoProveedor = pagoProveedor;
	}

	public NotaCreditoProveedorDO getNotaCreditoProveedor() {
		return notaCreditoProveedor;
	}

	public void setNotaCreditoProveedor(NotaCreditoProveedorDO notaCreditoProveedor) {
		this.notaCreditoProveedor = notaCreditoProveedor;
	}
}
