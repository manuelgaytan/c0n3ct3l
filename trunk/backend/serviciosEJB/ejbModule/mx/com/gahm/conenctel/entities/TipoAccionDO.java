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
 * @author GUILLERMO
 * 
 */
@Entity
@Table(name = "TipoAccion")
@NamedQueries({ @NamedQuery(name = "TipoAccionDO.findAll", query = "select rc from TipoAccionDO rc") })
public class TipoAccionDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8844441247305583628L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "accion")
	private String etiqueta;

	public TipoAccionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoAccionDO(Long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}
