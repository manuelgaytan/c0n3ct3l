package mx.com.gahm.conenctel.model;

import java.io.Serializable;

public class Requisicion implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String requisicion;
	private Proyecto proyecto;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRequisicion() {
		return requisicion;
	}
	public void setRequisicion(String requisicion) {
		this.requisicion = requisicion;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
