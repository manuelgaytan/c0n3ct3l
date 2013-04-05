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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "DireccionSolicitante")
@NamedQueries({
	@NamedQuery(name = "DireccionSolicitanteDO.findAll", query = "select rc from DireccionSolicitanteDO rc")
	})

public class DireccionSolicitanteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -320550429352243583L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "calle_numero", nullable = false)
	private String calleNumero;
	
	@Column(name = "colonia", nullable = false)
	private String colonia;
	
	@Column(name = "codigo_postal", nullable = false)
	private String codigoPostal;
	
	@Column(name = "delegacion_municipio", nullable = false)
	private String delegacionMunicipio;
	
	@Column(name = "entidad_federativa", nullable = false)
	private String entidadFederativa;

	public DireccionSolicitanteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DireccionSolicitanteDO(Integer id, String calleNumero,
			String colonia, String codigoPostal, String delegacionMunicipio,
			String entidadFederativa) {
		super();
		this.id = id;
		this.calleNumero = calleNumero;
		this.colonia = colonia;
		this.codigoPostal = codigoPostal;
		this.delegacionMunicipio = delegacionMunicipio;
		this.entidadFederativa = entidadFederativa;
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
	 * @return the calleNumero
	 */
	public String getCalleNumero() {
		return calleNumero;
	}

	/**
	 * @param calleNumero the calleNumero to set
	 */
	public void setCalleNumero(String calleNumero) {
		this.calleNumero = calleNumero;
	}

	/**
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the codigoPostal
	 */
	public String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * @return the delegacionMunicipio
	 */
	public String getDelegacionMunicipio() {
		return delegacionMunicipio;
	}

	/**
	 * @param delegacionMunicipio the delegacionMunicipio to set
	 */
	public void setDelegacionMunicipio(String delegacionMunicipio) {
		this.delegacionMunicipio = delegacionMunicipio;
	}

	/**
	 * @return the entidadFederativa
	 */
	public String getEntidadFederativa() {
		return entidadFederativa;
	}

	/**
	 * @param entidadFederativa the entidadFederativa to set
	 */
	public void setEntidadFederativa(String entidadFederativa) {
		this.entidadFederativa = entidadFederativa;
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
