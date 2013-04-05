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
	@NamedQuery(name = "NacionalidadDO.findAll", query = "select c from NacionalidadDO c") })
@Table(name="Nacionalidad")
public class NacionalidadDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -153802946158205534L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="nacionalidad")
	private String etiqueta;

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
