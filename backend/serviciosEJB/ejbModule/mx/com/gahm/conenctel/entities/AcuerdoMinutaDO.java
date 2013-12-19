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
@Table(name = "AcuerdoMinuta")
@NamedQueries({
	@NamedQuery(name = "AcuerdoMinutaDO.findAll", query = "select rc from AcuerdoMinutaDO rc")
	})
public class AcuerdoMinutaDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9129720797707900471L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_minuta", nullable = false)
	private MinutaDO minuta;
	
	@ManyToOne
	@JoinColumn(name = "fk_responsable_minuta", nullable = false)
	private ResponsableMinutaDO responsableMinuta;
	
	

	@Column(name = "responsable", nullable = false)
	private String responsable;
	

	@Column(name = "acuerdo", nullable = false)
	private String acuerdo;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_compromiso", nullable = false, length = 10)
	private Date fechaCompromiso;

	@Column(name = "responsable_elaboracion", nullable = false)
	private String responsableElaboracion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_cumplimiento", nullable = false, length = 10)
	private Date fechaCumplimiento;
	
	public AcuerdoMinutaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcuerdoMinutaDO(Integer id, MinutaDO minuta,
			ResponsableMinutaDO responsableMinuta, String responsable,
			String acuerdo, Date fechaCompromiso, String responsableElaboracion,
			Date fechaCumplimiento) {
		super();
		this.id = id;
		this.minuta = minuta;
		this.responsableMinuta = responsableMinuta;
		this.responsable = responsable;
		this.acuerdo = acuerdo;
		this.fechaCompromiso = fechaCompromiso;
		this.responsableElaboracion = responsableElaboracion;
		this.fechaCumplimiento = fechaCumplimiento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MinutaDO getMinuta() {
		return minuta;
	}

	public void setMinuta(MinutaDO minuta) {
		this.minuta = minuta;
	}

	public ResponsableMinutaDO getResponsableMinuta() {
		return responsableMinuta;
	}

	public void setResponsableMinuta(ResponsableMinutaDO responsableMinuta) {
		this.responsableMinuta = responsableMinuta;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}

	public Date getFechaCompromiso() {
		return fechaCompromiso;
	}

	public void setFechaCompromiso(Date fechaCompromiso) {
		this.fechaCompromiso = fechaCompromiso;
	}

	public String getResponsableElaboracion() {
		return responsableElaboracion;
	}

	public void setResponsableElaboracion(String responsableElaboracion) {
		this.responsableElaboracion = responsableElaboracion;
	}

	public Date getFechaCumplimiento() {
		return fechaCumplimiento;
	}

	public void setFechaCumplimiento(Date fechaCumplimiento) {
		this.fechaCumplimiento = fechaCumplimiento;
	}
	
	

}
