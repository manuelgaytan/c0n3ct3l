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
	@NamedQuery(name = "SexoDO.findAll", query = "select c from SexoDO c") })
@Table(name="Sexo")
public class SexoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7328078075416444775L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="sexo")
	private String sexo;
	
	

	public SexoDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public SexoDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.sexo = etiqueta;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String etiqueta) {
		this.sexo = etiqueta;
	}

	
}
