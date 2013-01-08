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
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla usuario.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "UsuarioDO.findAll", query = "select u from UsuarioDO u"),
		@NamedQuery(name = "UsuarioDO.findByName", query = "select u from UsuarioDO u where u.usuario = :usuario") })
@Table(name="usuario")
public class UsuarioDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private Boolean activo;

	private String contrasena;

	@Column(name="nombre_completo")
	private String nombreCompleto;

	private String usuario;

	@ManyToOne
	@JoinColumn(name="fk_perfil")
	private PerfilDO perfil;

	public UsuarioDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Boolean getActivo() {
		return this.activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public PerfilDO getPerfil() {
		return this.perfil;
	}

	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}

}