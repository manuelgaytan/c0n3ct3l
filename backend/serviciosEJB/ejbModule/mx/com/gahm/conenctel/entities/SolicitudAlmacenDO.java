package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Clase de persistencia para la tabla solicitudalmacen.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "SolicitudAlmacenDO.findAll", query = "select s from SolicitudAlmacenDO s") })
@Table(name="solicitudalmacen")
public class SolicitudAlmacenDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private UsuarioDO usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;
	
	@Column(name="motivo")
	private String motivo;
	
	@ManyToOne
	@JoinColumn(name="fk_prioridad")
	private PrioridadDO prioridad;
	
	@ManyToOne
	@JoinColumn(name="fk_area_solicitante")
	private AreaSolicitanteDO areaSolicitante;
	
	@Column(name="central_sitio")
	private String centralSitio;
	
	@ManyToOne
	@JoinColumn(name="fk_estado_solicitud_almacen")
	private EstadoSolicitudAlmacenDO estadoSolicitudAlmacen;
	
	@Column(name="nombre_solicitante")
	private String nombreSolicitante;
	
	@ManyToOne
	@JoinColumn(name="fk_autoriza")
	private ColaboradorDO autoriza;
	
	@ManyToOne
	@JoinColumn(name="fk_autoriza_final")
	private ColaboradorDO autorizaFinal;

	@ManyToOne
	@JoinColumn(name="fk_entrega")
	private ColaboradorDO entrega;
	
	@Column(name="recibe")
	private String recibe;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<HerramientaSolicitudAlmacenDO> herramientasSolicitudAlmacen;

	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<HardwareSolicitudAlmacenDO> hardwareSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<SoftwareSolicitudAlmacenDO> softwareSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<ConsumibleSolicitudAlmacenDO> consumiblesSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<TelefoniaMovilSolicitudAlmacenDO> telefoniaMovilSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<MaterialSolicitudAlmacenDO> materialesSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<EquipoTransporteSolicitudAlmacenDO> equipoTransporteSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<EquipoMedicionSolicitudAlmacenDO> equipoMedicionSolicitudAlmacen;
	
	
	public SolicitudAlmacenDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudAlmacenDO(Long id, UsuarioDO usuario, Date fechaSolicitud,
			String motivo, PrioridadDO prioridad,
			AreaSolicitanteDO areaSolicitante, String centralSitio,
			EstadoSolicitudAlmacenDO estadoSolicitudAlmacen,
			String nombreSolicitante, ColaboradorDO autoriza,
			ColaboradorDO entrega, String recibe) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.estadoSolicitudAlmacen = estadoSolicitudAlmacen;
		this.nombreSolicitante = nombreSolicitante;
		this.autoriza = autoriza;
		this.entrega = entrega;
		this.recibe = recibe;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public PrioridadDO getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadDO prioridad) {
		this.prioridad = prioridad;
	}

	public AreaSolicitanteDO getAreaSolicitante() {
		return areaSolicitante;
	}

	public void setAreaSolicitante(AreaSolicitanteDO areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}

	public String getCentralSitio() {
		return centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public EstadoSolicitudAlmacenDO getEstadoSolicitudAlmacen() {
		return estadoSolicitudAlmacen;
	}

	public void setEstadoSolicitudAlmacen(
			EstadoSolicitudAlmacenDO estadoSolicitudAlmacen) {
		this.estadoSolicitudAlmacen = estadoSolicitudAlmacen;
	}

	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public ColaboradorDO getAutoriza() {
		return autoriza;
	}

	public void setAutoriza(ColaboradorDO autoriza) {
		this.autoriza = autoriza;
	}

	public ColaboradorDO getEntrega() {
		return entrega;
	}

	public void setEntrega(ColaboradorDO entrega) {
		this.entrega = entrega;
	}

	public String getRecibe() {
		return recibe;
	}

	public void setRecibe(String recibe) {
		this.recibe = recibe;
	}

	public List<HerramientaSolicitudAlmacenDO> getHerramientasSolicitudAlmacen() {
		return herramientasSolicitudAlmacen;
	}

	public void setHerramientasSolicitudAlmacen(
			List<HerramientaSolicitudAlmacenDO> herramientasSolicitudAlmacen) {
		this.herramientasSolicitudAlmacen = herramientasSolicitudAlmacen;
	}

	public List<HardwareSolicitudAlmacenDO> getHardwareSolicitudAlmacen() {
		return hardwareSolicitudAlmacen;
	}

	public void setHardwareSolicitudAlmacen(
			List<HardwareSolicitudAlmacenDO> hardwareSolicitudAlmacen) {
		this.hardwareSolicitudAlmacen = hardwareSolicitudAlmacen;
	}

	public List<SoftwareSolicitudAlmacenDO> getSoftwareSolicitudAlmacen() {
		return softwareSolicitudAlmacen;
	}

	public void setSoftwareSolicitudAlmacen(
			List<SoftwareSolicitudAlmacenDO> softwareSolicitudAlmacen) {
		this.softwareSolicitudAlmacen = softwareSolicitudAlmacen;
	}

	public List<ConsumibleSolicitudAlmacenDO> getConsumiblesSolicitudAlmacen() {
		return consumiblesSolicitudAlmacen;
	}

	public void setConsumiblesSolicitudAlmacen(
			List<ConsumibleSolicitudAlmacenDO> consumiblesSolicitudAlmacen) {
		this.consumiblesSolicitudAlmacen = consumiblesSolicitudAlmacen;
	}

	public List<TelefoniaMovilSolicitudAlmacenDO> getTelefoniaMovilSolicitudAlmacen() {
		return telefoniaMovilSolicitudAlmacen;
	}

	public void setTelefoniaMovilSolicitudAlmacen(
			List<TelefoniaMovilSolicitudAlmacenDO> telefoniaMovilSolicitudAlmacen) {
		this.telefoniaMovilSolicitudAlmacen = telefoniaMovilSolicitudAlmacen;
	}

	public List<MaterialSolicitudAlmacenDO> getMaterialesSolicitudAlmacen() {
		return materialesSolicitudAlmacen;
	}

	public void setMaterialesSolicitudAlmacen(
			List<MaterialSolicitudAlmacenDO> materialesSolicitudAlmacen) {
		this.materialesSolicitudAlmacen = materialesSolicitudAlmacen;
	}

	public List<EquipoTransporteSolicitudAlmacenDO> getEquipoTransporteSolicitudAlmacen() {
		return equipoTransporteSolicitudAlmacen;
	}

	public void setEquipoTransporteSolicitudAlmacen(
			List<EquipoTransporteSolicitudAlmacenDO> equipoTransporteSolicitudAlmacen) {
		this.equipoTransporteSolicitudAlmacen = equipoTransporteSolicitudAlmacen;
	}

	public List<EquipoMedicionSolicitudAlmacenDO> getEquipoMedicionSolicitudAlmacen() {
		return equipoMedicionSolicitudAlmacen;
	}

	public void setEquipoMedicionSolicitudAlmacen(
			List<EquipoMedicionSolicitudAlmacenDO> equipoMedicionSolicitudAlmacen) {
		this.equipoMedicionSolicitudAlmacen = equipoMedicionSolicitudAlmacen;
	}

	public ColaboradorDO getAutorizaFinal() {
		return autorizaFinal;
	}

	public void setAutorizaFinal(ColaboradorDO autorizaFinal) {
		this.autorizaFinal = autorizaFinal;
	}
	
	
	
	
}