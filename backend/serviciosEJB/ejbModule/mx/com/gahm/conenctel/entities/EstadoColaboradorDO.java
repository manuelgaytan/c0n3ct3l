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
	@NamedQuery(name = "EstadoColaboradorDO.findAll", query = "select c from EstadoColaboradorDO c") })
@Table(name="EstadoColaborador")
public class EstadoColaboradorDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9163912573056708055L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="estado")
	private String estado;

	public EstadoColaboradorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoColaboradorDO(Long id, String etiqueta) {
		super();
		this.id = id;
		this.estado = etiqueta;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the etiqueta
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEstado(String etiqueta) {
		this.estado = etiqueta;
	}
	
	

}
