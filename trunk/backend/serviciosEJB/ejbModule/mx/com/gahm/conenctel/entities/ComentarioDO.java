package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * Clase de persistencia para la tabla comentarios.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="comentarios")
public class ComentarioDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String comentario;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_captura")
	private Date fechaCaptura;

	// TODO
	@Column(name="fk_usuario")
	private Long fkUsuario;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO fkTipoalmacen;

	@ManyToOne
	@JoinColumn(name="fk_almacen")
	private HerramientaDO fkAlmacen;

	public ComentarioDO() {
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

	public Long getFkUsuario() {
		return this.fkUsuario;
	}

	public void setFkUsuario(Long fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public TipoAlmacenDO getFkTipoalmacen() {
		return this.fkTipoalmacen;
	}

	public void setFkTipoalmacen(TipoAlmacenDO fkTipoalmacen) {
		this.fkTipoalmacen = fkTipoalmacen;
	}

	public HerramientaDO getFkAlmacen() {
		return fkAlmacen;
	}

	public void setFkAlmacen(HerramientaDO fkAlmacen) {
		this.fkAlmacen = fkAlmacen;
	}


}