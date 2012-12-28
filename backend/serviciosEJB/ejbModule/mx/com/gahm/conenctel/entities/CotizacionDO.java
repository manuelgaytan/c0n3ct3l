package mx.com.gahm.conenctel.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Cotizacion")
public class CotizacionDO implements java.io.Serializable {

	
	private static final long serialVersionUID = -2040688573181488305L;
	private Integer id;
	private String descripcion;
	private String emisor;
	private Date fecha;
	private String nombreArchivo;

	
	public CotizacionDO() {
	}

	public CotizacionDO(String descripcion, String emisor, Date fecha,
			String nombreArchivo) {
		this.descripcion = descripcion;
		this.emisor = emisor;
		this.fecha = fecha;
		this.nombreArchivo = nombreArchivo;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "emisor", nullable = false)
	public String getEmisor() {
		return this.emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "nombre_archivo", nullable = false)
	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

}