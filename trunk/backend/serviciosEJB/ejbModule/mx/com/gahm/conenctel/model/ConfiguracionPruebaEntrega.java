package mx.com.gahm.conenctel.model;

import java.io.Serializable;
import java.util.Date;

public class ConfiguracionPruebaEntrega implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String alineacion;
	private String claveAceptacion;
	private String comisionado;
	private Date fechaEntrega;
	private String puertosEntregados;
	private String slotEntregado;
	private String tarjetasEntregadas;
	private Proyecto proyecto;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlineacion() {
		return alineacion;
	}
	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}
	public String getClaveAceptacion() {
		return claveAceptacion;
	}
	public void setClaveAceptacion(String claveAceptacion) {
		this.claveAceptacion = claveAceptacion;
	}
	public String getComisionado() {
		return comisionado;
	}
	public void setComisionado(String comisionado) {
		this.comisionado = comisionado;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getPuertosEntregados() {
		return puertosEntregados;
	}
	public void setPuertosEntregados(String puertosEntregados) {
		this.puertosEntregados = puertosEntregados;
	}
	public String getSlotEntregado() {
		return slotEntregado;
	}
	public void setSlotEntregado(String slotEntregado) {
		this.slotEntregado = slotEntregado;
	}
	public String getTarjetasEntregadas() {
		return tarjetasEntregadas;
	}
	public void setTarjetasEntregadas(String tarjetasEntregadas) {
		this.tarjetasEntregadas = tarjetasEntregadas;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

}
