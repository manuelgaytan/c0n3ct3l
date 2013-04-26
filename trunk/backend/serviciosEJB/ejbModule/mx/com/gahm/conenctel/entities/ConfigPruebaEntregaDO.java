package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * Clase de persistencia para la tabla configuracionpruebaentrega.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ConfigPruebaEntregaDO.findAll", query = "select c from ConfigPruebaEntregaDO c") })
@Table(name="configuracionpruebaentrega")
public class ConfigPruebaEntregaDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String alineacion;

	@Column(name="clave_aceptacion")
	private String claveAceptacion;

	private String comisionado;

	@Column(name="fecha_entrega")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaEntrega;

	@Column(name="puertos_entregados")
	private String puertosEntregados;

	@Column(name="slot_entregado")
	private String slotEntregado;

	@Column(name="tarjetas_entregadas")
	private String tarjetasEntregadas;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;
	
	@Column(name="entregables_completos")
	private Boolean entregablesCompletos;
	
	@ManyToOne
	@JoinColumn(name="fk_estatus_validacion_operativa")
	private EstadoValidacionOperativaDO estadoValidacionOperativa;
	
	@Column(name="fecha_validacion_operativa")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaValidacionOperativa;

	@Transient
	public List<ProyectoEntregableDO> siteSurvey;
	@Transient
	public List<ProyectoEntregableDO> planos;
	@Transient
	public List<ProyectoEntregableDO> ingenieria;
	@Transient
	public List<ProyectoEntregableDO> visitaFactibilidad;
	@Transient
	public List<ProyectoEntregableDO> carpetaAdministrativa;
	@Transient
	public List<ProyectoEntregableDO> protocolo;
	@Transient
	public List<ProyectoEntregableDO> ot;
	@Transient
	public List<ProyectoEntregableDO> clienteSatisfecho;
	@Transient
	public List<ProyectoEntregableDO> checklistInspeccion;
	@Transient
	public List<ProyectoEntregableDO> checklistFotografico;
	@Transient
	public List<ProyectoEntregableDO> asBuild;
	@Transient
	public List<ProyectoEntregableDO> entregableX;
	@Transient
	public List<ProyectoEntregableDO> entregableY;

	public ConfigPruebaEntregaDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlineacion() {
		return this.alineacion;
	}

	public void setAlineacion(String alineacion) {
		this.alineacion = alineacion;
	}

	public String getClaveAceptacion() {
		return this.claveAceptacion;
	}

	public void setClaveAceptacion(String claveAceptacion) {
		this.claveAceptacion = claveAceptacion;
	}

	public String getComisionado() {
		return this.comisionado;
	}

	public void setComisionado(String comisionado) {
		this.comisionado = comisionado;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public String getPuertosEntregados() {
		return this.puertosEntregados;
	}

	public void setPuertosEntregados(String puertosEntregados) {
		this.puertosEntregados = puertosEntregados;
	}

	public String getSlotEntregado() {
		return this.slotEntregado;
	}

	public void setSlotEntregado(String slotEntregado) {
		this.slotEntregado = slotEntregado;
	}

	public String getTarjetasEntregadas() {
		return this.tarjetasEntregadas;
	}

	public void setTarjetasEntregadas(String tarjetasEntregadas) {
		this.tarjetasEntregadas = tarjetasEntregadas;
	}

	public ProyectoDO getProyecto() {
		return this.proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public List<ProyectoEntregableDO> getSiteSurvey() {
		return siteSurvey;
	}

	public void setSiteSurvey(List<ProyectoEntregableDO> siteSurvey) {
		this.siteSurvey = siteSurvey;
	}

	public List<ProyectoEntregableDO> getPlanos() {
		return planos;
	}

	public void setPlanos(List<ProyectoEntregableDO> planos) {
		this.planos = planos;
	}

	public List<ProyectoEntregableDO> getIngenieria() {
		return ingenieria;
	}

	public void setIngenieria(List<ProyectoEntregableDO> ingenieria) {
		this.ingenieria = ingenieria;
	}

	public List<ProyectoEntregableDO> getVisitaFactibilidad() {
		return visitaFactibilidad;
	}

	public void setVisitaFactibilidad(List<ProyectoEntregableDO> visitaFactibilidad) {
		this.visitaFactibilidad = visitaFactibilidad;
	}

	public List<ProyectoEntregableDO> getCarpetaAdministrativa() {
		return carpetaAdministrativa;
	}

	public void setCarpetaAdministrativa(
			List<ProyectoEntregableDO> carpetaAdministrativa) {
		this.carpetaAdministrativa = carpetaAdministrativa;
	}

	public List<ProyectoEntregableDO> getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(List<ProyectoEntregableDO> protocolo) {
		this.protocolo = protocolo;
	}

	public List<ProyectoEntregableDO> getOt() {
		return ot;
	}

	public void setOt(List<ProyectoEntregableDO> ot) {
		this.ot = ot;
	}

	public List<ProyectoEntregableDO> getClienteSatisfecho() {
		return clienteSatisfecho;
	}

	public void setClienteSatisfecho(List<ProyectoEntregableDO> clienteSatisfecho) {
		this.clienteSatisfecho = clienteSatisfecho;
	}

	public List<ProyectoEntregableDO> getChecklistInspeccion() {
		return checklistInspeccion;
	}

	public void setChecklistInspeccion(
			List<ProyectoEntregableDO> checklistInspeccion) {
		this.checklistInspeccion = checklistInspeccion;
	}

	public List<ProyectoEntregableDO> getChecklistFotografico() {
		return checklistFotografico;
	}

	public void setChecklistFotografico(
			List<ProyectoEntregableDO> checklistFotografico) {
		this.checklistFotografico = checklistFotografico;
	}

	public List<ProyectoEntregableDO> getAsBuild() {
		return asBuild;
	}

	public void setAsBuild(List<ProyectoEntregableDO> asBuild) {
		this.asBuild = asBuild;
	}

	public List<ProyectoEntregableDO> getEntregableX() {
		return entregableX;
	}

	public void setEntregableX(List<ProyectoEntregableDO> entregableX) {
		this.entregableX = entregableX;
	}

	public List<ProyectoEntregableDO> getEntregableY() {
		return entregableY;
	}

	public void setEntregableY(List<ProyectoEntregableDO> entregableY) {
		this.entregableY = entregableY;
	}

	public Boolean getEntregablesCompletos() {
		return entregablesCompletos;
	}

	public void setEntregablesCompletos(Boolean entregablesCompletos) {
		this.entregablesCompletos = entregablesCompletos;
	}

	public EstadoValidacionOperativaDO getEstadoValidacionOperativa() {
		return estadoValidacionOperativa;
	}

	public void setEstadoValidacionOperativa(
			EstadoValidacionOperativaDO estadoValidacionOperativa) {
		this.estadoValidacionOperativa = estadoValidacionOperativa;
	}

	public Date getFechaValidacionOperativa() {
		return fechaValidacionOperativa;
	}

	public void setFechaValidacionOperativa(Date fechaValidacionOperativa) {
		this.fechaValidacionOperativa = fechaValidacionOperativa;
	}

}