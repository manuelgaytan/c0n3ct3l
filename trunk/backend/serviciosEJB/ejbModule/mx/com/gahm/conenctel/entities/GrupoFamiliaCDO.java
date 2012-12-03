package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla grupofamiliac.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoFamiliaCDO.findAll", query = "select g from GrupoFamiliaCDO g") })
@Table(name="grupofamiliac")
public class GrupoFamiliaCDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="grupo_familia")
	private String etiqueta;

//	@OneToMany(mappedBy="fkGrupoFamiliaC")
//	private List<MaterialDO> materials;

	public GrupoFamiliaCDO() {
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

//	public List<MaterialDO> getMaterials() {
//		return this.materials;
//	}
//
//	public void setMaterials(List<MaterialDO> materials) {
//		this.materials = materials;
//	}

}