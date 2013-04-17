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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author SEVEN
 *
 */
@Entity
@Table(name = "ComentarioCotizacion")
@NamedQueries({
	@NamedQuery(name = "ComentarioCotizacionDO.findAll", query = "select c from ComentarioCotizacionDO c")})
public class ComentarioCotizacionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 996278680931600030L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_cotizacion", nullable = false)
	private CotizacionDO cotizacion;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_compras")
	private ComentarioComprasDO comentarioCompras;

	public ComentarioCotizacionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioCotizacionDO(Integer id, CotizacionDO cotizacion) {
		super();
		this.id = id;
		this.cotizacion = cotizacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CotizacionDO getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(CotizacionDO cotizacion) {
		this.cotizacion = cotizacion;
	}

	public ComentarioComprasDO getComentarioCompras() {
		return comentarioCompras;
	}

	public void setComentarioCompras(ComentarioComprasDO comentarioCompras) {
		this.comentarioCompras = comentarioCompras;
	} 
	
	
	
	
}
