/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author SEVEN
 *
 */
@Entity
@Table(name = "DatosGeneralesProyecto")
@NamedQueries({
	@NamedQuery(name = "DatosGeneralesProyectoDO.findAll", query = "select rc from DatosGeneralesProyectoDO rc")
	})
public class DatosGeneralesProyectoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6891312105084373883L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "id_proyecto", nullable = false)
	private ProyectoDO proyecto;
	
	@Column(name = "division_region", nullable = false)
	private String divisionRegion;
	
	@Column(name = "area_goa", nullable = false)
	private String areaGoa;
	
	@Column(name = "cliente_final", nullable = false)
	private String clienteFinal;
	
	@Column(name = "cliente_id", nullable = false)
	private String clienteId;
	
	@Column(name = "nodo_id", nullable = false)
	private String nodoId;
	
	@Column(name = "grafo", nullable = false)
	private String grafo;
	
	@Column(name = "pedido_cliente", nullable = false)
	private String pedidoCliente;
	
	@Column(name = "elemento_pep", nullable = false)
	private String elementoPep;
	
	@Column(name = "responsable_cliente", nullable = false)
	private String responsableCliente;
	
	@Column(name = "semana", nullable = false)
	private String semana;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_asignacion_cliente", nullable = false, length = 10)
	private Date fechaAsignacionCliente;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_programada", nullable = false, length = 10)
	private Date fechaInicioProgramada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino_programada", nullable = false, length = 10)
	private Date fechaTerminoProgramada;
	
	@ManyToOne
	@JoinColumn(name = "id_responsable_conectel", nullable = false)
	private ColaboradorDO responsableConectel;
	
	@ManyToOne
	@JoinColumn(name = "id_responsable_implementacion", nullable = false)
	private ColaboradorDO responsableImplementacion;
	
	@Column(name = "id_material", nullable = false)
	private Integer idMaterial;
	
	@Column(name = "id_herramienta", nullable = false)
	private Integer idHerramienta;
	
	@Column(name = "id_equipo", nullable = false)
	private String idEquipo;
	
	@Column(name = "id_unidad", nullable = false)
	private String idUnidad;
	
	@Column(name = "id_viaticos", nullable = false)
	private String idViaticos;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_real", nullable = false, length = 10)
	private Date fechaInicioReal;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino_real", nullable = false, length = 10)
	private Date fechaTerminoReal;
	
	@Column(name = "site_survey", nullable = false)
	private String siteSurvey;

	public DatosGeneralesProyectoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosGeneralesProyectoDO(Integer id, ProyectoDO proyecto,
			String divisionRegion, String areaGoa, String clienteFinal,
			String clienteId, String nodoId, String grafo,
			String pedidoCliente, String elementoPep,
			String responsableCliente, String semana,
			Date fechaAsignacionCliente, Date fechaInicioProgramada,
			Date fechaTerminoProgramada, ColaboradorDO responsableConectel,
			ColaboradorDO responsableImplementacion, Integer idMaterial,
			Integer idHerramienta, String idEquipo, String idUnidad,
			String idViaticos, Date fechaInicioReal, Date fechaTerminoReal,
			String siteSurvey) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.divisionRegion = divisionRegion;
		this.areaGoa = areaGoa;
		this.clienteFinal = clienteFinal;
		this.clienteId = clienteId;
		this.nodoId = nodoId;
		this.grafo = grafo;
		this.pedidoCliente = pedidoCliente;
		this.elementoPep = elementoPep;
		this.responsableCliente = responsableCliente;
		this.semana = semana;
		this.fechaAsignacionCliente = fechaAsignacionCliente;
		this.fechaInicioProgramada = fechaInicioProgramada;
		this.fechaTerminoProgramada = fechaTerminoProgramada;
		this.responsableConectel = responsableConectel;
		this.responsableImplementacion = responsableImplementacion;
		this.idMaterial = idMaterial;
		this.idHerramienta = idHerramienta;
		this.idEquipo = idEquipo;
		this.idUnidad = idUnidad;
		this.idViaticos = idViaticos;
		this.fechaInicioReal = fechaInicioReal;
		this.fechaTerminoReal = fechaTerminoReal;
		this.siteSurvey = siteSurvey;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProyectoDO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public String getDivisionRegion() {
		return divisionRegion;
	}

	public void setDivisionRegion(String divisionRegion) {
		this.divisionRegion = divisionRegion;
	}

	public String getAreaGoa() {
		return areaGoa;
	}

	public void setAreaGoa(String areaGoa) {
		this.areaGoa = areaGoa;
	}

	public String getClienteFinal() {
		return clienteFinal;
	}

	public void setClienteFinal(String clienteFinal) {
		this.clienteFinal = clienteFinal;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getNodoId() {
		return nodoId;
	}

	public void setNodoId(String nodoId) {
		this.nodoId = nodoId;
	}

	public String getGrafo() {
		return grafo;
	}

	public void setGrafo(String grafo) {
		this.grafo = grafo;
	}

	public String getPedidoCliente() {
		return pedidoCliente;
	}

	public void setPedidoCliente(String pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public String getElementoPep() {
		return elementoPep;
	}

	public void setElementoPep(String elementoPep) {
		this.elementoPep = elementoPep;
	}

	public String getResponsableCliente() {
		return responsableCliente;
	}

	public void setResponsableCliente(String responsableCliente) {
		this.responsableCliente = responsableCliente;
	}

	public String getSemana() {
		return semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public Date getFechaAsignacionCliente() {
		return fechaAsignacionCliente;
	}

	public void setFechaAsignacionCliente(Date fechaAsignacionCliente) {
		this.fechaAsignacionCliente = fechaAsignacionCliente;
	}

	public Date getFechaInicioProgramada() {
		return fechaInicioProgramada;
	}

	public void setFechaInicioProgramada(Date fechaInicioProgramada) {
		this.fechaInicioProgramada = fechaInicioProgramada;
	}

	public Date getFechaTerminoProgramada() {
		return fechaTerminoProgramada;
	}

	public void setFechaTerminoProgramada(Date fechaTerminoProgramada) {
		this.fechaTerminoProgramada = fechaTerminoProgramada;
	}

	public ColaboradorDO getResponsableConectel() {
		return responsableConectel;
	}

	public void setResponsableConectel(ColaboradorDO responsableConectel) {
		this.responsableConectel = responsableConectel;
	}

	public ColaboradorDO getResponsableImplementacion() {
		return responsableImplementacion;
	}

	public void setResponsableImplementacion(ColaboradorDO responsableImplementacion) {
		this.responsableImplementacion = responsableImplementacion;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Integer getIdHerramienta() {
		return idHerramienta;
	}

	public void setIdHerramienta(Integer idHerramienta) {
		this.idHerramienta = idHerramienta;
	}

	public String getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(String idEquipo) {
		this.idEquipo = idEquipo;
	}

	public String getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getIdViaticos() {
		return idViaticos;
	}

	public void setIdViaticos(String idViaticos) {
		this.idViaticos = idViaticos;
	}

	public Date getFechaInicioReal() {
		return fechaInicioReal;
	}

	public void setFechaInicioReal(Date fechaInicioReal) {
		this.fechaInicioReal = fechaInicioReal;
	}

	public Date getFechaTerminoReal() {
		return fechaTerminoReal;
	}

	public void setFechaTerminoReal(Date fechaTerminoReal) {
		this.fechaTerminoReal = fechaTerminoReal;
	}

	public String getSiteSurvey() {
		return siteSurvey;
	}

	public void setSiteSurvey(String siteSurvey) {
		this.siteSurvey = siteSurvey;
	}
	
	
	
}
