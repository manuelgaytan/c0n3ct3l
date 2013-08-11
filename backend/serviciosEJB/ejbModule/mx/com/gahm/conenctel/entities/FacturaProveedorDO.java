package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FacturaProveedor")
@NamedQueries({
	@NamedQuery(name = "FacturaProveedorDO.findAll", query = "select rc from FacturaProveedorDO rc"),
	@NamedQuery(name = "FacturaProveedorDO.getFacturacionByIdMaquilador", query = "select rc from FacturaProveedorDO rc where rc.proveedorMaquilador.id=:idMaquilador"),
	@NamedQuery(name = "FacturaProveedorDO.getFacturacionByIdCalificado", query = "select rc from FacturaProveedorDO rc where rc.proveedorCalificado.id=:idCalificado")
	})
public class FacturaProveedorDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3550798602765460251L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "fecha_factura", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaFactura;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_investigacion_calidad", nullable = false)
	private EstadoInvestigacionCalidadDO estadoInvestigacionCalidad;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_tesoreria", nullable = false)
	private EstadoTesoreriaDO estadoTesoreria;
	
	@Column(name = "semana", nullable = false)
	private Double semana;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_calificado", nullable = false)
	private ProveedorCalificadoDO proveedorCalificado;
	
	
	@ManyToOne
	@JoinColumn(name = "fk_orden_compra", nullable = false)
	private OrdenCompraDO ordenCompra;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_maquilador", nullable = false)
	private ProveedorMaquiladorDO proveedorMaquilador;
	
	@ManyToOne
	@JoinColumn(name = "fk_orden_compra_maquilado", nullable = false)
	private OrdenCompraMaquiladoDO ordenCompraMaquilado;

	@Column(name = "numero_factura", nullable = false)
	private String numeroFactura;
	
	@Column(name = "fecha_revision", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaRevision;
	
	@Column(name = "fecha_pago", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaPago;

	@OneToMany(mappedBy="facturaProveedor", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor;
	
	
	public FacturaProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FacturaProveedorDO(Integer id, Date fechaFactura,
			EstadoInvestigacionCalidadDO estadoInvestigacionCalidad,
			EstadoTesoreriaDO estadoTesoreria, Double semana,
			ProveedorCalificadoDO proveedorCalificado,
			OrdenCompraDO ordenCompra,
			ProveedorMaquiladorDO proveedorMaquilador,
			OrdenCompraMaquiladoDO ordenCompraMaquilado, String numeroFactura,
			Date fechaRevision, Date fechaPago) {
		super();
		this.id = id;
		this.fechaFactura = fechaFactura;
		this.estadoInvestigacionCalidad = estadoInvestigacionCalidad;
		this.estadoTesoreria = estadoTesoreria;
		this.semana = semana;
		this.proveedorCalificado = proveedorCalificado;
		this.ordenCompra = ordenCompra;
		this.proveedorMaquilador = proveedorMaquilador;
		this.ordenCompraMaquilado = ordenCompraMaquilado;
		this.numeroFactura = numeroFactura;
		this.fechaRevision = fechaRevision;
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the fechaFactura
	 */
	public Date getFechaFactura() {
		return fechaFactura;
	}

	/**
	 * @param fechaFactura the fechaFactura to set
	 */
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	/**
	 * @return the estadoInvestigacionCalidad
	 */
	public EstadoInvestigacionCalidadDO getEstadoInvestigacionCalidad() {
		return estadoInvestigacionCalidad;
	}

	/**
	 * @param estadoInvestigacionCalidad the estadoInvestigacionCalidad to set
	 */
	public void setEstadoInvestigacionCalidad(
			EstadoInvestigacionCalidadDO estadoInvestigacionCalidad) {
		this.estadoInvestigacionCalidad = estadoInvestigacionCalidad;
	}

	/**
	 * @return the estadoTesoreria
	 */
	public EstadoTesoreriaDO getEstadoTesoreria() {
		return estadoTesoreria;
	}

	/**
	 * @param estadoTesoreria the estadoTesoreria to set
	 */
	public void setEstadoTesoreria(EstadoTesoreriaDO estadoTesoreria) {
		this.estadoTesoreria = estadoTesoreria;
	}

	/**
	 * @return the semana
	 */
	public Double getSemana() {
		return semana;
	}

	/**
	 * @param semana the semana to set
	 */
	public void setSemana(Double semana) {
		this.semana = semana;
	}

	/**
	 * @return the proveedorCalificado
	 */
	public ProveedorCalificadoDO getProveedorCalificado() {
		return proveedorCalificado;
	}

	/**
	 * @param proveedorCalificado the proveedorCalificado to set
	 */
	public void setProveedorCalificado(ProveedorCalificadoDO proveedorCalificado) {
		this.proveedorCalificado = proveedorCalificado;
	}

	/**
	 * @return the ordenCompra
	 */
	public OrdenCompraDO getOrdenCompra() {
		return ordenCompra;
	}

	/**
	 * @param ordenCompra the ordenCompra to set
	 */
	public void setOrdenCompra(OrdenCompraDO ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	/**
	 * @return the proveedorMaquilador
	 */
	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return proveedorMaquilador;
	}

	/**
	 * @param proveedorMaquilador the proveedorMaquilador to set
	 */
	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
	}

	/**
	 * @return the ordenCompraMaquilado
	 */
	public OrdenCompraMaquiladoDO getOrdenCompraMaquilado() {
		return ordenCompraMaquilado;
	}

	/**
	 * @param ordenCompraMaquilado the ordenCompraMaquilado to set
	 */
	public void setOrdenCompraMaquilado(OrdenCompraMaquiladoDO ordenCompraMaquilado) {
		this.ordenCompraMaquilado = ordenCompraMaquilado;
	}

	/**
	 * @return the numeroFactura
	 */
	public String getNumeroFactura() {
		return numeroFactura;
	}

	/**
	 * @param numeroFactura the numeroFactura to set
	 */
	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	/**
	 * @return the fechaRevision
	 */
	public Date getFechaRevision() {
		return fechaRevision;
	}

	/**
	 * @param fechaRevision the fechaRevision to set
	 */
	public void setFechaRevision(Date fechaRevision) {
		this.fechaRevision = fechaRevision;
	}

	/**
	 * @return the fechaPago
	 */
	public Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the comentariosFacturaProveedor
	 */
	public List<ComentarioFacturaProveedorDO> getComentariosFacturaProveedor() {
		return comentariosFacturaProveedor;
	}

	/**
	 * @param comentariosFacturaProveedor the comentariosFacturaProveedor to set
	 */
	public void setComentariosFacturaProveedor(
			List<ComentarioFacturaProveedorDO> comentariosFacturaProveedor) {
		this.comentariosFacturaProveedor = comentariosFacturaProveedor;
	}
	
	
}
