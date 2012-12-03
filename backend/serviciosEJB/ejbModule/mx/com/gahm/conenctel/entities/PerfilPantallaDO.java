package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla perfilpantalla.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="perfilpantalla")
public class PerfilPantallaDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name="id_perfil")
	private PerfilDO perfil;

	@ManyToOne
	@JoinColumn(name="id_pantalla")
	private PantallaDO pantalla;

	public PerfilPantallaDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PerfilDO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}

	public PantallaDO getPantalla() {
		return this.pantalla;
	}

	public void setPantalla(PantallaDO pantalla) {
		this.pantalla = pantalla;
	}

}