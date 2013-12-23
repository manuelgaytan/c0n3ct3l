/**
 * 
 */
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
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "TipoServicio")
@NamedQueries({
	@NamedQuery(name = "TipoServicioDO.findAll", query = "select p from TipoServicioDO p ")})
public class TipoServicioDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -970902848586646278L;

	public static final long ID_LOCAL = 1;

	public static final long ID_FORANEO = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="tipo")
	private String tipo;
	
	
	public TipoServicioDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TipoServicioDO(long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
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


	
}
