package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


/**
 * Clase de persistencia para la tabla observacion.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="observacion")
public class ObservacionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="fecha_captura")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaCaptura;

	private String requisicion;

	@JoinColumn(name="usuario")
	private UsuarioDO usuario;

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

	@ManyToOne
	@JoinColumn(name="id_imputable")
	private ImputableDO imputable;

	@JoinColumn(name="id_estado_proyecto")
	private EstadoDO estado;

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFechaCaptura() {
		return this.fechaCaptura;
	}

	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public String getRequisicion() {
		return this.requisicion;
	}

	public void setRequisicion(String requisicion) {
		this.requisicion = requisicion;
	}

	public UsuarioDO getUsuario() {
		return this.usuario;
	}

	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}

	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public ImputableDO getImputable() {
		return this.imputable;
	}

	public void setImputable(ImputableDO imputable) {
		this.imputable = imputable;
	}

	public EstadoDO getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoDO estado) {
		this.estado = estado;
	}

}