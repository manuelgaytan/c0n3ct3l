package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

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


/**
 * Clase de persistencia para la tabla telefoniamovil.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TelefoniaMovilDO.findAll", query = "select t from TelefoniaMovilDO t") })
@Table(name="telefoniamovil")
public class TelefoniaMovilDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private String descripcion;

	private Double existencia;

	// TODO
	@Column(name="fk_responsable")
	private Long fkResponsable;

	private String imei;

	private String marca;

	private String modelo;

	@Column(name="no_serie")
	private String noSerie;

	@Column(name="no_telefono")
	private String noTelefono;

	@Column(name="tipo_plan_contratado")
	private String tipoPlanContratado;

	@ManyToOne
	@JoinColumn(name="fk_estatus_b")
	private EstatusBDO estatusB;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_grupo_familia_f")
	private GrupoFamiliaFDO grupoFamiliaF;

	@ManyToOne
	@JoinColumn(name="fk_compania")
	private CompaniaDO compania;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_b")
	private UbicacionBDO ubicacionB;

	public TelefoniaMovilDO() {
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

	public Long getFkResponsable() {
		return this.fkResponsable;
	}

	public void setFkResponsable(Long fkResponsable) {
		this.fkResponsable = fkResponsable;
	}

	public String getImei() {
		return this.imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
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

	public String getNoTelefono() {
		return this.noTelefono;
	}

	public void setNoTelefono(String noTelefono) {
		this.noTelefono = noTelefono;
	}

	public String getTipoPlanContratado() {
		return this.tipoPlanContratado;
	}

	public void setTipoPlanContratado(String tipoPlanContratado) {
		this.tipoPlanContratado = tipoPlanContratado;
	}

	public EstatusBDO getEstatusB() {
		return estatusB;
	}

	public void setEstatusB(EstatusBDO estatusB) {
		this.estatusB = estatusB;
	}

	public TipoAlmacenDO getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacenDO tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	public GrupoFamiliaFDO getGrupoFamiliaF() {
		return grupoFamiliaF;
	}

	public void setGrupoFamiliaF(GrupoFamiliaFDO grupoFamiliaF) {
		this.grupoFamiliaF = grupoFamiliaF;
	}

	public CompaniaDO getCompania() {
		return compania;
	}

	public void setCompania(CompaniaDO compania) {
		this.compania = compania;
	}

	public UbicacionBDO getUbicacionB() {
		return ubicacionB;
	}

	public void setUbicacionB(UbicacionBDO ubicacionB) {
		this.ubicacionB = ubicacionB;
	}

}