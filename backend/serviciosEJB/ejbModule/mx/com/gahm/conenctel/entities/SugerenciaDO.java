/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
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
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "Sugerencia")
@NamedQueries({
	@NamedQuery(name = "SugerenciaDO.findAll", query = "select rc from SugerenciaDO rc")
	})
public class SugerenciaDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5999792334860118883L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private ColaboradorDO colaborador;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "correo_electronico", nullable = false)
	private String correoElectronico;
	@Column(name = "telefono", nullable = false)
	private String telefono;
	@Column(name = "sugerencia", nullable = false)
	private String sugerencia;
	@Column(name = "requiere_accion_inmediata", nullable = false)
	private Boolean requiereAccionInmediata;
	@Column(name = "requiere_accion_correctiva", nullable = false)
	private Boolean requiereAccionCorrectiva;
	@Column(name = "accion_inmediata", nullable = false)
	private String accionInmediata;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_implementacion", nullable = false, length = 10)
	private Date fechaImplementacion;
	
	@Column(name = "responsable_implementacion", nullable = false)
	private String responsableImplementacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_resultado_implementacion", nullable = false)
	private ResultadoImplementacionDO ResultadoImplementacion;
	
	@OneToMany(mappedBy="sugerencia", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioSugerenciaDO> comentariosSugerencia; 
	
	public SugerenciaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SugerenciaDO(Integer id, Date fecha, ColaboradorDO colaborador,
			String nombre, String correoElectronico, String telefono,
			String sugerencia, Boolean requiereAccionInmediata,
			Boolean requiereAccionCorrectiva, String accionInmediata,
			Date fechaImplementacion, String responsableImplementacion,
			ResultadoImplementacionDO resultadoImplementacion) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.colaborador = colaborador;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		this.telefono = telefono;
		this.sugerencia = sugerencia;
		this.requiereAccionInmediata = requiereAccionInmediata;
		this.requiereAccionCorrectiva = requiereAccionCorrectiva;
		this.accionInmediata = accionInmediata;
		this.fechaImplementacion = fechaImplementacion;
		this.responsableImplementacion = responsableImplementacion;
		ResultadoImplementacion = resultadoImplementacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorDO colaborador) {
		this.colaborador = colaborador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}

	public Boolean getRequiereAccionInmediata() {
		return requiereAccionInmediata;
	}

	public void setRequiereAccionInmediata(Boolean requiereAccionInmediata) {
		this.requiereAccionInmediata = requiereAccionInmediata;
	}

	public Boolean getRequiereAccionCorrectiva() {
		return requiereAccionCorrectiva;
	}

	public void setRequiereAccionCorrectiva(Boolean requiereAccionCorrectiva) {
		this.requiereAccionCorrectiva = requiereAccionCorrectiva;
	}

	public String getAccionInmediata() {
		return accionInmediata;
	}

	public void setAccionInmediata(String accionInmediata) {
		this.accionInmediata = accionInmediata;
	}

	public Date getFechaImplementacion() {
		return fechaImplementacion;
	}

	public void setFechaImplementacion(Date fechaImplementacion) {
		this.fechaImplementacion = fechaImplementacion;
	}

	public String getResponsableImplementacion() {
		return responsableImplementacion;
	}

	public void setResponsableImplementacion(String responsableImplementacion) {
		this.responsableImplementacion = responsableImplementacion;
	}

	public ResultadoImplementacionDO getResultadoImplementacion() {
		return ResultadoImplementacion;
	}

	public void setResultadoImplementacion(
			ResultadoImplementacionDO resultadoImplementacion) {
		ResultadoImplementacion = resultadoImplementacion;
	}

	public List<ComentarioSugerenciaDO> getComentariosSugerencia() {
		return comentariosSugerencia;
	}

	public void setComentariosSugerencia(
			List<ComentarioSugerenciaDO> comentariosSugerencia) {
		this.comentariosSugerencia = comentariosSugerencia;
	}
	
	
}
