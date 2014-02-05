package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * Clase de persistencia para la tabla tipocolaborador.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="TipoColaborador")
@NamedQueries({
	@NamedQuery(name = "TipoColaboradorDO.findAll", query = "select es from TipoColaboradorDO es ")})
public class TipoColaboradorDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Transient
	public static long PROVEEDORES = 1;
	@Transient
	public static long NOMINA = 2;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	private String tipo;

	public TipoColaboradorDO() {
	}
	
	

	public TipoColaboradorDO(long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}