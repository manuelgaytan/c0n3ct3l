package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ComentarioSolicitudVacaciones")
@NamedQueries({
	@NamedQuery(name = "ComentarioSolicitudVacacionesDO.findAll", query = "select rc from ComentarioSolicitudVacacionesDO rc")
	})
public class ComentarioSolicitudVacacionesDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_solicitud_vacaciones", nullable = false)
	private SolicitudVacacionesDO solicitudVacaciones;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_recursos_humanos")
	private ComentarioRecursosHumanosDO comentarioRecursosHumanos;

	public ComentarioSolicitudVacacionesDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioSolicitudVacacionesDO(Integer id,
			SolicitudVacacionesDO solicitudVacaciones,
			ComentarioRecursosHumanosDO comentarioRecursosHumanos) {
		super();
		this.id = id;
		this.solicitudVacaciones = solicitudVacaciones;
		this.comentarioRecursosHumanos = comentarioRecursosHumanos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SolicitudVacacionesDO getSolicitudVacaciones() {
		return solicitudVacaciones;
	}

	public void setSolicitudVacaciones(SolicitudVacacionesDO solicitudVacaciones) {
		this.solicitudVacaciones = solicitudVacaciones;
	}

	public ComentarioRecursosHumanosDO getComentarioRecursosHumanos() {
		return comentarioRecursosHumanos;
	}

	public void setComentarioRecursosHumanos(
			ComentarioRecursosHumanosDO comentarioRecursosHumanos) {
		this.comentarioRecursosHumanos = comentarioRecursosHumanos;
	}

}
