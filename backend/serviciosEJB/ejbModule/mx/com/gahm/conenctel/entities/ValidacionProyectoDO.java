/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 * 
 */
@Entity
@NamedQueries({ @NamedQuery(name = "ValidacionProyectoDO.findAll", 
query = "select s from ValidacionProyectoDO s where s.estadoValidacionOperativa.id=2") })
@Table(name = "ValidacionProyecto")
public class ValidacionProyectoDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4918211133861901166L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "fk_estado_validacion_operativa")
	private EstadoValidacionOperativaDO estadoValidacionOperativa;

	@OneToOne
	@JoinColumn(name = "fk_proyecto")
	private ProyectoDO proyecto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoValidacionOperativaDO getEstadoValidacionOperativa() {
		return estadoValidacionOperativa;
	}

	public void setEstadoValidacionOperativa(
			EstadoValidacionOperativaDO estadoValidacionOperativa) {
		this.estadoValidacionOperativa = estadoValidacionOperativa;
	}

	public ProyectoDO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

}
