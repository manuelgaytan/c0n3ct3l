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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "DatosPrincipalesSolicitante")
@NamedQueries({
	@NamedQuery(name = "DatosPrincipalesSolicitanteDO.findAll", query = "select rc from DatosPrincipalesSolicitanteDO rc")
	})

public class DatosPrincipalesSolicitanteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9050495144895207549L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_solicitud", nullable = false, length = 10)
	private Date fechaSolicitud;
	
	@Column(name = "puesto_solicitado", nullable = false)
	private String puestoSolicitado;
	
	@Column(name = "sueldo_solicitado", nullable = false)
	private Double sueldoSolicitado;
	
	@Column(name = "objetivo_laboral", nullable = false)
	private String objetivoLaboral;

	public DatosPrincipalesSolicitanteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosPrincipalesSolicitanteDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			Date fechaSolicitud, String puestoSolicitado,
			Double sueldoSolicitado, String objetivoLaboral) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.fechaSolicitud = fechaSolicitud;
		this.puestoSolicitado = puestoSolicitado;
		this.sueldoSolicitado = sueldoSolicitado;
		this.objetivoLaboral = objetivoLaboral;
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
	 * @return the fechaSolicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the puestoSolicitado
	 */
	public String getPuestoSolicitado() {
		return puestoSolicitado;
	}

	/**
	 * @param puestoSolicitado the puestoSolicitado to set
	 */
	public void setPuestoSolicitado(String puestoSolicitado) {
		this.puestoSolicitado = puestoSolicitado;
	}

	/**
	 * @return the sueldoSolicitado
	 */
	public Double getSueldoSolicitado() {
		return sueldoSolicitado;
	}

	/**
	 * @param sueldoSolicitado the sueldoSolicitado to set
	 */
	public void setSueldoSolicitado(Double sueldoSolicitado) {
		this.sueldoSolicitado = sueldoSolicitado;
	}

	/**
	 * @return the objetivoLaboral
	 */
	public String getObjetivoLaboral() {
		return objetivoLaboral;
	}

	/**
	 * @param objetivoLaboral the objetivoLaboral to set
	 */
	public void setObjetivoLaboral(String objetivoLaboral) {
		this.objetivoLaboral = objetivoLaboral;
	}
	
	
	
	
}
