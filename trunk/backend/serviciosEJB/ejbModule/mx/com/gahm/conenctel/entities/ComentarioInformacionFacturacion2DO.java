/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

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
 * @author MHDolores
 *
 */
@Entity
@Table(name = "ComentarioInformacionFacturacion_2")
@NamedQueries({
	@NamedQuery(name = "ComentarioInformacionFacturacion2DO.findAll", query = "select rc from ComentarioInformacionFacturacion2DO rc")
	})
public class ComentarioInformacionFacturacion2DO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6316999175914075327L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_informacion_facturacion")
	private InformacionFacturacionDO informacionFacturacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_cuentas_pagar_facturacion")
	private ComentarioCuentasPagarFacturacionDO comentarioCuentasPagarFacturacion;

	public ComentarioInformacionFacturacion2DO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioInformacionFacturacion2DO(
			Long id,
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
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
