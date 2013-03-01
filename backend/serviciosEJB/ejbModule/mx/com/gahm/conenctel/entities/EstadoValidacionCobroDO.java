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
	@NamedQuery(name = "EstadoValidacionCobroDO.findAll", query = "select c from EstadoValidacionCobroDO c") })
@Table(name="EstadoValidacionCobro")
public class EstadoValidacionCobroDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2179525299376607686L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "estado")
	private String etiqueta;

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
