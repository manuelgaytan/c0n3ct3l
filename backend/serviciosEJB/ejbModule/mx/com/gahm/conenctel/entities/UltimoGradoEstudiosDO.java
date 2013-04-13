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
@Table(name = "UltimoGradoEstudios")
@NamedQueries({ @NamedQuery(name = "UltimoGradoEstudiosDO.findAll", query = "select rc from UltimoGradoEstudiosDO rc") })
public class UltimoGradoEstudiosDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3328448830373667158L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "estudios")
	private String estudios;

	public UltimoGradoEstudiosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UltimoGradoEstudiosDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.estudios = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstudios() {
		return estudios;
	}

	public void setEstudios(String etiqueta) {
		this.estudios = etiqueta;
	}

}
