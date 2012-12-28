package mx.com.gahm.conenctel.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "UnidadOrdenCompra")
@NamedQueries({
	@NamedQuery(name = "UnidadOrdenCompraDO.findAll", 
			query = "select oc from UnidadOrdenCompraDO oc") })
public class UnidadOrdenCompraDO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5103801106130001615L;
	private Integer id;
	private String unidad;

	public UnidadOrdenCompraDO() {
	}

	public UnidadOrdenCompraDO(String unidad) {
		this.unidad = unidad;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "unidad")
	public String getUnidad() {
		return this.unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}