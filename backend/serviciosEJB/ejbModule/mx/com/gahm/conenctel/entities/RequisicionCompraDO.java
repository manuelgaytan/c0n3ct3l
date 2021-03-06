package mx.com.gahm.conenctel.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "RequisicionCompra")
@NamedQueries({
	@NamedQuery(name = "RequisicionCompraDO.findAll", query = "select rc from RequisicionCompraDO rc"),
	@NamedQuery(name = "RequisicionCompraDO.findAllByPerfil", query = "select s from RequisicionCompraDO s where s.perfil.id = :idPerfil")
	})
public class RequisicionCompraDO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 221968463812549205L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Column(name = "fecha_solicitud", nullable = false, length = 10)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaSolicitud;
	@Column(name = "motivo", nullable = false)
	private String motivo;
	@ManyToOne
	@JoinColumn(name = "fk_prioridad", nullable = false)
	private PrioridadDO prioridad;
	@ManyToOne
	@JoinColumn(name = "fk_area_solicitante", nullable = false)
	private PerfilDO areaSolicitante;
	@Column(name = "central_sitio", nullable = false)
	private String centralSitio;
	@ManyToOne
	@JoinColumn(name = "fk_estatus", nullable = false)
	private EstatusRequisicionCompraDO estatusRequisicionCompra;
	@OneToMany(mappedBy="requisicionCompra", fetch = FetchType.EAGER)
	private List<SolicitanteRequisicionDO> solicitantesRequisicion;
	@OneToMany(mappedBy="requisicionCompra", fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
    private List<PartidaRequisicionCompraDO> partidasRequisicionCompra;
	@OneToMany(mappedBy="requisicionCompra", fetch = FetchType.EAGER)
    private List<ComentarioRequisicionDO> comentariosRequisicion;
	@Column(name = "fecha_estatus_requisicion", nullable = false, length = 10)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaEstatusRequisicion;
	@ManyToOne
	@JoinColumn(name="fk_perfil")
	private PerfilDO perfil;

	public RequisicionCompraDO() {
	}

	/** full constructor */
	public RequisicionCompraDO(Integer id, Date fechaSolicitud, String motivo,
			PrioridadDO prioridad, PerfilDO areaSolicitante,
			String centralSitio,
			EstatusRequisicionCompraDO estatusRequisicionCompra,
			List<SolicitanteRequisicionDO> solicitantesRequisicion,
			List<PartidaRequisicionCompraDO> partidasRequisicionCompra,
			PerfilDO perfil
			) {
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.estatusRequisicionCompra = estatusRequisicionCompra;
		this.solicitantesRequisicion = solicitantesRequisicion;
		this.partidasRequisicionCompra = partidasRequisicionCompra;
		this.perfil = perfil;
	}

	public RequisicionCompraDO(Date fechaSolicitud, String motivo,
			PrioridadDO prioridad, PerfilDO areaSolicitante,
			String centralSitio, String codigo, String grupoFamilia,
			String descripcion, String cantidad, String validacion,
			EstatusRequisicionCompraDO estatusRequisicionCompra,
			PerfilDO perfil) {
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.estatusRequisicionCompra = estatusRequisicionCompra;
		this.perfil = perfil;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaSolicitud() {
		return this.fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	
	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public PrioridadDO getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(PrioridadDO prioridad) {
		this.prioridad = prioridad;
	}

	public PerfilDO getAreaSolicitante() {
		return this.areaSolicitante;
	}

	public void setAreaSolicitante(PerfilDO areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}

	public String getCentralSitio() {
		return this.centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public EstatusRequisicionCompraDO getEstatusRequisicionCompra() {
		return this.estatusRequisicionCompra;
	}

	public void setEstatusRequisicionCompra(
			EstatusRequisicionCompraDO estatusRequisicionCompra) {
		this.estatusRequisicionCompra = estatusRequisicionCompra;
	}
	
	public List<PartidaRequisicionCompraDO> getPartidasRequisicionCompra() {
		return partidasRequisicionCompra;
	}

	public void setPartidasRequisicionCompra(
			List<PartidaRequisicionCompraDO> partidasRequisicionCompra) {
		this.partidasRequisicionCompra = partidasRequisicionCompra;
	}

	public List<SolicitanteRequisicionDO> getSolicitantesRequisicion() {
		return solicitantesRequisicion;
	}

	public void setSolicitantesRequisicion(
			List<SolicitanteRequisicionDO> solicitantesRequisicion) {
		this.solicitantesRequisicion = solicitantesRequisicion;
	}

	public List<ComentarioRequisicionDO> getComentariosRequisicion() {
		return comentariosRequisicion;
	}

	public void setComentariosRequisicion(
			List<ComentarioRequisicionDO> comentariosRequisicion) {
		this.comentariosRequisicion = comentariosRequisicion;
	}

	public Date getFechaEstatusRequisicion() {
		return fechaEstatusRequisicion;
	}

	public void setFechaEstatusRequisicion(Date fechaEstatusRequisicion) {
		this.fechaEstatusRequisicion = fechaEstatusRequisicion;
	}

	public PerfilDO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}
}