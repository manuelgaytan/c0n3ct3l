/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author lespinosa
 *Clase de persistencia para el tipo de persona Fisica Moral.
 */

@Cacheable(false)
@Entity
@NamedQueries({
	@NamedQuery(name = "TipoPersonaDO.findAll", query = "select p from TipoPersonaDO p ")})
@Table(name = "tipopersona")

public class TipoPersonaDO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	public static long FISICA = 1;
	@Transient
	public static long MORAL = 2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="tipo")
	private String tipo;
	
	
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
