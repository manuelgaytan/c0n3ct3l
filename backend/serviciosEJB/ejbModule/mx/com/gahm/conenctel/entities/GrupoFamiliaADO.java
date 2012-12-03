package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla grupofamiliaa.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoFamiliaADO.findAll", query = "select g from GrupoFamiliaADO g") })
@Table(name="grupofamiliaa")
public class GrupoFamiliaADO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="grupo_familia")
	private String etiqueta;

//	@OneToMany(mappedBy="fkGrupoFamiliaA")
//	private List<HerramientaDO> herramientas;

	public GrupoFamiliaADO() {
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