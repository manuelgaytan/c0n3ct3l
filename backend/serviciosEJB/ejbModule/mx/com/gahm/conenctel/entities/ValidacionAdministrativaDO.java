package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@NamedQueries({
	@NamedQuery(name = "ValidacionAdministrativaDO.findAll", query = "select c from ValidacionAdministrativaDO c"),
	@NamedQuery(name = "ValidacionAdministrativaDO.getAllByWithOutInvoice", query = "select v from ValidacionAdministrativaDO v where v.id not in (select i.validacionAdministrativa.id from InformacionFacturacionDO i)")})
@Table(name="ValidacionAdministrativa")
public class ValidacionAdministrativaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8732419770838531681L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_estado_validacion_administrativa")
	private EstadoValidacionAdministrativaDO estadoValidacionAdministrativa;
	
	@ManyToOne
	@JoinColumn(name="fk_tipo_validacion_administrativa")
	private TipoValidacionAdministrativaDO tipoValidacionAdministrativa;

	@Column(name="porcentaje_1")
	private Double porcentaje1;
	
	@Column(name="clave_validacion_1")
	private String claveValidacion1;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_validacion_1")
	private Date fechaValidacion1;
	
	@ManyToOne
	@JoinColumn(name="fk_estado_validacion_cobro_1")
	private EstadoValidacionCobroDO etadoValidacionCobro1;
	
	@Column(name="porcentaje_2")
	private Double porcentaje2;
	
	@Column(name="clave_validacion_2")
	private String claveValidacion2;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_validacion_2")
	private Date fechaValidacion2;
	
	@ManyToOne
	@JoinColumn(name="fk_estado_validacion_cobro_2")
	private EstadoValidacionCobroDO etadoValidacionCobro2;
	
	@Column(name="porcentaje_3")
	private Double porcentaje3;
	
	@Column(name="clave_validacion_3")
	private String claveValidacion3;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_validacion_3")
	private Date fechaValidacion3;
	
	@ManyToOne
	@JoinColumn(name="fk_estado_validacion_cobro_3")
	private EstadoValidacionCobroDO etadoValidacionCobro3;
	
	@Column(name="porcentaje_total_cobro")
	private Double porcentajeTotalCobro;
	
	
	@ManyToOne
	@JoinColumn(name="fk_estado_final_validacion")
	private EstadoFinalValidacionDO etadoValidacionFinal;
	
	@ManyToOne
	@JoinColumn(name="fk_imputable")
	private ImputableDO imputable;
	
	
	@OneToMany(mappedBy="validacionAdministrativa", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ComentarioPantallaValidacionAdministrativaDO> comentariosPantallaValidacionAdministrativa;
   	
	@OneToOne  
	@JoinColumn(name = "fk_proyecto_padre") 
	private ProyectoPadreDO proyectoPadre;
	@OneToOne  
	@JoinColumn(name = "fk_proyecto") 
	private ProyectoDO proyecto;
	
	public ValidacionAdministrativaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValidacionAdministrativaDO(Long id,
			EstadoValidacionAdministrativaDO estadoValidacionAdministrativa,
			TipoValidacionAdministrativaDO tipoValidacionAdministrativa,
			Double porcentaje1, String claveValidacion1, Date fechaValidacion1,
			EstadoValidacionCobroDO etadoValidacionCobro1, Double porcentaje2,
			String claveValidacion2, Date fechaValidacion2,
			EstadoValidacionCobroDO etadoValidacionCobro2, Double porcentaje3,
			String claveValidacion3, Date fechaValidacion3,
			EstadoValidacionCobroDO etadoValidacionCobro3,
			Double porcentajeTotalCobro,
			EstadoFinalValidacionDO etadoValidacionFinal, ImputableDO imputable) {
		super();
		this.id = id;
		this.estadoValidacionAdministrativa = estadoValidacionAdministrativa;
		this.tipoValidacionAdministrativa = tipoValidacionAdministrativa;
		this.porcentaje1 = porcentaje1;
		this.claveValidacion1 = claveValidacion1;
		this.fechaValidacion1 = fechaValidacion1;
		this.etadoValidacionCobro1 = etadoValidacionCobro1;
		this.porcentaje2 = porcentaje2;
		this.claveValidacion2 = claveValidacion2;
		this.fechaValidacion2 = fechaValidacion2;
		this.etadoValidacionCobro2 = etadoValidacionCobro2;
		this.porcentaje3 = porcentaje3;
		this.claveValidacion3 = claveValidacion3;
		this.fechaValidacion3 = fechaValidacion3;
		this.etadoValidacionCobro3 = etadoValidacionCobro3;
		this.porcentajeTotalCobro = porcentajeTotalCobro;
		this.etadoValidacionFinal = etadoValidacionFinal;
		this.imputable = imputable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoValidacionAdministrativaDO getEstadoValidacionAdministrativa() {
		return estadoValidacionAdministrativa;
	}

	public void setEstadoValidacionAdministrativa(
			EstadoValidacionAdministrativaDO estadoValidacionAdministrativa) {
		this.estadoValidacionAdministrativa = estadoValidacionAdministrativa;
	}

	public TipoValidacionAdministrativaDO getTipoValidacionAdministrativa() {
		return tipoValidacionAdministrativa;
	}

	public void setTipoValidacionAdministrativa(
			TipoValidacionAdministrativaDO tipoValidacionAdministrativa) {
		this.tipoValidacionAdministrativa = tipoValidacionAdministrativa;
	}

	public Double getPorcentaje1() {
		return porcentaje1;
	}

	public void setPorcentaje1(Double porcentaje1) {
		this.porcentaje1 = porcentaje1;
	}

	public String getClaveValidacion1() {
		return claveValidacion1;
	}

	public void setClaveValidacion1(String claveValidacion1) {
		this.claveValidacion1 = claveValidacion1;
	}

	public Date getFechaValidacion1() {
		return fechaValidacion1;
	}

	public void setFechaValidacion1(Date fechaValidacion1) {
		this.fechaValidacion1 = fechaValidacion1;
	}

	public EstadoValidacionCobroDO getEtadoValidacionCobro1() {
		return etadoValidacionCobro1;
	}

	public void setEtadoValidacionCobro1(
			EstadoValidacionCobroDO etadoValidacionCobro1) {
		this.etadoValidacionCobro1 = etadoValidacionCobro1;
	}

	public Double getPorcentaje2() {
		return porcentaje2;
	}

	public void setPorcentaje2(Double porcentaje2) {
		this.porcentaje2 = porcentaje2;
	}

	public String getClaveValidacion2() {
		return claveValidacion2;
	}

	public void setClaveValidacion2(String claveValidacion2) {
		this.claveValidacion2 = claveValidacion2;
	}

	public Date getFechaValidacion2() {
		return fechaValidacion2;
	}

	public void setFechaValidacion2(Date fechaValidacion2) {
		this.fechaValidacion2 = fechaValidacion2;
	}

	public EstadoValidacionCobroDO getEtadoValidacionCobro2() {
		return etadoValidacionCobro2;
	}

	public void setEtadoValidacionCobro2(
			EstadoValidacionCobroDO etadoValidacionCobro2) {
		this.etadoValidacionCobro2 = etadoValidacionCobro2;
	}

	public Double getPorcentaje3() {
		return porcentaje3;
	}

	public void setPorcentaje3(Double porcentaje3) {
		this.porcentaje3 = porcentaje3;
	}

	public String getClaveValidacion3() {
		return claveValidacion3;
	}

	public void setClaveValidacion3(String claveValidacion3) {
		this.claveValidacion3 = claveValidacion3;
	}

	public Date getFechaValidacion3() {
		return fechaValidacion3;
	}

	public void setFechaValidacion3(Date fechaValidacion3) {
		this.fechaValidacion3 = fechaValidacion3;
	}

	public EstadoValidacionCobroDO getEtadoValidacionCobro3() {
		return etadoValidacionCobro3;
	}

	public void setEtadoValidacionCobro3(
			EstadoValidacionCobroDO etadoValidacionCobro3) {
		this.etadoValidacionCobro3 = etadoValidacionCobro3;
	}

	public Double getPorcentajeTotalCobro() {
		return porcentajeTotalCobro;
	}

	public void setPorcentajeTotalCobro(Double porcentajeTotalCobro) {
		this.porcentajeTotalCobro = porcentajeTotalCobro;
	}

	public EstadoFinalValidacionDO getEtadoValidacionFinal() {
		return etadoValidacionFinal;
	}

	public void setEtadoValidacionFinal(EstadoFinalValidacionDO etadoValidacionFinal) {
		this.etadoValidacionFinal = etadoValidacionFinal;
	}

	public ImputableDO getImputable() {
		return imputable;
	}

	public void setImputable(ImputableDO imputable) {
		this.imputable = imputable;
	}
	
	public List<ComentarioPantallaValidacionAdministrativaDO> getComentariosPantallaValidacionAdministrativa() {
		return comentariosPantallaValidacionAdministrativa;
	}

	public void setComentariosPantallaValidacionAdministrativa(
			List<ComentarioPantallaValidacionAdministrativaDO> comentariosPantallaValidacionAdministrativa) {
		this.comentariosPantallaValidacionAdministrativa = comentariosPantallaValidacionAdministrativa;
	}

	/**
	 * @return the proyectoPadre
	 */
	public ProyectoPadreDO getProyectoPadre() {
		return proyectoPadre;
	}

	/**
	 * @param proyectoPadre the proyectoPadre to set
	 */
	public void setProyectoPadre(ProyectoPadreDO proyectoPadre) {
		this.proyectoPadre = proyectoPadre;
	}

	/**
	 * @return the proyecto
	 */
	public ProyectoDO getProyecto() {
		return proyecto;
	}

	/**
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	
	
}
