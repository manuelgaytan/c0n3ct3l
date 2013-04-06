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
	@NamedQuery(name = "ClasificacionPermisoDO.findAll", query = "select c from ClasificacionPermisoDO c") })
@Table(name="ClasificacionPermiso")
public class ClasificacionPermisoDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7463329554618982019L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="tipo")
	private String etiqueta;

	public ClasificacionPermisoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClasificacionPermisoDO(long id, String etiqueta) {
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
