package mx.com.gahm.conenctel.entities;


import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Cotizacion")
@NamedQueries({
	@NamedQuery(name = "CotizacionDO.findAll", query = "select c from CotizacionDO c"),
	@NamedQuery(name = "CotizacionDO.findById", 
				query = "select c from CotizacionDO c where c.id = :id")})
public class CotizacionDO implements java.io.Serializable {

	
	private static final long serialVersionUID = -2040688573181488305L;
	private Integer id;
	private String descripcion;
	private String emisor;
	private Date fecha;
	private List<ComentarioCotizacionDO> comentariosCotizacion;
	private List<ArchivoCotizacionDO> archivosCotizacion;
	
	public CotizacionDO() {
	}

	public CotizacionDO(String descripcion, String emisor, Date fecha,
			String nombreArchivo) {
		this.descripcion = descripcion;
		this.emisor = emisor;
		this.fecha = fecha;
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

	@OneToMany(mappedBy="cotizacion", fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)	
	public List<ComentarioCotizacionDO> getComentariosCotizacion() {
		return comentariosCotizacion;
	}

	public void setComentariosCotizacion(
			List<ComentarioCotizacionDO> comentariosCotizacion) {
		this.comentariosCotizacion = comentariosCotizacion;
	}

	@OneToMany(mappedBy="cotizacion", fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	public List<ArchivoCotizacionDO> getArchivosCotizacion() {
		return archivosCotizacion;
	}

	public void setArchivosCotizacion(List<ArchivoCotizacionDO> archivosCotizacion) {
		this.archivosCotizacion = archivosCotizacion;
	}

}