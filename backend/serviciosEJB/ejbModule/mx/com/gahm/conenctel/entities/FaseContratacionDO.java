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
	@NamedQuery(name = "FaseContratacionDO.findAll", query = "select c from FaseContratacionDO c") })
@Table(name="FaseContratacion")
public class FaseContratacionDO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4432474362844907165L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "fase")
	private String fase;

	public FaseContratacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FaseContratacionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.fase = etiqueta;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the etiqueta
	 */
	public String getFase() {
		return fase;
	}

	/**
	 * @param etiqueta
	 *            the etiqueta to set
	 */
	public void setFase(String etiqueta) {
		this.fase = etiqueta;
	}

}
