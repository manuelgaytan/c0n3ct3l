package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase de persistencia para la tabla producto.
 * 
 * @author Carlos Leyva
 */
@Cacheable(false)
@Entity
@NamedQueries({
		@NamedQuery(name = "ProductoDO.findAll", query = "select p from ProductoDO p"),
		@NamedQuery(name = "ProductoDO.findByFilter", query = "select p from ProductoDO p where ((:idCliente is null or :idCliente = 0) or p.cliente.id = :idCliente) and ((:tipoProyecto is null or :tipoProyecto = '') or p.tipoProyecto = :tipoProyecto) and ((:teconologia is null or :teconologia = '') or p.teconologia = :teconologia) and ((:equipo is null or :equipo = '') or p.equipo = :equipo)"),
		@NamedQuery(name = "ProductoDO.findTipoProyecto", query = "select distinct p.tipoProyecto from ProductoDO p where p.cliente.id = :idCliente"),
		@NamedQuery(name = "ProductoDO.findTecnologia", query = "select distinct p.teconologia from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto"),
		@NamedQuery(name = "ProductoDO.findEquipo", query = "select distinct p.equipo from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia"),
		@NamedQuery(name = "ProductoDO.findActividadRealizar", query = "select distinct p.actividadRealizar from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo"),
		@NamedQuery(name = "ProductoDO.findModelo", query = "select distinct p.modelo from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar"),
		@NamedQuery(name = "ProductoDO.findDescripcionServicio", query = "select distinct p.descripcionServicio from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar and p.modelo = :modelo"),
		@NamedQuery(name = "ProductoDO.findTipoServicio", query = "select distinct p.tipoServicio from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar and p.modelo = :modelo and p.descripcionServicio = :descripcionServicio"),
		@NamedQuery(name = "ProductoDO.findCostoLocalCliente", query = "select p.id, p.costoLocalCliente from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar and p.modelo = :modelo and p.descripcionServicio = :descripcionServicio and p.tipoServicio = :tipoServicio"),
		@NamedQuery(name = "ProductoDO.findCostoForaneoCliente", query = "select p.id, p.costoForaneoCliente from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar and p.modelo = :modelo and p.descripcionServicio = :descripcionServicio and p.tipoServicio = :tipoServicio"),
		@NamedQuery(name = "ProductoDO.findCostoLocalProveedor", query = "select p.id, p.costoLocalProveedor from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar and p.modelo = :modelo and p.descripcionServicio = :descripcionServicio and p.tipoServicio = :tipoServicio"),
		@NamedQuery(name = "ProductoDO.findCostoForaneoProveedor", query = "select p.id, p.costoForaneoProveedor from ProductoDO p where p.cliente.id = :idCliente and p.tipoProyecto = :tipoProyecto and p.teconologia = :tecnologia and p.equipo = :equipo and p.actividadRealizar = :actividadRealizar and p.modelo = :modelo and p.descripcionServicio = :descripcionServicio and p.tipoServicio = :tipoServicio")})

@Table(name = "producto")
public class ProductoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "actividad_realizar")
	private String actividadRealizar;

	@Column(name = "costo_local_cliente")
	private Double costoLocalCliente;
	
	@Column(name = "costo_foraneo_cliente")
	private Double costoForaneoCliente;
	
	@Column(name = "costo_local_proveedor")
	private Double costoLocalProveedor;
	
	@Column(name = "costo_foraneo_proveedor")
	private Double costoForaneoProveedor;

	@Column(name = "descripcion_servicio")
	private String descripcionServicio;

	private String equipo;

	private String modelo;

	private String teconologia;

	@Column(name = "tipo_proyecto")
	private String tipoProyecto;

	@Column(name = "tipo_servicio")
	private String tipoServicio;
	
	@Column(name = "dias_implementacion")
	private int diasImplementacion;

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

	public Double getCostoLocalCliente() {
		return this.costoLocalCliente;
	}

	public void setCostoLocalCliente(Double costo) {
		this.costoLocalCliente = costo;
	}

	public Double getCostoForaneoCliente() {
		return costoForaneoCliente;
	}

	public void setCostoForaneoCliente(Double costoForaneoCliente) {
		this.costoForaneoCliente = costoForaneoCliente;
	}

	public Double getCostoLocalProveedor() {
		return costoLocalProveedor;
	}

	public void setCostoLocalProveedor(Double costoLocalProveedor) {
		this.costoLocalProveedor = costoLocalProveedor;
	}

	public Double getCostoForaneoProveedor() {
		return costoForaneoProveedor;
	}

	public void setCostoForaneoProveedor(Double costoForaneoProveedor) {
		this.costoForaneoProveedor = costoForaneoProveedor;
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

	public int getDiasImplementacion() {
		return diasImplementacion;
	}

	public void setDiasImplementacion(int diasImplementacion) {
		this.diasImplementacion = diasImplementacion;
	}

}