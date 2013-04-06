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
@Table(name = "RegistroPercepcion")
@NamedQueries({
	@NamedQuery(name = "RegistroPercepcionDO.findAll", query = "select rc from RegistroPercepcionDO rc")
	})
public class RegistroPercepcionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4050641377990193381L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private ContratacionDO contratacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_percepcion", nullable = false)
	private PercepcionDO Percepcion; 
	
	@Column(name = "monto_aportacion", nullable = false)
	private Double montoAportacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_variaciones", nullable = false)
	private VariacionDO variaciones;
	
	@Column(name = "dias_correspondientes", nullable = false)
	private Integer diasCorrespondientes;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_termino")
	private Date fechaTermino;
	
	@Column(name = "prima_vacacional", nullable = false)
	private Integer primaVacacional;

	public RegistroPercepcionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroPercepcionDO(Integer id, ContratacionDO contratacion,
			PercepcionDO percepcion, Double montoAportacion,
			VariacionDO variaciones, Integer diasCorrespondientes,
			Date fechaInicio, Date fechaTermino, Integer primaVacacional) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		Percepcion = percepcion;
		this.montoAportacion = montoAportacion;
		this.variaciones = variaciones;
		this.diasCorrespondientes = diasCorrespondientes;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
		this.primaVacacional = primaVacacional;
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
	 * @return the contratacion
	 */
	public ContratacionDO getContratacion() {
		return contratacion;
	}

	/**
	 * @param contratacion the contratacion to set
	 */
	public void setContratacion(ContratacionDO contratacion) {
		this.contratacion = contratacion;
	}

	/**
	 * @return the percepcion
	 */
	public PercepcionDO getPercepcion() {
		return Percepcion;
	}

	/**
	 * @param percepcion the percepcion to set
	 */
	public void setPercepcion(PercepcionDO percepcion) {
		Percepcion = percepcion;
	}

	/**
	 * @return the montoAportacion
	 */
	public Double getMontoAportacion() {
		return montoAportacion;
	}

	/**
	 * @param montoAportacion the montoAportacion to set
	 */
	public void setMontoAportacion(Double montoAportacion) {
		this.montoAportacion = montoAportacion;
	}

	/**
	 * @return the variaciones
	 */
	public VariacionDO getVariaciones() {
		return variaciones;
	}

	/**
	 * @param variaciones the variaciones to set
	 */
	public void setVariaciones(VariacionDO variaciones) {
		this.variaciones = variaciones;
	}

	/**
	 * @return the diasCorrespondientes
	 */
	public Integer getDiasCorrespondientes() {
		return diasCorrespondientes;
	}

	/**
	 * @param diasCorrespondientes the diasCorrespondientes to set
	 */
	public void setDiasCorrespondientes(Integer diasCorrespondientes) {
		this.diasCorrespondientes = diasCorrespondientes;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * @return the primaVacacional
	 */
	public Integer getPrimaVacacional() {
		return primaVacacional;
	}

	/**
	 * @param primaVacacional the primaVacacional to set
	 */
	public void setPrimaVacacional(Integer primaVacacional) {
		this.primaVacacional = primaVacacional;
	}
	
	
}
