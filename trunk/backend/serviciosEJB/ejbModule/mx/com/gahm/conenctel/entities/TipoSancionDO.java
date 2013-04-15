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
	@NamedQuery(name = "TipoSancionDO.findAll", query = "select c from TipoSancionDO c") })
@Table(name="TipoSancion")
public class TipoSancionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1845876685859413195L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="tipo")
	private String tipo;

	public TipoSancionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoSancionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.tipo = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String etiqueta) {
		this.tipo = etiqueta;
	}

}
