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
 * @author SEVEN
 *
 */
@Entity
@Table(name = "PagoMovimientoPagoContableServicio")
@NamedQueries({
	@NamedQuery(name = "PagoMovimientoPagoContableServicioDO.findAll", 
			query = "select rc from PagoMovimientoPagoContableServicioDO rc")		
	})
public class PagoMovimientoPagoContableServicioDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9051466475861996505L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_movimiento_pago_contable_servicio", nullable = false)
	private MovimientoPagoContableServicioDO movimientoPagoContableServicio;
	
	@ManyToOne
	@JoinColumn(name = "fk_banco_conectel", nullable = false)
	private BancoConectelDO bancoConectel;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_abono", nullable = false, length = 10)
	private Date fechaAbono;
	
	@Column(name = "monto", nullable = false)
	private Double monto;
	
	@Column(name = "referencia_abono", nullable = false)
	private String referenciaAbono;
	
	@Column(name = "cuentas_destino", nullable = false)
	private String cuentasDestino;
	
	@OneToMany(mappedBy="pagoMovimientoPagoContableServicio", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioPagoMovimientoPagoContableServicioDO> comentariosPagoMovimientoPagoContableServicio;
	
	public PagoMovimientoPagoContableServicioDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagoMovimientoPagoContableServicioDO(Integer id,
			MovimientoPagoContableServicioDO movimientoPagoContableServicio,
			BancoConectelDO bancoConectel, Date fechaAbono, Double monto,
			String referenciaAbono) {
		super();
		this.id = id;
		this.movimientoPagoContableServicio = movimientoPagoContableServicio;
		this.bancoConectel = bancoConectel;
		this.fechaAbono = fechaAbono;
		this.monto = monto;
		this.referenciaAbono = referenciaAbono;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MovimientoPagoContableServicioDO getMovimientoPagoContableServicio() {
		return movimientoPagoContableServicio;
	}

	public void setMovimientoPagoContableServicio(
			MovimientoPagoContableServicioDO movimientoPagoContableServicio) {
		this.movimientoPagoContableServicio = movimientoPagoContableServicio;
	}

	public BancoConectelDO getBancoConectel() {
		return bancoConectel;
	}

	public void setBancoConectel(BancoConectelDO bancoConectel) {
		this.bancoConectel = bancoConectel;
	}

	public Date getFechaAbono() {
		return fechaAbono;
	}

	public void setFechaAbono(Date fechaAbono) {
		this.fechaAbono = fechaAbono;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getReferenciaAbono() {
		return referenciaAbono;
	}

	public void setReferenciaAbono(String referenciaAbono) {
		this.referenciaAbono = referenciaAbono;
	}

	public List<ComentarioPagoMovimientoPagoContableServicioDO> getComentariosPagoMovimientoPagoContableServicio() {
		return comentariosPagoMovimientoPagoContableServicio;
	}

	public void setComentariosPagoMovimientoPagoContableServicio(
			List<ComentarioPagoMovimientoPagoContableServicioDO> comentarioPagoMovimientoPagoContableServicio) {
		this.comentariosPagoMovimientoPagoContableServicio = comentarioPagoMovimientoPagoContableServicio;
	}

	public String getCuentasDestino() {
		return cuentasDestino;
	}

	public void setCuentasDestino(String cuentasDestino) {
		this.cuentasDestino = cuentasDestino;
	}
}
