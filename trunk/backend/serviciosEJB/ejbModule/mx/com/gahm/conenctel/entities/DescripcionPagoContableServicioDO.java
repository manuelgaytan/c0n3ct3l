/**
 * 
 */
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

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "DescripcionPagoContableServicio")
@NamedQueries({
	@NamedQuery(name = "DescripcionPagoContableServicioDO.findAll", query = "select rc from DescripcionPagoContableServicioDO rc")
	})
public class DescripcionPagoContableServicioDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6611535983282760677L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "descripcion", nullable = false)
	private String descripcion;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_operacion", nullable = false)
	private TipoOperacionDO tipoOperacion;


	public DescripcionPagoContableServicioDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DescripcionPagoContableServicioDO(Integer id, String descripcion,
			TipoOperacionDO tipoOperacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.tipoOperacion = tipoOperacion;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return the tipoOperacion
	 */
	public TipoOperacionDO getTipoOperacion() {
		return tipoOperacion;
	}


	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(TipoOperacionDO tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	
	
}
