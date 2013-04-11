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
 * @author GUILLERMO
 * 
 */
@Entity
@Table(name = "NoConformidad")
@NamedQueries({
	@NamedQuery(name = "NoConformidadDO.findAll", query = "select rc from NoConformidadDO rc")
	})
public class NoConformidadDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786985295227197223L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "fk_area_levanta_no_conformidad", nullable = false)
	private AreaLevantaNoConformidadDO areaLevantaNoConformidad;

	@ManyToOne
	@JoinColumn(name = "fk_usuario", nullable = false)
	private UsuarioDO usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_suceso", nullable = false, length = 10)
	private Date fechaSuceso;

	@Column(name = "area_nombre_se_levanta", nullable = false)
	private String areaNombreSeLevanta;
	@Column(name = "suceso_evento", nullable = false)
	private String sucesoEvento;
	@Column(name = "donde_ocurrio", nullable = false)
	private String dondeOcurrio;
	@Column(name = "cuanto_afecto", nullable = false)
	private String cuantoAfecto;
	@Column(name = "causas", nullable = false)
	private String causas;
	@Column(name = "correccion", nullable = false)
	private String correccion;
	@Column(name = "observaciones", nullable = false)
	private String observaciones;
	@Column(name = "requiere_accion_correctiva", nullable = false)
	private Boolean requiereAccionCorrectiva;

}
