/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 * 
 */

@Entity
@NamedQueries({ @NamedQuery(name = "ConcentradoOrdenCompraClienteDO.findAll", query = "select c from ConcentradoOrdenCompraClienteDO c") })
@Table(name = "ConcentradoOrdenCompraCliente")
public class ConcentradoOrdenCompraClienteDO implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private ClienteDO cliente;
	@Column(name = "orden_compra")
	private String ordenCompra;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_orden_compra")
	private Date fechaOrdenCompra;
	@Column(name = "num_requisicion")
	private Integer numRequisicion;
	@Column(name = "central_sitio")
	private String centralSitio;
	@Column(name = "id_sitio")
	private String idSitio;
	@Column(name = "local_foraneo")
	private String localForaneo;
	@Column(name = "condicion_pago")
	private String condicionPago;

	public ConcentradoOrdenCompraClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConcentradoOrdenCompraClienteDO(long id, ClienteDO cliente,
			String ordenCompra, Date fechaOrdenCompra, Integer numRequisicion,
			String centralSitio, String idSitio, String localForaneo) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.ordenCompra = ordenCompra;
		this.fechaOrdenCompra = fechaOrdenCompra;
		this.numRequisicion = numRequisicion;
		this.centralSitio = centralSitio;
		this.idSitio = idSitio;
		this.localForaneo = localForaneo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClienteDO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDO cliente) {
		this.cliente = cliente;
	}

	public String getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(String ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public Date getFechaOrdenCompra() {
		return fechaOrdenCompra;
	}

	public void setFechaOrdenCompra(Date fechaOrdenCompra) {
		this.fechaOrdenCompra = fechaOrdenCompra;
	}

	public Integer getNumRequisicion() {
		return numRequisicion;
	}

	public void setNumRequisicion(Integer numRequisicion) {
		this.numRequisicion = numRequisicion;
	}

	public String getCentralSitio() {
		return centralSitio;
	}

	public void setCentralSitio(String centralSitio) {
		this.centralSitio = centralSitio;
	}

	public String getIdSitio() {
		return idSitio;
	}

	public void setIdSitio(String idSitio) {
		this.idSitio = idSitio;
	}

	public String getLocalForaneo() {
		return localForaneo;
	}

	public void setLocalForaneo(String localForaneo) {
		this.localForaneo = localForaneo;
	}

	public String getCondicionPago() {
		return condicionPago;
	}

	public void setCondicionPago(String condicionPago) {
		this.condicionPago = condicionPago;
	}

}
