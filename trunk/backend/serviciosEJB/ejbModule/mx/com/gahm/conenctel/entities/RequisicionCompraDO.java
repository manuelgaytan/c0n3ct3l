package mx.com.gahm.conenctel.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RequisicionCompra")
@NamedQueries({
	@NamedQuery(name = "RequisicionCompraDO.findAll", query = "select rc from RequisicionCompraDO rc")
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
	private String motivo;
	private PrioridadDO prioridad;
	private AreaSolicitanteDO areaSolicitante;
	@Column(name = "central_sitio", nullable = false)
	private String centralSitio;
	private EstatusRequisicionCompraDO estatusRequisicionCompra;
	private List<SolicitanteRequisicionDO> solicitantesRequisicion;
    private List<PartidaRequisicionCompraDO> partidasRequisicionCompra;
    private List<ComentarioRequisicionDO> comentariosRequisicion;
    
	public RequisicionCompraDO() {
	}

	/** full constructor */
	public RequisicionCompraDO(Date fechaSolicitud, String motivo,
			PrioridadDO prioridad, AreaSolicitanteDO areaSolicitante,
			String centralSitio,
			EstatusRequisicionCompraDO estatusRequisicionCompra,
			List<SolicitanteRequisicionDO> solicitanteRequisicion,
			List<PartidaRequisicionCompraDO> partidasRequisicionCompra
			) {
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.estatusRequisicionCompra = estatusRequisicionCompra;
		this.solicitantesRequisicion = solicitanteRequisicion;
		this.partidasRequisicionCompra = partidasRequisicionCompra;
	}

	public RequisicionCompraDO(Date fechaSolicitud, String motivo,
			PrioridadDO prioridad, AreaSolicitanteDO areaSolicitante,
			String centralSitio, String codigo, String grupoFamilia,
			String descripcion, String cantidad, String validacion,
			EstatusRequisicionCompraDO estatusRequisicionCompra) {
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.estatusRequisicionCompra = estatusRequisicionCompra;
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

	@Column(name = "motivo", nullable = false)
	public String getMotivo() {
		return this.motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	@ManyToOne
	@JoinColumn(name = "fk_prioridad", nullable = false)
	public PrioridadDO getPrioridad() {
		return this.prioridad;
	}

	public void setPrioridad(PrioridadDO prioridad) {
		this.prioridad = prioridad;
	}

	@ManyToOne
	@JoinColumn(name = "fk_area_solicitante", nullable = false)
	public AreaSolicitanteDO getAreaSolicitante() {
		return this.areaSolicitante;
	}

	public void setAreaSolicitante(AreaSolicitanteDO areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}

	public String getCentralSitio() {
		return this.centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	@ManyToOne
	@JoinColumn(name = "fk_estatus", nullable = false)
	public EstatusRequisicionCompraDO getEstatusRequisicionCompra() {
		return this.estatusRequisicionCompra;
	}

	public void setEstatusRequisicionCompra(
			EstatusRequisicionCompraDO estatusRequisicionCompra) {
		this.estatusRequisicionCompra = estatusRequisicionCompra;
	}
	
	@OneToMany(mappedBy="requisicionCompra", fetch = FetchType.EAGER)
	public List<PartidaRequisicionCompraDO> getPartidasReqisicionCompra() {
		return partidasRequisicionCompra;
	}

	public void setPartidasReqisicionCompra(
			List<PartidaRequisicionCompraDO> partidasReqisicionCompra) {
		this.partidasRequisicionCompra = partidasReqisicionCompra;
	}

	public List<SolicitanteRequisicionDO> getSolicitanteRequisicion() {
		return solicitantesRequisicion;
	}

	public void setSolicitanteRequisicion(
			List<SolicitanteRequisicionDO> solicitanteRequisicion) {
		this.solicitantesRequisicion = solicitanteRequisicion;
	}

	public List<ComentarioRequisicionDO> getComentariosRequisicion() {
		return comentariosRequisicion;
	}

	public void setComentariosRequisicion(
			List<ComentarioRequisicionDO> comentariosRequisicion) {
		this.comentariosRequisicion = comentariosRequisicion;
	}


}