/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "Minuta")
@NamedQueries({
	@NamedQuery(name = "MinutaDO.findAll", query = "select rc from MinutaDO rc")
	})
public class MinutaDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6112727092653095631L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora", nullable = false)
	private Date fechaHora;
	
	@Column(name = "lugar", nullable = false)
	private String lugar;
	
	@Column(name = "asunto", nullable = false)
	private String asunto;
	
	@OneToMany(mappedBy="minuta", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<ParticipanteMinutaDO> participanteMinuta;
	
	@OneToMany(mappedBy="minuta", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<AcuerdoMinutaDO> acuerdoMinuta;

	public MinutaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MinutaDO(Integer id, Date fechaHora, String lugar, String asunto) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.lugar = lugar;
		this.asunto = asunto;
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
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}

	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public List<ParticipanteMinutaDO> getParticipanteMinuta() {
		return participanteMinuta;
	}

	public void setParticipanteMinuta(List<ParticipanteMinutaDO> participanteMinuta) {
		this.participanteMinuta = participanteMinuta;
	}

	public List<AcuerdoMinutaDO> getAcuerdoMinuta() {
		return acuerdoMinuta;
	}

	public void setAcuerdoMinuta(List<AcuerdoMinutaDO> acuerdoMinuta) {
		this.acuerdoMinuta = acuerdoMinuta;
	}
	
	
	

}
