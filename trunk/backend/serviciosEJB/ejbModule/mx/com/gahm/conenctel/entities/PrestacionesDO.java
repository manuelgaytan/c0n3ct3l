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
@Table(name = "Prestaciones")
@NamedQueries({
	@NamedQuery(name = "PrestacionesDO.findAll", query = "select rc from PrestacionesDO rc")
	})
public class PrestacionesDO implements Serializable{

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
	
	@Column(name = "seguro_social", nullable = false)
	private Boolean seguroSocial;
	
	@Column(name = "vacaciones", nullable = false)
	private Boolean vacaciones;
	
	@Column(name = "aguinaldo", nullable = false)
	private Boolean aguinaldo;
	
	@Column(name = "utilidades", nullable = false)
	private Boolean utilidades;
	
	@Column(name = "fonacot", nullable = false)
	private Boolean fonacot;
	
	@Column(name = "infonavit", nullable = false)
	private Boolean infonavit;
	
	@Column(name = "prima_vacacional", nullable = false)
	private Boolean primaVacacional;
	
	public PrestacionesDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PrestacionesDO(Integer id, ContratacionDO contratacion,
			Boolean seguroSocial, Boolean vacaciones,
			Boolean aguinaldo, Boolean utilidades,
			Boolean fonacot, Boolean infonavit, Boolean primaVacacional) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.seguroSocial = seguroSocial;
		this.vacaciones = vacaciones;
		this.aguinaldo = aguinaldo;
		this.utilidades = utilidades;
		this.fonacot = fonacot;
		this.infonavit = infonavit;
		this.primaVacacional = primaVacacional;
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


	public Boolean getSeguroSocial() {
		return seguroSocial;
	}


	public void setSeguroSocial(Boolean seguroSocial) {
		this.seguroSocial = seguroSocial;
	}


	public Boolean getVacaciones() {
		return vacaciones;
	}


	public void setVacaciones(Boolean vacaciones) {
		this.vacaciones = vacaciones;
	}


	public Boolean getAguinaldo() {
		return aguinaldo;
	}


	public void setAguinaldo(Boolean aguinaldo) {
		this.aguinaldo = aguinaldo;
	}


	public Boolean getUtilidades() {
		return utilidades;
	}


	public void setUtilidades(Boolean utilidades) {
		this.utilidades = utilidades;
	}


	public Boolean getFonacot() {
		return fonacot;
	}


	public void setFonacot(Boolean fonacot) {
		this.fonacot = fonacot;
	}


	public Boolean getInfonavit() {
		return infonavit;
	}


	public void setInfonavit(Boolean infonavit) {
		this.infonavit = infonavit;
	}


	public Boolean getPrimaVacacional() {
		return primaVacacional;
	}


	public void setPrimaVacacional(Boolean primaVacacional) {
		this.primaVacacional = primaVacacional;
	}
}
