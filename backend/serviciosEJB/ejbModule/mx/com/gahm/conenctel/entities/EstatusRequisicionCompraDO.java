package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "EstatusRequisicionCompra")
@NamedQueries({
	@NamedQuery(name = "EstatusRequisicionCompraDO.findAll", query = "select e from EstatusRequisicionCompraDO e")
	})
public class EstatusRequisicionCompraDO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -8548327481470328507L;
	private Integer id;
	private String estatus;


	public EstatusRequisicionCompraDO() {
	}

	public EstatusRequisicionCompraDO(String estatus) {
		this.estatus = estatus;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "estatus", nullable = false)
	public String getEstatus() {
		return this.estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}