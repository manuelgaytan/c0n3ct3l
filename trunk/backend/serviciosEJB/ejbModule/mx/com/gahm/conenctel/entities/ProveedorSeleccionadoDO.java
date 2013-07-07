/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author lespinosa
 * 
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "ProveedorSeleccionadoDO.findAll", query = "select p from ProveedorSeleccionadoDO p "),
		@NamedQuery(name = "ClienteDO.findByName", query = "select c from ClienteDO c where c.nombreComercial = :nombre") })
@Table(name = "proveedorseleccionado")
public class ProveedorSeleccionadoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_proveedor", nullable = false)
	private ProveedorDO proveedor;

	public ProveedorSeleccionadoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProveedorSeleccionadoDO(long id, ProveedorDO proveedor) {
		super();
		this.id = id;
		this.proveedor = proveedor;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the proveedor
	 */
	public ProveedorDO getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor
	 *            the proveedor to set
	 */
	public void setProveedor(ProveedorDO proveedor) {
		this.proveedor = proveedor;
	}

}
