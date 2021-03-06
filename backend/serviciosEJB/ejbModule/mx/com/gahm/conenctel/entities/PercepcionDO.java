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
	@NamedQuery(name = "PercepcionDO.findAll", query = "select c from PercepcionDO c") })
@Table(name="Percepcion")

public class PercepcionDO implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="percepcion")
	private String percepcion;
	
	public PercepcionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PercepcionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.percepcion = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPercepcion() {
		return percepcion;
	}

	public void setPercepcion(String etiqueta) {
		this.percepcion = etiqueta;
	}

}
