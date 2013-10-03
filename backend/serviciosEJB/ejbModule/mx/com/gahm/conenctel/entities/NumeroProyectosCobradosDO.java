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


/**
 * Clase de persistencia para la tabla NumeroProyectosCobrados.
 * 
 * @author Manuel Gaytan
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "NumeroProyectosCobradosDO.getProyectosCobrados", query = "select new mx.com.gahm.conenctel.model.ItemEstatusProyecto(npc.id, npc.tipo, npc.cantidad ) from NumeroProyectosCobradosDO npc") })
@Table(name="NumeroProyectosCobrados")
public class NumeroProyectosCobradosDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;

	@Column(name="Tipo")
	private String tipo;

	@Column(name="Cantidad")
	private String cantidad;

	public NumeroProyectosCobradosDO() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
}