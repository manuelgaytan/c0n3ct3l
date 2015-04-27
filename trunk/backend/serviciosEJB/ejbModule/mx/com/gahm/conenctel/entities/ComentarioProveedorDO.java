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
 * @author MHDolores
 *
 */
@Entity
@Table(name = "ComentarioProveedor")
@NamedQueries({
	@NamedQuery(name = "ComentarioProveedorDO.findAll", query = "select rc from ComentarioProveedorDO rc")
	})
public class ComentarioProveedorDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_calificado", nullable = false)
	private ProveedorCalificadoDO proveedorCalificado;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_compras", nullable = false)
	private ComentarioComprasDO comentarioCompras;

	public ComentarioProveedorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioProveedorDO(Integer id,
			ProveedorCalificadoDO proveedorCalificado,
			ComentarioComprasDO comentarioCompras) {
		super();
		this.id = id;
		this.proveedorCalificado = proveedorCalificado;
		this.comentarioCompras = comentarioCompras;
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
	 * @return the proveedorCalificado
	 */
	public ProveedorCalificadoDO getProveedorCalificado() {
		return proveedorCalificado;
	}

	/**
	 * @param proveedorCalificado the proveedorCalificado to set
	 */
	public void setProveedorCalificado(ProveedorCalificadoDO proveedorCalificado) {
		this.proveedorCalificado = proveedorCalificado;
	}

	/**
	 * @return the comentarioCompras
	 */
	public ComentarioComprasDO getComentarioCompras() {
		return comentarioCompras;
	}

	/**
	 * @param comentarioCompras the comentarioCompras to set
	 */
	public void setComentarioCompras(ComentarioComprasDO comentarioCompras) {
		this.comentarioCompras = comentarioCompras;
	}
	
	
	
	
	
	
}
