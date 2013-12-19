/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="DescripcionFondoFijoCajaChica")
@NamedQueries({
	@NamedQuery(name = "DescripcionFondoFijoCajaChicaDO.findAll", query = "select rc from DescripcionFondoFijoCajaChicaDO rc"),
	@NamedQuery(name = "DescripcionFondoFijoCajaChicaDO.getByTipoOperacion", query = "select c from DescripcionFondoFijoCajaChicaDO c where c.tipoOperacion.id=:idTipoOperacion")
	})
public class DescripcionFondoFijoCajaChicaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7718974143194841093L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="descripcion")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_operacion", nullable = false)
	private TipoOperacionDO tipoOperacion;

	public DescripcionFondoFijoCajaChicaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DescripcionFondoFijoCajaChicaDO(long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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

	public TipoOperacionDO getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(TipoOperacionDO tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	
	
}
