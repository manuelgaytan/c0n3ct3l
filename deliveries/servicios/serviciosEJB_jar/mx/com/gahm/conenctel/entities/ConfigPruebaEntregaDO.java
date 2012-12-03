package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;


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

	@ManyToOne
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

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

}