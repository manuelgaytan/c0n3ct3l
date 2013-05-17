package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla requisicion.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="requisicion")
public class RequisicionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name="requisicion")
	private String requisicion;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

	
	
	
	
	public RequisicionDO(long id, String requisicion, ProyectoDO proyecto) {
		super();
		this.id = id;
		this.requisicion = requisicion;
		this.proyecto = proyecto;
	}

	public RequisicionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRequisicion() {
		return this.requisicion;
	}

	public void setRequisicion(String requisicion) {
		this.requisicion = requisicion;
	}

	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

}