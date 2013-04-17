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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author SEVEN
 *
 */
@Entity
@Table(name = "DocumentoComprobacionViaticos")
@NamedQueries({
	@NamedQuery(name = "DocumentoComprobacionViaticosDO.findAll", query = "select rc from DocumentoComprobacionViaticosDO rc")
	})
public class DocumentoComprobacionViaticosDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5862725635765416133L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_comprobacion_viaticos", nullable = false)
	private ComprobacionViaticosDO comprobacionViatico;
	
	@Column(name = "documento", nullable = false)
	private String documento;

	public DocumentoComprobacionViaticosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentoComprobacionViaticosDO(long id,
			ComprobacionViaticosDO comprobacionViatico, String documento) {
		super();
		this.id = id;
		this.comprobacionViatico = comprobacionViatico;
		this.documento = documento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ComprobacionViaticosDO getComprobacionViatico() {
		return comprobacionViatico;
	}

	public void setComprobacionViatico(ComprobacionViaticosDO comprobacionViatico) {
		this.comprobacionViatico = comprobacionViatico;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
}
