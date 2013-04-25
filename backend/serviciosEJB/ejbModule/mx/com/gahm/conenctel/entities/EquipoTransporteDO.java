package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * Clase de persistencia para la tabla equipotransporte.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EquipoTransporteDO.findAll", query = "select e from EquipoTransporteDO e") })
@Table(name="equipotransporte")
public class EquipoTransporteDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String codigo;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_mantenimiento")
	private Date fechaMantenimiento;

	// TODO
	@Column(name="fk_responsable")
	private Long fkResponsable;

	private String marca;

	private String modelo;

	@Column(name="no_placas")
	private String noPlacas;

	@Column(name="no_serie")
	private String noSerie;

	@Column(name="no_tarjeta_circulacion")
	private String noTarjetaCirculacion;

	@ManyToOne
	@JoinColumn(name="fk_tipo_mantenimiento")
	private TipoMantenimientoDO tipomantenimiento;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoalmacen;

	@ManyToOne
	@JoinColumn(name="fk_grupo_familia_b")
	private GrupoFamiliaBDO grupofamiliab;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_b")
	private UbicacionBDO ubicacionb;

	@ManyToOne
	@JoinColumn(name="fk_estatus_b")
	private EstatusBDO estatusb;

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
	
	public EquipoTransporteDO() {
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

	public Date getFechaMantenimiento() {
		return this.fechaMantenimiento;
	}

	public void setFechaMantenimiento(Date fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
	}

	public Long getFkResponsable() {
		return this.fkResponsable;
	}

	public void setFkResponsable(Long fkResponsable) {
		this.fkResponsable = fkResponsable;
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

	public String getNoPlacas() {
		return this.noPlacas;
	}

	public void setNoPlacas(String noPlacas) {
		this.noPlacas = noPlacas;
	}

	public String getNoSerie() {
		return this.noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public String getNoTarjetaCirculacion() {
		return this.noTarjetaCirculacion;
	}

	public void setNoTarjetaCirculacion(String noTarjetaCirculacion) {
		this.noTarjetaCirculacion = noTarjetaCirculacion;
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

	public GrupoFamiliaBDO getGrupofamiliab() {
		return this.grupofamiliab;
	}

	public void setGrupofamiliab(GrupoFamiliaBDO grupofamiliab) {
		this.grupofamiliab = grupofamiliab;
	}

	public UbicacionBDO getUbicacionb() {
		return this.ubicacionb;
	}

	public void setUbicacionb(UbicacionBDO ubicacionb) {
		this.ubicacionb = ubicacionb;
	}

	public EstatusBDO getEstatusb() {
		return this.estatusb;
	}

	public void setEstatusb(EstatusBDO estatusb) {
		this.estatusb = estatusb;
	}

	/**
	 * @return the polizaGarantia
	 */
	public List<DocumentoAlmacenDO> getPolizaGarantia() {
		return polizaGarantia;
	}

	/**
	 * @param polizaGarantia the polizaGarantia to set
	 */
	public void setPolizaGarantia(List<DocumentoAlmacenDO> polizaGarantia) {
		this.polizaGarantia = polizaGarantia;
	}

	/**
	 * @return the polizaSeguro
	 */
	public List<DocumentoAlmacenDO> getPolizaSeguro() {
		return polizaSeguro;
	}

	/**
	 * @param polizaSeguro the polizaSeguro to set
	 */
	public void setPolizaSeguro(List<DocumentoAlmacenDO> polizaSeguro) {
		this.polizaSeguro = polizaSeguro;
	}

	/**
	 * @return the certificadoCalibracion
	 */
	public List<DocumentoAlmacenDO> getCertificadoCalibracion() {
		return certificadoCalibracion;
	}

	/**
	 * @param certificadoCalibracion the certificadoCalibracion to set
	 */
	public void setCertificadoCalibracion(
			List<DocumentoAlmacenDO> certificadoCalibracion) {
		this.certificadoCalibracion = certificadoCalibracion;
	}

	/**
	 * @return the ordenMantenimiento
	 */
	public List<DocumentoAlmacenDO> getOrdenMantenimiento() {
		return ordenMantenimiento;
	}

	/**
	 * @param ordenMantenimiento the ordenMantenimiento to set
	 */
	public void setOrdenMantenimiento(List<DocumentoAlmacenDO> ordenMantenimiento) {
		this.ordenMantenimiento = ordenMantenimiento;
	}

	/**
	 * @return the comentarios
	 */
	public List<ComentariosDO> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<ComentariosDO> comentarios) {
		this.comentarios = comentarios;
	}

}