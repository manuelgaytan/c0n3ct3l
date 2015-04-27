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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "InformacionConfidencialColaborador")
@NamedQueries({
	@NamedQuery(name = "InformacionConfidencialColaboradorDO.findAll", query = "select rc from InformacionConfidencialColaboradorDO rc"),
	@NamedQuery(name = "InformacionConfidencialColaboradorDO.getInformacionConfidencialColaboradorByIdColaborador", query = "select rc from InformacionConfidencialColaboradorDO rc where rc.contratacion.colaborador.id=:idColaborador")
	})
public class InformacionConfidencialColaboradorDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -26929716848830694L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private ContratacionDO contratacion;
	
	@Column(name = "foto", nullable = false)
	private String foto;
	
	@Column(name = "sueldo", nullable = false)
	private Double sueldo;
	
	@Column(name = "tiene_imss", nullable = false)
	private Boolean tieneImss;
	
	@Column(name = "nss", nullable = false)
	private String nss;
	
	@Column(name = "alta_imss", nullable = false, length = 10)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date altaImss;
	
	@Column(name = "baja_imss", nullable = false, length = 10)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date bajaImss;
	
	
	@Column(name = "modificacion_imss", nullable = false, length = 10)
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date modificacionImss;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_colaborador", nullable = false)
	private EstadoColaboradorDO estadoColaborador;
	
	
	@Column(name = "en_caso_accidente_avisar", nullable = false)
	private String enCasoAccidenteAvisar;
	
	@Column(name = "telefono_emergencia", nullable = false)
	private String telefonoEmergencia;
	
	@Column(name = "bajo_tratamiento", nullable = false)
	private Boolean bajoTratamiento;
	
	@Column(name = "medicamento", nullable = false)
	private String medicamento;
	
	@Column(name = "alergias", nullable = false)
	private String alergias;
	
	@Column(name = "tipo_sangre", nullable = false)
	private String tipoSangre;
	
	@Column(name = "numero_tarjeta_nomina", nullable = false)
	private String numeroTarjetaNomina;
	
	
	@Column(name = "correo_electronico", nullable = false)
	private String correoElectronico;


	public InformacionConfidencialColaboradorDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InformacionConfidencialColaboradorDO(Integer id,
			ContratacionDO contratacion, String foto, Double sueldo,
			Boolean tieneImss, String nss, Date altaImss, Date bajaImss,
			Date modificacionImss, EstadoColaboradorDO estadoColaborador,
			String enCasoAccidenteAvisar, String telefonoEmergencia,
			Boolean bajoTratamiento, String medicamento, String alergias,
			String tipoSangre, String numeroTarjetaNomina,
			String correoElectronico) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.foto = foto;
		this.sueldo = sueldo;
		this.tieneImss = tieneImss;
		this.nss = nss;
		this.altaImss = altaImss;
		this.bajaImss = bajaImss;
		this.modificacionImss = modificacionImss;
		this.estadoColaborador = estadoColaborador;
		this.enCasoAccidenteAvisar = enCasoAccidenteAvisar;
		this.telefonoEmergencia = telefonoEmergencia;
		this.bajoTratamiento = bajoTratamiento;
		this.medicamento = medicamento;
		this.alergias = alergias;
		this.tipoSangre = tipoSangre;
		this.numeroTarjetaNomina = numeroTarjetaNomina;
		this.correoElectronico = correoElectronico;
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


	/**
	 * @return the foto
	 */
	public String getFoto() {
		return foto;
	}


	/**
	 * @param foto the foto to set
	 */
	public void setFoto(String foto) {
		this.foto = foto;
	}


	/**
	 * @return the sueldo
	 */
	public Double getSueldo() {
		return sueldo;
	}


	/**
	 * @param sueldo the sueldo to set
	 */
	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}


	/**
	 * @return the tieneImss
	 */
	public Boolean getTieneImss() {
		return tieneImss;
	}


	/**
	 * @param tieneImss the tieneImss to set
	 */
	public void setTieneImss(Boolean tieneImss) {
		this.tieneImss = tieneImss;
	}


	/**
	 * @return the nss
	 */
	public String getNss() {
		return nss;
	}


	/**
	 * @param nss the nss to set
	 */
	public void setNss(String nss) {
		this.nss = nss;
	}


	/**
	 * @return the altaImss
	 */
	public Date getAltaImss() {
		return altaImss;
	}


	/**
	 * @param altaImss the altaImss to set
	 */
	public void setAltaImss(Date altaImss) {
		this.altaImss = altaImss;
	}


	/**
	 * @return the bajaImss
	 */
	public Date getBajaImss() {
		return bajaImss;
	}


	/**
	 * @param bajaImss the bajaImss to set
	 */
	public void setBajaImss(Date bajaImss) {
		this.bajaImss = bajaImss;
	}


	/**
	 * @return the modificacionImss
	 */
	public Date getModificacionImss() {
		return modificacionImss;
	}


	/**
	 * @param modificacionImss the modificacionImss to set
	 */
	public void setModificacionImss(Date modificacionImss) {
		this.modificacionImss = modificacionImss;
	}


	/**
	 * @return the estadoColaborador
	 */
	public EstadoColaboradorDO getEstadoColaborador() {
		return estadoColaborador;
	}


	/**
	 * @param estadoColaborador the estadoColaborador to set
	 */
	public void setEstadoColaborador(EstadoColaboradorDO estadoColaborador) {
		this.estadoColaborador = estadoColaborador;
	}


	/**
	 * @return the enCasoAccidenteAvisar
	 */
	public String getEnCasoAccidenteAvisar() {
		return enCasoAccidenteAvisar;
	}


	/**
	 * @param enCasoAccidenteAvisar the enCasoAccidenteAvisar to set
	 */
	public void setEnCasoAccidenteAvisar(String enCasoAccidenteAvisar) {
		this.enCasoAccidenteAvisar = enCasoAccidenteAvisar;
	}


	/**
	 * @return the telefonoEmergencia
	 */
	public String getTelefonoEmergencia() {
		return telefonoEmergencia;
	}


	/**
	 * @param telefonoEmergencia the telefonoEmergencia to set
	 */
	public void setTelefonoEmergencia(String telefonoEmergencia) {
		this.telefonoEmergencia = telefonoEmergencia;
	}


	/**
	 * @return the bajoTratamiento
	 */
	public Boolean getBajoTratamiento() {
		return bajoTratamiento;
	}


	/**
	 * @param bajoTratamiento the bajoTratamiento to set
	 */
	public void setBajoTratamiento(Boolean bajoTratamiento) {
		this.bajoTratamiento = bajoTratamiento;
	}


	/**
	 * @return the medicamento
	 */
	public String getMedicamento() {
		return medicamento;
	}


	/**
	 * @param medicamento the medicamento to set
	 */
	public void setMedicamento(String medicamento) {
		this.medicamento = medicamento;
	}


	/**
	 * @return the alergias
	 */
	public String getAlergias() {
		return alergias;
	}


	/**
	 * @param alergias the alergias to set
	 */
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}


	/**
	 * @return the tipoSangre
	 */
	public String getTipoSangre() {
		return tipoSangre;
	}


	/**
	 * @param tipoSangre the tipoSangre to set
	 */
	public void setTipoSangre(String tipoSangre) {
		this.tipoSangre = tipoSangre;
	}


	/**
	 * @return the numeroTarjetaNomina
	 */
	public String getNumeroTarjetaNomina() {
		return numeroTarjetaNomina;
	}


	/**
	 * @param numeroTarjetaNomina the numeroTarjetaNomina to set
	 */
	public void setNumeroTarjetaNomina(String numeroTarjetaNomina) {
		this.numeroTarjetaNomina = numeroTarjetaNomina;
	}


	/**
	 * @return the correoElectronico
	 */
	public String getCorreoElectronico() {
		return correoElectronico;
	}


	/**
	 * @param correoElectronico the correoElectronico to set
	 */
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
}
