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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "DatosUltimoEmpleoSolicitante")
@NamedQueries({
	@NamedQuery(name = "DatosUltimoEmpleoSolicitanteDO.findAll", query = "select rc from DatosUltimoEmpleoSolicitanteDO rc")
	})

public class DatosUltimoEmpleoSolicitanteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 699748667692961721L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
	@Column(name = "nombre_empresa", nullable = false)
	private String nombreEmpresa;
	
	@Column(name = "domicilio", nullable = false)
	private String domicilio;
	
	@Column(name = "telefonos", nullable = false)
	private String telefonos;
	
	@Column(name = "puesto_inicial", nullable = false)
	private String puestoInicial;
	
	@Column(name = "puesto_final", nullable = false)
	private String puestoFinal;
	
	@Column(name = "sueldo_inicial", nullable = false)
	private Double sueldoInicial;
	
	@Column(name = "sueldo_final", nullable = false)
	private Double sueldoFinal;
	
	@Column(name = "motivo_separacion", nullable = false)
	private String motivoSeparacion;
	
	@Column(name = "actividades_desempenadas", nullable = false)
	private String actividadesDesempenadas;
	
	@Column(name = "nombre_empresa_anterior", nullable = false)
	private String nombreEmpresaAnterior;
	
	@Column(name = "domicilio_anterior", nullable = false)
	private String domicilioAnterior;
	
	@Column(name = "telefonos_anterior", nullable = false)
	private String telefonosAnterior;
	
	@Column(name = "puesto_inicial_anterior", nullable = false)
	private String puestoInicialAnterior;
	
	
	@Column(name = "puesto_final_anterior", nullable = false)
	private String puestoFinalAnterior;
	
	@Column(name = "sueldo_inicial_anterior", nullable = false)
	private Double sueldoInicialAnterior;
	
	@Column(name = "sueldo_final_anterior", nullable = false)
	private Double sueldoFinalAnterior;
	
	@Column(name = "motivo_separacion_anterior", nullable = false)
	private String motivoSeparacionAnterior;
	
	@Column(name = "nombre_jefe_inmediato_anterior", nullable = false)
	private String nombreJefeInmediatoAnterior;
	
	@Column(name = "actividades_desempenadas_anterior", nullable = false)
	private String actividadesDesempenadasAnterior;

	public DatosUltimoEmpleoSolicitanteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosUltimoEmpleoSolicitanteDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			String nombreEmpresa, String domicilio, String telefonos,
			String puestoInicial, String puestoFinal, Double sueldoInicial,
			Double sueldoFinal, String motivoSeparacion,
			String actividadesDesempenadas, String nombreEmpresaAnterior,
			String domicilioAnterior, String telefonosAnterior,
			String puestoInicialAnterior, String puestoFinalAnterior,
			Double sueldoInicialAnterior, Double sueldoFinalAnterior,
			String motivoSeparacionAnterior,
			String nombreJefeInmediatoAnterior,
			String actividadesDesempenadasAnterior) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.nombreEmpresa = nombreEmpresa;
		this.domicilio = domicilio;
		this.telefonos = telefonos;
		this.puestoInicial = puestoInicial;
		this.puestoFinal = puestoFinal;
		this.sueldoInicial = sueldoInicial;
		this.sueldoFinal = sueldoFinal;
		this.motivoSeparacion = motivoSeparacion;
		this.actividadesDesempenadas = actividadesDesempenadas;
		this.nombreEmpresaAnterior = nombreEmpresaAnterior;
		this.domicilioAnterior = domicilioAnterior;
		this.telefonosAnterior = telefonosAnterior;
		this.puestoInicialAnterior = puestoInicialAnterior;
		this.puestoFinalAnterior = puestoFinalAnterior;
		this.sueldoInicialAnterior = sueldoInicialAnterior;
		this.sueldoFinalAnterior = sueldoFinalAnterior;
		this.motivoSeparacionAnterior = motivoSeparacionAnterior;
		this.nombreJefeInmediatoAnterior = nombreJefeInmediatoAnterior;
		this.actividadesDesempenadasAnterior = actividadesDesempenadasAnterior;
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
	 * @return the nombreEmpresa
	 */
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	/**
	 * @param nombreEmpresa the nombreEmpresa to set
	 */
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	/**
	 * @return the domicilio
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @return the telefonos
	 */
	public String getTelefonos() {
		return telefonos;
	}

	/**
	 * @param telefonos the telefonos to set
	 */
	public void setTelefonos(String telefonos) {
		this.telefonos = telefonos;
	}

	/**
	 * @return the puestoInicial
	 */
	public String getPuestoInicial() {
		return puestoInicial;
	}

	/**
	 * @param puestoInicial the puestoInicial to set
	 */
	public void setPuestoInicial(String puestoInicial) {
		this.puestoInicial = puestoInicial;
	}

	/**
	 * @return the puestoFinal
	 */
	public String getPuestoFinal() {
		return puestoFinal;
	}

	/**
	 * @param puestoFinal the puestoFinal to set
	 */
	public void setPuestoFinal(String puestoFinal) {
		this.puestoFinal = puestoFinal;
	}

	/**
	 * @return the sueldoInicial
	 */
	public Double getSueldoInicial() {
		return sueldoInicial;
	}

	/**
	 * @param sueldoInicial the sueldoInicial to set
	 */
	public void setSueldoInicial(Double sueldoInicial) {
		this.sueldoInicial = sueldoInicial;
	}

	/**
	 * @return the sueldoFinal
	 */
	public Double getSueldoFinal() {
		return sueldoFinal;
	}

	/**
	 * @param sueldoFinal the sueldoFinal to set
	 */
	public void setSueldoFinal(Double sueldoFinal) {
		this.sueldoFinal = sueldoFinal;
	}

	/**
	 * @return the motivoSeparacion
	 */
	public String getMotivoSeparacion() {
		return motivoSeparacion;
	}

	/**
	 * @param motivoSeparacion the motivoSeparacion to set
	 */
	public void setMotivoSeparacion(String motivoSeparacion) {
		this.motivoSeparacion = motivoSeparacion;
	}

	/**
	 * @return the actividadesDesempenadas
	 */
	public String getActividadesDesempenadas() {
		return actividadesDesempenadas;
	}

	/**
	 * @param actividadesDesempenadas the actividadesDesempenadas to set
	 */
	public void setActividadesDesempenadas(String actividadesDesempenadas) {
		this.actividadesDesempenadas = actividadesDesempenadas;
	}

	/**
	 * @return the nombreEmpresaAnterior
	 */
	public String getNombreEmpresaAnterior() {
		return nombreEmpresaAnterior;
	}

	/**
	 * @param nombreEmpresaAnterior the nombreEmpresaAnterior to set
	 */
	public void setNombreEmpresaAnterior(String nombreEmpresaAnterior) {
		this.nombreEmpresaAnterior = nombreEmpresaAnterior;
	}

	/**
	 * @return the domicilioAnterior
	 */
	public String getDomicilioAnterior() {
		return domicilioAnterior;
	}

	/**
	 * @param domicilioAnterior the domicilioAnterior to set
	 */
	public void setDomicilioAnterior(String domicilioAnterior) {
		this.domicilioAnterior = domicilioAnterior;
	}

	/**
	 * @return the telefonosAnterior
	 */
	public String getTelefonosAnterior() {
		return telefonosAnterior;
	}

	/**
	 * @param telefonosAnterior the telefonosAnterior to set
	 */
	public void setTelefonosAnterior(String telefonosAnterior) {
		this.telefonosAnterior = telefonosAnterior;
	}

	/**
	 * @return the puestoInicialAnterior
	 */
	public String getPuestoInicialAnterior() {
		return puestoInicialAnterior;
	}

	/**
	 * @param puestoInicialAnterior the puestoInicialAnterior to set
	 */
	public void setPuestoInicialAnterior(String puestoInicialAnterior) {
		this.puestoInicialAnterior = puestoInicialAnterior;
	}

	/**
	 * @return the puestoFinalAnterior
	 */
	public String getPuestoFinalAnterior() {
		return puestoFinalAnterior;
	}

	/**
	 * @param puestoFinalAnterior the puestoFinalAnterior to set
	 */
	public void setPuestoFinalAnterior(String puestoFinalAnterior) {
		this.puestoFinalAnterior = puestoFinalAnterior;
	}

	/**
	 * @return the sueldoInicialAnterior
	 */
	public Double getSueldoInicialAnterior() {
		return sueldoInicialAnterior;
	}

	/**
	 * @param sueldoInicialAnterior the sueldoInicialAnterior to set
	 */
	public void setSueldoInicialAnterior(Double sueldoInicialAnterior) {
		this.sueldoInicialAnterior = sueldoInicialAnterior;
	}

	/**
	 * @return the sueldoFinalAnterior
	 */
	public Double getSueldoFinalAnterior() {
		return sueldoFinalAnterior;
	}

	/**
	 * @param sueldoFinalAnterior the sueldoFinalAnterior to set
	 */
	public void setSueldoFinalAnterior(Double sueldoFinalAnterior) {
		this.sueldoFinalAnterior = sueldoFinalAnterior;
	}

	/**
	 * @return the motivoSeparacionAnterior
	 */
	public String getMotivoSeparacionAnterior() {
		return motivoSeparacionAnterior;
	}

	/**
	 * @param motivoSeparacionAnterior the motivoSeparacionAnterior to set
	 */
	public void setMotivoSeparacionAnterior(String motivoSeparacionAnterior) {
		this.motivoSeparacionAnterior = motivoSeparacionAnterior;
	}

	/**
	 * @return the nombreJefeInmediatoAnterior
	 */
	public String getNombreJefeInmediatoAnterior() {
		return nombreJefeInmediatoAnterior;
	}

	/**
	 * @param nombreJefeInmediatoAnterior the nombreJefeInmediatoAnterior to set
	 */
	public void setNombreJefeInmediatoAnterior(String nombreJefeInmediatoAnterior) {
		this.nombreJefeInmediatoAnterior = nombreJefeInmediatoAnterior;
	}

	/**
	 * @return the actividadesDesempenadasAnterior
	 */
	public String getActividadesDesempenadasAnterior() {
		return actividadesDesempenadasAnterior;
	}

	/**
	 * @param actividadesDesempenadasAnterior the actividadesDesempenadasAnterior to set
	 */
	public void setActividadesDesempenadasAnterior(
			String actividadesDesempenadasAnterior) {
		this.actividadesDesempenadasAnterior = actividadesDesempenadasAnterior;
	}
	
	
	
	
}
