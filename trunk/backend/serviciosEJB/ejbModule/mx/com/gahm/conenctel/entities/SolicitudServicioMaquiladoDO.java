/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 * 
 */
@Entity
@Table(name = "SolicitudServicioMaquilado")
@NamedQueries({
	@NamedQuery(name = "SolicitudServicioMaquiladoDO.findAll", query = "select so from SolicitudServicioMaquiladoDO so"),
	@NamedQuery(name = "SolicitudServicioMaquiladoDO.findById", 
				query = "select so from SolicitudServicioMaquiladoDO so where so.id = :id")})
public class SolicitudServicioMaquiladoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2368324208155747289L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_operacion", nullable = false, length = 10)
	private Date fechaOperacion;
	@ManyToOne
   	@JoinColumn(name="fk_proyecto_padre")
	private ProyectoPadreDO proyectoPadre;
	@ManyToOne
   	@JoinColumn(name="fk_estado_solicitud_servicio_maquilado")
	private EstadoSolicitudServicioMaquiladoDO estadoSolicitudServicioMaquilado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaOperacion() {
		return fechaOperacion;
	}

	public void setFechaOperacion(Date fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	public ProyectoPadreDO getProyectoPadre() {
		return proyectoPadre;
	}

	public void setProyectoPadre(ProyectoPadreDO proyectoPadre) {
		this.proyectoPadre = proyectoPadre;
	}

	public EstadoSolicitudServicioMaquiladoDO getEstadoSolicitudServicioMaquilado() {
		return estadoSolicitudServicioMaquilado;
	}

	public void setEstadoSolicitudServicioMaquilado(
			EstadoSolicitudServicioMaquiladoDO estadoSolicitudServicioMaquilado) {
		this.estadoSolicitudServicioMaquilado = estadoSolicitudServicioMaquilado;
	}

}
