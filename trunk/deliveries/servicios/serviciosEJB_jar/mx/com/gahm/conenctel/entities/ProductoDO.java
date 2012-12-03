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
 * Clase de persistencia para la tabla producto.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
		@NamedQuery(name = "ProductoDO.findAll", query = "select p from ProductoDO p"),
		@NamedQuery(name = "ProductoDO.findByFilter", query = "select p from ProductoDO p where ((:idCliente is null or :idCliente = 0) or p.cliente.id = :idCliente) and ((:tipoProyecto is null or :tipoProyecto = '') or p.tipoProyecto = :tipoProyecto) and ((:tipoServicio is null or :tipoServicio = '') or p.tipoServicio = :tipoServicio) and ((:equipo is null or :equipo = '') or p.equipo = :equipo)"),
		@NamedQuery(name = "ProductoDO.findTipoProyecto", query = "select distinct p.id, p.tipoProyecto from ProductoDO p where p.cliente.id = :idCliente"),
		@NamedQuery(name = "ProductoDO.findTecnologia", query = "select distinct p.id, p.teconologia from ProductoDO p where p.cliente.id = :idCliente"),
		@NamedQuery(name = "ProductoDO.findEquipo", query = "select distinct p.id, p.equipo from ProductoDO p where p.cliente.id = :idCliente") })
@Table(name = "producto")
public class ProductoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "actividad_realizar")
	private String actividadRealizar;

	private Double costo;

	@Column(name = "descripcion_servicio")
	private String descripcionServicio;

	private String equipo;

	private String modelo;

	private String teconologia;

	@Column(name = "tipo_proyecto")
	private String tipoProyecto;

	@Column(name = "tipo_servicio")
	private String tipoServicio;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteDO cliente;

	public ProductoDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActividadRealizar() {
		return this.actividadRealizar;
	}

	public void setActividadRealizar(String actividadRealizar) {
		this.actividadRealizar = actividadRealizar;
	}

	public Double getCosto() {
		return this.costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	public String getDescripcionServicio() {
		return this.descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public String getEquipo() {
		return this.equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTeconologia() {
		return this.teconologia;
	}

	public void setTeconologia(String teconologia) {
		this.teconologia = teconologia;
	}

	public String getTipoProyecto() {
		return this.tipoProyecto;
	}

	public void setTipoProyecto(String tipoProyecto) {
		this.tipoProyecto = tipoProyecto;
	}

	public String getTipoServicio() {
		return this.tipoServicio;
	}

	public void setTipoServicio(String tipoServicio) {
		this.tipoServicio = tipoServicio;
	}

	public ClienteDO getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteDO cliente) {
		this.cliente = cliente;
	}

}