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
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "EquipoOficinaDomina")
@NamedQueries({
	@NamedQuery(name = "EquipoOficinaDominaDO.findAll", query = "select rc from EquipoOficinaDominaDO rc")
	})
public class EquipoOficinaDominaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4003846544048748865L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_datos_escolares_habilidades", nullable = false)
	private DatosEscolaresHabilidadesDO datosEscolaresHabilidades;
	
	@Column(name = "pc", nullable = false)
	private Boolean pc;
	
	@Column(name = "calculadora", nullable = false)
	private Boolean calculadora;
	
	@Column(name = "fax", nullable = false)
	private Boolean fax;
	
	@Column(name = "impresora", nullable = false)
	private Boolean impresora;
	
	@Column(name = "telefono", nullable = false)
	private Boolean telefono;
	
	@Column(name = "scanner", nullable = false)
	private Boolean scanner;
	
	@Column(name = "tablet", nullable = false)
	private Boolean tablet;
	
	@Column(name = "laptop", nullable = false)
	private Boolean laptop;
	
	@Column(name = "otros", nullable = false)
	private Boolean otros;
	
	
	
	
	
	
	
	
	
}
