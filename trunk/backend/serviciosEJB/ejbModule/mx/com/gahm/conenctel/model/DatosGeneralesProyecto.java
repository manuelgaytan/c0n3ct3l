package mx.com.gahm.conenctel.model;

import java.io.Serializable;
import java.util.Date;

public class DatosGeneralesProyecto implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String areaGoa;
	private String clienteFinal;
	private String clienteId;
	private String divisionRegion;
	private String elementoPep;
	private Date fechaAsignacionCliente;
	private Date fechaInicioProgramada;
	private Date fechaInicioReal;
	private Date fechaTerminoProgramada;
	private Date fechaTerminoReal;
	private String grafo;
	private long idEquipo;
	private long idHerramienta;
	private long idUnidad;
	private long idViaticos;
	private String nodoId;
	private String pedidoCliente;
	private String responsableCliente;
	private String semana;
	private String siteSurvey;
	private Proyecto proyecto;
	private Colaborador reponsableConectel;
	private Colaborador responsableImpl;
	private Catalogo material;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getAreaGoa() {
		return areaGoa;
	}
	public void setAreaGoa(String areaGoa) {
		this.areaGoa = areaGoa;
	}
	public String getClienteFinal() {
		return clienteFinal;
	}
	public void setClienteFinal(String clienteFinal) {
		this.clienteFinal = clienteFinal;
	}
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public String getDivisionRegion() {
		return divisionRegion;
	}
	public void setDivisionRegion(String divisionRegion) {
		this.divisionRegion = divisionRegion;
	}
	public String getElementoPep() {
		return elementoPep;
	}
	public void setElementoPep(String elementoPep) {
		this.elementoPep = elementoPep;
	}
	public Date getFechaAsignacionCliente() {
		return fechaAsignacionCliente;
	}
	public void setFechaAsignacionCliente(Date fechaAsignacionCliente) {
		this.fechaAsignacionCliente = fechaAsignacionCliente;
	}
	public Date getFechaInicioProgramada() {
		return fechaInicioProgramada;
	}
	public void setFechaInicioProgramada(Date fechaInicioProgramada) {
		this.fechaInicioProgramada = fechaInicioProgramada;
	}
	public Date getFechaInicioReal() {
		return fechaInicioReal;
	}
	public void setFechaInicioReal(Date fechaInicioReal) {
		this.fechaInicioReal = fechaInicioReal;
	}
	public Date getFechaTerminoProgramada() {
		return fechaTerminoProgramada;
	}
	public void setFechaTerminoProgramada(Date fechaTerminoProgramada) {
		this.fechaTerminoProgramada = fechaTerminoProgramada;
	}
	public Date getFechaTerminoReal() {
		return fechaTerminoReal;
	}
	public void setFechaTerminoReal(Date fechaTerminoReal) {
		this.fechaTerminoReal = fechaTerminoReal;
	}
	public String getGrafo() {
		return grafo;
	}
	public void setGrafo(String grafo) {
		this.grafo = grafo;
	}
	public long getIdEquipo() {
		return idEquipo;
	}
	public void setIdEquipo(long idEquipo) {
		this.idEquipo = idEquipo;
	}
	public long getIdHerramienta() {
		return idHerramienta;
	}
	public void setIdHerramienta(long idHerramienta) {
		this.idHerramienta = idHerramienta;
	}
	public long getIdUnidad() {
		return idUnidad;
	}
	public void setIdUnidad(long idUnidad) {
		this.idUnidad = idUnidad;
	}
	public long getIdViaticos() {
		return idViaticos;
	}
	public void setIdViaticos(long idViaticos) {
		this.idViaticos = idViaticos;
	}
	public String getNodoId() {
		return nodoId;
	}
	public void setNodoId(String nodoId) {
		this.nodoId = nodoId;
	}
	public String getPedidoCliente() {
		return pedidoCliente;
	}
	public void setPedidoCliente(String pedidoCliente) {
		this.pedidoCliente = pedidoCliente;
	}
	public String getResponsableCliente() {
		return responsableCliente;
	}
	public void setResponsableCliente(String responsableCliente) {
		this.responsableCliente = responsableCliente;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}
	public String getSiteSurvey() {
		return siteSurvey;
	}
	public void setSiteSurvey(String siteSurvey) {
		this.siteSurvey = siteSurvey;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Colaborador getReponsableConectel() {
		return reponsableConectel;
	}
	public void setReponsableConectel(Colaborador reponsableConectel) {
		this.reponsableConectel = reponsableConectel;
	}
	public Colaborador getResponsableImpl() {
		return responsableImpl;
	}
	public void setResponsableImpl(Colaborador responsableImpl) {
		this.responsableImpl = responsableImpl;
	}
	public Catalogo getMaterial() {
		return material;
	}
	public void setMaterial(Catalogo material) {
		this.material = material;
	}

}
