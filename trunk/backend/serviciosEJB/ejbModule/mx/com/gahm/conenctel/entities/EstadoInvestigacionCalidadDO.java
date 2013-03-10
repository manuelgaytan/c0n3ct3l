package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "EstadoInvestigacionCalidad")
@NamedQueries({
	@NamedQuery(name = "EstadoInvestigacionCalidadDO.findAll", query = "select rc from EstadoInvestigacionCalidadDO rc")
	})
public class EstadoInvestigacionCalidadDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5972296087158828603L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="estado")
	private String etiqueta;

	public EstadoInvestigacionCalidadDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoInvestigacionCalidadDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	
}
