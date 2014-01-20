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
@Table(name = "FacturaProveedorPagoProveedor")
@NamedQueries({
	@NamedQuery(name = "FacturaProveedorPagoProveedorDO.findAll", query = "select rc from FacturaProveedorPagoProveedorDO rc")
	})
public class FacturaProveedorPagoProveedorDO implements Serializable{
	
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
	@JoinColumn(name = "fk_factura_proveedor", nullable = false)
	private FacturaProveedorDO facturaProveedor;

	public FacturaProveedorPagoProveedorDO() {
		super();
	}

	public FacturaProveedorPagoProveedorDO(Integer id, PagoProveedorDO pagoProveedor,
			FacturaProveedorDO facturaProveedor) {
		super();
		this.id = id;
		this.pagoProveedor = pagoProveedor;
		this.facturaProveedor = facturaProveedor;
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

	public FacturaProveedorDO getFacturaProveedor() {
		return facturaProveedor;
	}

	public void setFacturaProveedor(FacturaProveedorDO facturaProveedor) {
		this.facturaProveedor = facturaProveedor;
	}
}
