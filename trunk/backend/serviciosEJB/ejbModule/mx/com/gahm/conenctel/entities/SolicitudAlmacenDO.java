package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Clase de persistencia para la tabla solicitudalmacen.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "SolicitudAlmacenDO.findAll", query = "select s from SolicitudAlmacenDO s"),
	@NamedQuery(name = "SolicitudAlmacenDO.findAllByPerfil", query = "select s from SolicitudAlmacenDO s where s.perfil.id = :idPerfil")})
@Table(name="solicitudalmacen")
public class SolicitudAlmacenDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_usuario")
	private UsuarioDO usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;
	
	@Column(name="motivo")
	private String motivo;
	
	@ManyToOne
	@JoinColumn(name="fk_prioridad")
	private PrioridadDO prioridad;
	
	@ManyToOne
	@JoinColumn(name="fk_area_solicitante")
	private AreaSolicitanteDO areaSolicitante;
	
	@Column(name="central_sitio")
	private String centralSitio;
	
	@ManyToOne
	@JoinColumn(name="fk_estado_solicitud_almacen")
	private EstadoSolicitudAlmacenDO estadoSolicitudAlmacen;
	
	@Column(name="nombre_solicitante")
	private String nombreSolicitante;
	
	@ManyToOne
	@JoinColumn(name="fk_autoriza")
	private ColaboradorDO autoriza;
	
	@ManyToOne
	@JoinColumn(name="fk_autoriza_final")
	private ColaboradorDO autorizaFinal;

	@ManyToOne
	@JoinColumn(name="fk_entrega")
	private ColaboradorDO entrega;
	
	@Column(name="recibe")
	private String recibe;
	
	@Column(name="leyenda")
	private String leyenda;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_retorno")
	private Date fechaRetorno;
	
	@ManyToOne
	@JoinColumn(name="fk_perfil")
	private PerfilDO perfil;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<HerramientaSolicitudAlmacenDO> herramientasSolicitudAlmacen;

	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<HardwareSolicitudAlmacenDO> hardwareSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<SoftwareSolicitudAlmacenDO> softwareSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<ConsumibleSolicitudAlmacenDO> consumiblesSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<TelefoniaMovilSolicitudAlmacenDO> telefoniaMovilSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<MaterialSolicitudAlmacenDO> materialesSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<EquipoTransporteSolicitudAlmacenDO> equipoTransporteSolicitudAlmacen;
	
	@OneToMany(mappedBy="solicitudAlmacen", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<EquipoMedicionSolicitudAlmacenDO> equipoMedicionSolicitudAlmacen;
	
	
	public SolicitudAlmacenDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitudAlmacenDO(Long id, UsuarioDO usuario, Date fechaSolicitud,
			String motivo, PrioridadDO prioridad,
			AreaSolicitanteDO areaSolicitante, String centralSitio,
			EstadoSolicitudAlmacenDO estadoSolicitudAlmacen,
			String nombreSolicitante, ColaboradorDO autoriza,
			ColaboradorDO autorizaFinal,
			ColaboradorDO entrega, String recibe, String leyenda,
			Date fechaRetorno, PerfilDO perfil) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fechaSolicitud = fechaSolicitud;
		this.motivo = motivo;
		this.prioridad = prioridad;
		this.areaSolicitante = areaSolicitante;
		this.centralSitio = centralSitio;
		this.estadoSolicitudAlmacen = estadoSolicitudAlmacen;
		this.nombreSolicitante = nombreSolicitante;
		this.autoriza = autoriza;
		this.autorizaFinal = autorizaFinal;
		this.entrega = entrega;
		this.recibe = recibe;
		this.leyenda = leyenda;
		this.fechaRetorno = fechaRetorno;
		this.perfil = perfil;
	}

	public List<PartidaSolicitudAlmacen> getListaPlana(){
		List<PartidaSolicitudAlmacen> partidaSolicitudAlmacen = new ArrayList<PartidaSolicitudAlmacen>();
		if( this.validarLista(this.consumiblesSolicitudAlmacen) ){
			for (ConsumibleSolicitudAlmacenDO iterable_element : this.consumiblesSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeConsumible(iterable_element) );
			}
		}
		if( this.validarLista(this.equipoMedicionSolicitudAlmacen) ){
			for (EquipoMedicionSolicitudAlmacenDO iterable_element : this.equipoMedicionSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeEquipoMedicion(iterable_element) );
			}
		}
		if( this.validarLista(this.equipoTransporteSolicitudAlmacen) ){
			for (EquipoTransporteSolicitudAlmacenDO iterable_element : this.equipoTransporteSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeEquipoTransporte(iterable_element) );
			}
		}
		if( this.validarLista(this.materialesSolicitudAlmacen) ){
			for (MaterialSolicitudAlmacenDO iterable_element : this.materialesSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeMaterial(iterable_element) );
			}
		}
		if( this.validarLista(this.telefoniaMovilSolicitudAlmacen) ){
			for (TelefoniaMovilSolicitudAlmacenDO iterable_element : this.telefoniaMovilSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeTelefoniaMovil(iterable_element) );
			}
		}
		if( this.validarLista(this.hardwareSolicitudAlmacen) ){
			for (HardwareSolicitudAlmacenDO iterable_element : this.hardwareSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeHardware(iterable_element) );
			}
		}
		if( this.validarLista(this.softwareSolicitudAlmacen) ){
			for (SoftwareSolicitudAlmacenDO iterable_element : this.softwareSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeSoftware(iterable_element) );
			}
		}
		if( this.validarLista(this.herramientasSolicitudAlmacen) ){
			for (HerramientaSolicitudAlmacenDO iterable_element : this.herramientasSolicitudAlmacen) {
				partidaSolicitudAlmacen.add( this.crearDeHerramienta(iterable_element) );
			}
		}
		return partidaSolicitudAlmacen;
	}
	
	private boolean validarLista(List lista){
		return !( lista == null || lista.size() == 0 );
	}
	
	private PartidaSolicitudAlmacen crearDeConsumible(ConsumibleSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.CONSUMIBLES );
		partidaSolicitudAlmacen.setCodigo( item.getConsumible().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getConsumible().getGrupoFamiliaD().getEtiqueta());
		partidaSolicitudAlmacen.setDescripcion(item.getConsumible().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad(item.getConsumible().getUnidadB().getEtiqueta());
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeEquipoMedicion(EquipoMedicionSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.EQUIPO_MEDICION );
		partidaSolicitudAlmacen.setCodigo( item.getEquipoMedicion().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getEquipoMedicion().getGrupoFamilia());
		partidaSolicitudAlmacen.setDescripcion(item.getEquipoMedicion().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad("");
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeEquipoTransporte(EquipoTransporteSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.EQUIPO_TRANSPORTE );
		partidaSolicitudAlmacen.setCodigo( item.getEquipoTransporte().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getEquipoTransporte().getGrupofamiliab().getEtiqueta());
		partidaSolicitudAlmacen.setDescripcion(item.getEquipoTransporte().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad("");
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeMaterial(MaterialSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.MATERIALES );
		partidaSolicitudAlmacen.setCodigo( item.getMaterial().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getMaterial().getGrupoFamiliaC().getEtiqueta());
		partidaSolicitudAlmacen.setDescripcion(item.getMaterial().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad(item.getMaterial().getUnidadB().getEtiqueta());
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeTelefoniaMovil(TelefoniaMovilSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.TELEFONIA_MOVIL );
		partidaSolicitudAlmacen.setCodigo( item.getTelefoniaMovil().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getTelefoniaMovil().getGrupoFamiliaF().getEtiqueta());
		partidaSolicitudAlmacen.setDescripcion(item.getTelefoniaMovil().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad("");
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeHardware(HardwareSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.HARDWARE );
		partidaSolicitudAlmacen.setCodigo( item.getHardware().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getHardware().getGrupoFamiliaE().getEtiqueta());
		partidaSolicitudAlmacen.setDescripcion(item.getHardware().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad(item.getHardware().getUnidadC().getEtiqueta());
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeSoftware(SoftwareSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.SOFTWARE );
		partidaSolicitudAlmacen.setCodigo( item.getSoftware().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia("");
		partidaSolicitudAlmacen.setDescripcion(item.getSoftware().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad(item.getSoftware().getUnidad());
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	private PartidaSolicitudAlmacen crearDeHerramienta(HerramientaSolicitudAlmacenDO item){
		PartidaSolicitudAlmacen partidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
		partidaSolicitudAlmacen.setTipoAlmacen( TipoAlmacenDO.HERRAMIENTA );
		partidaSolicitudAlmacen.setCodigo( item.getHerramienta().getCodigo() );
		partidaSolicitudAlmacen.setGrupoFamilia(item.getHerramienta().getGrupoFamiliaA().getEtiqueta());
		partidaSolicitudAlmacen.setDescripcion(item.getHerramienta().getDescripcion());
		partidaSolicitudAlmacen.setCantidad(item.getCantidadSolicitada());
		partidaSolicitudAlmacen.setUnidad(item.getHerramienta().getUnidadA().getEtiqueta());
		partidaSolicitudAlmacen.setRegresoAlmacen(item.getRegresoAlmacen());
		partidaSolicitudAlmacen.setObservacion(item.getObservacion());
		return partidaSolicitudAlmacen; 
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDO usuario) {
		this.usuario = usuario;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public PrioridadDO getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(PrioridadDO prioridad) {
		this.prioridad = prioridad;
	}

	public AreaSolicitanteDO getAreaSolicitante() {
		return areaSolicitante;
	}

	public void setAreaSolicitante(AreaSolicitanteDO areaSolicitante) {
		this.areaSolicitante = areaSolicitante;
	}

	public String getCentralSitio() {
		return centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public EstadoSolicitudAlmacenDO getEstadoSolicitudAlmacen() {
		return estadoSolicitudAlmacen;
	}

	public void setEstadoSolicitudAlmacen(
			EstadoSolicitudAlmacenDO estadoSolicitudAlmacen) {
		this.estadoSolicitudAlmacen = estadoSolicitudAlmacen;
	}

	public String getNombreSolicitante() {
		return nombreSolicitante;
	}

	public void setNombreSolicitante(String nombreSolicitante) {
		this.nombreSolicitante = nombreSolicitante;
	}

	public ColaboradorDO getAutoriza() {
		return autoriza;
	}

	public void setAutoriza(ColaboradorDO autoriza) {
		this.autoriza = autoriza;
	}

	public ColaboradorDO getEntrega() {
		return entrega;
	}

	public void setEntrega(ColaboradorDO entrega) {
		this.entrega = entrega;
	}

	public String getRecibe() {
		return recibe;
	}

	public void setRecibe(String recibe) {
		this.recibe = recibe;
	}
	
	public String getLeyenda() {
		return leyenda;
	}

	public void setLeyenda(String leyenda) {
		this.leyenda = leyenda;
	}
	
	public Date getFechaRetorno() {
		return fechaRetorno;
	}

	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}

	public List<HerramientaSolicitudAlmacenDO> getHerramientasSolicitudAlmacen() {
		return herramientasSolicitudAlmacen;
	}

	public void setHerramientasSolicitudAlmacen(
			List<HerramientaSolicitudAlmacenDO> herramientasSolicitudAlmacen) {
		this.herramientasSolicitudAlmacen = herramientasSolicitudAlmacen;
	}

	public List<HardwareSolicitudAlmacenDO> getHardwareSolicitudAlmacen() {
		return hardwareSolicitudAlmacen;
	}

	public void setHardwareSolicitudAlmacen(
			List<HardwareSolicitudAlmacenDO> hardwareSolicitudAlmacen) {
		this.hardwareSolicitudAlmacen = hardwareSolicitudAlmacen;
	}

	public List<SoftwareSolicitudAlmacenDO> getSoftwareSolicitudAlmacen() {
		return softwareSolicitudAlmacen;
	}

	public void setSoftwareSolicitudAlmacen(
			List<SoftwareSolicitudAlmacenDO> softwareSolicitudAlmacen) {
		this.softwareSolicitudAlmacen = softwareSolicitudAlmacen;
	}

	public List<ConsumibleSolicitudAlmacenDO> getConsumiblesSolicitudAlmacen() {
		return consumiblesSolicitudAlmacen;
	}

	public void setConsumiblesSolicitudAlmacen(
			List<ConsumibleSolicitudAlmacenDO> consumiblesSolicitudAlmacen) {
		this.consumiblesSolicitudAlmacen = consumiblesSolicitudAlmacen;
	}

	public List<TelefoniaMovilSolicitudAlmacenDO> getTelefoniaMovilSolicitudAlmacen() {
		return telefoniaMovilSolicitudAlmacen;
	}

	public void setTelefoniaMovilSolicitudAlmacen(
			List<TelefoniaMovilSolicitudAlmacenDO> telefoniaMovilSolicitudAlmacen) {
		this.telefoniaMovilSolicitudAlmacen = telefoniaMovilSolicitudAlmacen;
	}

	public List<MaterialSolicitudAlmacenDO> getMaterialesSolicitudAlmacen() {
		return materialesSolicitudAlmacen;
	}

	public void setMaterialesSolicitudAlmacen(
			List<MaterialSolicitudAlmacenDO> materialesSolicitudAlmacen) {
		this.materialesSolicitudAlmacen = materialesSolicitudAlmacen;
	}

	public List<EquipoTransporteSolicitudAlmacenDO> getEquipoTransporteSolicitudAlmacen() {
		return equipoTransporteSolicitudAlmacen;
	}

	public void setEquipoTransporteSolicitudAlmacen(
			List<EquipoTransporteSolicitudAlmacenDO> equipoTransporteSolicitudAlmacen) {
		this.equipoTransporteSolicitudAlmacen = equipoTransporteSolicitudAlmacen;
	}

	public List<EquipoMedicionSolicitudAlmacenDO> getEquipoMedicionSolicitudAlmacen() {
		return equipoMedicionSolicitudAlmacen;
	}

	public void setEquipoMedicionSolicitudAlmacen(
			List<EquipoMedicionSolicitudAlmacenDO> equipoMedicionSolicitudAlmacen) {
		this.equipoMedicionSolicitudAlmacen = equipoMedicionSolicitudAlmacen;
	}

	public ColaboradorDO getAutorizaFinal() {
		return autorizaFinal;
	}

	public void setAutorizaFinal(ColaboradorDO autorizaFinal) {
		this.autorizaFinal = autorizaFinal;
	}

	public PerfilDO getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilDO perfil) {
		this.perfil = perfil;
	}
	
	
	
	
}