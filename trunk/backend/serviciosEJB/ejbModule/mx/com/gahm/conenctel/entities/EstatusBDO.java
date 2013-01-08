package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla estatusb.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EstatusBDO.findAll", query = "select e from EstatusBDO e") })
@Table(name="estatusb")
public class EstatusBDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="estatus")
	private String etiqueta;

//	@OneToMany(mappedBy="estatusb")
//	private List<EquipoTransporteDO> equipotransportes;
//
//	@OneToMany(mappedBy="fkEstatusB")
//	private List<HardwareDO> hardwares;
//
//	@OneToMany(mappedBy="fkEstatusB")
//	private List<TelefoniaMovilDO> telefoniamovils;

	public EstatusBDO() {
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
//
//	public List<HardwareDO> getHardwares() {
//		return this.hardwares;
//	}
//
//	public void setHardwares(List<HardwareDO> hardwares) {
//		this.hardwares = hardwares;
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