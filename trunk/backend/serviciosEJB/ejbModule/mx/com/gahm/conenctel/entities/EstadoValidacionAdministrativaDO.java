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
@Table(name = "EstadoValidacionAdministrativa")
@NamedQueries({
	@NamedQuery(name = "EstadoValidacionAdministrativaDO.findAll", query = "select rc from EstadoValidacionAdministrativaDO rc")
	})
public class EstadoValidacionAdministrativaDO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4205774598743337557L;

	
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
