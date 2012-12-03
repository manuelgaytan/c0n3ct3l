package mx.com.gahm.conenctel.model;

import java.io.Serializable;

public class Colaborador implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String nombreCompleto;
	private long idTipoColaborador;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public long getIdTipoColaborador() {
		return idTipoColaborador;
	}
	public void setIdTipoColaborador(long idTipoColaborador) {
		this.idTipoColaborador = idTipoColaborador;
	}

}
