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
 * @author SEVEN
 * 
 */
@Entity
@Table(name = "PerfilEscala")
@NamedQueries({
	@NamedQuery(name = "PerfilEscalaDO.findAll", query = "select rc from PerfilEscalaDO rc")
	})
public class PerfilEscalaDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6635250350774116155L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "fk_seleccion_reclutamiento", nullable = false)
	private SeleccionReclutamientoDO seleccionReclutamiento;

	@Column(name = "inteligencia", nullable = false)
	private Integer inteligencia;
	
	@Column(name = "sociable", nullable = false)
	private Integer sociable;
	
	@Column(name = "metodos_procedimientos", nullable = false)
	private Integer metodosProcedimientos;
	
	@Column(name = "aspecto_fisico", nullable = false)
	private Integer aspectoFisico;
	
	@Column(name = "desenvolvimiento", nullable = false)
	private Integer desenvolvimiento;
	
	@Column(name = "concentracion", nullable = false)
	private Integer concentracion;
	
	@Column(name = "entusiasmo", nullable = false)
	private Integer entusiasmo;
	
	@Column(name = "amabilidad", nullable = false)
	private Integer amabilidad;
	
	@Column(name = "agresivo", nullable = false)
	private Integer agresivo;
	
	@Column(name = "audaz", nullable = false)
	private Integer audaz;
	
	@Column(name = "lenguaje", nullable = false)
	private Integer lenguaje;
	
	@Column(name = "respecto_autoridad", nullable = false)
	private Integer respectoAutoridad;
	
	@Column(name = "orden", nullable = false)
	private Integer orden;

	public PerfilEscalaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfilEscalaDO(Integer id,
			SeleccionReclutamientoDO seleccionReclutamiento,
			Integer inteligencia, Integer sociable,
			Integer metodosProcedimientos, Integer aspectofisico,
			Integer desenvolvimiento, Integer concentracion,
			Integer entusiasmo, Integer amabilidad, Integer agresivo, Integer audaz,
			Integer lenguaje, Integer respectoAutoridad, Integer orden) {
		super();
		this.id = id;
		this.seleccionReclutamiento = seleccionReclutamiento;
		this.inteligencia = inteligencia;
		this.sociable = sociable;
		this.metodosProcedimientos = metodosProcedimientos;
		this.aspectoFisico = aspectofisico;
		this.desenvolvimiento = desenvolvimiento;
		this.concentracion = concentracion;
		this.entusiasmo = entusiasmo;
		this.amabilidad = amabilidad;
		this.agresivo = agresivo;
		this.audaz = audaz;
		this.lenguaje = lenguaje;
		this.respectoAutoridad = respectoAutoridad;
		this.orden = orden;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SeleccionReclutamientoDO getSeleccionReclutamiento() {
		return seleccionReclutamiento;
	}

	public void setSeleccionReclutamiento(
			SeleccionReclutamientoDO seleccionReclutamiento) {
		this.seleccionReclutamiento = seleccionReclutamiento;
	}

	public Integer getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Integer inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Integer getSociable() {
		return sociable;
	}

	public void setSociable(Integer sociable) {
		this.sociable = sociable;
	}

	public Integer getMetodosProcedimientos() {
		return metodosProcedimientos;
	}

	public void setMetodosProcedimientos(Integer metodosProcedimientos) {
		this.metodosProcedimientos = metodosProcedimientos;
	}

	public Integer getAspectoFisico() {
		return aspectoFisico;
	}

	public void setAspectoFisico(Integer aspectofisico) {
		this.aspectoFisico = aspectofisico;
	}

	public Integer getDesenvolvimiento() {
		return desenvolvimiento;
	}

	public void setDesenvolvimiento(Integer desenvolvimiento) {
		this.desenvolvimiento = desenvolvimiento;
	}

	public Integer getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(Integer concentracion) {
		this.concentracion = concentracion;
	}

	public Integer getEntusiasmo() {
		return entusiasmo;
	}

	public void setEntusiasmo(Integer entusiasmo) {
		this.entusiasmo = entusiasmo;
	}

	public Integer getAmabilidad() {
		return amabilidad;
	}

	public void setAmabilidad(Integer amabilidad) {
		this.amabilidad = amabilidad;
	}

	public Integer getAgresivo() {
		return agresivo;
	}

	public void setAgresivo(Integer agresivo) {
		this.agresivo = agresivo;
	}
	
	public Integer getAudaz() {
		return audaz;
	}

	public void setAudaz(Integer audaz) {
		this.audaz = audaz;
	}

	public Integer getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(Integer lenguaje) {
		this.lenguaje = lenguaje;
	}

	public Integer getRespectoAutoridad() {
		return respectoAutoridad;
	}

	public void setRespectoAutoridad(Integer respectoAutoridad) {
		this.respectoAutoridad = respectoAutoridad;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	
	
	
	
}
