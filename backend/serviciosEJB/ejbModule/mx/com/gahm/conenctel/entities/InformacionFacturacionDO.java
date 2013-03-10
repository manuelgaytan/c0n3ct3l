package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
@Table(name = "InformacionFacturacion")
@NamedQueries({
	@NamedQuery(name = "InformacionFacturacionDO.findAll", query = "select rc from InformacionFacturacionDO rc")
	})
public class InformacionFacturacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7814754054440941976L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_validacion_administrativa", nullable = false)
	private ValidacionAdministrativaDO validacionAdministrativa;
	
	@Column(name = "folio_factura_1", nullable = false)
	private String folioFactura1;
	
	@Column(name = "subtotal_1", nullable = false)
	private Double subtotal1;
	
	@Column(name = "iva_1", nullable = false)
	private Double iva1;
	
	@Column(name = "total_1", nullable = false)
	private Double total1;
	
	@Column(name = "fecha_emision_1", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaEmision1;
	
	@Column(name = "fecha_ingreso_1", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso1;
	
	@Column(name = "dias_credito_1", nullable = false)
	private Double diasCredito1;
	
	@Column(name = "fecha_programada_1", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaProgramada1;
	
	@Column(name = "estado_pago_1", nullable = false)
	private String estadoPago1;
	
	//
	
	@Column(name = "folio_factura_2", nullable = false)
	private String folioFactura2;
	
	@Column(name = "subtotal_2", nullable = false)
	private Double subtotal2;
	
	@Column(name = "iva_1", nullable = false)
	private Double iva2;
	
	@Column(name = "total_2", nullable = false)
	private Double total2;
	
	@Column(name = "fecha_emision_2", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaEmision2;
	
	@Column(name = "fecha_ingreso_2", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso2;
	
	@Column(name = "dias_credito_2", nullable = false)
	private Double diasCredito2;
	
	@Column(name = "fecha_programada_2", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaProgramada2;
	
	@Column(name = "estado_pago_2", nullable = false)
	private String estadoPago2;
	
	
	@Column(name = "folio_factura_3", nullable = false)
	private String folioFactura3;
	
	@Column(name = "subtotal_3", nullable = false)
	private Double subtotal3;
	
	@Column(name = "iva_3", nullable = false)
	private Double iva3;
	
	@Column(name = "total_3", nullable = false)
	private Double total3;
	
	@Column(name = "fecha_emision_3", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaEmision3;
	
	@Column(name = "fecha_ingreso_3", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso3;
	
	@Column(name = "dias_credito_3", nullable = false)
	private Double diasCredito3;
	
	@Column(name = "fecha_programada_3", nullable = false, length = 10)
	@Temporal(TemporalType.DATE)
	private Date fechaProgramada3;
	
	@Column(name = "estado_pago_3", nullable = false)
	private String estadoPago3;

	public InformacionFacturacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@OneToMany(mappedBy="informacionFacturacion", fetch = FetchType.EAGER)
	private List<ComentarioInformacionFacturacion3DO> comentariosInformacionFacturacion3DO;

	@OneToMany(mappedBy="informacionFacturacion", fetch = FetchType.EAGER)
	private List<ComentarioInformacionFacturacion2DO> comentariosInformacionFacturacion2DO;

	@OneToMany(mappedBy="informacionFacturacion", fetch = FetchType.EAGER)
	private List<ComentarioInformacionFacturacion1DO> comentariosInformacionFacturacion1DO;

	public InformacionFacturacionDO(Integer id,
			ValidacionAdministrativaDO validacionAdministrativa,
			String folioFactura1, Double subtotal1, Double iva1, Double total1,
			Date fechaEmision1, Date fechaIngreso1, Double diasCredito1,
			Date fechaProgramada1, String estadoPago1, String folioFactura2,
			Double subtotal2, Double iva2, Double total2, Date fechaEmision2,
			Date fechaIngreso2, Double diasCredito2, Date fechaProgramada2,
			String estadoPago2, String folioFactura3, Double subtotal3,
			Double iva3, Double total3, Date fechaEmision3, Date fechaIngreso3,
			Double diasCredito3, Date fechaProgramada3, String estadoPago3) {
		super();
		this.id = id;
		this.validacionAdministrativa = validacionAdministrativa;
		this.folioFactura1 = folioFactura1;
		this.subtotal1 = subtotal1;
		this.iva1 = iva1;
		this.total1 = total1;
		this.fechaEmision1 = fechaEmision1;
		this.fechaIngreso1 = fechaIngreso1;
		this.diasCredito1 = diasCredito1;
		this.fechaProgramada1 = fechaProgramada1;
		this.estadoPago1 = estadoPago1;
		this.folioFactura2 = folioFactura2;
		this.subtotal2 = subtotal2;
		this.iva2 = iva2;
		this.total2 = total2;
		this.fechaEmision2 = fechaEmision2;
		this.fechaIngreso2 = fechaIngreso2;
		this.diasCredito2 = diasCredito2;
		this.fechaProgramada2 = fechaProgramada2;
		this.estadoPago2 = estadoPago2;
		this.folioFactura3 = folioFactura3;
		this.subtotal3 = subtotal3;
		this.iva3 = iva3;
		this.total3 = total3;
		this.fechaEmision3 = fechaEmision3;
		this.fechaIngreso3 = fechaIngreso3;
		this.diasCredito3 = diasCredito3;
		this.fechaProgramada3 = fechaProgramada3;
		this.estadoPago3 = estadoPago3;
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
	 * @return the validacionAdministrativa
	 */
	public ValidacionAdministrativaDO getValidacionAdministrativa() {
		return validacionAdministrativa;
	}

	/**
	 * @param validacionAdministrativa the validacionAdministrativa to set
	 */
	public void setValidacionAdministrativa(
			ValidacionAdministrativaDO validacionAdministrativa) {
		this.validacionAdministrativa = validacionAdministrativa;
	}

	/**
	 * @return the folioFactura1
	 */
	public String getFolioFactura1() {
		return folioFactura1;
	}

	/**
	 * @param folioFactura1 the folioFactura1 to set
	 */
	public void setFolioFactura1(String folioFactura1) {
		this.folioFactura1 = folioFactura1;
	}

	/**
	 * @return the subtotal1
	 */
	public Double getSubtotal1() {
		return subtotal1;
	}

	/**
	 * @param subtotal1 the subtotal1 to set
	 */
	public void setSubtotal1(Double subtotal1) {
		this.subtotal1 = subtotal1;
	}

	/**
	 * @return the iva1
	 */
	public Double getIva1() {
		return iva1;
	}

	/**
	 * @param iva1 the iva1 to set
	 */
	public void setIva1(Double iva1) {
		this.iva1 = iva1;
	}

	/**
	 * @return the total1
	 */
	public Double getTotal1() {
		return total1;
	}

	/**
	 * @param total1 the total1 to set
	 */
	public void setTotal1(Double total1) {
		this.total1 = total1;
	}

	/**
	 * @return the fechaEmision1
	 */
	public Date getFechaEmision1() {
		return fechaEmision1;
	}

	/**
	 * @param fechaEmision1 the fechaEmision1 to set
	 */
	public void setFechaEmision1(Date fechaEmision1) {
		this.fechaEmision1 = fechaEmision1;
	}

	/**
	 * @return the fechaIngreso1
	 */
	public Date getFechaIngreso1() {
		return fechaIngreso1;
	}

	/**
	 * @param fechaIngreso1 the fechaIngreso1 to set
	 */
	public void setFechaIngreso1(Date fechaIngreso1) {
		this.fechaIngreso1 = fechaIngreso1;
	}

	/**
	 * @return the diasCredito1
	 */
	public Double getDiasCredito1() {
		return diasCredito1;
	}

	/**
	 * @param diasCredito1 the diasCredito1 to set
	 */
	public void setDiasCredito1(Double diasCredito1) {
		this.diasCredito1 = diasCredito1;
	}

	/**
	 * @return the fechaProgramada1
	 */
	public Date getFechaProgramada1() {
		return fechaProgramada1;
	}

	/**
	 * @param fechaProgramada1 the fechaProgramada1 to set
	 */
	public void setFechaProgramada1(Date fechaProgramada1) {
		this.fechaProgramada1 = fechaProgramada1;
	}

	/**
	 * @return the estadoPago1
	 */
	public String getEstadoPago1() {
		return estadoPago1;
	}

	/**
	 * @param estadoPago1 the estadoPago1 to set
	 */
	public void setEstadoPago1(String estadoPago1) {
		this.estadoPago1 = estadoPago1;
	}

	/**
	 * @return the folioFactura2
	 */
	public String getFolioFactura2() {
		return folioFactura2;
	}

	/**
	 * @param folioFactura2 the folioFactura2 to set
	 */
	public void setFolioFactura2(String folioFactura2) {
		this.folioFactura2 = folioFactura2;
	}

	/**
	 * @return the subtotal2
	 */
	public Double getSubtotal2() {
		return subtotal2;
	}

	/**
	 * @param subtotal2 the subtotal2 to set
	 */
	public void setSubtotal2(Double subtotal2) {
		this.subtotal2 = subtotal2;
	}

	/**
	 * @return the iva2
	 */
	public Double getIva2() {
		return iva2;
	}

	/**
	 * @param iva2 the iva2 to set
	 */
	public void setIva2(Double iva2) {
		this.iva2 = iva2;
	}

	/**
	 * @return the total2
	 */
	public Double getTotal2() {
		return total2;
	}

	/**
	 * @param total2 the total2 to set
	 */
	public void setTotal2(Double total2) {
		this.total2 = total2;
	}

	/**
	 * @return the fechaEmision2
	 */
	public Date getFechaEmision2() {
		return fechaEmision2;
	}

	/**
	 * @param fechaEmision2 the fechaEmision2 to set
	 */
	public void setFechaEmision2(Date fechaEmision2) {
		this.fechaEmision2 = fechaEmision2;
	}

	/**
	 * @return the fechaIngreso2
	 */
	public Date getFechaIngreso2() {
		return fechaIngreso2;
	}

	/**
	 * @param fechaIngreso2 the fechaIngreso2 to set
	 */
	public void setFechaIngreso2(Date fechaIngreso2) {
		this.fechaIngreso2 = fechaIngreso2;
	}

	/**
	 * @return the diasCredito2
	 */
	public Double getDiasCredito2() {
		return diasCredito2;
	}

	/**
	 * @param diasCredito2 the diasCredito2 to set
	 */
	public void setDiasCredito2(Double diasCredito2) {
		this.diasCredito2 = diasCredito2;
	}

	/**
	 * @return the fechaProgramada2
	 */
	public Date getFechaProgramada2() {
		return fechaProgramada2;
	}

	/**
	 * @param fechaProgramada2 the fechaProgramada2 to set
	 */
	public void setFechaProgramada2(Date fechaProgramada2) {
		this.fechaProgramada2 = fechaProgramada2;
	}

	/**
	 * @return the estadoPago2
	 */
	public String getEstadoPago2() {
		return estadoPago2;
	}

	/**
	 * @param estadoPago2 the estadoPago2 to set
	 */
	public void setEstadoPago2(String estadoPago2) {
		this.estadoPago2 = estadoPago2;
	}

	/**
	 * @return the folioFactura3
	 */
	public String getFolioFactura3() {
		return folioFactura3;
	}

	/**
	 * @param folioFactura3 the folioFactura3 to set
	 */
	public void setFolioFactura3(String folioFactura3) {
		this.folioFactura3 = folioFactura3;
	}

	/**
	 * @return the subtotal3
	 */
	public Double getSubtotal3() {
		return subtotal3;
	}

	/**
	 * @param subtotal3 the subtotal3 to set
	 */
	public void setSubtotal3(Double subtotal3) {
		this.subtotal3 = subtotal3;
	}

	/**
	 * @return the iva3
	 */
	public Double getIva3() {
		return iva3;
	}

	/**
	 * @param iva3 the iva3 to set
	 */
	public void setIva3(Double iva3) {
		this.iva3 = iva3;
	}

	/**
	 * @return the total3
	 */
	public Double getTotal3() {
		return total3;
	}

	/**
	 * @param total3 the total3 to set
	 */
	public void setTotal3(Double total3) {
		this.total3 = total3;
	}

	/**
	 * @return the fechaEmision3
	 */
	public Date getFechaEmision3() {
		return fechaEmision3;
	}

	/**
	 * @param fechaEmision3 the fechaEmision3 to set
	 */
	public void setFechaEmision3(Date fechaEmision3) {
		this.fechaEmision3 = fechaEmision3;
	}

	/**
	 * @return the fechaIngreso3
	 */
	public Date getFechaIngreso3() {
		return fechaIngreso3;
	}

	/**
	 * @param fechaIngreso3 the fechaIngreso3 to set
	 */
	public void setFechaIngreso3(Date fechaIngreso3) {
		this.fechaIngreso3 = fechaIngreso3;
	}

	/**
	 * @return the diasCredito3
	 */
	public Double getDiasCredito3() {
		return diasCredito3;
	}

	/**
	 * @param diasCredito3 the diasCredito3 to set
	 */
	public void setDiasCredito3(Double diasCredito3) {
		this.diasCredito3 = diasCredito3;
	}

	/**
	 * @return the fechaProgramada3
	 */
	public Date getFechaProgramada3() {
		return fechaProgramada3;
	}

	/**
	 * @param fechaProgramada3 the fechaProgramada3 to set
	 */
	public void setFechaProgramada3(Date fechaProgramada3) {
		this.fechaProgramada3 = fechaProgramada3;
	}

	/**
	 * @return the estadoPago3
	 */
	public String getEstadoPago3() {
		return estadoPago3;
	}

	/**
	 * @param estadoPago3 the estadoPago3 to set
	 */
	public void setEstadoPago3(String estadoPago3) {
		this.estadoPago3 = estadoPago3;
	}

	/**
	 * @return the comentariosInformacionFacturacion3DO
	 */
	public List<ComentarioInformacionFacturacion3DO> getComentariosInformacionFacturacion3DO() {
		return comentariosInformacionFacturacion3DO;
	}

	/**
	 * @param comentariosInformacionFacturacion3DO the comentariosInformacionFacturacion3DO to set
	 */
	public void setComentariosInformacionFacturacion3DO(
			List<ComentarioInformacionFacturacion3DO> comentariosInformacionFacturacion3DO) {
		this.comentariosInformacionFacturacion3DO = comentariosInformacionFacturacion3DO;
	}

	/**
	 * @return the comentariosInformacionFacturacion2DO
	 */
	public List<ComentarioInformacionFacturacion2DO> getComentariosInformacionFacturacion2DO() {
		return comentariosInformacionFacturacion2DO;
	}

	/**
	 * @param comentariosInformacionFacturacion2DO the comentariosInformacionFacturacion2DO to set
	 */
	public void setComentariosInformacionFacturacion2DO(
			List<ComentarioInformacionFacturacion2DO> comentariosInformacionFacturacion2DO) {
		this.comentariosInformacionFacturacion2DO = comentariosInformacionFacturacion2DO;
	}

	/**
	 * @return the comentariosInformacionFacturacion1DO
	 */
	public List<ComentarioInformacionFacturacion1DO> getComentariosInformacionFacturacion1DO() {
		return comentariosInformacionFacturacion1DO;
	}

	/**
	 * @param comentariosInformacionFacturacion1DO the comentariosInformacionFacturacion1DO to set
	 */
	public void setComentariosInformacionFacturacion1DO(
			List<ComentarioInformacionFacturacion1DO> comentariosInformacionFacturacion1DO) {
		this.comentariosInformacionFacturacion1DO = comentariosInformacionFacturacion1DO;
	}
	
	
	
	
}
