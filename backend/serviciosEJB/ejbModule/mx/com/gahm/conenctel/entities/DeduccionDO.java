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
	@NamedQuery(name = "DeduccionDO.findAll", query = "select c from DeduccionDO c") })
@Table(name="Deduccion")

public class DeduccionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8731759040966574725L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="deduccion")
	private String deduccion;
	
	public DeduccionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeduccionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.deduccion = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDeduccion() {
		return deduccion;
	}

	public void setDeduccion(String etiqueta) {
		this.deduccion = etiqueta;
	}

	
}
