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

@Entity
@Table(name = "ComentarioCuentasPagarFacturacionDO")
@NamedQueries({
	@NamedQuery(name = "ComentarioCuentasPagarFacturacionDO.findAll", query = "select rc from ComentarioCuentasPagarFacturacionDO rc")
	})
public class ComentarioCuentasPagarFacturacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4562888955468622133L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	private UsuarioDO usuario;
	
	@Column(name = "comentario", nullable = false)
	private String comentario;

	public ComentarioCuentasPagarFacturacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioCuentasPagarFacturacionDO(Integer id, Date fecha,
			UsuarioDO usuario, String comentario) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.usuario = usuario;
		this.comentario = comentario;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuario
	 */
	public UsuarioDO getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	
	
}
