/**
 * 
 */
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ComentarioValidacionAdministrativaDO.findAll", query = "select c from ComentarioValidacionAdministrativaDO c") })
@Table(name="ComentarioValidacionAdministrativa")

public class ComentarioValidacionAdministrativaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2587673497929708993L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_captura")
	private Date fechaCaptura;
	
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private UsuarioDO usuario;
	
	@Column(name="comentario")
	private String comentario;

	public ComentarioValidacionAdministrativaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioValidacionAdministrativaDO(Long id, Date fechaCaptura,
			UsuarioDO usuario, String comentario) {
		super();
		this.id = id;
		this.fechaCaptura = fechaCaptura;
		this.usuario = usuario;
		this.comentario = comentario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
