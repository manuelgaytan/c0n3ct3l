package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla unidada.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "UnidadADO.findAll", query = "select u from UnidadADO u") })
@Table(name="unidada")
public class UnidadADO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="unidad")
	private String etiqueta;

//	@OneToMany(mappedBy="fkUnidadA")
//	private List<HerramientaDO> herramientas;

	public UnidadADO() {
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

//	public List<HerramientaDO> getHerramientas() {
//		return this.herramientas;
//	}
//
//	public void setHerramientas(List<HerramientaDO> herramientas) {
//		this.herramientas = herramientas;
//	}

}