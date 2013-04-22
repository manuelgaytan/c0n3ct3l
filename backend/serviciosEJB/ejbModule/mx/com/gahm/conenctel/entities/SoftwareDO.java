package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;

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


/**
 * Clase de persistencia para la tabla software.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "SoftwareDO.findAll", query = "select s from SoftwareDO s") })
@Table(name="software")
public class SoftwareDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String codigo;

	private String descripcion;

	private Double existencia;

	@ManyToOne
	@JoinColumn(name = "fk_responsable", nullable = false)
	private ColaboradorDO fkResponsable;

	@Temporal(TemporalType.DATE)
	@Column(name="licenciamiento_final")
	private Date licenciamientoFinal;

	@Temporal(TemporalType.DATE)
	@Column(name="licenciamiento_inicial")
	private Date licenciamientoInicial;

	@Column(name="no_serie")
	private String noSerie;

	private String unidad;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO tipoAlmacen;

	@ManyToOne
	@JoinColumn(name="fk_ubicacion_b")
	private UbicacionBDO ubicacionB;

	public SoftwareDO() {
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

	public ColaboradorDO getFkResponsable() {
		return this.fkResponsable;
	}

	public void setFkResponsable(ColaboradorDO fkResponsable) {
		this.fkResponsable = fkResponsable;
	}

	public Date getLicenciamientoFinal() {
		return this.licenciamientoFinal;
	}

	public void setLicenciamientoFinal(Date licenciamientoFinal) {
		this.licenciamientoFinal = licenciamientoFinal;
	}

	public Date getLicenciamientoInicial() {
		return this.licenciamientoInicial;
	}

	public void setLicenciamientoInicial(Date licenciamientoInicial) {
		this.licenciamientoInicial = licenciamientoInicial;
	}

	public String getNoSerie() {
		return this.noSerie;
	}

	public void setNoSerie(String noSerie) {
		this.noSerie = noSerie;
	}

	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public TipoAlmacenDO getTipoAlmacen() {
		return tipoAlmacen;
	}

	public void setTipoAlmacen(TipoAlmacenDO tipoAlmacen) {
		this.tipoAlmacen = tipoAlmacen;
	}

	public UbicacionBDO getUbicacionB() {
		return ubicacionB;
	}

	public void setUbicacionB(UbicacionBDO ubicacionB) {
		this.ubicacionB = ubicacionB;
	}

}