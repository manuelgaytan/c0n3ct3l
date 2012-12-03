package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla grupofamiliab.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoFamiliaBDO.findAll", query = "select g from GrupoFamiliaBDO g") })
@Table(name="grupofamiliab")
public class GrupoFamiliaBDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="grupo_familia")
	private String etiqueta;

//	@OneToMany(mappedBy="grupofamiliab")
//	private List<EquipoTransporteDO> equipotransportes;

	public GrupoFamiliaBDO() {
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

//	public List<EquipoTransporteDO> getEquipotransportes() {
//		return this.equipotransportes;
//	}
//
//	public void setEquipotransportes(List<EquipoTransporteDO> equipotransportes) {
//		this.equipotransportes = equipotransportes;
//	}

}