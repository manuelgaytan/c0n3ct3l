package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla comentario requisicion.
 * 
 * @author Manuel Gayt&aacute;n
 */
@Entity
@Table(name="ComentarioRequisicion")
public class ComentarioRequisicionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name="fk_requisicion_compra")
	private RequisicionCompraDO requisicionCompra;
	
	@OneToOne
    @JoinColumn(name = "fk_comentario_compras")
	private ComentarioComprasDO comentarioCompras;

	public ComentarioRequisicionDO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RequisicionCompraDO getRequisicionCompra() {
		return requisicionCompra;
	}

	public void setRequisicionCompra(RequisicionCompraDO requisicionCompra) {
		this.requisicionCompra = requisicionCompra;
	}

	public ComentarioComprasDO getComentarioCompras() {
		return comentarioCompras;
	}

	public void setComentarioCompras(ComentarioComprasDO comentarioCompras) {
		this.comentarioCompras = comentarioCompras;
	}
	
	

}