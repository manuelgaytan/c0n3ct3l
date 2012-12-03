package mx.com.gahm.conenctel.model;

import java.io.Serializable;
import java.util.Date;

public class Observacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Date fechaCaptura;
	private String requisicion;
	private Usuario usuario;
	private Proyecto proyecto;
	private Catalogo imputable;
	private Catalogo estado;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public String getRequisicion() {
		return requisicion;
	}
	public void setRequisicion(String requisicion) {
		this.requisicion = requisicion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Catalogo getImputable() {
		return imputable;
	}
	public void setImputable(Catalogo imputable) {
		this.imputable = imputable;
	}
	public Catalogo getEstado() {
		return estado;
	}
	public void setEstado(Catalogo estado) {
		this.estado = estado;
	}

}
