package mx.com.gahm.conenctel.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Proyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private Catalogo categoria;
	private Producto producto;
	private String centralSitio;
	private Catalogo estado;
	private Date fechaCaptura;
	private List<Requisicion> requisiciones;
	private List<Observacion> observaciones;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Catalogo getCategoria() {
		return categoria;
	}
	public void setCategoria(Catalogo categoria) {
		this.categoria = categoria;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public String getCentralSitio() {
		return centralSitio;
	}
	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}
	public Catalogo getEstado() {
		return estado;
	}
	public void setEstado(Catalogo estado) {
		this.estado = estado;
	}
	public Date getFechaCaptura() {
		return fechaCaptura;
	}
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	public List<Requisicion> getRequisiciones() {
		return requisiciones;
	}
	public void setRequisiciones(List<Requisicion> requisiciones) {
		this.requisiciones = requisiciones;
	}
	public List<Observacion> getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(List<Observacion> observaciones) {
		this.observaciones = observaciones;
	}

}
