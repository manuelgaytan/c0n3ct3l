package mx.com.gahm.conenctel.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private RequisicionCompraDO requisicionCompraDO;
	private ColaboradorDO colaboradorDO;

	public SolicitanteRequisicionDO() {
	}

	public SolicitanteRequisicionDO(RequisicionCompraDO requisicionCompraDO, ColaboradorDO colaboradorDO) {
		this.requisicionCompraDO = requisicionCompraDO;
		this.colaboradorDO = colaboradorDO;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RequisicionCompraDO getRequisicionCompraDO() {
		return requisicionCompraDO;
	}

	public void setRequisicionCompraDO(RequisicionCompraDO requisicionCompraDO) {
		this.requisicionCompraDO = requisicionCompraDO;
	}

	public ColaboradorDO getColaboradorDO() {
		return colaboradorDO;
	}

	public void setColaboradorDO(ColaboradorDO colaboradorDO) {
		this.colaboradorDO = colaboradorDO;
	}

}