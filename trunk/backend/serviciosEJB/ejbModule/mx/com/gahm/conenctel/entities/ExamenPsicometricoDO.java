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
@Table(name = "ExamenPsicometrico")
@NamedQueries({
	@NamedQuery(name = "ExamenPsicometricoDO.findAll", query = "select rc from ExamenPsicometricoDO rc")
	})
public class ExamenPsicometricoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531576253869440048L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_seleccion_reclutamiento", nullable = false)
	private SeleccionReclutamientoDO seleccionReclutamiento;
	
	@Column(name = "raven_army_beta", nullable = false)
	private Boolean ravenArmyBeta;
	
	
	@Column(name = "figura_humana", nullable = false)
	private Boolean figuraHumana;
	
	@Column(name = "arbol", nullable = false)
	private Boolean arbol;
	
	@Column(name = "casa", nullable = false)
	private Boolean casa;
	
	@Column(name = "grafologia", nullable = false)
	private Boolean grafologia;
	
	@Column(name = "cleaver", nullable = false)
	private Boolean cleaver;
	
	@Column(name = "frases_incompletas", nullable = false)
	private Boolean frasesIncompletas;
	
	@Column(name = "therman", nullable = false)
	private Boolean therman;
	
	@Column(name = "dominos", nullable = false)
	private Boolean dominos;

	public ExamenPsicometricoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamenPsicometricoDO(Integer id,
			SeleccionReclutamientoDO seleccionReclutamiento,
			Boolean ravenArmyBeta, Boolean figuraHumana, Boolean arbol,
			Boolean casa, Boolean grafologia, Boolean cleaver,
			Boolean frasesIncompletas, Boolean therman, Boolean dominos) {
		super();
		this.id = id;
		this.seleccionReclutamiento = seleccionReclutamiento;
		this.ravenArmyBeta = ravenArmyBeta;
		this.figuraHumana = figuraHumana;
		this.arbol = arbol;
		this.casa = casa;
		this.grafologia = grafologia;
		this.cleaver = cleaver;
		this.frasesIncompletas = frasesIncompletas;
		this.therman = therman;
		this.dominos = dominos;
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

	public Boolean getRavenArmyBeta() {
		return ravenArmyBeta;
	}

	public void setRavenArmyBeta(Boolean ravenArmyBeta) {
		this.ravenArmyBeta = ravenArmyBeta;
	}

	public Boolean getFiguraHumana() {
		return figuraHumana;
	}

	public void setFiguraHumana(Boolean figuraHumana) {
		this.figuraHumana = figuraHumana;
	}

	public Boolean getArbol() {
		return arbol;
	}

	public void setArbol(Boolean arbol) {
		this.arbol = arbol;
	}

	public Boolean getCasa() {
		return casa;
	}

	public void setCasa(Boolean casa) {
		this.casa = casa;
	}

	public Boolean getGrafologia() {
		return grafologia;
	}

	public void setGrafologia(Boolean grafologia) {
		this.grafologia = grafologia;
	}

	public Boolean getCleaver() {
		return cleaver;
	}

	public void setCleaver(Boolean cleaver) {
		this.cleaver = cleaver;
	}

	public Boolean getFrasesIncompletas() {
		return frasesIncompletas;
	}

	public void setFrasesIncompletas(Boolean frasesIncompletas) {
		this.frasesIncompletas = frasesIncompletas;
	}

	public Boolean getTherman() {
		return therman;
	}

	public void setTherman(Boolean therman) {
		this.therman = therman;
	}

	public Boolean getDominos() {
		return dominos;
	}

	public void setDominos(Boolean dominos) {
		this.dominos = dominos;
	}
	

}
