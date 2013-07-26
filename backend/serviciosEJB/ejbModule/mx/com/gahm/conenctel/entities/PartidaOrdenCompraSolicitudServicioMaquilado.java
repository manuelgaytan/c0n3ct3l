package mx.com.gahm.conenctel.entities;

public class PartidaOrdenCompraSolicitudServicioMaquilado implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer partida;
	private Double cantidad;
	private String unidad;
	private String descripcion;
	private Double costo;
	private Double importe;

	public PartidaOrdenCompraSolicitudServicioMaquilado() {
	}

	public PartidaOrdenCompraSolicitudServicioMaquilado(Integer partida, Double cantidad, 
			String unidad, String descripcion, Double costo, Double importe ) {
		this.partida = partida;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.descripcion = descripcion;
		this.costo = costo;
		this.importe = importe;
	}

	public Integer getPartida() {
		return partida;
	}

	public void setPartida(Integer partida) {
		this.partida = partida;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	
}