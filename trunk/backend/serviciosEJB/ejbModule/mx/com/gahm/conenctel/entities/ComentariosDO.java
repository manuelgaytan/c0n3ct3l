/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author SEVEN
 *
 */
@Entity
@Table(name="Comentarios")
@NamedQueries({
	@NamedQuery(name = "ComentariosDO.findAll", query = "select c from ComentariosDO c where c.almacen=:almacen and c.tipoAlmacen.id=:tipoAlmacen") })
public class ComentariosDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3281926057654672381L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_almacen", nullable = false)
	private TipoAlmacenDO tipoAlmacen;
	
	@Column(name = "almacen", nullable = false)
	private Long almacen;
	
	@Column(name = "comentario", nullable = false)
	private String comentario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_captura", nullable = false, length = 10)
	private Date fechaCaptura;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	private UsuarioDO usuario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoAlmacenDO getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacenDO tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	public Long getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Long almacen) {
		this.almacen = almacen;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechaCaptura() {
		return fechaCaptura;
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
	
	
	
	
	
}
