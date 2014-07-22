package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

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

@Entity
@NamedQueries({ @NamedQuery(name = "PartidaConcentradoOrdenCompraClienteDO.findAll", query = "select c from PartidaConcentradoOrdenCompraClienteDO c") })
@Table(name = "PartidaConcentradoOrdenCompraCliente")
public class PartidaConcentradoOrdenCompraClienteDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7306989193621279441L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne
	@JoinColumn(name = "fk_concentrado_orden_compra_cliente")
	private ConcentradoOrdenCompraClienteDO concentradoOrdenCompraCliente;

	@Column(name = "item")
	private Integer item;

	@Column(name = "codigo")
	private String codigo;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "precio_unitario")
	private Integer precioUnitario;
	
	@Column(name = "central_sitio")
	private String centralSitio;
	@Column(name = "id_sitio")
	private String idSitio;
	@Column(name = "local_foraneo")
	private String localForaneo;
	@Column(name = "condicion_pago")
	private String condicionPago;

	public PartidaConcentradoOrdenCompraClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartidaConcentradoOrdenCompraClienteDO(long id,
			ConcentradoOrdenCompraClienteDO concentradoOrdenCompraCliente,
			Integer item, String codigo, String descripcion,
			Integer precioUnitario, String centralSitio, String idSitio, String localForaneo, String condicionPago) {
		super();
		this.id = id;
		this.concentradoOrdenCompraCliente = concentradoOrdenCompraCliente;
		this.item = item;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.centralSitio = centralSitio;
		this.idSitio = idSitio;
		this.localForaneo = localForaneo;
		this.condicionPago = condicionPago;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ConcentradoOrdenCompraClienteDO getConcentradoOrdenCompraCliente() {
		return concentradoOrdenCompraCliente;
	}

	public void setConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO concentradoOrdenCompraCliente) {
		this.concentradoOrdenCompraCliente = concentradoOrdenCompraCliente;
	}

	public Integer getItem() {
		return item;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Integer precioUnitario) {
		this.precioUnitario = precioUnitario;
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
