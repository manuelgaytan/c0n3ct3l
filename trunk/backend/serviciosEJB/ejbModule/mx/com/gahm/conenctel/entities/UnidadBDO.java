package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla unidadb.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "UnidadBDO.findAll", query = "select u from UnidadBDO u") })
@Table(name="unidadb")
public class UnidadBDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="unidad")
	private String etiqueta;

//	@OneToMany(mappedBy="fkUnidadB")
//	private List<ConsumibleDO> consumibles;
//
//	@OneToMany(mappedBy="fkUnidadB")
//	private List<MaterialDO> materials;
//
//	@OneToMany(mappedBy="fkUnidadB")
//	private List<SolicitudAlmacenDO> solicitudalmacens;

	public UnidadBDO() {
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
//
//	public List<MaterialDO> getMaterials() {
//		return this.materials;
//	}
//
//	public void setMaterials(List<MaterialDO> materials) {
//		this.materials = materials;
//	}
//
//	public List<SolicitudAlmacenDO> getSolicitudalmacens() {
//		return this.solicitudalmacens;
//	}
//
//	public void setSolicitudalmacens(List<SolicitudAlmacenDO> solicitudalmacens) {
//		this.solicitudalmacens = solicitudalmacens;
//	}

}