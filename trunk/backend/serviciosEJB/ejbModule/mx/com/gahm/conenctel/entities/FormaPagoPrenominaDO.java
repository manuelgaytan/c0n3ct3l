/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "FormaPagoPrenominaDO.findAll", query = "select c from FormaPagoPrenominaDO c") })
@Table(name="FormaPagoPrenomina")

public class FormaPagoPrenominaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9121509552781704376L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="tipo")
	private String etiqueta;

	public FormaPagoPrenominaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FormaPagoPrenominaDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}


	
	
}
