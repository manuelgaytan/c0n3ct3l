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
@Table(name = "DatosSobreConectelSolicitante")
@NamedQueries({
	@NamedQuery(name = "DatosSobreConectelSolicitanteDO.findAll", query = "select rc from DatosSobreConectelSolicitanteDO rc")
	})
public class DatosSobreConectelSolicitanteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4834554857378926061L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
	@ManyToOne
	@JoinColumn(name = "fk_fuente_reclutamiento", nullable = false)
	private FuenteReclutamientoDO fuenteReclutamiento;

	@Column(name = "conocidos_conectel", nullable = false)
	private Boolean conocidosConectel;
	
	@Column(name = "puede_viajar", nullable = false)
	private Boolean puedeViajar;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_presentarse", nullable = false, length = 10)
	private Date fechaPresentarse;
	
	@ManyToOne
	@JoinColumn(name = "fk_fase_seleccion", nullable = false)
	private FaseSeleccionDO faseSeleccion;

	public DatosSobreConectelSolicitanteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosSobreConectelSolicitanteDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			FuenteReclutamientoDO fuenteReclutamiento,
			Boolean conocidosConectel, Boolean puedeViajar,
			Date fechaPresentarse, FaseSeleccionDO faseSeleccion) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.fuenteReclutamiento = fuenteReclutamiento;
		this.conocidosConectel = conocidosConectel;
		this.puedeViajar = puedeViajar;
		this.fechaPresentarse = fechaPresentarse;
		this.faseSeleccion = faseSeleccion;
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
	 * @return the fuenteReclutamiento
	 */
	public FuenteReclutamientoDO getFuenteReclutamiento() {
		return fuenteReclutamiento;
	}

	/**
	 * @param fuenteReclutamiento the fuenteReclutamiento to set
	 */
	public void setFuenteReclutamiento(FuenteReclutamientoDO fuenteReclutamiento) {
		this.fuenteReclutamiento = fuenteReclutamiento;
	}

	/**
	 * @return the conocidosConectel
	 */
	public Boolean getConocidosConectel() {
		return conocidosConectel;
	}

	/**
	 * @param conocidosConectel the conocidosConectel to set
	 */
	public void setConocidosConectel(Boolean conocidosConectel) {
		this.conocidosConectel = conocidosConectel;
	}

	/**
	 * @return the puedeViajar
	 */
	public Boolean getPuedeViajar() {
		return puedeViajar;
	}

	/**
	 * @param puedeViajar the puedeViajar to set
	 */
	public void setPuedeViajar(Boolean puedeViajar) {
		this.puedeViajar = puedeViajar;
	}

	/**
	 * @return the fechaPresentarse
	 */
	public Date getFechaPresentarse() {
		return fechaPresentarse;
	}

	/**
	 * @param fechaPresentarse the fechaPresentarse to set
	 */
	public void setFechaPresentarse(Date fechaPresentarse) {
		this.fechaPresentarse = fechaPresentarse;
	}

	/**
	 * @return the faseSeleccion
	 */
	public FaseSeleccionDO getFaseSeleccion() {
		return faseSeleccion;
	}

	/**
	 * @param faseSeleccion the faseSeleccion to set
	 */
	public void setFaseSeleccion(FaseSeleccionDO faseSeleccion) {
		this.faseSeleccion = faseSeleccion;
	}
	
	
	
	
}
