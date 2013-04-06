/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "InformacionPrenomina")
@NamedQueries({
	@NamedQuery(name = "InformacionPrenominaDO.findAll", query = "select rc from InformacionPrenominaDO rc")
	})

public class InformacionPrenominaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2215643715895872499L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private ContratacionDO contratacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_clase_incidencia", nullable = false)
	private ClaseIncidenciaDO claseIncidencia;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_incapacidad", nullable = false)
	private TipoIncapacidadDO tipoIncapacidad;
	
	@Column(name = "monto_imss", nullable = false)
	private Double montoImss;
	
	@Column(name = "monto_conectel", nullable = false)
	private Double montoConectel;

	public InformacionPrenominaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InformacionPrenominaDO(Integer id, ContratacionDO contratacion,
			ClaseIncidenciaDO claseIncidencia,
			TipoIncapacidadDO tipoIncapacidad, Double montoImss,
			Double montoConectel) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.claseIncidencia = claseIncidencia;
		this.tipoIncapacidad = tipoIncapacidad;
		this.montoImss = montoImss;
		this.montoConectel = montoConectel;
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
	 * @return the contratacion
	 */
	public ContratacionDO getContratacion() {
		return contratacion;
	}

	/**
	 * @param contratacion the contratacion to set
	 */
	public void setContratacion(ContratacionDO contratacion) {
		this.contratacion = contratacion;
	}

	/**
	 * @return the claseIncidencia
	 */
	public ClaseIncidenciaDO getClaseIncidencia() {
		return claseIncidencia;
	}

	/**
	 * @param claseIncidencia the claseIncidencia to set
	 */
	public void setClaseIncidencia(ClaseIncidenciaDO claseIncidencia) {
		this.claseIncidencia = claseIncidencia;
	}

	/**
	 * @return the tipoIncapacidad
	 */
	public TipoIncapacidadDO getTipoIncapacidad() {
		return tipoIncapacidad;
	}

	/**
	 * @param tipoIncapacidad the tipoIncapacidad to set
	 */
	public void setTipoIncapacidad(TipoIncapacidadDO tipoIncapacidad) {
		this.tipoIncapacidad = tipoIncapacidad;
	}

	/**
	 * @return the montoImss
	 */
	public Double getMontoImss() {
		return montoImss;
	}

	/**
	 * @param montoImss the montoImss to set
	 */
	public void setMontoImss(Double montoImss) {
		this.montoImss = montoImss;
	}

	/**
	 * @return the montoConectel
	 */
	public Double getMontoConectel() {
		return montoConectel;
	}

	/**
	 * @param montoConectel the montoConectel to set
	 */
	public void setMontoConectel(Double montoConectel) {
		this.montoConectel = montoConectel;
	}
	
	
	
	
	
}
