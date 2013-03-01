package mx.com.gahm.conenctel.entities;

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
@NamedQueries({
	@NamedQuery(name = "ComentarioConcentradoOrdenCompraClienteDO.findAll", query = "select c from ComentarioConcentradoOrdenCompraClienteDO c") })
@Table(name="ComentarioConcentradoOrdenCompraCliente")
public class ComentarioConcentradoOrdenCompraClienteDO {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_concentrado_orden_compra_cliente")
	private ConcentradoOrdenCompraClienteDO concentradoOrdenCompraCliente;
	
	@ManyToOne
	@JoinColumn(name="fk_validacion_administrativa")
	private ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa;

	public ComentarioConcentradoOrdenCompraClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioConcentradoOrdenCompraClienteDO(
			Long id,
			ConcentradoOrdenCompraClienteDO concentradoOrdenCompraCliente,
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa) {
		super();
		this.id = id;
		this.concentradoOrdenCompraCliente = concentradoOrdenCompraCliente;
		this.comentarioValidacionAdministrativa = comentarioValidacionAdministrativa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConcentradoOrdenCompraClienteDO getConcentradoOrdenCompraCliente() {
		return concentradoOrdenCompraCliente;
	}

	public void setConcentradoOrdenCompraCliente(
			ConcentradoOrdenCompraClienteDO concentradoOrdenCompraCliente) {
		this.concentradoOrdenCompraCliente = concentradoOrdenCompraCliente;
	}

	public ComentarioValidacionAdministrativaDO getComentarioValidacionAdministrativa() {
		return comentarioValidacionAdministrativa;
	}

	public void setComentarioValidacionAdministrativa(
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa) {
		this.comentarioValidacionAdministrativa = comentarioValidacionAdministrativa;
	}

	
}
