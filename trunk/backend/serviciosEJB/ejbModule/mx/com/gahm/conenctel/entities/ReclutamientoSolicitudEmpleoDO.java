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
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "ReclutamientoSolicitudEmpleo")
public class ReclutamientoSolicitudEmpleoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3151207624640553362L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	public ReclutamientoSolicitudEmpleoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReclutamientoSolicitudEmpleoDO(Integer id) {
		super();
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
	
}
