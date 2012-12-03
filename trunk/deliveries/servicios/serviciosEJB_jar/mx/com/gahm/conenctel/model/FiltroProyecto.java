package mx.com.gahm.conenctel.model;

import java.io.Serializable;

public class FiltroProyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long idConectel;
	private long idCategoria;
	private long idCliente;
	private String tipoProyecto;
	private String tecnologia;
	private String equipo;
	private String actividadRealizar;
	private String modelo;
	private String descripcionServicio;
	private String tipoServicio;	
	private Double costo;

	
	public long getIdConectel() {
		return idConectel;
	}
	public void setIdConectel(long idConectel) {
		this.idConectel = idConectel;
	}
	public long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipoProyecto() {
		return tipoProyecto;
	}
	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public String getActividadRealizar() {
		return actividadRealizar;
	}
	public void setActividadRealizar(String actividadRealizar) {
		this.actividadRealizar = actividadRealizar;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescripcionServicio() {
		return descripcionServicio;
	}
	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}
	public String getTipoServicio() {
		return tipoServicio;
	}
	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
	public Double getCosto() {
		return costo;
	}
	public void setCosto(Double costo) {
		this.costo = costo;
	}

}
