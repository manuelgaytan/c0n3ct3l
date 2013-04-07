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
 * @author MHDolores
 *
 */
@Entity
@Table(name = "DatosGeneralesSolicitante")
@NamedQueries({
	@NamedQuery(name = "DatosGeneralesSolicitanteDO.findAll", query = "select rc from DatosGeneralesSolicitanteDO rc")
	})
public class DatosGeneralesSolicitanteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8343380858417869252L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
	@Column(name = "apellido_paterno", nullable = false)
	private String apellidoPaterno;
	
	@Column(name = "apellido_materno", nullable = false)
	private String apellidoMaterno;
	
	@Column(name = "nombres", nullable = false)
	private String nombres;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento", nullable = false, length = 10)
	private Date fechaNacimiento;
	
	@Column(name = "lugar_nacimiento", nullable = false)
	private String lugarNacimiento;
	
	@Column(name = "edad", nullable = false)
	private String edad;
	
	@ManyToOne
	@JoinColumn(name = "fk_nacionalidad", nullable = false)
	private NacionalidadDO nacionalidad;
	
	@ManyToOne
	@JoinColumn(name = "fk_identificacion", nullable = false)
	private IdentificacionDO identificacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_documentacion_extranjeros", nullable = false)
	private DocumentacionExtranjerosDO documentacionExtranjeros;
	
	@ManyToOne
	@JoinColumn(name = "fk_direccion_solicitante", nullable = false)
	private DireccionSolicitanteDO direccionSolicitante;
	
	@Column(name = "telefono", nullable = false)
	private String telefono;
	
	@Column(name = "celular", nullable = false)
	private String celular;
	
	@Column(name = "correo_electronico", nullable = false)
	private String correoElectronico;
	
	@Column(name = "rfc", nullable = false)
	private String nss;
	
	@Column(name = "nss", nullable = false)
	private String rfc;
	
	@Column(name = "curp", nullable = false)
	private String curp;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_licencia", nullable = false)
	private LicenciaDO licencia;
	
	@ManyToOne
	@JoinColumn(name = "fk_carta_antecedentes_penales", nullable = false)
	private CartaAntecedentesPenalesDO cartaAntecedentesPenales;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_salud", nullable = false)
	private EstadoSaludDO estadoSalud;
	
	@Column(name = "enfermedad_cronica", nullable = false)
	private String enfermedadCronica;
	
	@ManyToOne
	@JoinColumn(name = "fk_tiempo_libre", nullable = false)
	private TiempoLibreDO tiempoLibre;

	public DatosGeneralesSolicitanteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosGeneralesSolicitanteDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			String apellidoPaterno, String apellidoMaterno, String nombres,
			Date fechaNacimiento, String lugarNacimiento, String edad,
			NacionalidadDO nacionalidad, IdentificacionDO identificacion,
			DocumentacionExtranjerosDO documentacionExtranjeros,
			DireccionSolicitanteDO direccionSolicitante, String telefono,
			String celular, String correoElectronico, String nss, String rfc,
			String curp, LicenciaDO licencia,
			CartaAntecedentesPenalesDO cartaAntecedentesPenales,
			EstadoSaludDO estadoSalud, String enfermedadCronica,
			TiempoLibreDO tiempoLibre) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.fechaNacimiento = fechaNacimiento;
		this.lugarNacimiento = lugarNacimiento;
		this.edad = edad;
		this.nacionalidad = nacionalidad;
		this.identificacion = identificacion;
		this.documentacionExtranjeros = documentacionExtranjeros;
		this.direccionSolicitante = direccionSolicitante;
		this.telefono = telefono;
		this.celular = celular;
		this.correoElectronico = correoElectronico;
		this.nss = nss;
		this.rfc = rfc;
		this.curp = curp;
		this.licencia = licencia;
		this.cartaAntecedentesPenales = cartaAntecedentesPenales;
		this.estadoSalud = estadoSalud;
		this.enfermedadCronica = enfermedadCronica;
		this.tiempoLibre = tiempoLibre;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the reclutamientoSolicitudEmpleo
	 */
	public ReclutamientoSolicitudEmpleoDO getReclutamientoSolicitudEmpleo() {
		return reclutamientoSolicitudEmpleo;
	}

	/**
	 * @param reclutamientoSolicitudEmpleo the reclutamientoSolicitudEmpleo to set
	 */
	public void setReclutamientoSolicitudEmpleo(
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo) {
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the lugarNacimiento
	 */
	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	/**
	 * @param lugarNacimiento the lugarNacimiento to set
	 */
	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}

	/**
	 * @return the nacionalidad
	 */
	public NacionalidadDO getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(NacionalidadDO nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the identificacion
	 */
	public IdentificacionDO getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionDO identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * @return the documentacionExtranjeros
	 */
	public DocumentacionExtranjerosDO getDocumentacionExtranjeros() {
		return documentacionExtranjeros;
	}

	/**
	 * @param documentacionExtranjeros the documentacionExtranjeros to set
	 */
	public void setDocumentacionExtranjeros(
			DocumentacionExtranjerosDO documentacionExtranjeros) {
		this.documentacionExtranjeros = documentacionExtranjeros;
	}

	/**
	 * @return the direccionSolicitante
	 */
	public DireccionSolicitanteDO getDireccionSolicitante() {
		return direccionSolicitante;
	}

	/**
	 * @param direccionSolicitante the direccionSolicitante to set
	 */
	public void setDireccionSolicitante(DireccionSolicitanteDO direccionSolicitante) {
		this.direccionSolicitante = direccionSolicitante;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the celular
	 */
	public String getCelular() {
		return celular;
	}

	/**
	 * @param celular the celular to set
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}

	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}

	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the licencia
	 */
	public LicenciaDO getLicencia() {
		return licencia;
	}

	/**
	 * @param licencia the licencia to set
	 */
	public void setLicencia(LicenciaDO licencia) {
		this.licencia = licencia;
	}

	/**
	 * @return the cartaAntecedentesPenales
	 */
	public CartaAntecedentesPenalesDO getCartaAntecedentesPenales() {
		return cartaAntecedentesPenales;
	}

	/**
	 * @param cartaAntecedentesPenales the cartaAntecedentesPenales to set
	 */
	public void setCartaAntecedentesPenales(
			CartaAntecedentesPenalesDO cartaAntecedentesPenales) {
		this.cartaAntecedentesPenales = cartaAntecedentesPenales;
	}

	/**
	 * @return the estadoSalud
	 */
	public EstadoSaludDO getEstadoSalud() {
		return estadoSalud;
	}

	/**
	 * @param estadoSalud the estadoSalud to set
	 */
	public void setEstadoSalud(EstadoSaludDO estadoSalud) {
		this.estadoSalud = estadoSalud;
	}

	/**
	 * @return the enfermedadCronica
	 */
	public String getEnfermedadCronica() {
		return enfermedadCronica;
	}

	/**
	 * @param enfermedadCronica the enfermedadCronica to set
	 */
	public void setEnfermedadCronica(String enfermedadCronica) {
		this.enfermedadCronica = enfermedadCronica;
	}

	/**
	 * @return the tiempoLibre
	 */
	public TiempoLibreDO getTiempoLibre() {
		return tiempoLibre;
	}

	/**
	 * @param tiempoLibre the tiempoLibre to set
	 */
	public void setTiempoLibre(TiempoLibreDO tiempoLibre) {
		this.tiempoLibre = tiempoLibre;
	}
	
	
	
}
