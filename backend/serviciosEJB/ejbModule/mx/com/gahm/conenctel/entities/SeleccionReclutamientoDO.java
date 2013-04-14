/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "SeleccionReclutamiento")
@NamedQueries({
	@NamedQuery(name = "SeleccionReclutamientoDO.findAll", query = "select rc from SeleccionReclutamientoDO rc")
	})
public class SeleccionReclutamientoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6411196365609373153L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
	public ExamenPsicometricoDO getExamenPsicometrico() {
		return ExamenPsicometrico;
	}

	public void setExamenPsicometrico(ExamenPsicometricoDO examenPsicometrico) {
		ExamenPsicometrico = examenPsicometrico;
	}

	@ManyToOne
	@JoinColumn(name = "fk_tipo_candidato", nullable = false)
	private TipoCandidatoDO tipoCandidato;
	
	@Column(name = "examen_tecnico", nullable = false)
	private Integer examenTecnico;
	
	@ManyToOne
	@JoinColumn(name = "fk_fase_contratacion", nullable = false)
	private FaseContratacionDO faseContratacion;

	@OneToOne(mappedBy="seleccionReclutamiento",cascade=CascadeType.ALL)
	private ExamenPsicometricoDO ExamenPsicometrico;
	
	public SeleccionReclutamientoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SeleccionReclutamientoDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			TipoCandidatoDO tipoCandidato, Integer examenTecnico,
			FaseContratacionDO faseContratacion) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.tipoCandidato = tipoCandidato;
		this.examenTecnico = examenTecnico;
		this.faseContratacion = faseContratacion;
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
	 * @return the tipoCandidato
	 */
	public TipoCandidatoDO getTipoCandidato() {
		return tipoCandidato;
	}

	/**
	 * @param tipoCandidato the tipoCandidato to set
	 */
	public void setTipoCandidato(TipoCandidatoDO tipoCandidato) {
		this.tipoCandidato = tipoCandidato;
	}

	/**
	 * @return the examenTecnico
	 */
	public Integer getExamenTecnico() {
		return examenTecnico;
	}

	/**
	 * @param examenTecnico the examenTecnico to set
	 */
	public void setExamenTecnico(Integer examenTecnico) {
		this.examenTecnico = examenTecnico;
	}

	/**
	 * @return the faseContratacion
	 */
	public FaseContratacionDO getFaseContratacion() {
		return faseContratacion;
	}

	/**
	 * @param faseContratacion the faseContratacion to set
	 */
	public void setFaseContratacion(FaseContratacionDO faseContratacion) {
		this.faseContratacion = faseContratacion;
	}
	
	
}
