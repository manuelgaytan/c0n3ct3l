/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
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
	
	@OneToMany(mappedBy="concentradoOrdenCompraCliente", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ComentarioConcentradoOrdenCompraClienteDO> comentariosConcentradoOrdenCompraCliente;
	
	@OneToMany(mappedBy="concentradoOrdenCompraCliente", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<PartidaConcentradoOrdenCompraClienteDO> partidasConcentradoOrdenCompraCliente;

	public ConcentradoOrdenCompraClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ConcentradoOrdenCompraClienteDO(long id, ClienteDO cliente,
			String ordenCompra, Date fechaOrdenCompra, Integer numRequisicion) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.ordenCompra = ordenCompra;
		this.fechaOrdenCompra = fechaOrdenCompra;
		this.numRequisicion = numRequisicion;
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

	public List<ComentarioConcentradoOrdenCompraClienteDO> getComentariosConcentradoOrdenCompraCliente() {
		return comentariosConcentradoOrdenCompraCliente;
	}

	public void setComentariosConcentradoOrdenCompraCliente(
			List<ComentarioConcentradoOrdenCompraClienteDO> comentariosConcentradoOrdenCompraCliente) {
		this.comentariosConcentradoOrdenCompraCliente = comentariosConcentradoOrdenCompraCliente;
	}

	public List<PartidaConcentradoOrdenCompraClienteDO> getPartidasConcentradoOrdenCompraCliente() {
		return partidasConcentradoOrdenCompraCliente;
	}

	public void setPartidasConcentradoOrdenCompraCliente(
			List<PartidaConcentradoOrdenCompraClienteDO> partidasConcentradoOrdenCompraCliente) {
		this.partidasConcentradoOrdenCompraCliente = partidasConcentradoOrdenCompraCliente;
	}

}
