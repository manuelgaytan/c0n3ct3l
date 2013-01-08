package mx.com.gahm.conenctel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "EstatusRequisicionCompra")
public class EstatusRequisicionCompraDO implements java.io.Serializable {


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