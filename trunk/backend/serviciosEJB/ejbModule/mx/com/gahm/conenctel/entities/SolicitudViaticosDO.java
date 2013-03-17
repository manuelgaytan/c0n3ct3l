/**
 * 
 */
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
 * @author MHDolores
 *
 */

@Entity
@Table(name = "SolicitudViaticos")
@NamedQueries({
	@NamedQuery(name = "SolicitudViaticosDO.findAll", query = "select rc from SolicitudViaticosDO rc")
	})
public class SolicitudViaticosDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6720584927530165291L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_proyecto", nullable = false)
	private ProyectoDO proyecto;
	
	@ManyToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private ColaboradorDO colaborador;

	@ManyToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private MedioTransporteDO medioTransporte;
	
	@Column(name = "numero_vehiculo", nullable = false)
	private String numeroVehiculo;
	
	@Column(name = "kilometraje_inicial", nullable = false)
	private String kilometrajeInicial;
	
	@Column(name = "combustible", nullable = false)
	private Double combustible;
	
	@Column(name = "casetas", nullable = false)
	private Double casetas;
	
	@Column(name = "pasajes", nullable = false)
	private Double pasajes;
	
	@Column(name = "hospedaje", nullable = false)
	private Double hospedaje;
	
	@Column(name = "alimentos", nullable = false)
	private Double alimentos;
	
	@Column(name = "materiales_herramienta", nullable = false)
	private Double materialesHerramienta;
	
	@Column(name = "otros", nullable = false)
	private Double otros;

	@Column(name = "total_solicitado", nullable = false)
	private Double totalSolicitado;

	public SolicitudViaticosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudViaticosDO(Integer id, ProyectoDO proyecto,
			ColaboradorDO colaborador, MedioTransporteDO medioTransporte,
			String numeroVehiculo, String kilometrajeInicial,
			Double combustible, Double casetas, Double pasajes,
			Double hospedaje, Double alimentos, Double materialesHerramienta,
			Double otros, Double totalSolicitado) {
		super();
		this.id = id;
		this.proyecto = proyecto;
		this.colaborador = colaborador;
		this.medioTransporte = medioTransporte;
		this.numeroVehiculo = numeroVehiculo;
		this.kilometrajeInicial = kilometrajeInicial;
		this.combustible = combustible;
		this.casetas = casetas;
		this.pasajes = pasajes;
		this.hospedaje = hospedaje;
		this.alimentos = alimentos;
		this.materialesHerramienta = materialesHerramienta;
		this.otros = otros;
		this.totalSolicitado = totalSolicitado;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the proyecto
	 */
	public ProyectoDO getProyecto() {
		return proyecto;
	}

	/**
	 * @param proyecto the proyecto to set
	 */
	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	/**
	 * @return the colaborador
	 */
	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	/**
	 * @param colaborador the colaborador to set
	 */
	public void setColaborador(ColaboradorDO colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * @return the medioTransporte
	 */
	public MedioTransporteDO getMedioTransporte() {
		return medioTransporte;
	}

	/**
	 * @param medioTransporte the medioTransporte to set
	 */
	public void setMedioTransporte(MedioTransporteDO medioTransporte) {
		this.medioTransporte = medioTransporte;
	}

	/**
	 * @return the numeroVehiculo
	 */
	public String getNumeroVehiculo() {
		return numeroVehiculo;
	}

	/**
	 * @param numeroVehiculo the numeroVehiculo to set
	 */
	public void setNumeroVehiculo(String numeroVehiculo) {
		this.numeroVehiculo = numeroVehiculo;
	}

	/**
	 * @return the kilometrajeInicial
	 */
	public String getKilometrajeInicial() {
		return kilometrajeInicial;
	}

	/**
	 * @param kilometrajeInicial the kilometrajeInicial to set
	 */
	public void setKilometrajeInicial(String kilometrajeInicial) {
		this.kilometrajeInicial = kilometrajeInicial;
	}

	/**
	 * @return the combustible
	 */
	public Double getCombustible() {
		return combustible;
	}

	/**
	 * @param combustible the combustible to set
	 */
	public void setCombustible(Double combustible) {
		this.combustible = combustible;
	}

	/**
	 * @return the casetas
	 */
	public Double getCasetas() {
		return casetas;
	}

	/**
	 * @param casetas the casetas to set
	 */
	public void setCasetas(Double casetas) {
		this.casetas = casetas;
	}

	/**
	 * @return the pasajes
	 */
	public Double getPasajes() {
		return pasajes;
	}

	/**
	 * @param pasajes the pasajes to set
	 */
	public void setPasajes(Double pasajes) {
		this.pasajes = pasajes;
	}

	/**
	 * @return the hospedaje
	 */
	public Double getHospedaje() {
		return hospedaje;
	}

	/**
	 * @param hospedaje the hospedaje to set
	 */
	public void setHospedaje(Double hospedaje) {
		this.hospedaje = hospedaje;
	}

	/**
	 * @return the alimentos
	 */
	public Double getAlimentos() {
		return alimentos;
	}

	/**
	 * @param alimentos the alimentos to set
	 */
	public void setAlimentos(Double alimentos) {
		this.alimentos = alimentos;
	}

	/**
	 * @return the materialesHerramienta
	 */
	public Double getMaterialesHerramienta() {
		return materialesHerramienta;
	}

	/**
	 * @param materialesHerramienta the materialesHerramienta to set
	 */
	public void setMaterialesHerramienta(Double materialesHerramienta) {
		this.materialesHerramienta = materialesHerramienta;
	}

	/**
	 * @return the otros
	 */
	public Double getOtros() {
		return otros;
	}

	/**
	 * @param otros the otros to set
	 */
	public void setOtros(Double otros) {
		this.otros = otros;
	}

	/**
	 * @return the totalSolicitado
	 */
	public Double getTotalSolicitado() {
		return totalSolicitado;
	}

	/**
	 * @param totalSolicitado the totalSolicitado to set
	 */
	public void setTotalSolicitado(Double totalSolicitado) {
		this.totalSolicitado = totalSolicitado;
	}
	
	
	
	

	
}
