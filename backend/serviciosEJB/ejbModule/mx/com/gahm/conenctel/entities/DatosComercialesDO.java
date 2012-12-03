package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla datoscomerciales.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="datoscomerciales")
public class DatosComercialesDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="condiciones_comerciales")
	private String condicionesComerciales;

	@Column(name="ejecutivo_cuenta")
	private String ejecutivoCuenta;

	@Column(name="no_vendor")
	private String noVendedor;

	public DatosComercialesDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCondicionesComerciales() {
		return this.condicionesComerciales;
	}

	public void setCondicionesComerciales(String condicionesComerciales) {
		this.condicionesComerciales = condicionesComerciales;
	}

	public String getEjecutivoCuenta() {
		return this.ejecutivoCuenta;
	}

	public void setEjecutivoCuenta(String ejecutivoCuenta) {
		this.ejecutivoCuenta = ejecutivoCuenta;
	}

	public String getNoVendedor() {
		return this.noVendedor;
	}

	public void setNoVendedor(String noVendedor) {
		this.noVendedor = noVendedor;
	}

}