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
 * @author Manuel Gaytan
 *
 */
@Entity
@Table(name = "EstadoNotificacion")
@NamedQueries({
	@NamedQuery(name = "EstadoNotificacionDO.findAll", query = "select rc from EstadoNotificacionDO rc")
	})
public class EstadoNotificacionDO implements Serializable{
	public static final long ID_PENDIENTE = 1L;
	public static final long ID_ATENDIDA = 2L;
	/**
	 * 
	 */
	private static final long serialVersionUID = -3335729679010880615L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="estado")
	private String estado;

	public EstadoNotificacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoNotificacionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.estado = etiqueta;
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
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the etiqueta to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
