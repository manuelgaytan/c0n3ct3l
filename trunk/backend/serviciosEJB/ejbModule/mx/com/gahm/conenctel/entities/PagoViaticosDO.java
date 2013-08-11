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
 * @author Guillermo
 *
 */
@Entity
@Table(name = "PagoViaticos")
@NamedQueries({
	@NamedQuery(name = "PagoViaticosDO.findAll", query = "select rc from PagoViaticosDO rc")
	})
public class PagoViaticosDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9081926163601735697L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_comprobacion_viaticos", nullable = false)
	private ComprobacionViaticosDO comprobacionViaticos;
	
	@ManyToOne
	@JoinColumn(name = "fk_banco_conectel", nullable = false)
	private BancoConectelDO bancoConectel; 
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_abono")
	private Date fechaAbono;
	
	@Column(name = "monto", nullable = false)
	private Double monto;

	@Column(name = "referencia_abono", nullable = false)
	private Integer referenciaAbono;

	@OneToMany(mappedBy="pagoViaticos", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioPagoViaticosDO> comentariosPagoViaticos; 
	
	public PagoViaticosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PagoViaticosDO(Integer id,
			ComprobacionViaticosDO comprobacionViaticos,
			BancoConectelDO bancoConectel, Date fechaAbono, Double monto,
			Integer referenciaAbono) {
		super();
		this.id = id;
		this.comprobacionViaticos = comprobacionViaticos;
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

	public ComprobacionViaticosDO getComprobacionViaticos() {
		return comprobacionViaticos;
	}

	public void setComprobacionViaticos(ComprobacionViaticosDO comprobacionViaticos) {
		this.comprobacionViaticos = comprobacionViaticos;
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

	public Integer getReferenciaAbono() {
		return referenciaAbono;
	}

	public void setReferenciaAbono(Integer referenciaAbono) {
		this.referenciaAbono = referenciaAbono;
	}

	public List<ComentarioPagoViaticosDO> getComentariosPagoViaticos() {
		return comentariosPagoViaticos;
	}

	public void setComentariosPagoViaticos(
			List<ComentarioPagoViaticosDO> comentariosPagoViaticos) {
		this.comentariosPagoViaticos = comentariosPagoViaticos;
	}
	
	
}
