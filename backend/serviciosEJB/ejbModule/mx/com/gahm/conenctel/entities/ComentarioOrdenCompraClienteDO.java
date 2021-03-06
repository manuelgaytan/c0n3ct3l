package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ComentarioOrdenCompraCliente")
@NamedQueries({ @NamedQuery(name = "ComentarioOrdenCompraClienteDO.findAll", query = "select rc from ComentarioOrdenCompraClienteDO rc") })
public class ComentarioOrdenCompraClienteDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "fk_orden_compra_cliente", nullable = false)
	private OrdenCompraClienteDO ordenCompraCliente;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_validacion_administrativa", nullable = false)
	private ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa;
	

	/**
	 * 
	 */
	public ComentarioOrdenCompraClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param concentradoOrdenCompraCliente
	 * @param comentarioValidacionAdministrativa
	 */
	public ComentarioOrdenCompraClienteDO(
			Integer id,
			OrdenCompraClienteDO ordenCompraCliente,
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa) {
		super();
		this.id = id;
		this.ordenCompraCliente = ordenCompraCliente;
		this.comentarioValidacionAdministrativa = comentarioValidacionAdministrativa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public ComentarioValidacionAdministrativaDO getComentarioValidacionAdministrativa() {
		return comentarioValidacionAdministrativa;
	}

	public void setComentarioValidacionAdministrativa(
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa) {
		this.comentarioValidacionAdministrativa = comentarioValidacionAdministrativa;
	}

	public OrdenCompraClienteDO getOrdenCompraCliente() {
		return ordenCompraCliente;
	}

	public void setOrdenCompraCliente(OrdenCompraClienteDO ordenCompraCliente) {
		this.ordenCompraCliente = ordenCompraCliente;
	} 
	
}
