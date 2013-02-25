package mx.com.gahm.conenctel.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "PartidaRequisicionCompra", catalog = "conectel")
public class PartidaRequisicionCompraDO implements java.io.Serializable {

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
	@Column( nullable = false)
	private String unidad;
	@Column( nullable = false)
	private String validacion;
	@Column(name = "fk_estatus", nullable = false)
	private Integer fkEstatus;

	public PartidaRequisicionCompraDO() {
	}

	public PartidaRequisicionCompraDO(String descripcion, String cantidad,
			String unidad, String validacion, Integer fkEstatus) {
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.validacion = validacion;
		this.fkEstatus = fkEstatus;
	}

	/** full constructor */
	public PartidaRequisicionCompraDO(RequisicionCompraDO requisicionCompra,
			String codigo, String grupoFamilia, String descripcion,
			String cantidad, String unidad, String validacion, Integer fkEstatus) {
		this.requisicionCompra = requisicionCompra;
		this.codigo = codigo;
		this.grupoFamilia = grupoFamilia;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
		this.validacion = validacion;
		this.fkEstatus = fkEstatus;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="fk_requisicion_compra")
	public RequisicionCompraDO getRequisicionCompra() {
		return this.requisicionCompra;
	}

	public void setRequisicionCompra(RequisicionCompraDO eequisicionCompra) {
		this.requisicionCompra = eequisicionCompra;
	}

	@Column(name = "codigo")
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "grupo_familia")
	public String getGrupoFamilia() {
		return this.grupoFamilia;
	}

	public void setGrupoFamilia(String grupoFamilia) {
		this.grupoFamilia = grupoFamilia;
	}

	@Column(name = "descripcion", nullable = false)
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "cantidad", nullable = false)
	public String getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Column(name = "unidad", nullable = false)
	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	@Column(name = "validacion", nullable = false)
	public String getValidacion() {
		return this.validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	@Column(name = "fk_estatus", nullable = false)
	public Integer getFkEstatus() {
		return this.fkEstatus;
	}

	public void setFkEstatus(Integer fkEstatus) {
		this.fkEstatus = fkEstatus;
	}

}