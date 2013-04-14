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
	private Boolean inteligencia;
	
	@Column(name = "sociable", nullable = false)
	private Boolean sociable;
	
	@Column(name = "metodos_procedimientos", nullable = false)
	private Boolean metodosprocedimientos;
	
	@Column(name = "aspecto_fisico", nullable = false)
	private Boolean aspectofisico;
	
	@Column(name = "desenvolvimiento", nullable = false)
	private Boolean desenvolvimiento;
	
	@Column(name = "concentracion", nullable = false)
	private Boolean concentracion;
	
	@Column(name = "entusiasmo", nullable = false)
	private Boolean entusiasmo;
	
	@Column(name = "amabilidad", nullable = false)
	private Boolean amabilidad;
	
	@Column(name = "agresivo", nullable = false)
	private Boolean agresivo;
	
	@Column(name = "audaz", nullable = false)
	private Boolean lenguaje;
	
	@Column(name = "respecto_autoridad", nullable = false)
	private Boolean respectoAutoridad;
	
	@Column(name = "orden", nullable = false)
	private Boolean orden;

	public PerfilEscalaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfilEscalaDO(Integer id,
			SeleccionReclutamientoDO seleccionReclutamiento,
			Boolean inteligencia, Boolean sociable,
			Boolean metodosprocedimientos, Boolean aspectofisico,
			Boolean desenvolvimiento, Boolean concentracion,
			Boolean entusiasmo, Boolean amabilidad, Boolean agresivo,
			Boolean lenguaje, Boolean respectoAutoridad, Boolean orden) {
		super();
		this.id = id;
		this.seleccionReclutamiento = seleccionReclutamiento;
		this.inteligencia = inteligencia;
		this.sociable = sociable;
		this.metodosprocedimientos = metodosprocedimientos;
		this.aspectofisico = aspectofisico;
		this.desenvolvimiento = desenvolvimiento;
		this.concentracion = concentracion;
		this.entusiasmo = entusiasmo;
		this.amabilidad = amabilidad;
		this.agresivo = agresivo;
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

	public Boolean getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(Boolean inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Boolean getSociable() {
		return sociable;
	}

	public void setSociable(Boolean sociable) {
		this.sociable = sociable;
	}

	public Boolean getMetodosprocedimientos() {
		return metodosprocedimientos;
	}

	public void setMetodosprocedimientos(Boolean metodosprocedimientos) {
		this.metodosprocedimientos = metodosprocedimientos;
	}

	public Boolean getAspectofisico() {
		return aspectofisico;
	}

	public void setAspectofisico(Boolean aspectofisico) {
		this.aspectofisico = aspectofisico;
	}

	public Boolean getDesenvolvimiento() {
		return desenvolvimiento;
	}

	public void setDesenvolvimiento(Boolean desenvolvimiento) {
		this.desenvolvimiento = desenvolvimiento;
	}

	public Boolean getConcentracion() {
		return concentracion;
	}

	public void setConcentracion(Boolean concentracion) {
		this.concentracion = concentracion;
	}

	public Boolean getEntusiasmo() {
		return entusiasmo;
	}

	public void setEntusiasmo(Boolean entusiasmo) {
		this.entusiasmo = entusiasmo;
	}

	public Boolean getAmabilidad() {
		return amabilidad;
	}

	public void setAmabilidad(Boolean amabilidad) {
		this.amabilidad = amabilidad;
	}

	public Boolean getAgresivo() {
		return agresivo;
	}

	public void setAgresivo(Boolean agresivo) {
		this.agresivo = agresivo;
	}

	public Boolean getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(Boolean lenguaje) {
		this.lenguaje = lenguaje;
	}

	public Boolean getRespectoAutoridad() {
		return respectoAutoridad;
	}

	public void setRespectoAutoridad(Boolean respectoAutoridad) {
		this.respectoAutoridad = respectoAutoridad;
	}

	public Boolean getOrden() {
		return orden;
	}

	public void setOrden(Boolean orden) {
		this.orden = orden;
	}

	
	
	
	
}
