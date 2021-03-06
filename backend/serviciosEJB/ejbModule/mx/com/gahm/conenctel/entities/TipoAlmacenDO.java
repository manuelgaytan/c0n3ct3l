package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * Clase de persistencia para la tabla tipoalmacen.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({ @NamedQuery(name = "TipoAlmacenDO.findAll", query = "select t from TipoAlmacenDO t") })
@Table(name = "tipoalmacen")
public class TipoAlmacenDO implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final long ID_HERRAMIENTA = 1L;
	public static final String HERRAMIENTA = "Herramienta";
	public static final long ID_EQUIPO_MEDICION = 2L;
	public static final String EQUIPO_MEDICION = "Equipo de Medici�n";
	public static final long ID_EQUIPO_TRANSPORTE = 3;
	public static final String EQUIPO_TRANSPORTE = "Equipo de Transporte";
	public static final long ID_MATERIALES = 4;
	public static final String MATERIALES = "Materiales";
	public static final long ID_CONSUMIBLES = 5;
	public static final String CONSUMIBLES = "Consumibles";
	public static final long ID_HARDWARE = 6;
	public static final String HARDWARE = "Hardware";
	public static final long ID_SOFTWARE = 7;
	public static final String SOFTWARE = "Software";
	public static final long ID_TELEFONIA_MOVIL = 8;
	public static final String TELEFONIA_MOVIL = "Telefon�a M�vil";
	public static final long ID_SOLICITUD_ALMACEN = 9;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tipo")
	private String etiqueta;

	public TipoAlmacenDO(Long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public static TipoAlmacenDO getHerramienta() {
		TipoAlmacenDO tipoAlmacen = new TipoAlmacenDO(ID_HERRAMIENTA,
				HERRAMIENTA);
		return tipoAlmacen;
	}

	// @OneToMany(mappedBy="fkTipoalmacen")
	// private List<ComentarioDO> comentarios;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<ConsumibleDO> consumibles;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<DocumentoAlmacenDO> documentoalmacens;
	//
	// @OneToMany(mappedBy="tipoalmacen")
	// private List<EquipoMedicionDO> equipomedicions;
	//
	// @OneToMany(mappedBy="tipoalmacen")
	// private List<EquipoTransporteDO> equipotransportes;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<HardwareDO> hardwares;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<HerramientaDO> herramientas;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<MaterialDO> materials;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<SoftwareDO> softwares;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<SolicitudAlmacenDO> solicitudalmacens;
	//
	// @OneToMany(mappedBy="fkTipoAlmacen")
	// private List<TelefoniaMovilDO> telefoniamovils;

	public TipoAlmacenDO() {
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

	// public List<ComentarioDO> getComentarios() {
	// return this.comentarios;
	// }
	//
	// public void setComentarios(List<ComentarioDO> comentarios) {
	// this.comentarios = comentarios;
	// }
	//
	// public List<ConsumibleDO> getConsumibles() {
	// return this.consumibles;
	// }
	//
	// public void setConsumibles(List<ConsumibleDO> consumibles) {
	// this.consumibles = consumibles;
	// }
	//
	// public List<DocumentoAlmacenDO> getDocumentoalmacens() {
	// return this.documentoalmacens;
	// }
	//
	// public void setDocumentoalmacens(List<DocumentoAlmacenDO>
	// documentoalmacens) {
	// this.documentoalmacens = documentoalmacens;
	// }
	//
	// public List<EquipoMedicionDO> getEquipomedicions() {
	// return this.equipomedicions;
	// }
	//
	// public void setEquipomedicions(List<EquipoMedicionDO> equipomedicions) {
	// this.equipomedicions = equipomedicions;
	// }
	//
	// public List<EquipoTransporteDO> getEquipotransportes() {
	// return this.equipotransportes;
	// }
	//
	// public void setEquipotransportes(List<EquipoTransporteDO>
	// equipotransportes) {
	// this.equipotransportes = equipotransportes;
	// }
	//
	// public List<HardwareDO> getHardwares() {
	// return this.hardwares;
	// }
	//
	// public void setHardwares(List<HardwareDO> hardwares) {
	// this.hardwares = hardwares;
	// }
	//
	// public List<HerramientaDO> getHerramientas() {
	// return this.herramientas;
	// }
	//
	// public void setHerramientas(List<HerramientaDO> herramientas) {
	// this.herramientas = herramientas;
	// }
	//
	// public List<MaterialDO> getMaterials() {
	// return this.materials;
	// }
	//
	// public void setMaterials(List<MaterialDO> materials) {
	// this.materials = materials;
	// }
	//
	// public List<SoftwareDO> getSoftwares() {
	// return this.softwares;
	// }
	//
	// public void setSoftwares(List<SoftwareDO> softwares) {
	// this.softwares = softwares;
	// }
	//
	// public List<SolicitudAlmacenDO> getSolicitudalmacens() {
	// return this.solicitudalmacens;
	// }
	//
	// public void setSolicitudalmacens(List<SolicitudAlmacenDO>
	// solicitudalmacens) {
	// this.solicitudalmacens = solicitudalmacens;
	// }
	//
	// public List<TelefoniaMovilDO> getTelefoniamovils() {
	// return this.telefoniamovils;
	// }
	//
	// public void setTelefoniamovils(List<TelefoniaMovilDO> telefoniamovils) {
	// this.telefoniamovils = telefoniamovils;
	// }

}