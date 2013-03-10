package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
@Entity
@Table(name = "ComentarioFacturaProveedor")
@NamedQueries({
	@NamedQuery(name = "ComentarioFacturaProveedorDO.findAll", query = "select rc from ComentarioFacturaProveedorDO rc")
	})
public class ComentarioFacturaProveedorDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 772474405596909928L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_factura_proveedor", nullable = false)
	private FacturaProveedorDO facturaProveedor;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_cuentas_pagar_facturacion", nullable = false)
	private ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion;

	
	
	
	
	public ComentarioFacturaProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioFacturaProveedorDO(
			Integer id,
			FacturaProveedorDO facturaProveedor,
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion) {
		super();
		this.id = id;
		this.facturaProveedor = facturaProveedor;
		this.comentarioCuentasPagarFacturacion = comentarioCuentasPagarFacturacion;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the facturaProveedor
	 */
	public FacturaProveedorDO getFacturaProveedor() {
		return facturaProveedor;
	}

	/**
	 * @param facturaProveedor the facturaProveedor to set
	 */
	public void setFacturaProveedor(FacturaProveedorDO facturaProveedor) {
		this.facturaProveedor = facturaProveedor;
	}

	/**
	 * @return the comentarioCuentasPagarFacturacion
	 */
	public ComentarioCuentasPagarFacturacionDO getComentarioCuentasPagarFacturacion() {
		return comentarioCuentasPagarFacturacion;
	}

	/**
	 * @param comentarioCuentasPagarFacturacion the comentarioCuentasPagarFacturacion to set
	 */
	public void setComentarioCuentasPagarFacturacion(
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion) {
		this.comentarioCuentasPagarFacturacion = comentarioCuentasPagarFacturacion;
	}
	
	
}
