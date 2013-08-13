/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "RegistroDeduccion")
@NamedQueries({
	@NamedQuery(name = "RegistroDeduccionDO.findAll", query = "select rc from RegistroDeduccionDO rc")
	})
public class RegistroDeduccionDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7058264545903018845L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_contratacion", nullable = false)
	private ContratacionDO contratacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_deduccion", nullable = false)
	private DeduccionDO deduccion;
	
	@Column(name = "retardos", nullable = false)
	private Integer retardos;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_retardo")
	private Date fechaRetardo;
	
	@Column(name = "faltas", nullable = false)
	private Integer faltas;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_falta")
	private Date fechaFalta;
	
	@ManyToOne
	@JoinColumn(name = "fk_clasificacion_falta", nullable = false)
	private ClasificacionFaltaDO clasificacionFalta;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_permiso")
	private Date fechaPermiso;
	
	@ManyToOne
	@JoinColumn(name = "fk_clasificacion_permiso", nullable = false)
	private ClasificacionPermisoDO clasificacionPermiso;
	
	@ManyToOne
	@JoinColumn(name = "fk_tipo_sancion", nullable = false)
	private TipoSancionDO tipoSancion;
	
	@ManyToOne
	@JoinColumn(name = "fk_forma_pago_prenomina", nullable = false)
	private FormaPagoPrenominaDO formaPagoPrenomina;
	
	@Column(name = "monto_total_descuento", nullable = false)
	private Double montoTotalDescuento;
	
	@Column(name = "descuento_parcial", nullable = false)
	private Double descuentoParcial;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_termino")
	private Date fechaTermino;

	public RegistroDeduccionDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegistroDeduccionDO(Integer id, ContratacionDO contratacion,
			DeduccionDO deduccion, Integer retardos, Date fechaRetardo,
			Integer faltas, Date fechaFalta,
			ClasificacionFaltaDO clasificacionFalta,
			ClasificacionPermisoDO clasificacionPermiso,
			TipoSancionDO tipoSancion, FormaPagoPrenominaDO formaPagoPrenomina,
			Double montoTotalDescuento, Double descuentoParcial,
			Date fechaInicio, Date fechaTermino) {
		super();
		this.id = id;
		this.contratacion = contratacion;
		this.deduccion = deduccion;
		this.retardos = retardos;
		this.fechaRetardo = fechaRetardo;
		this.faltas = faltas;
		this.fechaFalta = fechaFalta;
		this.clasificacionFalta = clasificacionFalta;
		this.clasificacionPermiso = clasificacionPermiso;
		this.tipoSancion = tipoSancion;
		this.formaPagoPrenomina = formaPagoPrenomina;
		this.montoTotalDescuento = montoTotalDescuento;
		this.descuentoParcial = descuentoParcial;
		this.fechaInicio = fechaInicio;
		this.fechaTermino = fechaTermino;
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
	 * @return the contratacion
	 */
	public ContratacionDO getContratacion() {
		return contratacion;
	}

	/**
	 * @param contratacion the contratacion to set
	 */
	public void setContratacion(ContratacionDO contratacion) {
		this.contratacion = contratacion;
	}

	/**
	 * @return the deduccion
	 */
	public DeduccionDO getDeduccion() {
		return deduccion;
	}

	/**
	 * @param deduccion the deduccion to set
	 */
	public void setDeduccion(DeduccionDO deduccion) {
		this.deduccion = deduccion;
	}

	/**
	 * @return the retardos
	 */
	public Integer getRetardos() {
		return retardos;
	}

	/**
	 * @param retardos the retardos to set
	 */
	public void setRetardos(Integer retardos) {
		this.retardos = retardos;
	}

	/**
	 * @return the fechaRetardo
	 */
	public Date getFechaRetardo() {
		return fechaRetardo;
	}

	/**
	 * @param fechaRetardo the fechaRetardo to set
	 */
	public void setFechaRetardo(Date fechaRetardo) {
		this.fechaRetardo = fechaRetardo;
	}

	/**
	 * @return the faltas
	 */
	public Integer getFaltas() {
		return faltas;
	}

	/**
	 * @param faltas the faltas to set
	 */
	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}

	/**
	 * @return the fechaFalta
	 */
	public Date getFechaFalta() {
		return fechaFalta;
	}

	/**
	 * @param fechaFalta the fechaFalta to set
	 */
	public void setFechaFalta(Date fechaFalta) {
		this.fechaFalta = fechaFalta;
	}

	/**
	 * @return the clasificacionFalta
	 */
	public ClasificacionFaltaDO getClasificacionFalta() {
		return clasificacionFalta;
	}

	/**
	 * @param clasificacionFalta the clasificacionFalta to set
	 */
	public void setClasificacionFalta(ClasificacionFaltaDO clasificacionFalta) {
		this.clasificacionFalta = clasificacionFalta;
	}

	/**
	 * @return the clasificacionPermiso
	 */
	public ClasificacionPermisoDO getClasificacionPermiso() {
		return clasificacionPermiso;
	}

	/**
	 * @param clasificacionPermiso the clasificacionPermiso to set
	 */
	public void setClasificacionPermiso(ClasificacionPermisoDO clasificacionPermiso) {
		this.clasificacionPermiso = clasificacionPermiso;
	}

	/**
	 * @return the tipoSancion
	 */
	public TipoSancionDO getTipoSancion() {
		return tipoSancion;
	}

	/**
	 * @param tipoSancion the tipoSancion to set
	 */
	public void setTipoSancion(TipoSancionDO tipoSancion) {
		this.tipoSancion = tipoSancion;
	}

	/**
	 * @return the formaPagoPrenomina
	 */
	public FormaPagoPrenominaDO getFormaPagoPrenomina() {
		return formaPagoPrenomina;
	}

	/**
	 * @param formaPagoPrenomina the formaPagoPrenomina to set
	 */
	public void setFormaPagoPrenomina(FormaPagoPrenominaDO formaPagoPrenomina) {
		this.formaPagoPrenomina = formaPagoPrenomina;
	}

	/**
	 * @return the montoTotalDescuento
	 */
	public Double getMontoTotalDescuento() {
		return montoTotalDescuento;
	}

	/**
	 * @param montoTotalDescuento the montoTotalDescuento to set
	 */
	public void setMontoTotalDescuento(Double montoTotalDescuento) {
		this.montoTotalDescuento = montoTotalDescuento;
	}

	/**
	 * @return the descuentoParcial
	 */
	public Double getDescuentoParcial() {
		return descuentoParcial;
	}

	/**
	 * @param descuentoParcial the descuentoParcial to set
	 */
	public void setDescuentoParcial(Double descuentoParcial) {
		this.descuentoParcial = descuentoParcial;
	}

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	public Date getFechaPermiso() {
		return fechaPermiso;
	}

	public void setFechaPermiso(Date fechaPermiso) {
		this.fechaPermiso = fechaPermiso;
	}
	
	
	
}
