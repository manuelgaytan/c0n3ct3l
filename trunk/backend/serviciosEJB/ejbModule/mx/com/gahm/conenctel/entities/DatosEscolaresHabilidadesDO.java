/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */

@Entity
@Table(name = "DatosEscolaresHabilidades")
@NamedQueries({
	@NamedQuery(name = "DatosEscolaresHabilidadesDO.findAll", query = "select rc from DatosEscolaresHabilidadesDO rc")
	})
public class DatosEscolaresHabilidadesDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4317210481752165477L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;

	@ManyToOne
	@JoinColumn(name = "fk_ultimo_grado_estudios", nullable = false)
	private UltimoGradoEstudiosDO ultimoGradoEstudios;
	
	@Column(name = "escuela_procedencia", nullable = false)
	private String escuela_procedencia;

	@ManyToOne
	@JoinColumn(name = "fk_estado_academico", nullable = false)
	private EstadoAcademicoDO estadoAcademico;
	
	@Column(name = "idiomas", nullable = false)
	private String idiomas;
	
	@Column(name = "porcentaje_idiomas", nullable = false)
	private String porcentajeIdiomas;

	public DatosEscolaresHabilidadesDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosEscolaresHabilidadesDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			UltimoGradoEstudiosDO ultimoGradoEstudios,
			String escuela_procedencia, EstadoAcademicoDO estadoAcademico,
			String idiomas, String porcentajeIdiomas) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.ultimoGradoEstudios = ultimoGradoEstudios;
		this.escuela_procedencia = escuela_procedencia;
		this.estadoAcademico = estadoAcademico;
		this.idiomas = idiomas;
		this.porcentajeIdiomas = porcentajeIdiomas;
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
	 * @return the ultimoGradoEstudios
	 */
	public UltimoGradoEstudiosDO getUltimoGradoEstudios() {
		return ultimoGradoEstudios;
	}

	/**
	 * @param ultimoGradoEstudios the ultimoGradoEstudios to set
	 */
	public void setUltimoGradoEstudios(UltimoGradoEstudiosDO ultimoGradoEstudios) {
		this.ultimoGradoEstudios = ultimoGradoEstudios;
	}

	/**
	 * @return the escuela_procedencia
	 */
	public String getEscuela_procedencia() {
		return escuela_procedencia;
	}

	/**
	 * @param escuela_procedencia the escuela_procedencia to set
	 */
	public void setEscuela_procedencia(String escuela_procedencia) {
		this.escuela_procedencia = escuela_procedencia;
	}

	/**
	 * @return the estadoAcademico
	 */
	public EstadoAcademicoDO getEstadoAcademico() {
		return estadoAcademico;
	}

	/**
	 * @param estadoAcademico the estadoAcademico to set
	 */
	public void setEstadoAcademico(EstadoAcademicoDO estadoAcademico) {
		this.estadoAcademico = estadoAcademico;
	}

	/**
	 * @return the idiomas
	 */
	public String getIdiomas() {
		return idiomas;
	}

	/**
	 * @param idiomas the idiomas to set
	 */
	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	/**
	 * @return the porcentajeIdiomas
	 */
	public String getPorcentajeIdiomas() {
		return porcentajeIdiomas;
	}

	/**
	 * @param porcentajeIdiomas the porcentajeIdiomas to set
	 */
	public void setPorcentajeIdiomas(String porcentajeIdiomas) {
		this.porcentajeIdiomas = porcentajeIdiomas;
	}
	
	
	
	
	
}
