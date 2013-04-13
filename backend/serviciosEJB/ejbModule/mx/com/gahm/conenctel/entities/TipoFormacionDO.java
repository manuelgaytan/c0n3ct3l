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
@Table(name = "TipoFormacion")
@NamedQueries({
	@NamedQuery(name = "TipoFormacionDO.findAll", query = "select rc from TipoFormacionDO rc")
	})
public class TipoFormacionDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1411062891035427576L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	public TipoFormacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoFormacionDO(Integer id, String tipo) {
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
