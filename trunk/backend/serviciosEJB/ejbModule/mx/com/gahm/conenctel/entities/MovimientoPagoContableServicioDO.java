/**
 * 
 */
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

/**
 * @author MHDolores
 *
 */

@Entity
@Table(name = "MovimientoPagoContableServicio")
@NamedQueries({
	@NamedQuery(name = "MovimientoPagoContableServicioDO.findAll", query = "select rc from MovimientoPagoContableServicioDO rc")
	})
public class MovimientoPagoContableServicioDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3720805407476241903L;
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "fk_descripcion_pago_contable_servicio", nullable = false)
	private DescripcionPagoContableServicioDO  descripcionPagoContableServicio;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_calificado", nullable = false)
	private ProveedorCalificadoDO proveedorCalificado; 
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_maquilador", nullable = false)
	private ProveedorMaquiladorDO ProveedorMaquilador; 

	@Column(name = "ingreso", nullable = false)
	private Double ingreso;
	
	@Column(name = "egreso", nullable = false)
	private Double egreso;
	
	@Column(name = "folio_documento", nullable = false)
	private String folioDocumento;
	
	@Column(name = "importe", nullable = false)
	private String importe;
	
	@Column(name = "descuentos", nullable = false)
	private String descuentos;
	
	@Column(name = "iva", nullable = false)
	private Double iva;

	@Column(name = "redondeo", nullable = false)
	private Double redondeo;
	
	@Column(name = "isr_retencion", nullable = false)
	private Double isrRetencion;
	
	@Column(name = "iva_retencion", nullable = false)
	private Double ivaRetencion;
	
	@Column(name = "otros_impuestos", nullable = false)
	private Double otrosImpuestos;
	
	@Column(name = "total_pagar", nullable = false)
	private Double totalPagar;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_limite_pago", nullable = false, length = 10)
	private Date fechaLimitePago;
	
	@OneToMany(mappedBy="movimientoPagoContableServicio", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioMovimientoPagoContableServicioDO> comentarios; 

	public MovimientoPagoContableServicioDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovimientoPagoContableServicioDO(Integer id, Date fecha,
			DescripcionPagoContableServicioDO descripcionPagoContableServicio,
			ProveedorCalificadoDO proveedorCalificado,
			ProveedorMaquiladorDO proveedorMaquilador, Double ingreso,
			Double egreso, String folioDocumento, String importe,
			String descuentos, Double iva, Double redondeo,
			Double isrRetencion, Double ivaRetencion, Double otrosImpuestos,
			Double totalPagar, Date fechaLimitePago) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcionPagoContableServicio = descripcionPagoContableServicio;
		this.proveedorCalificado = proveedorCalificado;
		ProveedorMaquilador = proveedorMaquilador;
		this.ingreso = ingreso;
		this.egreso = egreso;
		this.folioDocumento = folioDocumento;
		this.importe = importe;
		this.descuentos = descuentos;
		this.iva = iva;
		this.redondeo = redondeo;
		this.isrRetencion = isrRetencion;
		this.ivaRetencion = ivaRetencion;
		this.otrosImpuestos = otrosImpuestos;
		this.totalPagar = totalPagar;
		this.fechaLimitePago = fechaLimitePago;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the descripcionPagoContableServicio
	 */
	public DescripcionPagoContableServicioDO getDescripcionPagoContableServicio() {
		return descripcionPagoContableServicio;
	}

	/**
	 * @param descripcionPagoContableServicio the descripcionPagoContableServicio to set
	 */
	public void setDescripcionPagoContableServicio(
			DescripcionPagoContableServicioDO descripcionPagoContableServicio) {
		this.descripcionPagoContableServicio = descripcionPagoContableServicio;
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
	 * @return the proveedorMaquilador
	 */
	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return ProveedorMaquilador;
	}

	/**
	 * @param proveedorMaquilador the proveedorMaquilador to set
	 */
	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		ProveedorMaquilador = proveedorMaquilador;
	}

	/**
	 * @return the ingreso
	 */
	public Double getIngreso() {
		return ingreso;
	}

	/**
	 * @param ingreso the ingreso to set
	 */
	public void setIngreso(Double ingreso) {
		this.ingreso = ingreso;
	}

	/**
	 * @return the egreso
	 */
	public Double getEgreso() {
		return egreso;
	}

	/**
	 * @param egreso the egreso to set
	 */
	public void setEgreso(Double egreso) {
		this.egreso = egreso;
	}

	/**
	 * @return the folioDocumento
	 */
	public String getFolioDocumento() {
		return folioDocumento;
	}

	/**
	 * @param folioDocumento the folioDocumento to set
	 */
	public void setFolioDocumento(String folioDocumento) {
		this.folioDocumento = folioDocumento;
	}

	/**
	 * @return the importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(String importe) {
		this.importe = importe;
	}

	/**
	 * @return the descuentos
	 */
	public String getDescuentos() {
		return descuentos;
	}

	/**
	 * @param descuentos the descuentos to set
	 */
	public void setDescuentos(String descuentos) {
		this.descuentos = descuentos;
	}

	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	/**
	 * @return the redondeo
	 */
	public Double getRedondeo() {
		return redondeo;
	}

	/**
	 * @param redondeo the redondeo to set
	 */
	public void setRedondeo(Double redondeo) {
		this.redondeo = redondeo;
	}

	/**
	 * @return the isrRetencion
	 */
	public Double getIsrRetencion() {
		return isrRetencion;
	}

	/**
	 * @param isrRetencion the isrRetencion to set
	 */
	public void setIsrRetencion(Double isrRetencion) {
		this.isrRetencion = isrRetencion;
	}

	/**
	 * @return the ivaRetencion
	 */
	public Double getIvaRetencion() {
		return ivaRetencion;
	}

	/**
	 * @param ivaRetencion the ivaRetencion to set
	 */
	public void setIvaRetencion(Double ivaRetencion) {
		this.ivaRetencion = ivaRetencion;
	}

	/**
	 * @return the otrosImpuestos
	 */
	public Double getOtrosImpuestos() {
		return otrosImpuestos;
	}

	/**
	 * @param otrosImpuestos the otrosImpuestos to set
	 */
	public void setOtrosImpuestos(Double otrosImpuestos) {
		this.otrosImpuestos = otrosImpuestos;
	}

	/**
	 * @return the totalPagar
	 */
	public Double getTotalPagar() {
		return totalPagar;
	}

	/**
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	/**
	 * @return the fechaLimitePago
	 */
	public Date getFechaLimitePago() {
		return fechaLimitePago;
	}

	/**
	 * @param fechaLimitePago the fechaLimitePago to set
	 */
	public void setFechaLimitePago(Date fechaLimitePago) {
		this.fechaLimitePago = fechaLimitePago;
	}

	/**
	 * @return the comentarios
	 */
	public List<ComentarioMovimientoPagoContableServicioDO> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(
			List<ComentarioMovimientoPagoContableServicioDO> comentarios) {
		this.comentarios = comentarios;
	}

	
	
	
	
	
	
	
}
