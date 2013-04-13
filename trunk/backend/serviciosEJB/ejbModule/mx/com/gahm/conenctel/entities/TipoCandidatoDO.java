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
@Table(name = "TipoCandidato")
@NamedQueries({
	@NamedQuery(name = "TipoCandidatoDO.findAll", query = "select rc from TipoCandidatoDO rc")
	})
public class TipoCandidatoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2025864582431732281L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="tipo")
	private String tipo;

	public TipoCandidatoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoCandidatoDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.tipo = etiqueta;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the etiqueta
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setTipo(String etiqueta) {
		this.tipo = etiqueta;
	}
	
	

}
