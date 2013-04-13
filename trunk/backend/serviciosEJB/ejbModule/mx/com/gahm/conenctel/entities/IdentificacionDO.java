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
	@NamedQuery(name = "IdentificacionDO.findAll", query = "select c from IdentificacionDO c") })
@Table(name="Identificacion")
public class IdentificacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4302760605846272290L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="identificacion")
	private String identificacion;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String etiqueta) {
		this.identificacion = etiqueta;
	}

	
}
