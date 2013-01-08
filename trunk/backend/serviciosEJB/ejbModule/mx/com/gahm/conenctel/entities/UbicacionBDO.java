package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla ubicacionb.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "UbicacionBDO.findAll", query = "select u from UbicacionBDO u") })
@Table(name="ubicacionb")
public class UbicacionBDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="ubicacion")
	private String etiqueta;

//	@OneToMany(mappedBy="ubicacionb")
//	private List<EquipoMedicionDO> equipomedicions;
//
//	@OneToMany(mappedBy="ubicacionb")
//	private List<EquipoTransporteDO> equipotransportes;
//
//	@OneToMany(mappedBy="fkUbicacionB")
//	private List<HardwareDO> hardwares;
//
//	@OneToMany(mappedBy="fkUbicacionB")
//	private List<MaterialDO> materials;
//
//	@OneToMany(mappedBy="fkUbicacionB")
//	private List<SoftwareDO> softwares;
//
//	@OneToMany(mappedBy="fkUbicacionB")
//	private List<TelefoniaMovilDO> telefoniamovils;

	public UbicacionBDO() {
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
//	public List<MaterialDO> getMaterials() {
//		return this.materials;
//	}
//
//	public void setMaterials(List<MaterialDO> materials) {
//		this.materials = materials;
//	}
//
//	public List<SoftwareDO> getSoftwares() {
//		return this.softwares;
//	}
//
//	public void setSoftwares(List<SoftwareDO> softwares) {
//		this.softwares = softwares;
//	}
//
//	public List<TelefoniaMovilDO> getTelefoniamovils() {
//		return this.telefoniamovils;
//	}
//
//	public void setTelefoniamovils(List<TelefoniaMovilDO> telefoniamovils) {
//		this.telefoniamovils = telefoniamovils;
//	}

}