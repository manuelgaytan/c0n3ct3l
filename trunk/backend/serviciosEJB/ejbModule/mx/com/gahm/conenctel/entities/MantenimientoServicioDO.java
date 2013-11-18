package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Clase de persistencia para la tabla MantenimientoServicio.
 * 
 * @author Manuel Gayt&aacute;n
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "MantenimientoServicioDO.findAll", query = "select e from MantenimientoServicioDO e") })
@Table(name="MantenimientoServicio")
public class MantenimientoServicioDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="tipo")
	private String etiqueta;

	public MantenimientoServicioDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
}