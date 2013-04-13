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
@Table(name = "Suspension")
@NamedQueries({
	@NamedQuery(name = "SuspensionDO.findAll", query = "select rc from SuspensionDO rc")
	})
public class SuspensionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3602096243844280324L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name="suspension")
	private String suspension;

	public SuspensionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuspensionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.suspension = etiqueta;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the etiqueta
	 */
	public String getSuspension() {
		return suspension;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setSuspension(String etiqueta) {
		this.suspension = etiqueta;
	}
	
	
}
