package mx.com.gahm.conenctel.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PartidaRequisicionCompra", catalog = "conectel")
public class PartidaRequisicionCompraDO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="fk_requisicion_compra")
	private RequisicionCompraDO requisicionCompra;
	private String codigo;
	@Column(name = "grupo_familia", nullable = true)
	private String grupoFamilia;
	@Column( nullable = false)
	private String descripcion;
	@Column( nullable = false)
	private String cantidad;
	@Column( nullable = true)
	private String unidad;
	@ManyToOne
	@JoinColumn(name="fk_validacion")
	private ColaboradorDO validacion;
	@Column(name = "fk_estatus", nullable = false)
	private Integer fkEstatus;
	@Column(name = "costo", nullable = true)
	private Double costo;
	@Column(name = "importe", nullable = true)
	private Double importe;

	public PartidaRequisicionCompraDO() {
	}

	public PartidaRequisicionCompraDO(String descripcion, String cantidad,
			String unidad, ColaboradorDO validacion, Integer fkEstatus) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.validacion = validacion;
		this.fkEstatus = fkEstatus;
	}
	
	public PartidaRequisicionCompraDO(RequisicionCompraDO requisicionCompra,
			String codigo, String grupoFamilia, String descripcion,
			String cantidad, String unidad, ColaboradorDO validacion, Integer fkEstatus, Double costo, Double importe) {
		this.requisicionCompra = requisicionCompra;
		this.codigo = codigo;
		this.grupoFamilia = grupoFamilia;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.validacion = validacion;
		this.fkEstatus = fkEstatus;
		this.costo = costo;
		this.importe = importe;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RequisicionCompraDO getRequisicionCompra() {
		return requisicionCompra;
	}

	public void setRequisicionCompra(RequisicionCompraDO requisicionCompra) {
		this.requisicionCompra = requisicionCompra;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getGrupoFamilia() {
		return grupoFamilia;
	}

	public void setGrupoFamilia(String grupoFamilia) {
		this.grupoFamilia = grupoFamilia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public ColaboradorDO getValidacion() {
		return validacion;
	}

	public void setValidacion(ColaboradorDO validacion) {
		this.validacion = validacion;
	}

	public Integer getFkEstatus() {
		return fkEstatus;
	}

	public void setFkEstatus(Integer fkEstatus) {
		this.fkEstatus = fkEstatus;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}
}