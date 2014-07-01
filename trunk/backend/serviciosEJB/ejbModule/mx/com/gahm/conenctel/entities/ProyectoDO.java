package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Clase de persistencia para la tabla proyecto.
 * 
 * @author Carlos Leyva
 */

@Entity
@NamedQueries({ 
	@NamedQuery(name = "ProyectoDO.findByFilter", query = "select p from ProyectoDO p " +
			"where ((:idProyecto is null or :idProyecto = 0) or p.id = :idProyecto) and ((:idCategoria is null or :idCategoria = 0)" +
			" or p.categoria.id = :idCategoria) and ((:idCliente is null or :idCliente = 0) or p.producto.cliente.id = :idCliente) and " +
			"((:tipoProyecto is null or :tipoProyecto = '') or p.producto.tipoProyecto = :tipoProyecto) and ((:tecnologia is null or :tecnologia = '') " +
			"or p.producto.teconologia = :tecnologia) and ((:equipo is null or :equipo = '') or p.producto.equipo = :equipo) and ((:actividadRealizar is null " +
			"or :actividadRealizar = '') or p.producto.actividadRealizar = :actividadRealizar) and ((:modelo is null or :modelo = '') or p.producto.modelo = " +
			":modelo) and ((:descripcionServicio is null or :descripcionServicio = '') or p.producto.descripcionServicio = :descripcionServicio) and " +
			"((:tipoServicio is null or :tipoServicio = '') or p.producto.tipoServicio = :tipoServicio) or p.proyectoPadreHijo.proyectoPadre.descripcion like (:proyectoPadre)"),
			
			@NamedQuery(name = "ProyectoDO.getProyectosByProducto", query = "select c from ProyectoDO c where c.producto.id=:idProducto"),
			@NamedQuery(name = "ProyectoDO.getProyectosNoAsociados", query = "select c from ProyectoDO c where c.id NOT IN(select dp.proyecto.id from DesarrolloProyectoABDO dp)"),
			@NamedQuery(name = "ProyectoDO.getProyectosByEstado", query = "select c from ProyectoDO c where c.estado.id=:idEstado"),
			@NamedQuery(name = "ProyectoDO.getCantidadEstatusProyectos", query = "select new mx.com.gahm.conenctel.model.ItemEstatusProyecto( p.id, ep.etiqueta, count(p.id) ) from ProyectoDO p, EstadoDO ep where p.estado.id = ep.id group by ep.etiqueta"),
			@NamedQuery(name = "ProyectoDO.getCantidadProyectosByEstado", query = "select new mx.com.gahm.conenctel.model.ItemEstatusProyecto( p.id, ep.etiqueta, count(p.id) ) from ProyectoDO p, EstadoDO ep where p.estado.id = ep.id and ep.id = :idEstadoProyecto group by ep.etiqueta"),
			@NamedQuery(name = "ProyectoDO.getProyectosAndDerivates", query = "select new mx.com.gahm.conenctel.model.ConsultaGeneralOperacion( p, dgp, dpab, cpe ) from ProyectoDO p, DatosGrlsProyectoDO dgp, DesarrolloProyectoABDO dpab, ConfigPruebaEntregaDO cpe where (p.id = dgp.proyecto.id or p.id = dpab.proyecto.id or p.id = cpe.proyecto.id ) group by p.id"),
			@NamedQuery(name = "ProyectoDO.getAll", query = "select c from ProyectoDO c"),
			@NamedQuery(name = "ProyectoDO.getAllByWithOutMaquilaRequest", query = "select p from ProyectoDO p where p.id not in (select s.proyecto.id from SolicitudServicioMaquiladoDO s)"),
			@NamedQuery(name = "ProyectoDO.getAllByWithOutCustomerPurchaseOrder", query = "select p from ProyectoDO p where p.id not in (select s.proyecto.id from OrdenCompraClienteDO s)")
})
@Table(name = "proyecto")
public class ProyectoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "central_sitio")
	private String centralSitio;

	@Column(name = "fecha_captura")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date fechaCaptura;

	@ManyToOne
	@JoinColumn(name = "id_categoria_proyecto")
	private CategoriaDO categoria;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoDO producto;

	@OneToMany(mappedBy = "proyecto", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<ObservacionDO> observaciones;
	
	@ManyToOne
	@JoinColumn(name = "id_estato")
	private EstadoDO estado;

	@OneToMany(mappedBy = "proyecto", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<RequisicionDO> requisiciones;
	
	@OneToMany(mappedBy="proyecto", fetch = FetchType.EAGER)
	private List<ProyectoEntregableDO> proyectoEntregables;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_solicitud_servicio_maquilado")
	private EstadoSolicitudServicioMaquiladoDO estadoSolicitudServicioMaquilado;
	
	@OneToOne(mappedBy="proyecto",cascade=CascadeType.ALL)
	private ProyectoPadreHijoDO proyectoPadreHijo;
	
	@OneToOne(mappedBy="proyecto", fetch = FetchType.EAGER)
	private ValidacionProyectoDO validacionProyecto;
	
	@Column(name = "clave_auditoria")
	private String claveAuditoria;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="fk_tipo_auditoria")
	private TipoAuditoriaDO tipoAuditoria;
	
	@ManyToOne(fetch= FetchType.EAGER)
	@JoinColumn(name="fk_tipo_servicio")
	private TipoServicioDO tipoServicio;
	
	public ProyectoDO() {
	}

	
	
	public ProyectoDO(
			Long id,
			String centralSitio,
			Date fechaCaptura,
			CategoriaDO categoria,
			ProductoDO producto,
			List<ObservacionDO> observaciones,
			EstadoDO estado,
			List<RequisicionDO> requisiciones,
			List<ProyectoEntregableDO> proyectoEntregables,
			EstadoSolicitudServicioMaquiladoDO estadoSolicitudServicioMaquilado,
			ProyectoPadreHijoDO proyectoPadreHijo,
			ValidacionProyectoDO validacionProyecto, String claveAuditoria,
			TipoAuditoriaDO tipoAuditoria) {
		super();
		this.id = id;
		this.centralSitio = centralSitio;
		this.fechaCaptura = fechaCaptura;
		this.categoria = categoria;
		this.producto = producto;
		this.observaciones = observaciones;
		this.estado = estado;
		this.requisiciones = requisiciones;
		this.proyectoEntregables = proyectoEntregables;
		this.estadoSolicitudServicioMaquilado = estadoSolicitudServicioMaquilado;
		this.proyectoPadreHijo = proyectoPadreHijo;
		this.validacionProyecto = validacionProyecto;
		this.claveAuditoria = claveAuditoria;
		this.tipoAuditoria = tipoAuditoria;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCentralSitio() {
		return this.centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public Date getFechaCaptura() {
		return this.fechaCaptura;
	}

	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	public CategoriaDO getCategoria() {
		return this.categoria;
	}

	public void setCategoria(CategoriaDO categoria) {
		this.categoria = categoria;
	}

	public ProductoDO getProducto() {
		return this.producto;
	}

	public void setProducto(ProductoDO producto) {
		this.producto = producto;
	}

	public List<ObservacionDO> getObservaciones() {
		return this.observaciones;
	}

	public void setObservaciones(List<ObservacionDO> observaciones) {
		this.observaciones = observaciones;
	}

	public EstadoDO getEstado() {
		return this.estado;
	}

	public void setEstado(EstadoDO estado) {
		this.estado = estado;
	}

	public List<RequisicionDO> getRequisiciones() {
		return this.requisiciones;
	}

	public void setRequisiciones(List<RequisicionDO> requisiciones) {
		this.requisiciones = requisiciones;
	}

	public List<ProyectoEntregableDO> getProyectoEntregables() {
		return proyectoEntregables;
	}

	public void setProyectoEntregables(
			List<ProyectoEntregableDO> proyectoEntregables) {
		this.proyectoEntregables = proyectoEntregables;
	}

	public ProyectoPadreHijoDO getProyectoPadreHijo() {
		return proyectoPadreHijo;
	}

	public void setProyectoPadreHijo(ProyectoPadreHijoDO proyectoPadreHijo) {
		this.proyectoPadreHijo = proyectoPadreHijo;
	}

	public EstadoSolicitudServicioMaquiladoDO getEstadoSolicitudServicioMaquilado() {
		return estadoSolicitudServicioMaquilado;
	}

	public void setEstadoSolicitudServicioMaquilado(
			EstadoSolicitudServicioMaquiladoDO estadoSolicitudServicioMaquilado) {
		this.estadoSolicitudServicioMaquilado = estadoSolicitudServicioMaquilado;
	}

	public ValidacionProyectoDO getValidacionProyecto() {
		return validacionProyecto;
	}

	public void setValidacionProyecto(ValidacionProyectoDO validacionProyecto) {
		this.validacionProyecto = validacionProyecto;
	}

	public String getClaveAuditoria() {
		return claveAuditoria;
	}

	public void setClaveAuditoria(String claveAuditoria) {
		this.claveAuditoria = claveAuditoria;
	}

	public TipoAuditoriaDO getTipoAuditoria() {
		return tipoAuditoria;
	}

	public void setTipoAuditoria(TipoAuditoriaDO tipoAuditoria) {
		this.tipoAuditoria = tipoAuditoria;
	}



	public TipoServicioDO getTipoServicio() {
		return tipoServicio;
	}



	public void setTipoServicio(TipoServicioDO tipoServicio) {
		this.tipoServicio = tipoServicio;
	}
}