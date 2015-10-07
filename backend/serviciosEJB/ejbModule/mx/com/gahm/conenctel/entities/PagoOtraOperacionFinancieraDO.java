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
@NamedQueries({ @NamedQuery(name = "PagoOtraOperacionFinancieraDO.findAll", query = "select c from PagoOtraOperacionFinancieraDO c") })
@Table(name = "PagoOtraOperacionFinanciera")
public class PagoOtraOperacionFinancieraDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6482272717542847148L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name="fk_concepto_otra_operacion_financiera")
	private ConceptoOtraOperacionFinancieraDO conceptoOtraOperacionFinanciera;

	@Column(name = "razon_social", nullable = false)
	private String razonSocial;

	@Column(name = "subtotal", nullable = false)
	private Double subtotal;

	@Column(name = "iva", nullable = false)
	private Double iva;

	@Column(name = "total", nullable = false)
	private Double total;
	
	@ManyToOne
	@JoinColumn(name="fk_banco_conectel")
	private BancoConectelDO bancoConectel;

	@Column(name = "fecha_abono", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaAbono;

	@Column(name = "monto", nullable = false)
	private Double monto;

	@Column(name = "referencia_abono", nullable = false)
	private Integer referenciaAbono;
	
	@Column(name = "cuentas_destino", nullable = false)
	private String cuentasDestino;

	@OneToMany(mappedBy="pagoOtraOperacionFinanciera", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ComentarioPagoOtraOperacionFinancieraDO> comentariosPagoOtraOperacionFinanciera;
	
	@Column(name = "observaciones", nullable = true)
	private String observaciones;
	
	public PagoOtraOperacionFinancieraDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagoOtraOperacionFinancieraDO(Integer id,
			ConceptoOtraOperacionFinancieraDO conceptoOtraOperacionFinanciera,
			String razonSocial, Double subtotal, Double iva, Double total,
			BancoConectelDO bancoConectel, Date fechaAbono, Double monto,
			Integer referenciaAbono, String observaciones) {
		super();
		this.id = id;
		this.conceptoOtraOperacionFinanciera = conceptoOtraOperacionFinanciera;
		this.razonSocial = razonSocial;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
		this.bancoConectel = bancoConectel;
		this.fechaAbono = fechaAbono;
		this.monto = monto;
		this.referenciaAbono = referenciaAbono;
		this.observaciones = observaciones;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the conceptoOtraOperacionFinanciera
	 */
	public ConceptoOtraOperacionFinancieraDO getConceptoOtraOperacionFinanciera() {
		return conceptoOtraOperacionFinanciera;
	}

	/**
	 * @param conceptoOtraOperacionFinanciera
	 *            the conceptoOtraOperacionFinanciera to set
	 */
	public void setConceptoOtraOperacionFinanciera(
			ConceptoOtraOperacionFinancieraDO conceptoOtraOperacionFinanciera) {
		this.conceptoOtraOperacionFinanciera = conceptoOtraOperacionFinanciera;
	}

	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}

	/**
	 * @param razonSocial
	 *            the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	/**
	 * @return the subtotal
	 */
	public Double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal
	 *            the subtotal to set
	 */
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * @param iva
	 *            the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	/**
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * @return the bancoConectel
	 */
	public BancoConectelDO getBancoConectel() {
		return bancoConectel;
	}

	/**
	 * @param bancoConectel
	 *            the bancoConectel to set
	 */
	public void setBancoConectel(BancoConectelDO bancoConectel) {
		this.bancoConectel = bancoConectel;
	}

	/**
	 * @return the fechaAbono
	 */
	public Date getFechaAbono() {
		return fechaAbono;
	}

	/**
	 * @param fechaAbono
	 *            the fechaAbono to set
	 */
	public void setFechaAbono(Date fechaAbono) {
		this.fechaAbono = fechaAbono;
	}

	/**
	 * @return the monto
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * @param monto
	 *            the monto to set
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * @return the referenciaAbono
	 */
	public Integer getReferenciaAbono() {
		return referenciaAbono;
	}

	/**
	 * @param referenciaAbono
	 *            the referenciaAbono to set
	 */
	public void setReferenciaAbono(Integer referenciaAbono) {
		this.referenciaAbono = referenciaAbono;
	}

	/**
	 * @return the comentariosPagoOtraOperacionFinanciera
	 */
	public List<ComentarioPagoOtraOperacionFinancieraDO> getComentariosPagoOtraOperacionFinanciera() {
		return comentariosPagoOtraOperacionFinanciera;
	}

	/**
	 * @param comentariosPagoOtraOperacionFinanciera the comentariosPagoOtraOperacionFinanciera to set
	 */
	public void setComentariosPagoOtraOperacionFinanciera(
			List<ComentarioPagoOtraOperacionFinancieraDO> comentariosPagoOtraOperacionFinanciera) {
		this.comentariosPagoOtraOperacionFinanciera = comentariosPagoOtraOperacionFinanciera;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getCuentasDestino() {
		return cuentasDestino;
	}

	public void setCuentasDestino(String cuentasDestino) {
		this.cuentasDestino = cuentasDestino;
	}

}
