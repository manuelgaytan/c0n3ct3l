package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * Clase de persistencia para la tabla datosgeneralesproyecto.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "DatosGrlsProyectoDO.findAll", query = "select d from DatosGrlsProyectoDO d where d.proyecto.estado.id=1"),
	@NamedQuery(name = "DatosGrlsProyectoDO.findAllAll", query = "select d from DatosGrlsProyectoDO d"),
	@NamedQuery(name = "DatosGrlsProyectoDO.getByIdProyecto", query = "select d from DatosGrlsProyectoDO d where d.proyecto.id=:idProyecto") })
@Table(name="datosgeneralesproyecto")
public class DatosGrlsProyectoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name="area_goa")
	private String areaGoa;

	@Column(name="cliente_final")
	private String clienteFinal;

	@Column(name="cliente_id")
	private String clienteId;

	@Column(name="division_region")
	private String divisionRegion;

	@Column(name="elemento_pep")
	private String elementoPep;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="fecha_asignacion_cliente")
	private Date fechaAsignacionCliente;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="fecha_inicio_programada")
	private Date fechaInicioProgramada;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="fecha_inicio_real")
	private Date fechaInicioReal;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="fecha_termino_programada")
	private Date fechaTerminoProgramada;

	@Temporal(javax.persistence.TemporalType.DATE)
	@Column(name="fecha_termino_real")
	private Date fechaTerminoReal;

	private String grafo;

	@JoinColumn(name="id_equipo")
	private AplicaDO equipo;

	@JoinColumn(name="id_herramienta")
	private AplicaDO herramienta;

	@JoinColumn(name="id_unidad")
	private AplicaDO unidad;

	@JoinColumn(name="id_viaticos")
	private AplicaDO viaticos;

	@Column(name="nodo_id")
	private String nodoId;

	@Column(name="pedido_cliente")
	private String pedidoCliente;

	@Column(name="responsable_cliente")
	private String responsableCliente;

	private String semana;

	@Column(name="site_survey")
	private String siteSurvey;

	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

	@JoinColumn(name="id_responsable_conectel")
	private ColaboradorDO reponsableConectel;

	@JoinColumn(name="id_material")
	private AplicaDO material;

	@OneToMany(mappedBy="datosgeneralesproyecto", fetch = FetchType.EAGER)
	private List<DatosGrlsProyectoImplDO> datosGrlsProyectoImplList;
/*
	@ManyToOne
	@JoinColumn(name="fk_tipo_empleado")
	private TipoEmpleadoDO tipoEmpleado;
*/
	
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAreaGoa() {
		return this.areaGoa;
	}

	public void setAreaGoa(String areaGoa) {
		this.areaGoa = areaGoa;
	}

	public String getClienteFinal() {
		return this.clienteFinal;
	}

	public void setClienteFinal(String clienteFinal) {
		this.clienteFinal = clienteFinal;
	}

	public String getClienteId() {
		return this.clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getDivisionRegion() {
		return this.divisionRegion;
	}

	public void setDivisionRegion(String divisionRegion) {
		this.divisionRegion = divisionRegion;
	}

	public String getElementoPep() {
		return this.elementoPep;
	}

	public void setElementoPep(String elementoPep) {
		this.elementoPep = elementoPep;
	}

	public Date getFechaAsignacionCliente() {
		return this.fechaAsignacionCliente;
	}

	public void setFechaAsignacionCliente(Date fechaAsignacionCliente) {
		this.fechaAsignacionCliente = fechaAsignacionCliente;
	}

	public Date getFechaInicioProgramada() {
		return this.fechaInicioProgramada;
	}

	public void setFechaInicioProgramada(Date fechaInicioProgramada) {
		this.fechaInicioProgramada = fechaInicioProgramada;
	}

	public Date getFechaInicioReal() {
		return this.fechaInicioReal;
	}

	public void setFechaInicioReal(Date fechaInicioReal) {
		this.fechaInicioReal = fechaInicioReal;
	}

	public Date getFechaTerminoProgramada() {
		return this.fechaTerminoProgramada;
	}

	public void setFechaTerminoProgramada(Date fechaTerminoProgramada) {
		this.fechaTerminoProgramada = fechaTerminoProgramada;
	}

	public Date getFechaTerminoReal() {
		return this.fechaTerminoReal;
	}

	public void setFechaTerminoReal(Date fechaTerminoReal) {
		this.fechaTerminoReal = fechaTerminoReal;
	}

	public String getGrafo() {
		return this.grafo;
	}

	public void setGrafo(String grafo) {
		this.grafo = grafo;
	}

	public AplicaDO getEquipo() {
		return equipo;
	}

	public void setEquipo(AplicaDO equipo) {
		this.equipo = equipo;
	}

	public AplicaDO getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(AplicaDO herramienta) {
		this.herramienta = herramienta;
	}

	public AplicaDO getUnidad() {
		return unidad;
	}

	public void setUnidad(AplicaDO unidad) {
		this.unidad = unidad;
	}

	public AplicaDO getViaticos() {
		return viaticos;
	}

	public void setViaticos(AplicaDO viaticos) {
		this.viaticos = viaticos;
	}

	public String getNodoId() {
		return this.nodoId;
	}

	public void setNodoId(String nodoId) {
		this.nodoId = nodoId;
	}

	public String getPedidoCliente() {
		return this.pedidoCliente;
	}

	public void setPedidoCliente(String pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}

	public String getResponsableCliente() {
		return this.responsableCliente;
	}

	public void setResponsableCliente(String responsableCliente) {
		this.responsableCliente = responsableCliente;
	}

	public String getSemana() {
		return this.semana;
	}

	public void setSemana(String semana) {
		this.semana = semana;
	}

	public String getSiteSurvey() {
		return this.siteSurvey;
	}

	public void setSiteSurvey(String siteSurvey) {
		this.siteSurvey = siteSurvey;
	}

	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public ColaboradorDO getReponsableConectel() {
		return reponsableConectel;
	}

	public void setReponsableConectel(ColaboradorDO reponsableConectel) {
		this.reponsableConectel = reponsableConectel;
	}

	public AplicaDO getMaterial() {
		return material;
	}

	public void setMaterial(AplicaDO material) {
		this.material = material;
	}

	public List<DatosGrlsProyectoImplDO> getDatosGrlsProyectoImplList() {
		return datosGrlsProyectoImplList;
	}

	public void setDatosGrlsProyectoImplList(
			List<DatosGrlsProyectoImplDO> datosGrlsProyectoImplList) {
		this.datosGrlsProyectoImplList = datosGrlsProyectoImplList;
	}

}