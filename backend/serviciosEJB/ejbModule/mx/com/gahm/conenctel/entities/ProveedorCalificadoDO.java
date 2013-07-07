/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author lespinosa
 * 
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "ProveedorCalificadoDO.findAll", query = "select p from ProveedorCalificadoDO p "),
		@NamedQuery(name = "ClienteDO.findByName", query = "select c from ClienteDO c where c.nombreComercial = :nombre"),
		@NamedQuery(name = "ProveedorCalificadoDO.findAllCombo", 
		query = "select new mx.com.gahm.conenctel.entities.ProveedorCalificadoComboDO(pc.id,pc.proveedorSeleccionado.proveedor.nombreComercial) "
		+ " from ProveedorCalificadoDO pc")
})
@Table(name = "proveedorcalificado")
public class ProveedorCalificadoDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JoinColumn(name = "fk_proveedor_seleccionado")
	private ProveedorSeleccionadoDO proveedorSeleccionado;

	@JoinColumn(name = "fk_forma_pago")
	private FormaPagoDO formaPago;

	@JoinColumn(name = "fk_tipo_pago")
	private TipoPagoDO tipoPago;

	@Column(name = "moneda")
	private String moneda;

	@Column(name = "limite_credito")
	private Double limiteCredito;

	@Column(name = "dias_credito")
	private int diasCredito;

	@Column(name = "descuentos")
	private Double descuentos;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_dato_bancario")
	private DatoBancarioDO datoBancario;
	
	@OneToMany(mappedBy="proveedorCalificado", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<ComentarioProveedorDO> comentariosProovedor;
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the proveedorSeleccionado
	 */
	public ProveedorSeleccionadoDO getProveedorSeleccionado() {
		return proveedorSeleccionado;
	}

	/**
	 * @param proveedorSeleccionado
	 *            the proveedorSeleccionado to set
	 */
	public void setProveedorSeleccionado(
			ProveedorSeleccionadoDO proveedorSeleccionado) {
		this.proveedorSeleccionado = proveedorSeleccionado;
	}

	/**
	 * @return the formaPago
	 */
	public FormaPagoDO getFormaPago() {
		return formaPago;
	}

	/**
	 * @param formaPago
	 *            the formaPago to set
	 */
	public void setFormaPago(FormaPagoDO formaPago) {
		this.formaPago = formaPago;
	}

	/**
	 * @return the tipoPago
	 */
	public TipoPagoDO getTipoPago() {
		return tipoPago;
	}

	/**
	 * @param tipoPago
	 *            the tipoPago to set
	 */
	public void setTipoPago(TipoPagoDO tipoPago) {
		this.tipoPago = tipoPago;
	}

	/**
	 * @return the moneda
	 */
	public String getMoneda() {
		return moneda;
	}

	/**
	 * @param moneda
	 *            the moneda to set
	 */
	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	/**
	 * @return the limiteCredito
	 */
	public Double getLimiteCredito() {
		return limiteCredito;
	}

	/**
	 * @param limiteCredito
	 *            the limiteCredito to set
	 */
	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	/**
	 * @return the diasCredito
	 */
	public int getDiasCredito() {
		return diasCredito;
	}

	/**
	 * @param diasCredito
	 *            the diasCredito to set
	 */
	public void setDiasCredito(int diasCredito) {
		this.diasCredito = diasCredito;
	}

	/**
	 * @return the descuentos
	 */
	public Double getDescuentos() {
		return descuentos;
	}

	/**
	 * @param descuentos
	 *            the descuentos to set
	 */
	public void setDescuentos(Double descuentos) {
		this.descuentos = descuentos;
	}

	/**
	 * @return the datoBancario
	 */
	public DatoBancarioDO getDatoBancario() {
		return datoBancario;
	}

	/**
	 * @param datoBancario
	 *            the datoBancario to set
	 */
	public void setDatoBancario(DatoBancarioDO datoBancario) {
		this.datoBancario = datoBancario;
	}

	/**
	 * @return the comentariosProovedor
	 */
	public List<ComentarioProveedorDO> getComentariosProovedor() {
		return comentariosProovedor;
	}

	/**
	 * @param comentariosProovedor the comentariosProovedor to set
	 */
	public void setComentariosProovedor(
			List<ComentarioProveedorDO> comentariosProovedor) {
		this.comentariosProovedor = comentariosProovedor;
	}

}
