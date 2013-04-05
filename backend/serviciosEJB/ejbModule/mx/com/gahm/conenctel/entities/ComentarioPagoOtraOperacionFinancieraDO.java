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
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ComentarioPagoOtraOperacionFinancieraDO.findAll", query = "select c from ComentarioPagoOtraOperacionFinancieraDO c") })
@Table(name="ComentarioPagoOtraOperacionFinanciera")
public class ComentarioPagoOtraOperacionFinancieraDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3270632969828481095L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="fk_pago_otra_operacion_financiera")
	private PagoOtraOperacionFinancieraDO pagoOtraOperacionFinanciera;
	
	@ManyToOne
	@JoinColumn(name="fk_comentario_tesoreria")
	private ComentarioTesoreriaDO comentarioTesoreria;

	public ComentarioPagoOtraOperacionFinancieraDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioPagoOtraOperacionFinancieraDO(Integer id,
			PagoOtraOperacionFinancieraDO pagoOtraOperacionFinanciera,
			ComentarioTesoreriaDO comentarioTesoreria) {
		super();
		this.id = id;
		this.pagoOtraOperacionFinanciera = pagoOtraOperacionFinanciera;
		this.comentarioTesoreria = comentarioTesoreria;
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
	 * @return the pagoOtraOperacionFinanciera
	 */
	public PagoOtraOperacionFinancieraDO getPagoOtraOperacionFinanciera() {
		return pagoOtraOperacionFinanciera;
	}

	/**
	 * @param pagoOtraOperacionFinanciera the pagoOtraOperacionFinanciera to set
	 */
	public void setPagoOtraOperacionFinanciera(
			PagoOtraOperacionFinancieraDO pagoOtraOperacionFinanciera) {
		this.pagoOtraOperacionFinanciera = pagoOtraOperacionFinanciera;
	}

	/**
	 * @return the comentarioTesoreria
	 */
	public ComentarioTesoreriaDO getComentarioTesoreria() {
		return comentarioTesoreria;
	}

	/**
	 * @param comentarioTesoreria the comentarioTesoreria to set
	 */
	public void setComentarioTesoreria(ComentarioTesoreriaDO comentarioTesoreria) {
		this.comentarioTesoreria = comentarioTesoreria;
	}
	
	
	
}
