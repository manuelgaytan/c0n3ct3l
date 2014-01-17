package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla desarrolloproyectoayb.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "DesarrolloProyectoABDO.findAll", query = "select d from DesarrolloProyectoABDO d where d.proyecto.estado.id=2"),
	@NamedQuery(name = "DesarrolloProyectoABDO.getByIdProyecto", query = "select d from DesarrolloProyectoABDO d where d.proyecto.id=:idProyecto") })
@Table(name="desarrolloproyectoayb")
public class DesarrolloProyectoABDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String alimentacion;

	private String aterrizaje;

	@Column(name="bastidor_gabinete")
	private String bastidorGabinete;

	private String cableado;

	private String champeado;

	private String controladora;

	@JoinColumn(name="id_plancha_base")
	private SeguimientoDO planchaBase;


	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="id_proyecto")
	private ProyectoDO proyecto;

	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="fk_tipo_desarrollo_proyecto")
	private TipoDesarrolloProyectoDO tipoDesarrolloProyecto;
	
	
	@Column(name="longitud_cable")
	private String longitudCable;

	@Column(name="no_cables")
	private String noCables;

	@Column(name="no_pares")
	private String noPares;

	@Column(name="no_puertos")
	private String noPuertos;

	@Column(name="pares_fo")
	private String paresFo;

	@Column(name="puertos_ot")
	private String puertosOt;

	private String repisa;

	private String rotulo;

	@Column(name="slots_cables")
	private String slotsCables;

	@Column(name="tarjeta_1")
	private String tarjeta1;

	@Column(name="tarjeta_2")
	private String tarjeta2;

	@Column(name="tarjeta_3")
	private String tarjeta3;

	@Column(name="tarjeta_4")
	private String tarjeta4;

	@Column(name="tarjeta_5")
	private String tarjeta5;

	@Column(name="tarjeta_6")
	private String tarjeta6;

	private String timbrado;

	private String version;

	@JoinColumn(name="id_fibra_cliente_final")
	private SeguimientoDO fibraClienteFinal;

	@JoinColumn(name="id_soportes")
	private SeguimientoDO soportes;

	@JoinColumn(name="id_antena")
	private SeguimientoDO antena;

	@JoinColumn(name="id_radio")
	private SeguimientoDO radio;

	@JoinColumn(name="id_radio_cable")
	private SeguimientoDO radioCable;

	@JoinColumn(name="id_aterrizaje_seguimiento")
	private SeguimientoDO aterrizajeSeguimiento;

	@JoinColumn(name="id_alimentacion_seguimiento")
	private SeguimientoDO alimentacionSeguimiento;

	public DesarrolloProyectoABDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAlimentacion() {
		return this.alimentacion;
	}

	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}

	public String getAterrizaje() {
		return this.aterrizaje;
	}

	public void setAterrizaje(String aterrizaje) {
		this.aterrizaje = aterrizaje;
	}

	public String getBastidorGabinete() {
		return this.bastidorGabinete;
	}

	public void setBastidorGabinete(String bastidorGabinete) {
		this.bastidorGabinete = bastidorGabinete;
	}

	public String getCableado() {
		return this.cableado;
	}

	public void setCableado(String cableado) {
		this.cableado = cableado;
	}

	public String getChampeado() {
		return this.champeado;
	}

	public void setChampeado(String champeado) {
		this.champeado = champeado;
	}

	public String getControladora() {
		return this.controladora;
	}

	public void setControladora(String controladora) {
		this.controladora = controladora;
	}

	public SeguimientoDO getPlanchaBase() {
		return planchaBase;
	}

	public void setPlanchaBase(SeguimientoDO planchaBase) {
		this.planchaBase = planchaBase;
	}

	public ProyectoDO getProyecto() {
		return proyecto;
	}

	public void setProyecto(ProyectoDO proyecto) {
		this.proyecto = proyecto;
	}

	public String getLongitudCable() {
		return this.longitudCable;
	}

	public void setLongitudCable(String longitudCable) {
		this.longitudCable = longitudCable;
	}

	public String getNoCables() {
		return this.noCables;
	}

	public void setNoCables(String noCables) {
		this.noCables = noCables;
	}

	public String getNoPares() {
		return this.noPares;
	}

	public void setNoPares(String noPares) {
		this.noPares = noPares;
	}

	public String getNoPuertos() {
		return this.noPuertos;
	}

	public void setNoPuertos(String noPuertos) {
		this.noPuertos = noPuertos;
	}

	public String getParesFo() {
		return this.paresFo;
	}

	public void setParesFo(String paresFo) {
		this.paresFo = paresFo;
	}

	public String getPuertosOt() {
		return this.puertosOt;
	}

	public void setPuertosOt(String puertosOt) {
		this.puertosOt = puertosOt;
	}

	public String getRepisa() {
		return this.repisa;
	}

	public void setRepisa(String repisa) {
		this.repisa = repisa;
	}

	public String getRotulo() {
		return this.rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getSlotsCables() {
		return this.slotsCables;
	}

	public void setSlotsCables(String slotsCables) {
		this.slotsCables = slotsCables;
	}

	public String getTarjeta1() {
		return this.tarjeta1;
	}

	public void setTarjeta1(String tarjeta1) {
		this.tarjeta1 = tarjeta1;
	}

	public String getTarjeta2() {
		return this.tarjeta2;
	}

	public void setTarjeta2(String tarjeta2) {
		this.tarjeta2 = tarjeta2;
	}

	public String getTarjeta3() {
		return this.tarjeta3;
	}

	public void setTarjeta3(String tarjeta3) {
		this.tarjeta3 = tarjeta3;
	}

	public String getTarjeta4() {
		return this.tarjeta4;
	}

	public void setTarjeta4(String tarjeta4) {
		this.tarjeta4 = tarjeta4;
	}

	public String getTarjeta5() {
		return this.tarjeta5;
	}

	public void setTarjeta5(String tarjeta5) {
		this.tarjeta5 = tarjeta5;
	}

	public String getTarjeta6() {
		return this.tarjeta6;
	}

	public void setTarjeta6(String tarjeta6) {
		this.tarjeta6 = tarjeta6;
	}

	public String getTimbrado() {
		return this.timbrado;
	}

	public void setTimbrado(String timbrado) {
		this.timbrado = timbrado;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public SeguimientoDO getFibraClienteFinal() {
		return fibraClienteFinal;
	}

	public void setFibraClienteFinal(SeguimientoDO fibraClienteFinal) {
		this.fibraClienteFinal = fibraClienteFinal;
	}

	public SeguimientoDO getSoportes() {
		return soportes;
	}

	public void setSoportes(SeguimientoDO soportes) {
		this.soportes = soportes;
	}

	public SeguimientoDO getAntena() {
		return antena;
	}

	public void setAntena(SeguimientoDO antena) {
		this.antena = antena;
	}

	public SeguimientoDO getRadio() {
		return radio;
	}

	public void setRadio(SeguimientoDO radio) {
		this.radio = radio;
	}

	public SeguimientoDO getRadioCable() {
		return radioCable;
	}

	public void setRadioCable(SeguimientoDO radioCable) {
		this.radioCable = radioCable;
	}

	public SeguimientoDO getAterrizajeSeguimiento() {
		return aterrizajeSeguimiento;
	}

	public void setAterrizajeSeguimiento(SeguimientoDO aterrizajeSeguimiento) {
		this.aterrizajeSeguimiento = aterrizajeSeguimiento;
	}

	public SeguimientoDO getAlimentacionSeguimiento() {
		return alimentacionSeguimiento;
	}

	public void setAlimentacionSeguimiento(SeguimientoDO alimentacionSeguimiento) {
		this.alimentacionSeguimiento = alimentacionSeguimiento;
	}

	/**
	 * @return the tipoDesarrolloProyecto
	 */
	public TipoDesarrolloProyectoDO getTipoDesarrolloProyecto() {
		return tipoDesarrolloProyecto;
	}

	/**
	 * @param tipoDesarrolloProyecto the tipoDesarrolloProyecto to set
	 */
	public void setTipoDesarrolloProyecto(
			TipoDesarrolloProyectoDO tipoDesarrolloProyecto) {
		this.tipoDesarrolloProyecto = tipoDesarrolloProyecto;
	}

}