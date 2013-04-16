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
 * @author SEVEN
 *
 */
@Entity
@Table(name = "EstadoAccionPreventivaCorrectiva")
@NamedQueries({ @NamedQuery(name = "EstadoAccionPreventivaCorrectivaDO.findAll", query = "select rc from EstadoAccionPreventivaCorrectivaDO rc") })
public class EstadoAccionPreventivaCorrectivaDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4577814490120234161L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "estado")
	private String estado;

	public EstadoAccionPreventivaCorrectivaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoAccionPreventivaCorrectivaDO(Long id, String etiqueta) {
		super();
		this.id = id;
		this.estado = etiqueta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String etiqueta) {
		this.estado = etiqueta;
	}
	
	

}
