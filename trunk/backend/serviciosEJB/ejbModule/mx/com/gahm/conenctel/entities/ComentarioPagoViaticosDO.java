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
 * @author Guillermo
 *
 */
@Entity
@Table(name = "ComentarioPagoViaticos")
@NamedQueries({
	@NamedQuery(name = "ComentarioPagoViaticosDO.findAll", 
			query = "select rc from ComentarioPagoViaticosDO rc")
	})
public class ComentarioPagoViaticosDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4082846414729825324L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_pago_viaticos", nullable = false)
	private PagoViaticosDO pagoViaticos;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_tesoreria", nullable = false)
	private ComentarioTesoreriaDO comentarioTesoreria;

	public ComentarioPagoViaticosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioPagoViaticosDO(Integer id, PagoViaticosDO pagoViaticos,
			ComentarioTesoreriaDO comentarioTesoreria) {
		super();
		this.id = id;
		this.pagoViaticos = pagoViaticos;
		this.comentarioTesoreria = comentarioTesoreria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PagoViaticosDO getPagoViaticos() {
		return pagoViaticos;
	}

	public void setPagoViaticos(PagoViaticosDO pagoViaticos) {
		this.pagoViaticos = pagoViaticos;
	}

	public ComentarioTesoreriaDO getComentarioTesoreria() {
		return comentarioTesoreria;
	}

	public void setComentarioTesoreria(ComentarioTesoreriaDO comentarioTesoreria) {
		this.comentarioTesoreria = comentarioTesoreria;
	} 
	
	
	
	
}
