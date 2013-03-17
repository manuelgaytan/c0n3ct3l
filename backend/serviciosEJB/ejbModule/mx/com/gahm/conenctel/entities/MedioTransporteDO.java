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
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name="MedioTransporte")
public class MedioTransporteDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1731927743945542497L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="transporte")
	private String etiqueta;

	public MedioTransporteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedioTransporteDO(long id, String etiqueta) {
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
