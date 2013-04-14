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
@Table(name = "FormaAuditoria")
@NamedQueries({
	@NamedQuery(name = "FormaAuditoriaDO.findAll", query = "select p from FormaAuditoriaDO p ")})
public class FormaAuditoriaDO  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -114208144826485475L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="forma")
	private String forma;
	
	
	public FormaAuditoriaDO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FormaAuditoriaDO(long id, String forma) {
		super();
		this.id = id;
		this.forma = forma;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getForma() {
		return forma;
	}


	public void setForma(String forma) {
		this.forma = forma;
	}
	


}
