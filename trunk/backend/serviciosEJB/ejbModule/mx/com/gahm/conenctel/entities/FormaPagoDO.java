/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author lespinosa Clase de persistencia para forma de pago
 */
@Cacheable(false)
@Entity
@NamedQueries({
	@NamedQuery(name = "FormaPagoDO.findAll", query = "select f from FormaPagoDO f ")})
@Table(name = "formapago")
public class FormaPagoDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "forma")
	private String forma;

	public FormaPagoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormaPagoDO(long id, String forma) {
		super();
		this.id = id;
		this.forma = forma;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

}
