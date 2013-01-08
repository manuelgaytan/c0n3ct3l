package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla grupofamiliae.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoFamiliaEDO.findAll", query = "select g from GrupoFamiliaEDO g") })
@Table(name="grupofamiliae")
public class GrupoFamiliaEDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="grupo_familia")
	private String etiqueta;

//	@OneToMany(mappedBy="fkGrupoFamiliaE")
//	private List<HardwareDO> hardwares;

	public GrupoFamiliaEDO() {
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

//	public List<HardwareDO> getHardwares() {
//		return this.hardwares;
//	}
//
//	public void setHardwares(List<HardwareDO> hardwares) {
//		this.hardwares = hardwares;
//	}

}