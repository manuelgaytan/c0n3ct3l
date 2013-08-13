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
@Table(name = "DocumentosContratacion")
@NamedQueries({
	@NamedQuery(name = "DocumentosContratacionDO.findAll", query = "select rc from DocumentosContratacionDO rc")
	})
public class DocumentosContratacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370563711213144595L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private ContratacionDO contratacion;
	
	@Column(name = "ife", nullable = false)
	private Boolean ife;
	
	@Column(name = "acta_nacimiento", nullable = false)
	private Boolean actaNacimiento;
	
	@Column(name = "comprobante_domicilio", nullable = false)
	private Boolean comprobanteDomicilio;
	
	@Column(name = "curp", nullable = false)
	private Boolean curp;
	
	@Column(name = "rfc", nullable = false)
	private Boolean rfc;
	
	@Column(name = "nss", nullable = false)
	private Boolean nss;
	
	@Column(name = "comprobante_estudios_certificacion", nullable = false)
	private Boolean comprobanteEstudiosCertificacion;
	
	@Column(name = "carta_militar", nullable = false)
	private Boolean cartaMilitar;
	
	@Column(name = "licencia", nullable = false)
	private Boolean licencia;
	
	@Column(name = "carta_antecedentes_no_penales", nullable = false)
	private Boolean cartaAntecedentesNoPenales;
	
	
	@Column(name = "certificado_medico", nullable = false)
	private Boolean certificadoMedico;
	
	@Column(name = "cartas_recomendacion", nullable = false)
	private Boolean cartasRecomendacion;
	
	@Column(name = "curriculum", nullable = false)
	private Boolean curriculum;
	
	@Column(name = "fm2_fm3", nullable = false)
	private Boolean fm2Fm3;
	
	@Column(name = "fotografia", nullable = false)
	private Boolean fotografia;
	
	
	public DocumentosContratacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DocumentosContratacionDO(Integer id, ContratacionDO contratacion,
			Boolean ife, Boolean actaNacimiento, Boolean comprobanteDomicilio,
			Boolean curp, Boolean rfc, Boolean nss,
			Boolean comprobanteEstudiosCertificacion, Boolean cartaMilitar,
			Boolean licencia, Boolean cartaAntecedentesNoPenales,
			Boolean certificadoMedico, Boolean cartasRecomendacion,
			Boolean curriculum, Boolean fm2Fm3, Boolean fotografia) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.ife = ife;
		this.actaNacimiento = actaNacimiento;
		this.comprobanteDomicilio = comprobanteDomicilio;
		this.curp = curp;
		this.rfc = rfc;
		this.nss = nss;
		this.comprobanteEstudiosCertificacion = comprobanteEstudiosCertificacion;
		this.cartaMilitar = cartaMilitar;
		this.licencia = licencia;
		this.cartaAntecedentesNoPenales = cartaAntecedentesNoPenales;
		this.certificadoMedico = certificadoMedico;
		this.cartasRecomendacion = cartasRecomendacion;
		this.curriculum = curriculum;
		this.fm2Fm3 = fm2Fm3;
		this.fotografia = fotografia;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public ContratacionDO getContratacion() {
		return contratacion;
	}


	public void setContratacion(ContratacionDO contratacion) {
		this.contratacion = contratacion;
	}


	public Boolean getIfe() {
		return ife;
	}


	public void setIfe(Boolean ife) {
		this.ife = ife;
	}


	public Boolean getActaNacimiento() {
		return actaNacimiento;
	}


	public void setActaNacimiento(Boolean actaNacimiento) {
		this.actaNacimiento = actaNacimiento;
	}


	public Boolean getComprobanteDomicilio() {
		return comprobanteDomicilio;
	}


	public void setComprobanteDomicilio(Boolean comprobanteDomicilio) {
		this.comprobanteDomicilio = comprobanteDomicilio;
	}


	public Boolean getCurp() {
		return curp;
	}


	public void setCurp(Boolean curp) {
		this.curp = curp;
	}


	public Boolean getRfc() {
		return rfc;
	}


	public void setRfc(Boolean rfc) {
		this.rfc = rfc;
	}


	public Boolean getNss() {
		return nss;
	}


	public void setNss(Boolean nss) {
		this.nss = nss;
	}


	public Boolean getComprobanteEstudiosCertificacion() {
		return comprobanteEstudiosCertificacion;
	}


	public void setComprobanteEstudiosCertificacion(
			Boolean comprobanteEstudiosCertificacion) {
		this.comprobanteEstudiosCertificacion = comprobanteEstudiosCertificacion;
	}


	public Boolean getCartaMilitar() {
		return cartaMilitar;
	}


	public void setCartaMilitar(Boolean cartaMilitar) {
		this.cartaMilitar = cartaMilitar;
	}


	public Boolean getLicencia() {
		return licencia;
	}


	public void setLicencia(Boolean licencia) {
		this.licencia = licencia;
	}


	public Boolean getCartaAntecedentesNoPenales() {
		return cartaAntecedentesNoPenales;
	}


	public void setCartaAntecedentesNoPenales(Boolean cartaAntecedentesNoPenales) {
		this.cartaAntecedentesNoPenales = cartaAntecedentesNoPenales;
	}


	public Boolean getCertificadoMedico() {
		return certificadoMedico;
	}


	public void setCertificadoMedico(Boolean certificadoMedico) {
		this.certificadoMedico = certificadoMedico;
	}


	public Boolean getCartasRecomendacion() {
		return cartasRecomendacion;
	}


	public void setCartasRecomendacion(Boolean cartasRecomendacion) {
		this.cartasRecomendacion = cartasRecomendacion;
	}


	public Boolean getCurriculum() {
		return curriculum;
	}


	public void setCurriculum(Boolean curriculum) {
		this.curriculum = curriculum;
	}


	public Boolean getFm2Fm3() {
		return fm2Fm3;
	}


	public void setFm2Fm3(Boolean fm2Fm3) {
		this.fm2Fm3 = fm2Fm3;
	}


	public Boolean getFotografia() {
		return fotografia;
	}


	public void setFotografia(Boolean fotografia) {
		this.fotografia = fotografia;
	}
	
	
	
	
	
	
	

}
