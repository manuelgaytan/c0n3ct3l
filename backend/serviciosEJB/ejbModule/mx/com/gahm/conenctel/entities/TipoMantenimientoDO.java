package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla tipomantenimiento.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "TipoMantenimientoDO.findAll", query = "select t from TipoMantenimientoDO t") })
@Table(name="tipomantenimiento")
public class TipoMantenimientoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="tipo_mantenimiento")
	private String etiqueta;

//	@OneToMany(mappedBy="tipomantenimiento")
//	private List<EquipoMedicionDO> equipomedicions;
//
//	@OneToMany(mappedBy="tipomantenimiento")
//	private List<EquipoTransporteDO> equipotransportes;
//
//	@OneToMany(mappedBy="fkTipoMantenimiento")
//	private List<HardwareDO> hardwares;
//
//	@OneToMany(mappedBy="fkTipoMantenimiento")
//	private List<HerramientaDO> herramientas;

	public TipoMantenimientoDO() {
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

//	public List<EquipoMedicionDO> getEquipomedicions() {
//		return this.equipomedicions;
//	}
//
//	public void setEquipomedicions(List<EquipoMedicionDO> equipomedicions) {
//		this.equipomedicions = equipomedicions;
//	}
//
//	public List<EquipoTransporteDO> getEquipotransportes() {
//		return this.equipotransportes;
//	}
//
//	public void setEquipotransportes(List<EquipoTransporteDO> equipotransportes) {
//		this.equipotransportes = equipotransportes;
//	}
//
//	public List<HardwareDO> getHardwares() {
//		return this.hardwares;
//	}
//
//	public void setHardwares(List<HardwareDO> hardwares) {
//		this.hardwares = hardwares;
//	}
//
//	public List<HerramientaDO> getHerramientas() {
//		return this.herramientas;
//	}
//
//	public void setHerramientas(List<HerramientaDO> herramientas) {
//		this.herramientas = herramientas;
//	}

}