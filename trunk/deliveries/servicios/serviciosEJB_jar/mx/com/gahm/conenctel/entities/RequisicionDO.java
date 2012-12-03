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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String requisicion;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

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