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
@Table(name = "FuenteNoConformidad")
@NamedQueries({ @NamedQuery(name = "FuenteNoConformidadDO.findAll", query = "select rc from FuenteNoConformidadDO rc") })
public class FuenteNoConformidadDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2375596445222798520L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fuente")
	private String fuente;

	public FuenteNoConformidadDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuenteNoConformidadDO(Long id, String etiqueta) {
		super();
		this.id = id;
		this.fuente = etiqueta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String etiqueta) {
		this.fuente = etiqueta;
	}
	
	
	
}
