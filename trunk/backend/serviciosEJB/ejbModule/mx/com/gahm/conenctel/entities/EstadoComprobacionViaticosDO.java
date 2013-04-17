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
 * @author MHDolores
 *
 */
@Entity
@Table(name="EstadoComprobacionViaticos")
@NamedQueries({
	@NamedQuery(name = "EstadoComprobacionViaticosDO.findAll", query = "select rc from EstadoComprobacionViaticosDO rc")
	})
public class EstadoComprobacionViaticosDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8064497268596839283L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="estado")
	private String etiqueta;

	public EstadoComprobacionViaticosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EstadoComprobacionViaticosDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.etiqueta = etiqueta;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}

	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	
	
}