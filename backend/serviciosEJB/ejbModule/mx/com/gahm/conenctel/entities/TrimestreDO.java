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
@Table(name = "Trimestre")
@NamedQueries({
	@NamedQuery(name = "TrimestreDO.findAll", query = "select rc from TrimestreDO rc")
	})
public class TrimestreDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "trimestre", nullable = false)
	private String trimestre;

	public TrimestreDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TrimestreDO(Integer id, String trimestre) {
		super();
		this.id = id;
		this.trimestre = trimestre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

}
