package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * Clase de persistencia para la tabla hardware.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "HardwareDO.findAll", query = "select h from HardwareDO h") })
@Table(name="hardware")
public class HardwareDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String codigo;

	private String descripcion;

	private Double existencia;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_mantenimiento")
	private Date fechaMantenimiento;

	@ManyToOne
	@JoinColumn(name = "fk_responsable", nullable = false)
	private ColaboradorDO responsable;


	private String marca;

	private String modelo;

	@Column(name="no_serie")
	private String noSerie;

	@ManyToOne
	@JoinColumn(name="fk_tipo_mantenimiento")
	private TipoMantenimientoDO tipoMantenimiento;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_grupo_familia_e")
	private GrupoFamiliaEDO grupoFamiliaE;

	@ManyToOne
	@JoinColumn(name="fk_unidad_c")
	private UnidadCDO unidadC;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_b")
	private UbicacionBDO ubicacionB;

	@ManyToOne
	@JoinColumn(name="fk_estatus_b")
	private EstatusBDO estatusB;
	
	@Transient
	List<DocumentoAlmacenDO> polizaGarantia;
	
	@Transient
	List<DocumentoAlmacenDO> polizaSeguro;
	
	@Transient
	List<DocumentoAlmacenDO> ordenMantenimiento;
	
	@Transient
	List<ComentariosDO> comentarios;

	public HardwareDO() {
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

	public Double getExistencia() {
		return this.existencia;
	}

	public void setExistencia(Double existencia) {
		this.existencia = existencia;
	}

	public Date getFechaMantenimiento() {
		return this.fechaMantenimiento;
	}

	public void setFechaMantenimiento(Date fechaMantenimiento) {
		this.fechaMantenimiento = fechaMantenimiento;
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

	public String getNoSerie() {
		return this.noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public TipoMantenimientoDO getTipoMantenimiento() {
		return tipoMantenimiento;
	}

	public void setTipoMantenimiento(TipoMantenimientoDO tipoMantenimiento) {
		this.tipoMantenimiento = tipoMantenimiento;
	}

	public TipoAlmacenDO getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacenDO tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	public GrupoFamiliaEDO getGrupoFamiliaE() {
		return grupoFamiliaE;
	}

	public void setGrupoFamiliaE(GrupoFamiliaEDO grupoFamiliaE) {
		this.grupoFamiliaE = grupoFamiliaE;
	}

	public UnidadCDO getUnidadC() {
		return unidadC;
	}

	public void setUnidadC(UnidadCDO unidadC) {
		this.unidadC = unidadC;
	}

	public UbicacionBDO getUbicacionB() {
		return ubicacionB;
	}

	public void setUbicacionB(UbicacionBDO ubicacionB) {
		this.ubicacionB = ubicacionB;
	}

	public EstatusBDO getEstatusB() {
		return estatusB;
	}

	public void setEstatusB(EstatusBDO estatusB) {
		this.estatusB = estatusB;
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

	/**
	 * @return the responsable
	 */
	public ColaboradorDO getResponsable() {
		return responsable;
	}

	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(ColaboradorDO responsable) {
		this.responsable = responsable;
	}

}