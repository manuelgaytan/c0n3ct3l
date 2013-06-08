package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * Clase de persistencia para la tabla equipomedicion.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EquipoMedicionDO.findAll", query = "select e from EquipoMedicionDO e") })
@Table(name="equipomedicion")
public class EquipoMedicionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String codigo;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_calibracion")
	private Date fechaCalibracion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_mantenimiento")
	private Date fechaMantenimiento;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_proxima_calibracion")
	private Date fechaProximaCalibracion;

	// TODO
	@ManyToOne
	@JoinColumn(name = "fk_responsable", nullable = false)
	private ColaboradorDO responsable;

	@Column(name="grupo_familia")
	private String grupoFamilia;

	private String marca;

	private String modelo;

	@Column(name="no_certificado")
	private String noCertificado;

	@Column(name="no_serie")
	private String noSerie;

	@ManyToOne
	@JoinColumn(name="fk_tipo_mantenimiento")
	private TipoMantenimientoDO tipomantenimiento;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoalmacen;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_b")
	private UbicacionBDO ubicacionb;

	@ManyToOne
	@JoinColumn(name="fk_estatus_a")
	private EstatusADO estatusa;
	
	private Double costo;
	
	@Transient
	List<DocumentoAlmacenDO> polizaGarantia;
	
	@Transient
	List<DocumentoAlmacenDO> polizaSeguro;
	
	@Transient
	List<DocumentoAlmacenDO> certificadoCalibracion;
	
	@Transient
	List<DocumentoAlmacenDO> ordenMantenimiento;
	
	@Transient
	List<ComentariosDO> comentarios;
	

	public EquipoMedicionDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaCalibracion() {
		return this.fechaCalibracion;
	}

	public void setFechaCalibracion(Date fechaCalibracion) {
		this.fechaCalibracion = fechaCalibracion;
	}

	public Date getFechaMantenimiento() {
		return this.fechaMantenimiento;
	}

	public void setFechaMantenimiento(Date fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}

	public Date getFechaProximaCalibracion() {
		return this.fechaProximaCalibracion;
	}

	public void setFechaProximaCalibracion(Date fechaProximaCalibracion) {
		this.fechaProximaCalibracion = fechaProximaCalibracion;
	}

	public String getGrupoFamilia() {
		return this.grupoFamilia;
	}

	public void setGrupoFamilia(String grupoFamilia) {
		this.grupoFamilia = grupoFamilia;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNoCertificado() {
		return this.noCertificado;
	}

	public void setNoCertificado(String noCertificado) {
		this.noCertificado = noCertificado;
	}

	public String getNoSerie() {
		return this.noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public TipoMantenimientoDO getTipomantenimiento() {
		return this.tipomantenimiento;
	}

	public void setTipomantenimiento(TipoMantenimientoDO tipomantenimiento) {
		this.tipomantenimiento = tipomantenimiento;
	}

	public TipoAlmacenDO getTipoalmacen() {
		return this.tipoalmacen;
	}

	public void setTipoalmacen(TipoAlmacenDO tipoalmacen) {
		this.tipoalmacen = tipoalmacen;
	}

	public UbicacionBDO getUbicacionb() {
		return this.ubicacionb;
	}

	public void setUbicacionb(UbicacionBDO ubicacionb) {
		this.ubicacionb = ubicacionb;
	}

	public EstatusADO getEstatusa() {
		return this.estatusa;
	}

	public void setEstatusa(EstatusADO estatusa) {
		this.estatusa = estatusa;
	}

	public List<DocumentoAlmacenDO> getPolizaGarantia() {
		return polizaGarantia;
	}

	public void setPolizaGarantia(List<DocumentoAlmacenDO> polizaGarantia) {
		this.polizaGarantia = polizaGarantia;
	}

	public List<DocumentoAlmacenDO> getPolizaSeguro() {
		return polizaSeguro;
	}

	public void setPolizaSeguro(List<DocumentoAlmacenDO> polizaSeguro) {
		this.polizaSeguro = polizaSeguro;
	}

	public List<DocumentoAlmacenDO> getCertificadoCalibracion() {
		return certificadoCalibracion;
	}

	public void setCertificadoCalibracion(
			List<DocumentoAlmacenDO> certificadoCalibracion) {
		this.certificadoCalibracion = certificadoCalibracion;
	}

	public List<DocumentoAlmacenDO> getOrdenMantenimiento() {
		return ordenMantenimiento;
	}

	public void setOrdenMantenimiento(List<DocumentoAlmacenDO> ordenMantenimiento) {
		this.ordenMantenimiento = ordenMantenimiento;
	}

	public List<ComentariosDO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentariosDO> comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * @return the fkResponsable
	 */
	public ColaboradorDO getResponsable() {
		return responsable;
	}

	/**
	 * @param fkResponsable the fkResponsable to set
	 */
	public void setResponsable(ColaboradorDO responsable) {
		this.responsable = responsable;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

}