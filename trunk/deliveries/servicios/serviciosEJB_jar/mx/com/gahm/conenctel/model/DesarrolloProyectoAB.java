package mx.com.gahm.conenctel.model;

import java.io.Serializable;

import mx.com.gahm.conenctel.entities.SeguimientoDO;

public class DesarrolloProyectoAB implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String alimentacion;
	private String aterrizaje;
	private String bastidorGabinete;
	private String cableado;
	private String champeado;
	private String controladora;
	private long idPlanchaBase;
	private long idProyecto;
	private String longitudCable;
	private String noCables;
	private String noPares;
	private String noPuertos;
	private String paresFo;
	private String puertosOt;
	private String repisa;
	private String rotulo;
	private String slotsCables;
	private String tarjeta1;
	private String tarjeta2;
	private String tarjeta3;
	private String tarjeta4;
	private String tarjeta5;
	private String tarjeta6;
	private String timbrado;
	private String version;
	private SeguimientoDO fibraClienteFinal;
	private SeguimientoDO soportes;
	private SeguimientoDO antena;
	private SeguimientoDO radio;
	private SeguimientoDO radioCable;
	private SeguimientoDO aterrizajeSeguimiento;
	private SeguimientoDO alimentacionSeguimiento;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAlimentacion() {
		return alimentacion;
	}
	public void setAlimentacion(String alimentacion) {
		this.alimentacion = alimentacion;
	}
	public String getAterrizaje() {
		return aterrizaje;
	}
	public void setAterrizaje(String aterrizaje) {
		this.aterrizaje = aterrizaje;
	}
	public String getBastidorGabinete() {
		return bastidorGabinete;
	}
	public void setBastidorGabinete(String bastidorGabinete) {
		this.bastidorGabinete = bastidorGabinete;
	}
	public String getCableado() {
		return cableado;
	}
	public void setCableado(String cableado) {
		this.cableado = cableado;
	}
	public String getChampeado() {
		return champeado;
	}
	public void setChampeado(String champeado) {
		this.champeado = champeado;
	}
	public String getControladora() {
		return controladora;
	}
	public void setControladora(String controladora) {
		this.controladora = controladora;
	}
	public long getIdPlanchaBase() {
		return idPlanchaBase;
	}
	public void setIdPlanchaBase(long idPlanchaBase) {
		this.idPlanchaBase = idPlanchaBase;
	}
	public long getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(long idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getLongitudCable() {
		return longitudCable;
	}
	public void setLongitudCable(String longitudCable) {
		this.longitudCable = longitudCable;
	}
	public String getNoCables() {
		return noCables;
	}
	public void setNoCables(String noCables) {
		this.noCables = noCables;
	}
	public String getNoPares() {
		return noPares;
	}
	public void setNoPares(String noPares) {
		this.noPares = noPares;
	}
	public String getNoPuertos() {
		return noPuertos;
	}
	public void setNoPuertos(String noPuertos) {
		this.noPuertos = noPuertos;
	}
	public String getParesFo() {
		return paresFo;
	}
	public void setParesFo(String paresFo) {
		this.paresFo = paresFo;
	}
	public String getPuertosOt() {
		return puertosOt;
	}
	public void setPuertosOt(String puertosOt) {
		this.puertosOt = puertosOt;
	}
	public String getRepisa() {
		return repisa;
	}
	public void setRepisa(String repisa) {
		this.repisa = repisa;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public String getSlotsCables() {
		return slotsCables;
	}
	public void setSlotsCables(String slotsCables) {
		this.slotsCables = slotsCables;
	}
	public String getTarjeta1() {
		return tarjeta1;
	}
	public void setTarjeta1(String tarjeta1) {
		this.tarjeta1 = tarjeta1;
	}
	public String getTarjeta2() {
		return tarjeta2;
	}
	public void setTarjeta2(String tarjeta2) {
		this.tarjeta2 = tarjeta2;
	}
	public String getTarjeta3() {
		return tarjeta3;
	}
	public void setTarjeta3(String tarjeta3) {
		this.tarjeta3 = tarjeta3;
	}
	public String getTarjeta4() {
		return tarjeta4;
	}
	public void setTarjeta4(String tarjeta4) {
		this.tarjeta4 = tarjeta4;
	}
	public String getTarjeta5() {
		return tarjeta5;
	}
	public void setTarjeta5(String tarjeta5) {
		this.tarjeta5 = tarjeta5;
	}
	public String getTarjeta6() {
		return tarjeta6;
	}
	public void setTarjeta6(String tarjeta6) {
		this.tarjeta6 = tarjeta6;
	}
	public String getTimbrado() {
		return timbrado;
	}
	public void setTimbrado(String timbrado) {
		this.timbrado = timbrado;
	}
	public String getVersion() {
		return version;
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

}
