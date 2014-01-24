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
@Table(name = "PermisoConGoceSueldo")
@NamedQueries({
	@NamedQuery(name = "PermisoConGoceSueldoDO.findAll", query = "select rc from PermisoConGoceSueldoDO rc")
	})
public class PermisoConGoceSueldoDO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "permiso", nullable = false)
	private String permiso;

	public PermisoConGoceSueldoDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermisoConGoceSueldoDO(Integer id, String permiso) {
		super();
		this.id = id;
		this.permiso = permiso;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

}
