/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

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
	@NamedQuery(name = "ViveConDO.findAll", query = "select c from ViveConDO c") })
@Table(name="ViveCon")

public class ViveConDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7413654401271921332L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "relacion")
	private String etiqueta;

	public ViveConDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ViveConDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
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
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

		
	
}
