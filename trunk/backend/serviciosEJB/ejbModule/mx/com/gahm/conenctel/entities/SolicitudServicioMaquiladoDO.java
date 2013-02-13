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
	@Column(name = "fecha", nullable = false, length = 10)
	private Date fecha;
	@ManyToOne
   	@JoinColumn(name="fk_proyecto_padre")
	private ProyectoPadreDO proyectoPadre;
	@ManyToOne
   	@JoinColumn(name="fk_proyecto")
	private ProyectoDO proyecto;
	
	
	public SolicitudServicioMaquiladoDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SolicitudServicioMaquiladoDO(Integer id, Date fecha,
			ProyectoPadreDO proyectoPadre, ProyectoDO proyecto) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.proyectoPadre = proyectoPadre;
		this.proyecto = proyecto;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public ProyectoPadreDO getProyectoPadre() {
		return proyectoPadre;
	}


	public void setProyectoPadre(ProyectoPadreDO proyectoPadre) {
		this.proyectoPadre = proyectoPadre;
	}


	public ProyectoDO getProyecto() {
		return proyecto;
	}


	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}



}
