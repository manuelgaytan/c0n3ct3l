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
@Table(name = "ComentarioMovimientoPagoContableServicio")
@NamedQueries({
	@NamedQuery(name = "ComentarioMovimientoPagoContableServicioDO.findAll", query = "select rc from ComentarioMovimientoPagoContableServicioDO rc")
	})
public class ComentarioMovimientoPagoContableServicioDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6243141410909571169L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_movimiento_pago_contable_servicio", nullable = false)
	private MovimientoPagoContableServicioDO  movimientoPagoContableServicio;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_contabilidad", nullable = false)
	private ComentarioContabilidadDO comentarioContabilidad;

	public ComentarioMovimientoPagoContableServicioDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioMovimientoPagoContableServicioDO(Integer id,
			MovimientoPagoContableServicioDO movimientoPagoContableServicio,
			ComentarioContabilidadDO comentarioContabilidad) {
		super();
		this.id = id;
		this.movimientoPagoContableServicio = movimientoPagoContableServicio;
		this.comentarioContabilidad = comentarioContabilidad;
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
	 * @return the movimientoPagoContableServicio
	 */
	public MovimientoPagoContableServicioDO getMovimientoPagoContableServicio() {
		return movimientoPagoContableServicio;
	}

	/**
	 * @param movimientoPagoContableServicio the movimientoPagoContableServicio to set
	 */
	public void setMovimientoPagoContableServicio(
			MovimientoPagoContableServicioDO movimientoPagoContableServicio) {
		this.movimientoPagoContableServicio = movimientoPagoContableServicio;
	}

	/**
	 * @return the comentarioContabilidad
	 */
	public ComentarioContabilidadDO getComentarioContabilidad() {
		return comentarioContabilidad;
	}

	/**
	 * @param comentarioContabilidad the comentarioContabilidad to set
	 */
	public void setComentarioContabilidad(
			ComentarioContabilidadDO comentarioContabilidad) {
		this.comentarioContabilidad = comentarioContabilidad;
	}
	
	
}
