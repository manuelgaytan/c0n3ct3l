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
@NamedQueries({ @NamedQuery(name = "EstadoCivilDO.findAll", query = "select c from EstadoCivilDO c") })
@Table(name = "EstadoCivil")
public class EstadoCivilDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6457826590556768160L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "estado")
	private String estado;

	public EstadoCivilDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.estado = etiqueta;
	}

	public EstadoCivilDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String etiqueta) {
		this.estado = etiqueta;
	}

}
