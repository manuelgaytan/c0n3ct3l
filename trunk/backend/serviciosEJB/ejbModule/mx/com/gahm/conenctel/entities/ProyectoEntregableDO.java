package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla proyectoentregable.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="proyectoentregable")
public class ProyectoEntregableDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

	@JoinColumn(name="id_entregable")
	private EntregableDO entregable;

	public ProyectoEntregableDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public EntregableDO getEntregable() {
		return this.entregable;
	}

	public void setEntregable(EntregableDO entregable) {
		this.entregable = entregable;
	}

}