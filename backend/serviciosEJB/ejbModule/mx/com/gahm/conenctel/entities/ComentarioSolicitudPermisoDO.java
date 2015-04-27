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
@Table(name = "ComentarioSolicitudPermiso")
@NamedQueries({
	@NamedQuery(name = "ComentarioSolicitudPermisoDO.findAll", query = "select rc from ComentarioSolicitudPermisoDO rc")
	})
public class ComentarioSolicitudPermisoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_solicitud_permiso", nullable = false)
	private SolicitudPermisoDO solicitudPermiso;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_recursos_humanos")
	private ComentarioRecursosHumanosDO comentarioRecursosHumanos;
	
	
	public ComentarioSolicitudPermisoDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComentarioSolicitudPermisoDO(Integer id,
			SolicitudPermisoDO solicitudPermiso,
			ComentarioRecursosHumanosDO comentarioRecursosHumanos) {
		super();
		this.id = id;
		this.solicitudPermiso = solicitudPermiso;
		this.comentarioRecursosHumanos = comentarioRecursosHumanos;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SolicitudPermisoDO getSolicitudPermiso() {
		return solicitudPermiso;
	}
	public void setSolicitudPermiso(SolicitudPermisoDO solicitudPermiso) {
		this.solicitudPermiso = solicitudPermiso;
	}
	public ComentarioRecursosHumanosDO getComentarioRecursosHumanos() {
		return comentarioRecursosHumanos;
	}
	public void setComentarioRecursosHumanos(
			ComentarioRecursosHumanosDO comentarioRecursosHumanos) {
		this.comentarioRecursosHumanos = comentarioRecursosHumanos;
	} 
}
