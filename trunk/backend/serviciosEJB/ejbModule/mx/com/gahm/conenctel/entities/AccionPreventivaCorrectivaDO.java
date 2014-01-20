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
@Table(name = "AccionPreventivaCorrectiva")
@NamedQueries({
	@NamedQuery(name = "AccionPreventivaCorrectivaDO.findAll", query = "select rc from AccionPreventivaCorrectivaDO rc")
	})
public class AccionPreventivaCorrectivaDO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3053664977410145741L;


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_no_conformidad", nullable = false)
	private NoConformidadDO noConformidad;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_apertura", nullable = false, length = 10)
	private Date fechaApertura;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_accion", nullable = false)
	private TipoAccionDO tipoAccion;
	
	@ManyToOne
	@JoinColumn(name = "fk_fuente_no_conformidad", nullable = false)
	private FuenteNoConformidadDO fuenteNoConformidad;
	
	@Column(name = "especificar", nullable = false)
	private String especificar;
	
	@Column(name = "participantes_analisis", nullable = false)
	private String participantesAnalisis;
	
	@Column(name = "determinacion_causas", nullable = false)
	private String determinacionCausas;
	
	@Column(name = "responsable_seguimiento", nullable = false)
	private String responsableSeguimiento;
	
	@Column(name = "acciones_seguimiento", nullable = false)
	private String accionesSeguimiento;
	
	@Column(name = "accion_tomada_eficaz", nullable = false)
	private Boolean accionTomadaEficaz;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_accion_preventiva_correctiva", nullable = false)
	private EstadoAccionPreventivaCorrectivaDO estadoAccionPreventivaCorrectiva;

	@ManyToOne
	@JoinColumn(name = "fk_sugerencia", nullable = false)
	private SugerenciaDO sugerencia;
	
	public AccionPreventivaCorrectivaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccionPreventivaCorrectivaDO(Integer id,
			NoConformidadDO noConformidad, SugerenciaDO consejo, 
			Date fechaApertura,
			TipoAccionDO tipoAccion, FuenteNoConformidadDO fuenteNoConformidad,
			String participantesAnalisis, String determinacionCausas,
			String responsableSeguimiento, String accionesSeguimiento,
			Boolean accionTomadaEficaz,
			EstadoAccionPreventivaCorrectivaDO estadoAccionPreventivaCorrectiva) {
		super();
		this.id = id;
		this.noConformidad = noConformidad;
		this.sugerencia = consejo;
		this.fechaApertura = fechaApertura;
		this.tipoAccion = tipoAccion;
		this.fuenteNoConformidad = fuenteNoConformidad;
		this.participantesAnalisis = participantesAnalisis;
		this.determinacionCausas = determinacionCausas;
		this.responsableSeguimiento = responsableSeguimiento;
		this.accionesSeguimiento = accionesSeguimiento;
		this.accionTomadaEficaz = accionTomadaEficaz;
		this.estadoAccionPreventivaCorrectiva = estadoAccionPreventivaCorrectiva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NoConformidadDO getNoConformidad() {
		return noConformidad;
	}

	public void setNoConformidad(NoConformidadDO noConformidad) {
		this.noConformidad = noConformidad;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public TipoAccionDO getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(TipoAccionDO tipoAccion) {
		this.tipoAccion = tipoAccion;
	}

	public FuenteNoConformidadDO getFuenteNoConformidad() {
		return fuenteNoConformidad;
	}

	public void setFuenteNoConformidad(FuenteNoConformidadDO fuenteNoConformidad) {
		this.fuenteNoConformidad = fuenteNoConformidad;
	}

	public String getParticipantesAnalisis() {
		return participantesAnalisis;
	}

	public void setParticipantesAnalisis(String participantesAnalisis) {
		this.participantesAnalisis = participantesAnalisis;
	}

	public String getDeterminacionCausas() {
		return determinacionCausas;
	}

	public void setDeterminacionCausas(String determinacionCausas) {
		this.determinacionCausas = determinacionCausas;
	}

	public String getResponsableSeguimiento() {
		return responsableSeguimiento;
	}

	public void setResponsableSeguimiento(String responsableSeguimiento) {
		this.responsableSeguimiento = responsableSeguimiento;
	}

	public String getAccionesSeguimiento() {
		return accionesSeguimiento;
	}

	public void setAccionesSeguimiento(String accionesSeguimiento) {
		this.accionesSeguimiento = accionesSeguimiento;
	}

	public Boolean getAccionTomadaEficaz() {
		return accionTomadaEficaz;
	}

	public void setAccionTomadaEficaz(Boolean accionTomadaEficaz) {
		this.accionTomadaEficaz = accionTomadaEficaz;
	}

	public EstadoAccionPreventivaCorrectivaDO getEstadoAccionPreventivaCorrectiva() {
		return estadoAccionPreventivaCorrectiva;
	}

	public void setEstadoAccionPreventivaCorrectiva(
			EstadoAccionPreventivaCorrectivaDO estadoAccionPreventivaCorrectiva) {
		this.estadoAccionPreventivaCorrectiva = estadoAccionPreventivaCorrectiva;
	}

	public String getEspecificar() {
		return especificar;
	}

	public void setEspecificar(String especificar) {
		this.especificar = especificar;
	}

	public SugerenciaDO getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(SugerenciaDO consejo) {
		this.sugerencia = consejo;
	}
}