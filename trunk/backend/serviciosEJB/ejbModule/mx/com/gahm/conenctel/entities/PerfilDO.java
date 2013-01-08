package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla perfil.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "PerfilDO.findAll", query = "select p from PerfilDO p") })
@Table(name="perfil")
public class PerfilDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="perfil")
	private String etiqueta;

	@OneToMany(mappedBy="perfil", fetch = FetchType.EAGER)
	private List<PerfilPantallaDO> perfilPantallas;

	public PerfilDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public List<PerfilPantallaDO> getPerfilPantallas() {
		return perfilPantallas;
	}

	public void setPerfilPantallas(List<PerfilPantallaDO> perfilPantallas) {
		this.perfilPantallas = perfilPantallas;
	}

}