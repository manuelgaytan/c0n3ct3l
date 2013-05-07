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
	@NamedQuery(name = "TipoDesarrolloProyectoDO.findAll", query = "select s from TipoDesarrolloProyectoDO s") })
@Table(name="TipoDesarrolloProyecto")
public class TipoDesarrolloProyectoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2906231287813005963L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tipo")
	private String tipo;

	public TipoDesarrolloProyectoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoDesarrolloProyectoDO(Integer id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}
