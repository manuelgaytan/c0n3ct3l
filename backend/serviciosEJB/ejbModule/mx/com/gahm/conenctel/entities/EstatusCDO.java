package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla estatusc.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EstatusCDO.findAll", query = "select e from EstatusCDO e") })
@Table(name="estatusc")
public class EstatusCDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="estatus")
	private String etiqueta;

//	@OneToMany(mappedBy="fkEstatusC")
//	private List<ConsumibleDO> consumibles;
//
//	@OneToMany(mappedBy="fkEstatusC")
//	private List<MaterialDO> materials;

	public EstatusCDO() {
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

}