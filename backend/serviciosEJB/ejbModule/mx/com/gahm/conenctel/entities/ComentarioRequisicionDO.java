package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Clase de persistencia para la tabla comentarioherramienta.
 * 
 * @author Manuel Gayt&aacute;n
 */
@Entity
@Table(name="comentarioherramienta")
public class ComentarioRequisicionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_captura")
	private Date fechaCaptura;

	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private UsuarioDO usuario;

	@ManyToOne
	@JoinColumn(name="fk_herramienta")
	private HerramientaDO herramienta;

	public ComentarioRequisicionDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaCaptura() {
		return this.fechaCaptura;
	}

	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public UsuarioDO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}

	public HerramientaDO getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(HerramientaDO herramienta) {
		this.herramienta = herramienta;
	}
}