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
@Table(name = "ComentarioPagoMovimientoPagoContableServicio")
@NamedQueries({ @NamedQuery(name = "ComentarioPagoMovimientoPagoContableServicioDO.findAll", query = "select rc from ComentarioPagoMovimientoPagoContableServicioDO rc") })
public class ComentarioPagoMovimientoPagoContableServicioDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3876124033257191337L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_pago_movimiento_pago_contable_servicio", nullable = false)
	private PagoMovimientoPagoContableServicioDO pagoMovimientoPagoContableServicio;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_tesoreria", nullable = false)
	private ComentarioTesoreriaDO comentarioTesoreria;

	public ComentarioPagoMovimientoPagoContableServicioDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioPagoMovimientoPagoContableServicioDO(
			Integer id,
			PagoMovimientoPagoContableServicioDO pagoMovimientoPagoContableServicio,
			ComentarioTesoreriaDO comentarioTesoreria) {
		super();
		this.id = id;
		this.pagoMovimientoPagoContableServicio = pagoMovimientoPagoContableServicio;
		this.comentarioTesoreria = comentarioTesoreria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PagoMovimientoPagoContableServicioDO getPagoMovimientoPagoContableServicio() {
		return pagoMovimientoPagoContableServicio;
	}

	public void setPagoMovimientoPagoContableServicio(
			PagoMovimientoPagoContableServicioDO pagoMovimientoPagoContableServicio) {
		this.pagoMovimientoPagoContableServicio = pagoMovimientoPagoContableServicio;
	}

	public ComentarioTesoreriaDO getComentarioTesoreria() {
		return comentarioTesoreria;
	}

	public void setComentarioTesoreria(ComentarioTesoreriaDO comentarioTesoreria) {
		this.comentarioTesoreria = comentarioTesoreria;
	} 
	
	
	
	
}
