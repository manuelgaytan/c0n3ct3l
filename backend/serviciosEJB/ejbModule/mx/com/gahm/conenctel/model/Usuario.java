package mx.com.gahm.conenctel.model;

import java.io.Serializable;
import java.util.List;

public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String usuario;
	private String contrasena;
	private String nombreCompleto;
	private Boolean activo;
		
	private List<Long> idsPantallas;
	private Catalogo perfil;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public List<Long> getIdsPantallas() {
		return idsPantallas;
	}
	public void setIdsPantallas(List<Long> idsPantallas) {
		this.idsPantallas = idsPantallas;
	}
	public Catalogo getPerfil() {
		return perfil;
	}
	public void setPerfil(Catalogo perfil) {
		this.perfil = perfil;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
