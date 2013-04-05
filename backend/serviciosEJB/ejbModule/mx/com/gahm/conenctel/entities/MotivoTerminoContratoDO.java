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
@Table(name = "MotivoTerminoContrato")
@NamedQueries({
	@NamedQuery(name = "MotivoTerminoContratoDO.findAll", query = "select rc from MotivoTerminoContratoDO rc")
	})
public class MotivoTerminoContratoDO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4516047467462097708L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@Column(name="motivo")
	private String etiqueta;

	public MotivoTerminoContratoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MotivoTerminoContratoDO(long id, String etiqueta) {
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
