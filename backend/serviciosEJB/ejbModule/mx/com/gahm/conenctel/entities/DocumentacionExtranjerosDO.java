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
	@NamedQuery(name = "DocumentacionExtranjerosDO.findAll", query = "select c from DocumentacionExtranjerosDO c") })
@Table(name="DocumentacionExtranjeros")
public class DocumentacionExtranjerosDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5050150938263385884L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="documento")
	private String etiqueta;

	
	
	public DocumentacionExtranjerosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentacionExtranjerosDO(long id, String etiqueta) {
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
