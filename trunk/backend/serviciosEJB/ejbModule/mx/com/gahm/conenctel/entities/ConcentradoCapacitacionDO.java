/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author GUILLERMO
 * 
 */
public class ConcentradoCapacitacionDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6629125885073909683L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private UsuarioDO colaborador;

	@ManyToOne
	@JoinColumn(name = "fk_tipo_formacion", nullable = false)
	private TipoFormacionDO tipoFormacion;

	@ManyToOne
	@JoinColumn(name = "fk_tipo_capacitacion", nullable = false)
	private TipoCapacitacionDO tipoCapacitacion;

	@Column(name = "nombre_capacitacion", nullable = false)
	private String nombreCapacitacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_capacitacion", nullable = false, length = 10)
	private Date fechaInicioCapacitacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino_capacitacion", nullable = false, length = 10)
	private Date fechaTerminoCapacitacion;

	@Column(name = "lugar_capacitacion", nullable = false)
	private String lugarCapacitacion;

	@Column(name = "nombre_instructor", nullable = false)
	private String nombreInstructor;

	@Column(name = "calificacion", nullable = false)
	private Double calificacion;

	@Column(name = "constancia", nullable = false)
	private String constancia;

	public ConcentradoCapacitacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConcentradoCapacitacionDO(Integer id, UsuarioDO colaborador,
			TipoFormacionDO tipoFormacion, TipoCapacitacionDO tipoCapacitacion,
			String nombreCapacitacion, Date fechaInicioCapacitacion,
			Date fechaTerminoCapacitacion, String lugarCapacitacion,
			String nombreInstructor, Double calificacion, String constancia) {
		super();
		this.id = id;
		this.colaborador = colaborador;
		this.tipoFormacion = tipoFormacion;
		this.tipoCapacitacion = tipoCapacitacion;
		this.nombreCapacitacion = nombreCapacitacion;
		this.fechaInicioCapacitacion = fechaInicioCapacitacion;
		this.fechaTerminoCapacitacion = fechaTerminoCapacitacion;
		this.lugarCapacitacion = lugarCapacitacion;
		this.nombreInstructor = nombreInstructor;
		this.calificacion = calificacion;
		this.constancia = constancia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioDO getColaborador() {
		return colaborador;
	}

	public void setColaborador(UsuarioDO colaborador) {
		this.colaborador = colaborador;
	}

	public TipoFormacionDO getTipoFormacion() {
		return tipoFormacion;
	}

	public void setTipoFormacion(TipoFormacionDO tipoFormacion) {
		this.tipoFormacion = tipoFormacion;
	}

	public TipoCapacitacionDO getTipoCapacitacion() {
		return tipoCapacitacion;
	}

	public void setTipoCapacitacion(TipoCapacitacionDO tipoCapacitacion) {
		this.tipoCapacitacion = tipoCapacitacion;
	}

	public String getNombreCapacitacion() {
		return nombreCapacitacion;
	}

	public void setNombreCapacitacion(String nombreCapacitacion) {
		this.nombreCapacitacion = nombreCapacitacion;
	}

	public Date getFechaInicioCapacitacion() {
		return fechaInicioCapacitacion;
	}

	public void setFechaInicioCapacitacion(Date fechaInicioCapacitacion) {
		this.fechaInicioCapacitacion = fechaInicioCapacitacion;
	}

	public Date getFechaTerminoCapacitacion() {
		return fechaTerminoCapacitacion;
	}

	public void setFechaTerminoCapacitacion(Date fechaTerminoCapacitacion) {
		this.fechaTerminoCapacitacion = fechaTerminoCapacitacion;
	}

	public String getLugarCapacitacion() {
		return lugarCapacitacion;
	}

	public void setLugarCapacitacion(String lugarCapacitacion) {
		this.lugarCapacitacion = lugarCapacitacion;
	}

	public String getNombreInstructor() {
		return nombreInstructor;
	}

	public void setNombreInstructor(String nombreInstructor) {
		this.nombreInstructor = nombreInstructor;
	}

	public Double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(Double calificacion) {
		this.calificacion = calificacion;
	}

	public String getConstancia() {
		return constancia;
	}

	public void setConstancia(String constancia) {
		this.constancia = constancia;
	}

}
