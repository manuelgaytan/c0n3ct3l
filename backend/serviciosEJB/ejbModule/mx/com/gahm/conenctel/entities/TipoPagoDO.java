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


/**
 *  @author lespinosa
 * The persistent class for the tipopago database table.
 * 
 */
@Cacheable(false)
@Entity
@NamedQueries({
	@NamedQuery(name = "TipoPagoDO.findAll", query = "select tp from TipoPagoDO tp "),
	@NamedQuery(name = "TipoPagoDO.findChequeEfectivoTransferencia", query = "select tp from TipoPagoDO tp where tp.id in (1,2,3)")})
@Table(name="tipopago")
public class TipoPagoDO implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name = "tipo")
	private String tipo;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public TipoPagoDO() {
	}


}