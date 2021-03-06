package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
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
import javax.persistence.Transient;


/**
 * Clase de persistencia para la tabla material.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "MaterialDO.findAll", query = "select m from MaterialDO m") })
@Table(name="material")
public class MaterialDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	private String codigo;

	private String descripcion;

	private Double existencia;

	@ManyToOne
	@JoinColumn(name = "fk_responsable", nullable = false)
	private ColaboradorDO responsable;


	@ManyToOne
	@JoinColumn(name="fk_estatus_c")
	private EstatusCDO estatusC;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_grupo_familia_c")
	private GrupoFamiliaCDO grupoFamiliaC;

	@ManyToOne
	@JoinColumn(name="fk_unidad_b")
	private UnidadBDO unidadB;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_b")
	private UbicacionBDO ubicacionB;

	private Double costo;
	
	@Transient
	List<ComentariosDO> comentarios;
	
	
	public MaterialDO() {
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

	public GrupoFamiliaCDO getGrupoFamiliaC() {
		return grupoFamiliaC;
	}

	public void setGrupoFamiliaC(GrupoFamiliaCDO grupoFamiliaC) {
		this.grupoFamiliaC = grupoFamiliaC;
	}

	public UnidadBDO getUnidadB() {
		return unidadB;
	}

	public void setUnidadB(UnidadBDO unidadB) {
		this.unidadB = unidadB;
	}

	public UbicacionBDO getUbicacionB() {
		return ubicacionB;
	}

	public void setUbicacionB(UbicacionBDO ubicacionB) {
		this.ubicacionB = ubicacionB;
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

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

}