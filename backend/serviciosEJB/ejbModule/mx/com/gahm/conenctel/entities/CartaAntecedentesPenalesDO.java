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
	@NamedQuery(name = "CartaAntecedentesPenalesDO.findAll", query = "select c from CartaAntecedentesPenalesDO c") })
@Table(name="CartaAntecedentesPenales")
public class CartaAntecedentesPenalesDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3618110110541446063L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "tiene_carta")
	private String etiqueta;

	public CartaAntecedentesPenalesDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public CartaAntecedentesPenalesDO() {
		super();
		// TODO Auto-generated constructor stub
	}

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
