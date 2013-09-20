package mx.com.gahm.conenctel.model;

import java.io.Serializable;

public class ItemEstatusProyecto implements Serializable{
	private long id;
	private String tipo;
	private long cantidad;
	
	public ItemEstatusProyecto(Long id, String tipo, Long cantidad) {
		super();
		this.id = id.longValue();
		this.tipo = tipo;
		this.cantidad = cantidad.longValue();
	}
	
	public ItemEstatusProyecto(long id, String tipo, String cantidad) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.cantidad = Long.parseLong( cantidad );
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
