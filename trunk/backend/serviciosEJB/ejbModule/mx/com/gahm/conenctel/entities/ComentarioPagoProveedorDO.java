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
@Table(name = "ComentarioPagoProveedor")
@NamedQueries({
	@NamedQuery(name = "ComentarioPagoProveedorDO.findAll", query = "select rc from ComentarioPagoProveedorDO rc")
	})
public class ComentarioPagoProveedorDO implements Serializable{
	
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
	@JoinColumn(name = "fk_comentario_tesoreria", nullable = false)
	private ComentarioTesoreriaDO comentarioTesoreria;

	public ComentarioPagoProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioPagoProveedorDO(Integer id, PagoProveedorDO pagoProveedor,
			ComentarioTesoreriaDO comentarioTesoreria) {
		super();
		this.id = id;
		this.pagoProveedor = pagoProveedor;
		this.comentarioTesoreria = comentarioTesoreria;
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

	public ComentarioTesoreriaDO getComentarioTesoreria() {
		return comentarioTesoreria;
	}

	public void setComentarioTesoreria(ComentarioTesoreriaDO comentarioTesoreria) {
		this.comentarioTesoreria = comentarioTesoreria;
	}
	
}
