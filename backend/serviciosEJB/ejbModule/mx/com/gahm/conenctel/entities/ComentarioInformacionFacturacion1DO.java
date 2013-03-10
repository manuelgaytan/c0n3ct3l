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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "ComentarioInformacionFacturacion_1")
@NamedQueries({
	@NamedQuery(name = "ComentarioInformacionFacturacion1DO.findAll", query = "select rc from ComentarioInformacionFacturacion1DO rc")
	})
public class ComentarioInformacionFacturacion1DO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1159695000432033367L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_informacion_facturacion", nullable = false)
	private InformacionFacturacionDO informacionFacturacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_cuentas_pagar_facturacion", nullable = false)
	private ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion;

	public ComentarioInformacionFacturacion1DO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioInformacionFacturacion1DO(
			Integer id,
			InformacionFacturacionDO informacionFacturacion,
			ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion) {
		super();
		this.id = id;
		this.informacionFacturacion = informacionFacturacion;
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
	 * @return the informacionFacturacion
	 */
	public InformacionFacturacionDO getInformacionFacturacion() {
		return informacionFacturacion;
	}

	/**
	 * @param informacionFacturacion the informacionFacturacion to set
	 */
	public void setInformacionFacturacion(
			InformacionFacturacionDO informacionFacturacion) {
		this.informacionFacturacion = informacionFacturacion;
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
