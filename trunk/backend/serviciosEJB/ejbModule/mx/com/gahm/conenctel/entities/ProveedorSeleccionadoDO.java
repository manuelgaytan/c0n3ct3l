/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author lespinosa
 *
 */
@Cacheable(false)
@Entity
@NamedQueries({
	@NamedQuery(name = "ProveedorSeleccionadoDO.findAll", query = "select p from ProveedorDO p "),
	@NamedQuery(name = "ClienteDO.findByName", query = "select c from ClienteDO c where c.nombreComercial = :nombre")})
@Table(name="proveedorseleccionado")
@PrimaryKeyJoinColumn(name="fk_proveedor")
@DiscriminatorValue("1")
public class ProveedorSeleccionadoDO extends ProveedorDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	

}
