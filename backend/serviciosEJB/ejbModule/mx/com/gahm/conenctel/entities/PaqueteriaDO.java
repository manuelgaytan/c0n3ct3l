/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="Paqueteria")
@NamedQueries({
	@NamedQuery(name = "PaqueteriaDO.findAll", query = "select c from PaqueteriaDO c") })
public class PaqueteriaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3085560628152938712L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@OneToOne
	@JoinColumn(name = "fk_datos_escolares_habilidades", nullable = false)
	private DatosEscolaresHabilidadesDO datosEscolaresHabilidades;
	
	@Column(name="word")
	private Boolean word;
	
	@Column(name="power_point")
	private Boolean powerPoint;
	
	@Column(name="excel")
	private Boolean excel;
	
	@Column(name="publisher")
	private Boolean publisher;
	
	@Column(name="access")
	private Boolean access;
	
	
	@Column(name="outlook")
	private Boolean outlook;
	
	@Column(name="acrobat")
	private Boolean acrobat;
	
	@Column(name="coi")
	private Boolean coi;
	
	@Column(name="noi")
	private Boolean noi;
	
	@Column(name="sae")
	private Boolean sae;
	
	@Column(name="otros")
	private Boolean otros;

	public PaqueteriaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaqueteriaDO(long id,
			DatosEscolaresHabilidadesDO datosEscolaresHabilidades,
			Boolean word, Boolean powerPoint, Boolean excel, Boolean publisher,
			Boolean access, Boolean outlook, Boolean acrobat, Boolean coi,
			Boolean noi, Boolean sae, Boolean otros) {
		super();
		this.id = id;
		this.datosEscolaresHabilidades = datosEscolaresHabilidades;
		this.word = word;
		this.powerPoint = powerPoint;
		this.excel = excel;
		this.publisher = publisher;
		this.access = access;
		this.outlook = outlook;
		this.acrobat = acrobat;
		this.coi = coi;
		this.noi = noi;
		this.sae = sae;
		this.otros = otros;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the datosEscolaresHabilidades
	 */
	public DatosEscolaresHabilidadesDO getDatosEscolaresHabilidades() {
		return datosEscolaresHabilidades;
	}

	/**
	 * @param datosEscolaresHabilidades the datosEscolaresHabilidades to set
	 */
	public void setDatosEscolaresHabilidades(
			DatosEscolaresHabilidadesDO datosEscolaresHabilidades) {
		this.datosEscolaresHabilidades = datosEscolaresHabilidades;
	}

	/**
	 * @return the word
	 */
	public Boolean getWord() {
		return word;
	}

	/**
	 * @param word the word to set
	 */
	public void setWord(Boolean word) {
		this.word = word;
	}

	/**
	 * @return the powerPoint
	 */
	public Boolean getPowerPoint() {
		return powerPoint;
	}

	/**
	 * @param powerPoint the powerPoint to set
	 */
	public void setPowerPoint(Boolean powerPoint) {
		this.powerPoint = powerPoint;
	}

	/**
	 * @return the excel
	 */
	public Boolean getExcel() {
		return excel;
	}

	/**
	 * @param excel the excel to set
	 */
	public void setExcel(Boolean excel) {
		this.excel = excel;
	}

	/**
	 * @return the publisher
	 */
	public Boolean getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(Boolean publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the access
	 */
	public Boolean getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(Boolean access) {
		this.access = access;
	}

	/**
	 * @return the outlook
	 */
	public Boolean getOutlook() {
		return outlook;
	}

	/**
	 * @param outlook the outlook to set
	 */
	public void setOutlook(Boolean outlook) {
		this.outlook = outlook;
	}

	/**
	 * @return the acrobat
	 */
	public Boolean getAcrobat() {
		return acrobat;
	}

	/**
	 * @param acrobat the acrobat to set
	 */
	public void setAcrobat(Boolean acrobat) {
		this.acrobat = acrobat;
	}

	/**
	 * @return the coi
	 */
	public Boolean getCoi() {
		return coi;
	}

	/**
	 * @param coi the coi to set
	 */
	public void setCoi(Boolean coi) {
		this.coi = coi;
	}

	/**
	 * @return the noi
	 */
	public Boolean getNoi() {
		return noi;
	}

	/**
	 * @param noi the noi to set
	 */
	public void setNoi(Boolean noi) {
		this.noi = noi;
	}

	/**
	 * @return the sae
	 */
	public Boolean getSae() {
		return sae;
	}

	/**
	 * @param sae the sae to set
	 */
	public void setSae(Boolean sae) {
		this.sae = sae;
	}

	/**
	 * @return the otros
	 */
	public Boolean getOtros() {
		return otros;
	}

	/**
	 * @param otros the otros to set
	 */
	public void setOtros(Boolean otros) {
		this.otros = otros;
	}
	
	
	
}
