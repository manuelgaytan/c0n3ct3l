package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MoviemientoFondoFijoCajaChica")
@NamedQueries({
	@NamedQuery(name = "MoviemientoFondoFijoCajaChicaDO.findAll", query = "select rc from MoviemientoFondoFijoCajaChicaDO rc")
	})
public class MoviemientoFondoFijoCajaChicaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4229816533018801328L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 10)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "fk_descripcion_fondo_fijo_caja_chica", nullable = false)
	private DescripcionFondoFijoCajaChicaDO descripcionFondoFijoCajaChica;
	
	@Column(name = "entrega", nullable = false)
	private String entrega;
	
	@ManyToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private ColaboradorDO colaborador;
	
	@Column(name = "ingreso", nullable = false)
	private Double ingreso;
	
	@Column(name = "egreso", nullable = false)
	private Double egreso;

	public MoviemientoFondoFijoCajaChicaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MoviemientoFondoFijoCajaChicaDO(Integer id, Date fecha,
			DescripcionFondoFijoCajaChicaDO descripcionFondoFijoCajaChica,
			String entrega, ColaboradorDO colaborador, Double ingreso,
			Double egreso) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.descripcionFondoFijoCajaChica = descripcionFondoFijoCajaChica;
		this.entrega = entrega;
		this.colaborador = colaborador;
		this.ingreso = ingreso;
		this.egreso = egreso;
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
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the descripcionFondoFijoCajaChica
	 */
	public DescripcionFondoFijoCajaChicaDO getDescripcionFondoFijoCajaChica() {
		return descripcionFondoFijoCajaChica;
	}

	/**
	 * @param descripcionFondoFijoCajaChica the descripcionFondoFijoCajaChica to set
	 */
	public void setDescripcionFondoFijoCajaChica(
			DescripcionFondoFijoCajaChicaDO descripcionFondoFijoCajaChica) {
		this.descripcionFondoFijoCajaChica = descripcionFondoFijoCajaChica;
	}

	/**
	 * @return the entrega
	 */
	public String getEntrega() {
		return entrega;
	}

	/**
	 * @param entrega the entrega to set
	 */
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	/**
	 * @return the colaborador
	 */
	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	/**
	 * @param colaborador the colaborador to set
	 */
	public void setColaborador(ColaboradorDO colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * @return the ingreso
	 */
	public Double getIngreso() {
		return ingreso;
	}

	/**
	 * @param ingreso the ingreso to set
	 */
	public void setIngreso(Double ingreso) {
		this.ingreso = ingreso;
	}

	/**
	 * @return the egreso
	 */
	public Double getEgreso() {
		return egreso;
	}

	/**
	 * @param egreso the egreso to set
	 */
	public void setEgreso(Double egreso) {
		this.egreso = egreso;
	}
	
}
