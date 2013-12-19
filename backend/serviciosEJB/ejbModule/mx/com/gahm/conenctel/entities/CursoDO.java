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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "Curso")
@NamedQueries({
	@NamedQuery(name = "CursoDO.findAll", query = "select rc from CursoDO rc")
	})
public class CursoDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2343774782400450138L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private ContratacionDO contratacion;
	
	@Column(name = "induccion1", nullable = false)
	private Boolean induccion1;
	
	@Column(name = "induccion2", nullable = false)
	private Boolean induccion2;
	
	@Column(name = "induccion3", nullable = false)
	private Boolean induccion3;
	
	@Column(name = "induccion4", nullable = false)
	private Boolean induccion4;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_enc")
	private Date fechaEnc;
	
	@Column(name = "resultado_enc", nullable = false)
	private Double resultadoEnc;
	
	@Column(name = "enc", nullable = false)
	private Boolean enc;
	
	@Column(name = "curso_tecnico", nullable = false)
	private String cursoTecnico;
	
	@Column(name = "capacitador_interno_ct", nullable = false)
	private String capacitadorInternoCt;
	
	@Column(name = "capacitador_externo_ct", nullable = false)
	private String capacitadorExternoCt;
	
	@Column(name = "autorizacion_ct", nullable = false)
	private Boolean autorizacionCt;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ct")
	private Date fechaCt;
	
	@Column(name = "resultado_ct", nullable = false)
	private Double resultadoCt;
	

	@Column(name = "curso_general", nullable = false)
	private String cursoGeneral;
	
	@Column(name = "capacitador_interno_cg", nullable = false)
	private String capacitadorInternoCg;
	
	@Column(name = "capacitador_externo_cg", nullable = false)
	private String capacitadorExternoCg;
	
	@Column(name = "autorizacion_cg", nullable = false)
	private Boolean autorizacionCg;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cg")
	private Date fechaCg;
	
	@Column(name = "resultado_cg", nullable = false)
	private Double resultadoCg;

	public CursoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CursoDO(Integer id, ContratacionDO contratacion, Date fechaEnc,
			Double resultadoEnc, Boolean enc, String cursoTecnico,
			String capacitadorInternoCt, String capacitadorExternoCt,
			Boolean autorizacionCt, Date fechaCt, Double resultadoCt,
			String cursoGeneral, String capacitadorInternoCg,
			String capacitadorExternoCg, Boolean autorizacionCg, Date fechaC,
			Double resultadoCg) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.fechaEnc = fechaEnc;
		this.resultadoEnc = resultadoEnc;
		this.enc = enc;
		this.cursoTecnico = cursoTecnico;
		this.capacitadorInternoCt = capacitadorInternoCt;
		this.capacitadorExternoCt = capacitadorExternoCt;
		this.autorizacionCt = autorizacionCt;
		this.fechaCt = fechaCt;
		this.resultadoCt = resultadoCt;
		this.cursoGeneral = cursoGeneral;
		this.capacitadorInternoCg = capacitadorInternoCg;
		this.capacitadorExternoCg = capacitadorExternoCg;
		this.autorizacionCg = autorizacionCg;
		this.fechaCg = fechaC;
		this.resultadoCg = resultadoCg;
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
	 * @return the contratacion
	 */
	public ContratacionDO getContratacion() {
		return contratacion;
	}

	/**
	 * @param contratacion the contratacion to set
	 */
	public void setContratacion(ContratacionDO contratacion) {
		this.contratacion = contratacion;
	}

	public Boolean getInduccion1() {
		return induccion1;
	}

	public void setInduccion1(Boolean induccion1) {
		this.induccion1 = induccion1;
	}

	public Boolean getInduccion2() {
		return induccion2;
	}

	public void setInduccion2(Boolean induccion2) {
		this.induccion2 = induccion2;
	}

	public Boolean getInduccion3() {
		return induccion3;
	}

	public void setInduccion3(Boolean induccion3) {
		this.induccion3 = induccion3;
	}

	public Boolean getInduccion4() {
		return induccion4;
	}

	public void setInduccion4(Boolean induccion4) {
		this.induccion4 = induccion4;
	}

	/**
	 * @return the fechaEnc
	 */
	public Date getFechaEnc() {
		return fechaEnc;
	}

	/**
	 * @param fechaEnc the fechaEnc to set
	 */
	public void setFechaEnc(Date fechaEnc) {
		this.fechaEnc = fechaEnc;
	}

	/**
	 * @return the resultadoEnc
	 */
	public Double getResultadoEnc() {
		return resultadoEnc;
	}

	/**
	 * @param resultadoEnc the resultadoEnc to set
	 */
	public void setResultadoEnc(Double resultadoEnc) {
		this.resultadoEnc = resultadoEnc;
	}

	/**
	 * @return the enc
	 */
	public Boolean getEnc() {
		return enc;
	}

	/**
	 * @param enc the enc to set
	 */
	public void setEnc(Boolean enc) {
		this.enc = enc;
	}

	/**
	 * @return the cursoTecnico
	 */
	public String getCursoTecnico() {
		return cursoTecnico;
	}

	/**
	 * @param cursoTecnico the cursoTecnico to set
	 */
	public void setCursoTecnico(String cursoTecnico) {
		this.cursoTecnico = cursoTecnico;
	}

	/**
	 * @return the capacitadorInternoCt
	 */
	public String getCapacitadorInternoCt() {
		return capacitadorInternoCt;
	}

	/**
	 * @param capacitadorInternoCt the capacitadorInternoCt to set
	 */
	public void setCapacitadorInternoCt(String capacitadorInternoCt) {
		this.capacitadorInternoCt = capacitadorInternoCt;
	}

	/**
	 * @return the capacitadorExternoCt
	 */
	public String getCapacitadorExternoCt() {
		return capacitadorExternoCt;
	}

	/**
	 * @param capacitadorExternoCt the capacitadorExternoCt to set
	 */
	public void setCapacitadorExternoCt(String capacitadorExternoCt) {
		this.capacitadorExternoCt = capacitadorExternoCt;
	}

	/**
	 * @return the autorizacionCt
	 */
	public Boolean getAutorizacionCt() {
		return autorizacionCt;
	}

	/**
	 * @param autorizacionCt the autorizacionCt to set
	 */
	public void setAutorizacionCt(Boolean autorizacionCt) {
		this.autorizacionCt = autorizacionCt;
	}

	/**
	 * @return the fechaCt
	 */
	public Date getFechaCt() {
		return fechaCt;
	}

	/**
	 * @param fechaCt the fechaCt to set
	 */
	public void setFechaCt(Date fechaCt) {
		this.fechaCt = fechaCt;
	}

	/**
	 * @return the resultadoCt
	 */
	public Double getResultadoCt() {
		return resultadoCt;
	}

	/**
	 * @param resultadoCt the resultadoCt to set
	 */
	public void setResultadoCt(Double resultadoCt) {
		this.resultadoCt = resultadoCt;
	}

	/**
	 * @return the cursoGeneral
	 */
	public String getCursoGeneral() {
		return cursoGeneral;
	}

	/**
	 * @param cursoGeneral the cursoGeneral to set
	 */
	public void setCursoGeneral(String cursoGeneral) {
		this.cursoGeneral = cursoGeneral;
	}

	/**
	 * @return the capacitadorInternoCg
	 */
	public String getCapacitadorInternoCg() {
		return capacitadorInternoCg;
	}

	/**
	 * @param capacitadorInternoCg the capacitadorInternoCg to set
	 */
	public void setCapacitadorInternoCg(String capacitadorInternoCg) {
		this.capacitadorInternoCg = capacitadorInternoCg;
	}

	/**
	 * @return the capacitadorExternoCg
	 */
	public String getCapacitadorExternoCg() {
		return capacitadorExternoCg;
	}

	/**
	 * @param capacitadorExternoCg the capacitadorExternoCg to set
	 */
	public void setCapacitadorExternoCg(String capacitadorExternoCg) {
		this.capacitadorExternoCg = capacitadorExternoCg;
	}

	/**
	 * @return the autorizacionCg
	 */
	public Boolean getAutorizacionCg() {
		return autorizacionCg;
	}

	/**
	 * @param autorizacionCg the autorizacionCg to set
	 */
	public void setAutorizacionCg(Boolean autorizacionCg) {
		this.autorizacionCg = autorizacionCg;
	}

	/**
	 * @return the fechaC
	 */
	public Date getFechaCg() {
		return fechaCg;
	}

	/**
	 * @param fechaC the fechaC to set
	 */
	public void setFechaCg(Date fechaC) {
		this.fechaCg = fechaC;
	}

	/**
	 * @return the resultadoCg
	 */
	public Double getResultadoCg() {
		return resultadoCg;
	}

	/**
	 * @param resultadoCg the resultadoCg to set
	 */
	public void setResultadoCg(Double resultadoCg) {
		this.resultadoCg = resultadoCg;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
