package mx.com.gahm.conenctel.entities;

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

@Entity
@Table(name = "ComentarioRecursosHumanos")
@NamedQueries({
	@NamedQuery(name = "ComentarioRecursosHumanosDO.findAll", query = "select rc from ComentarioRecursosHumanosDO rc")
	})
public class ComentarioRecursosHumanosDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fechaCaptura;
	
	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	private UsuarioDO usuario;
	
	@Column(name = "comentario")
	private String comentario;
	
	public ComentarioRecursosHumanosDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ComentarioRecursosHumanosDO(Integer id, Date fechaCaptura,
			UsuarioDO usuario, String comentario) {
		super();
		this.id = id;
		this.fechaCaptura = fechaCaptura;
		this.usuario = usuario;
		this.comentario = comentario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
