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
@NamedQueries({
	@NamedQuery(name = "ActividadTiempoLibreDO.findAll", query = "select c from ActividadTiempoLibreDO c") })
@Table(name="ActividadTiempoLibre")
public class ActividadTiempoLibreDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1664554012218904915L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="categoria")
	private String etiqueta;

	public ActividadTiempoLibreDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActividadTiempoLibreDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}	
