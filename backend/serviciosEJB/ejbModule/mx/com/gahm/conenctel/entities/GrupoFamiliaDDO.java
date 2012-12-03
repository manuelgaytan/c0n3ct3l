package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla grupofamiliad.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoFamiliaDDO.findAll", query = "select g from GrupoFamiliaDDO g") })
@Table(name="grupofamiliad")
public class GrupoFamiliaDDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="grupo_familia")
	private String etiqueta;

//	@OneToMany(mappedBy="fkGrupoFamiliaD")
//	private List<ConsumibleDO> consumibles;

	public GrupoFamiliaDDO() {
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

//	public List<ConsumibleDO> getConsumibles() {
//		return this.consumibles;
//	}
//
//	public void setConsumibles(List<ConsumibleDO> consumibles) {
//		this.consumibles = consumibles;
//	}

}