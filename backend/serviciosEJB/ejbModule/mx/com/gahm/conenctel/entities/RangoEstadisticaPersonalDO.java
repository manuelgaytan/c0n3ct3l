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
@Table(name = "RangoEstadisticaPersonal")
@NamedQueries({
	@NamedQuery(name = "RangoEstadisticaPersonalDO.findAll", query = "select rc from RangoEstadisticaPersonalDO rc")
	})
public class RangoEstadisticaPersonalDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "rango", nullable = false)
	private String rango;

	public RangoEstadisticaPersonalDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RangoEstadisticaPersonalDO(Integer id, String rango) {
		super();
		this.id = id;
		this.rango = rango;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

}
