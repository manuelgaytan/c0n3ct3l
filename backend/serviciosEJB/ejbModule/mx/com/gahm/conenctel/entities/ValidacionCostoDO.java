package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({ @NamedQuery(name = "ValidacionCostoDO.findAll", query = "select s from ValidacionCostoDO s") })
@Table(name = "EstadoValidacionCosto")
public class ValidacionCostoDO implements Serializable{

	/**
	 * Guillermo Hernandez Dolores
	 */
	private static final long serialVersionUID = 2392688882774470005L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "estado")
	private String etiqueta;

	/**
	 * 
	 */
	public ValidacionCostoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param etiqueta
	 */
	public ValidacionCostoDO(Long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
}