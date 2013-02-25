package mx.com.gahm.conenctel.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "SolicitanteRequisicion")
@NamedQueries({
	@NamedQuery(name = "SolicitanteRequisicionDO.findAll", 
			query = "select oc from SolicitanteRequisicionDO oc") })
public class SolicitanteRequisicionDO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5103801106130001615L;
	private Integer id;
	@ManyToOne
	@JoinColumn(name="fk_requisicion_compra")
	private RequisicionCompraDO requisicionCompra;
	private ColaboradorDO colaborador;

	public SolicitanteRequisicionDO() {
	}

	public SolicitanteRequisicionDO(RequisicionCompraDO requisicionCompraDO, ColaboradorDO colaboradorDO) {
		this.requisicionCompra = requisicionCompraDO;
		this.colaborador = colaboradorDO;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RequisicionCompraDO getRequisicionCompra() {
		return requisicionCompra;
	}

	public void setRequisicionCompra(RequisicionCompraDO requisicionCompraDO) {
		this.requisicionCompra = requisicionCompraDO;
	}

	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorDO colaboradorDO) {
		this.colaborador = colaboradorDO;
	}

}