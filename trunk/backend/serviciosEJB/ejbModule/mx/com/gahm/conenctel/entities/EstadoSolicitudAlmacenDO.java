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
 * @author Manuel Gayt&aacute;n.
 * 
 */
@Entity
@Table(name = "EstadoSolicitudAlmacen")
@NamedQueries({
	@NamedQuery(name = "EstadoSolicitudAlmacenDO.findAll", query = "select es from EstadoSolicitudAlmacenDO es ")})
public class EstadoSolicitudAlmacenDO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1258999436745740307L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "estado")
	private String etiqueta;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}
