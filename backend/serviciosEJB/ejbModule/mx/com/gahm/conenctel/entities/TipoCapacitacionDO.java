/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "TipoCapacitacion")
@NamedQueries({
	@NamedQuery(name = "TipoCapacitacionDO.findAll", query = "select rc from TipoCapacitacionDO rc")
	})
public class TipoCapacitacionDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -844047197583207920L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "tipo", nullable = false)
	private String tipo;

	public TipoCapacitacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoCapacitacionDO(Integer id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
