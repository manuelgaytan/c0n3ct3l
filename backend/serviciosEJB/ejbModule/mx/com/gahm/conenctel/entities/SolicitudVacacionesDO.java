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

@Entity
@Table(name = "SolicitudVacaciones")
@NamedQueries({
	@NamedQuery(name = "SolicitudVacacionesDO.findAll", query = "select rc from SolicitudVacacionesDO rc"),
	@NamedQuery(name = "SolicitudVacacionesDO.findAllByPerfil", query = "select s from SolicitudVacacionesDO s where s.perfil.id = :idPerfil")
	})
public class SolicitudVacacionesDO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private InformacionConfidencialColaboradorDO contratacion;
	
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "fk_variacion", nullable = false)
	private VariacionDO variacion;
	
	@Column(name = "dias_correspondientes", nullable = false)
	private Integer diasCorrespondientes;
	
	@Column(name = "fecha_inicio", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaInicio;
	
	@Column(name = "fecha_fin", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaFin;
	
	@Column(name = "visto_bueno_jefe_inmediato")
	private Boolean vistoBuenoJefeInmediato;
	
	@Column(name = "autorizacion")
	private Boolean autorizacion;
	
	@OneToMany(mappedBy="solicitudVacaciones", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioSolicitudVacacionesDO> comentarios;
	
	@ManyToOne
	@JoinColumn(name="fk_perfil")
	private PerfilDO perfil;
	
	public SolicitudVacacionesDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SolicitudVacacionesDO(Integer id, InformacionConfidencialColaboradorDO contratacion,
			Date fecha, VariacionDO variacion, Integer diasCorrespondientes,
			Date fechaInicio, Date fechaFin, Boolean vistoBuenoJefeInmediato,
			Boolean autorizacion) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.fecha = fecha;
		this.variacion = variacion;
		this.diasCorrespondientes = diasCorrespondientes;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.vistoBuenoJefeInmediato = vistoBuenoJefeInmediato;
		this.autorizacion = autorizacion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public InformacionConfidencialColaboradorDO getContratacion() {
		return contratacion;
	}
	public void setContratacion(InformacionConfidencialColaboradorDO contratacion) {
		this.contratacion = contratacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public VariacionDO getVariacion() {
		return variacion;
	}
	public void setVariacion(VariacionDO variacion) {
		this.variacion = variacion;
	}
	public Integer getDiasCorrespondientes() {
		return diasCorrespondientes;
	}
	public void setDiasCorrespondientes(Integer diasCorrespondientes) {
		this.diasCorrespondientes = diasCorrespondientes;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Boolean getVistoBuenoJefeInmediato() {
		return vistoBuenoJefeInmediato;
	}
	public void setVistoBuenoJefeInmediato(Boolean vistoBuenoJefeInmediato) {
		this.vistoBuenoJefeInmediato = vistoBuenoJefeInmediato;
	}
	public Boolean getAutorizacion() {
		return autorizacion;
	}
	public void setAutorizacion(Boolean autorizacion) {
		this.autorizacion = autorizacion;
	}
	public List<ComentarioSolicitudVacacionesDO> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioSolicitudVacacionesDO> comentarios) {
		this.comentarios = comentarios;
	}
	public PerfilDO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}
	
	
	
	
}
