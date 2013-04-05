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
 * @author MHDolores
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "LicenciaDO.findAll", query = "select c from LicenciaDO c") })
@Table(name="Licencia")
public class LicenciaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3744223441472558172L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "vigencia", nullable = false, length = 10)
	private Date vigencia;
	
	@Column(name = "numero_licencia", nullable = false)
	private String numeroLicencia;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_licencia", nullable = false)
	private TipoLicenciaDO tipoLicencia;

	public LicenciaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LicenciaDO(Integer id, Date vigencia, String numeroLicencia,
			TipoLicenciaDO tipoLicencia) {
		super();
		this.id = id;
		this.vigencia = vigencia;
		this.numeroLicencia = numeroLicencia;
		this.tipoLicencia = tipoLicencia;
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
	 * @return the vigencia
	 */
	public Date getVigencia() {
		return vigencia;
	}

	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	/**
	 * @return the numeroLicencia
	 */
	public String getNumeroLicencia() {
		return numeroLicencia;
	}

	/**
	 * @param numeroLicencia the numeroLicencia to set
	 */
	public void setNumeroLicencia(String numeroLicencia) {
		this.numeroLicencia = numeroLicencia;
	}

	/**
	 * @return the tipoLicencia
	 */
	public TipoLicenciaDO getTipoLicencia() {
		return tipoLicencia;
	}

	/**
	 * @param tipoLicencia the tipoLicencia to set
	 */
	public void setTipoLicencia(TipoLicenciaDO tipoLicencia) {
		this.tipoLicencia = tipoLicencia;
	}
	
	

	
}
