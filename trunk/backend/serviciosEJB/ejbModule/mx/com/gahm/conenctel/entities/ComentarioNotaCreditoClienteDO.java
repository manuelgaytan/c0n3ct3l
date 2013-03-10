package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ComentarioNotaCreditoClienteDO")
@NamedQueries({
	@NamedQuery(name = "ComentarioNotaCreditoClienteDO.findAll", query = "select rc from ComentarioNotaCreditoClienteDO rc")
	})
public class ComentarioNotaCreditoClienteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1444883757243027858L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;


	@ManyToOne
	@JoinColumn(name = "fk_nota_credito_cliente", nullable = false)
	private NotaCreditoClienteDO notaCreditoCliente;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_cuentas_pagar_facturacion", nullable = false)
	private ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion;

	public ComentarioNotaCreditoClienteDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioNotaCreditoClienteDO(
			Integer id,
			NotaCreditoClienteDO notaCreditoCliente,
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion) {
		super();
		this.id = id;
		this.notaCreditoCliente = notaCreditoCliente;
		this.comentarioCuentasPagarFacturacion = comentarioCuentasPagarFacturacion;
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
	 * @return the notaCreditoCliente
	 */
	public NotaCreditoClienteDO getNotaCreditoCliente() {
		return notaCreditoCliente;
	}

	/**
	 * @param notaCreditoCliente the notaCreditoCliente to set
	 */
	public void setNotaCreditoCliente(NotaCreditoClienteDO notaCreditoCliente) {
		this.notaCreditoCliente = notaCreditoCliente;
	}

	/**
	 * @return the comentarioCuentasPagarFacturacion
	 */
	public ComentarioCuentasPagarFacturacionDO getComentarioCuentasPagarFacturacion() {
		return comentarioCuentasPagarFacturacion;
	}

	/**
	 * @param comentarioCuentasPagarFacturacion the comentarioCuentasPagarFacturacion to set
	 */
	public void setComentarioCuentasPagarFacturacion(
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion) {
		this.comentarioCuentasPagarFacturacion = comentarioCuentasPagarFacturacion;
	}
	
	
	

}
