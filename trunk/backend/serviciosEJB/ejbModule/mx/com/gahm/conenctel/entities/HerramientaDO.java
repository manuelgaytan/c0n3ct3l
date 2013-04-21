package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * Clase de persistencia para la tabla herramienta.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "HerramientaDO.findAll", query = "select h from HerramientaDO h") })
@Table(name="herramienta")
public class HerramientaDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private String descripcion;

	private Double existencia;

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
	@Column(name="fk_responsable")
	private Long fkResponsable;

	private String marca;

	private String modelo;

	@Column(name="no_certificado")
	private String noCertificado;

	@Column(name="no_serie")
	private String noSerie;

/*	@OneToMany(mappedBy="herramienta")
	private List<ComentarioHerramientaDO> comentarios;
*/
	@ManyToOne
	@JoinColumn(name="fk_tipo_mantenimiento")
	private TipoMantenimientoDO tipoMantenimiento;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_grupo_familia_a")
	private GrupoFamiliaADO grupoFamiliaA;

	@ManyToOne
	@JoinColumn(name="fk_unidad_a")
	private UnidadADO unidadA;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_a")
	private UbicacionADO ubicacionA	;

	@ManyToOne
	@JoinColumn(name="fk_estatus_a")
	private EstatusADO estatusA;
	
	@Transient
	List<DocumentoAlmacenDO> polizaGarantia;
	
	@Transient
	List<DocumentoAlmacenDO> polizaSeguro;
	
	@Transient
	List<DocumentoAlmacenDO> certificadoCalibracion;
	
	@Transient
	List<ComentariosDO> comentarios;
	
	public HerramientaDO() {
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
/*
	public List<ComentarioHerramientaDO> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<ComentarioHerramientaDO> comentarios) {
		this.comentarios = comentarios;
	}
*/
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

	public GrupoFamiliaADO getGrupoFamiliaA() {
		return grupoFamiliaA;
	}

	public void setGrupoFamiliaA(GrupoFamiliaADO grupoFamiliaA) {
		this.grupoFamiliaA = grupoFamiliaA;
	}

	public UnidadADO getUnidadA() {
		return unidadA;
	}

	public void setUnidadA(UnidadADO unidadA) {
		this.unidadA = unidadA;
	}

	public UbicacionADO getUbicacionA() {
		return ubicacionA;
	}

	public void setUbicacionA(UbicacionADO ubicacionA) {
		this.ubicacionA = ubicacionA;
	}

	public EstatusADO getEstatusA() {
		return estatusA;
	}

	public void setEstatusA(EstatusADO estatusA) {
		this.estatusA = estatusA;
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

	public List<ComentariosDO> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<ComentariosDO> comentarios) {
		this.comentarios = comentarios;
	}

}