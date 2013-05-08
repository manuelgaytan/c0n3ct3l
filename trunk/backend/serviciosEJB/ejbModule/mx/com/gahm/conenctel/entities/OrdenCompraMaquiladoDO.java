package mx.com.gahm.conenctel.entities;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "OrdenCompraMaquilado")
@NamedQueries({
	@NamedQuery(name = "OrdenCompraMaquiladoDO.findAll", query = "select oc from OrdenCompraMaquiladoDO oc"),
	@NamedQuery(name = "OrdenCompraMaquiladoDO.findById", 
				query = "select oc from OrdenCompraMaquiladoDO oc where oc.id = :id")})
public class OrdenCompraMaquiladoDO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -2659817735727555176L;
	private Integer id;
	private SolicitudServicioMaquiladoDO solicitudServicioMaquilado;
	private Date fecha;
	private ProveedorMaquiladorDO proveedorMaquilador;
	private String claveValidacion;
	private String leyenda;
	
	public OrdenCompraMaquiladoDO() {
	}

	public OrdenCompraMaquiladoDO(SolicitudServicioMaquiladoDO solicitudServicioMaquilado,
			Date fecha, ProveedorMaquiladorDO proveedorMaquilador) {
		this.solicitudServicioMaquilado = solicitudServicioMaquilado;
		this.fecha = fecha;
		this.proveedorMaquilador = proveedorMaquilador;
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

	@ManyToOne
   	@JoinColumn(name="fk_solicitud_servicio_maquilado", nullable = false)
	public SolicitudServicioMaquiladoDO getSolicitudServicioMaquilado() {
		return this.solicitudServicioMaquilado;
	}

	public void setSolicitudServicioMaquilado(
			SolicitudServicioMaquiladoDO solicitudServicioMaquilado) {
		this.solicitudServicioMaquilado = solicitudServicioMaquilado;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@ManyToOne
   	@JoinColumn(name="fk_proveedor_maquilador", nullable = false)
	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return this.proveedorMaquilador;
	}

	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
	}

	@Column(name="clave_validacion")
	public String getClaveValidacion() {
		return claveValidacion;
	}

	public void setClaveValidacion(String claveValidacion) {
		this.claveValidacion = claveValidacion;
	}

	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}

}