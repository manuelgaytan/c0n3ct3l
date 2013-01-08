package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla pantalla.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="pantalla")
public class PantallaDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String pantalla;

	public PantallaDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPantalla() {
		return this.pantalla;
	}

	public void setPantalla(String pantalla) {
		this.pantalla = pantalla;
	}

}