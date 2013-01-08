package mx.com.gahm.conenctel.model;

import java.io.Serializable;

public class DatosComerciales implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String condicionesComerciales;
	private String noVendedor;
	private String ejecutivoCuenta;
	
	public String getCondicionesComerciales() {
		return condicionesComerciales;
	}
	public void setCondicionesComerciales(String condicionesComerciales) {
		this.condicionesComerciales = condicionesComerciales;
	}
	public String getNoVendedor() {
		return noVendedor;
	}
	public void setNoVendedor(String noVendedor) {
		this.noVendedor = noVendedor;
	}
	public String getEjecutivoCuenta() {
		return ejecutivoCuenta;
	}
	public void setEjecutivoCuenta(String ejecutivoCuenta) {
		this.ejecutivoCuenta = ejecutivoCuenta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
