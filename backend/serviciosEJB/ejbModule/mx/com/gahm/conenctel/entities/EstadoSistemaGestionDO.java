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
@Table(name = "EstadoSistemaGestion")
@NamedQueries({
	@NamedQuery(name = "EstadoSistemaGestionDO.findAll", query = "select p from EstadoSistemaGestionDO p ")})
public class EstadoSistemaGestionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1138155744378825541L;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="estado")
	private String estado;

	public EstadoSistemaGestionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoSistemaGestionDO(long id, String estado) {
		super();
		this.id = id;
		this.estado = estado;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	

}
