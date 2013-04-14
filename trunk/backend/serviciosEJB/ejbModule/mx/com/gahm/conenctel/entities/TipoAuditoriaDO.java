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
@Table(name = "TipoAuditoria")
@NamedQueries({
	@NamedQuery(name = "TipoAuditoriaDO.findAll", query = "select p from TipoAuditoriaDO p ")})
public class TipoAuditoriaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -970902848586646278L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="tipo")
	private String tipo;
	
	
	public TipoAuditoriaDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public TipoAuditoriaDO(long id, String tipo) {
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
