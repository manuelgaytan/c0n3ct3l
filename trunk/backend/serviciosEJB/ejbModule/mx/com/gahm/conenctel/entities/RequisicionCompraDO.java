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
	private Integer id;
	private Date fechaSolicitud;
	private String motivo;
	private PrioridadDO prioridad;
	private AreaSolicitanteDO areaSolicitante;
	private String centralSitio;
	private String codigo;
	private String grupoFamilia;
	private String descripcion;
	private String cantidad;
	private String validacion;
	private EstatusRequisicionCompraDO estatusRequisicionCompra;
    private List<PartidaRequisicionCompraDO> partidasReqisicionCompra; 
	
	public RequisicionCompraDO() {
	}

	public RequisicionCompraDO(Date fechaSolicitud, String motivo,
			PrioridadDO prioridad, AreaSolicitanteDO areaSolicitante,
			String centralSitio, String descripcion, String cantidad,
			String validacion,
			EstatusRequisicionCompraDO estatusRequisicionCompra) {
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.validacion = validacion;
		this.estatusRequisicionCompra = estatusRequisicionCompra;
	}

	/** full constructor */
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
		this.codigo = codigo;
		this.grupoFamilia = grupoFamilia;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.validacion = validacion;
		this.estatusRequisicionCompra = estatusRequisicionCompra;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicitud", nullable = false, length = 10)
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

	@Column(name = "central_sitio", nullable = false)
	public String getCentralSitio() {
		return this.centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	@Column(name = "codigo")
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "grupo_familia")
	public String getGrupoFamilia() {
		return this.grupoFamilia;
	}

	public void setGrupoFamilia(String grupoFamilia) {
		this.grupoFamilia = grupoFamilia;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "cantidad", nullable = false)
	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "validacion", nullable = false)
	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
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
		return partidasReqisicionCompra;
	}

	public void setPartidasReqisicionCompra(
			List<PartidaRequisicionCompraDO> partidasReqisicionCompra) {
		this.partidasReqisicionCompra = partidasReqisicionCompra;
	}


}