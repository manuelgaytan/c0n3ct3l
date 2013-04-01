/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "BancoConectel")
@NamedQueries({
	@NamedQuery(name = "BancoConectelDO.findAll", query = "select rc from BancoConectelDO rc")
	})
public class BancoConectelDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5200878235475225226L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "clabe_interbancaria", nullable = false)
	private String clabeInterbancaria;
	
	@Column(name = "banco", nullable = false)
	private String banco;
	
	@Column(name = "cuenta_bancaria", nullable = false)
	private String cuentaBancaria;

	public BancoConectelDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BancoConectelDO(Integer id, String clabeInterbancaria, String banco,
			String cuentaBancaria) {
		super();
		this.id = id;
		this.clabeInterbancaria = clabeInterbancaria;
		this.banco = banco;
		this.cuentaBancaria = cuentaBancaria;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the clabeInterbancaria
	 */
	public String getClabeInterbancaria() {
		return clabeInterbancaria;
	}

	/**
	 * @param clabeInterbancaria the clabeInterbancaria to set
	 */
	public void setClabeInterbancaria(String clabeInterbancaria) {
		this.clabeInterbancaria = clabeInterbancaria;
	}

	/**
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * @return the cuentaBancaria
	 */
	public String getCuentaBancaria() {
		return cuentaBancaria;
	}

	/**
	 * @param cuentaBancaria the cuentaBancaria to set
	 */
	public void setCuentaBancaria(String cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}
	
	
	
	
	
	
}
