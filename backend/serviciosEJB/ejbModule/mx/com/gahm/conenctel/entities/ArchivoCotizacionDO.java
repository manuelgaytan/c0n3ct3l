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
 * @author SEVEN
 *
 */
@Entity
@Table(name = "ArchivoCotizacion")
@NamedQueries({
	@NamedQuery(name = "ArchivoCotizacionDO.findAll", query = "select c from ArchivoCotizacionDO c")})
public class ArchivoCotizacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 996278680931600030L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_cotizacion", nullable = false)
	private CotizacionDO cotizacion;
	
	@Column(name = "nombre_archivo", nullable = false)
	private String nombreArchivo;

	public ArchivoCotizacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArchivoCotizacionDO(Integer id, CotizacionDO cotizacion, String nombreArchivo) {
		super();
		this.id = id;
		this.cotizacion = cotizacion;
		this.setNombreArchivo(nombreArchivo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CotizacionDO getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(CotizacionDO cotizacion) {
		this.cotizacion = cotizacion;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
}
