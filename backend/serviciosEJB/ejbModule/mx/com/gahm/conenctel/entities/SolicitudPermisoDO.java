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
@Table(name = "SolicitudPermiso")
@NamedQueries({
	@NamedQuery(name = "SolicitudPermisoDO.findAll", query = "select rc from SolicitudPermisoDO rc"),
	@NamedQuery(name = "SolicitudPermisoDO.findAllByPerfil", query = "select s from SolicitudPermisoDO s where s.perfil.id = :idPerfil")
	})
public class SolicitudPermisoDO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "fecha_registro", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	
	@ManyToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private InformacionConfidencialColaboradorDO contratacion;
	
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "fk_forma_pago_prenomina", nullable = false)
	private FormaPagoPrenominaDO formaPagoPrenomina;
	
	@Column(name = "fecha_hora_salida", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraSalida;
	
	@Column(name = "fecha_hora_retorno", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaHoraRetorno;
	
	@ManyToOne
	@JoinColumn(name = "fk_permiso_sin_goce_sueldo", nullable = false)
	private PermisoSinGoceSueldoDO permisoSinGoceSueldo;
	
	@ManyToOne
	@JoinColumn(name = "fk_permiso_con_goce_sueldo", nullable = false)
	private PermisoConGoceSueldoDO permisoConGoceSueldo;
	
	@Column(name = "visto_bueno_jefe_inmediato")
	private Boolean vistoBuenoJefeInmediato;
	
	@Column(name = "autorizacion")
	private Boolean autorizacion;
	
	@ManyToOne
	@JoinColumn(name="fk_perfil")
	private PerfilDO perfil;
	
	@OneToMany(mappedBy="solicitudPermiso", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioSolicitudPermisoDO> comentarios;
	public SolicitudPermisoDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SolicitudPermisoDO(Integer id, Date fechaRegistro, InformacionConfidencialColaboradorDO contratacion,
			Date fecha, FormaPagoPrenominaDO formaPagoPrenomina,
			Date fechaHoraSalida, Date fechaHoraRetorno,
			PermisoSinGoceSueldoDO permisoSinGoceSueldo,
			PermisoConGoceSueldoDO permisoConGoceSueldo,
			Boolean vistoBuenoJefeInmediato, Boolean autorizacion,
			List<ComentarioSolicitudPermisoDO> comentarios) {
		super();
		this.id = id;
		this.fechaRegistro = fechaRegistro;
		this.contratacion = contratacion;
		this.fecha = fecha;
		this.formaPagoPrenomina = formaPagoPrenomina;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraRetorno = fechaHoraRetorno;
		this.permisoSinGoceSueldo = permisoSinGoceSueldo;
		this.permisoConGoceSueldo = permisoConGoceSueldo;
		this.vistoBuenoJefeInmediato = vistoBuenoJefeInmediato;
		this.autorizacion = autorizacion;
		this.comentarios = comentarios;
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
	public FormaPagoPrenominaDO getFormaPagoPrenomina() {
		return formaPagoPrenomina;
	}
	public void setFormaPagoPrenomina(FormaPagoPrenominaDO formaPagoPrenomina) {
		this.formaPagoPrenomina = formaPagoPrenomina;
	}
	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}
	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	public Date getFechaHoraRetorno() {
		return fechaHoraRetorno;
	}
	public void setFechaHoraRetorno(Date fechaHoraRetorno) {
		this.fechaHoraRetorno = fechaHoraRetorno;
	}
	public PermisoSinGoceSueldoDO getPermisoSinGoceSueldo() {
		return permisoSinGoceSueldo;
	}
	public void setPermisoSinGoceSueldo(PermisoSinGoceSueldoDO permisoSinGoceSueldo) {
		this.permisoSinGoceSueldo = permisoSinGoceSueldo;
	}
	public PermisoConGoceSueldoDO getPermisoConGoceSueldo() {
		return permisoConGoceSueldo;
	}
	public void setPermisoConGoceSueldo(PermisoConGoceSueldoDO permisoConGoceSueldo) {
		this.permisoConGoceSueldo = permisoConGoceSueldo;
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
	public List<ComentarioSolicitudPermisoDO> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<ComentarioSolicitudPermisoDO> comentarios) {
		this.comentarios = comentarios;
	}
	public PerfilDO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
}
