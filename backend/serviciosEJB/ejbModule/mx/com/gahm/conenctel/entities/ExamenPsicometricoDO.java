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
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;
	
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
	

}
