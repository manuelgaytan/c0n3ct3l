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
 * Clase de persistencia para la tabla consumible.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ConsumibleDO.findAll", query = "select c from ConsumibleDO c") })
@Table(name="consumible")
public class ConsumibleDO implements Serializable {
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

	@ManyToOne
	@JoinColumn(name="fk_estatus_c")
	private EstatusCDO estatusC;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_grupo_familia_d")
	private GrupoFamiliaDDO grupoFamiliaD;

	@ManyToOne
	@JoinColumn(name="fk_unidad_b")
	private UnidadBDO unidadB;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_c")
	private UbicacionCDO ubicacionC;

	public ConsumibleDO() {
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

	public EstatusCDO getEstatusC() {
		return estatusC;
	}

	public void setEstatusC(EstatusCDO estatusC) {
		this.estatusC = estatusC;
	}

	public TipoAlmacenDO getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacenDO tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	public GrupoFamiliaDDO getGrupoFamiliaD() {
		return grupoFamiliaD;
	}

	public void setGrupoFamiliaD(GrupoFamiliaDDO grupoFamiliaD) {
		this.grupoFamiliaD = grupoFamiliaD;
	}

	public UnidadBDO getUnidadB() {
		return unidadB;
	}

	public void setUnidadB(UnidadBDO unidadB) {
		this.unidadB = unidadB;
	}

	public UbicacionCDO getUbicacionC() {
		return ubicacionC;
	}

	public void setUbicacionC(UbicacionCDO ubicacionC) {
		this.ubicacionC = ubicacionC;
	}

}