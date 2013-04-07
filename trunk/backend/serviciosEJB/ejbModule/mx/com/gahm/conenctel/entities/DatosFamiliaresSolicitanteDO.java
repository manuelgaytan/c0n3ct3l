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
@Table(name = "DatosFamiliaresSolicitante")
@NamedQueries({ @NamedQuery(name = "DatosFamiliaresSolicitanteDO.findAll", query = "select rc from DatosFamiliaresSolicitanteDO rc") })
public class DatosFamiliaresSolicitanteDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8937722980043147903L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@OneToOne
	@JoinColumn(name = "fk_reclutamiento_solicitud_empleo", nullable = false)
	private ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo;

	@ManyToOne
	@JoinColumn(name = "fk_vive_con", nullable = false)
	private ViveConDO viveCon;

	@ManyToOne
	@JoinColumn(name = "fk_dependientes", nullable = false)
	private ViveConDO dependientes;

	public DatosFamiliaresSolicitanteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DatosFamiliaresSolicitanteDO(Integer id,
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo,
			ViveConDO viveCon, ViveConDO dependientes) {
		super();
		this.id = id;
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
		this.viveCon = viveCon;
		this.dependientes = dependientes;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the reclutamientoSolicitudEmpleo
	 */
	public ReclutamientoSolicitudEmpleoDO getReclutamientoSolicitudEmpleo() {
		return reclutamientoSolicitudEmpleo;
	}

	/**
	 * @param reclutamientoSolicitudEmpleo
	 *            the reclutamientoSolicitudEmpleo to set
	 */
	public void setReclutamientoSolicitudEmpleo(
			ReclutamientoSolicitudEmpleoDO reclutamientoSolicitudEmpleo) {
		this.reclutamientoSolicitudEmpleo = reclutamientoSolicitudEmpleo;
	}

	/**
	 * @return the viveCon
	 */
	public ViveConDO getViveCon() {
		return viveCon;
	}

	/**
	 * @param viveCon
	 *            the viveCon to set
	 */
	public void setViveCon(ViveConDO viveCon) {
		this.viveCon = viveCon;
	}

	/**
	 * @return the dependientes
	 */
	public ViveConDO getDependientes() {
		return dependientes;
	}

	/**
	 * @param dependientes
	 *            the dependientes to set
	 */
	public void setDependientes(ViveConDO dependientes) {
		this.dependientes = dependientes;
	}

}
