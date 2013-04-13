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
	@NamedQuery(name = "ClaseIncidenciaDO.findAll", query = "select c from ClaseIncidenciaDO c") })
@Table(name="ClaseIncidencia")
public class ClaseIncidenciaDO implements Serializable{

	/**
	 *
	 * 
	 */
	private static final long serialVersionUID = -5513041132722697772L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="incidencia")
	private String incidencia;
	
	public ClaseIncidenciaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClaseIncidenciaDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.incidencia = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIncidencia() {
		return incidencia;
	}

	public void setIncidencia(String etiqueta) {
		this.incidencia = etiqueta;
	}

	
	

}
