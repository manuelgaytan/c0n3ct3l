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
@Table(name = "ResultadoImplementacion")
@NamedQueries({
	@NamedQuery(name = "ResultadoImplementacionDO.findAll", query = "select rc from ResultadoImplementacionDO rc")
	})
public class ResultadoImplementacionDO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5115748546624552827L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="resultado")
	private String resultado;

	public ResultadoImplementacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultadoImplementacionDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.resultado = etiqueta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String etiqueta) {
		this.resultado = etiqueta;
	}
	
	
	
	
	
}
