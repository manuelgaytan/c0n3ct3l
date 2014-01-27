package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "EstadisticaPersonal")
@NamedQueries({
	@NamedQuery(name = "EstadisticaPersonalDO.findAll", query = "select rc from EstadisticaPersonalDO rc")
	})
public class EstadisticaPersonalDO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_trimestre", nullable = false)
	private TrimestreDO trimestre;
	
	@ManyToOne
	@JoinColumn(name = "fk_ano", nullable = false)
	private AnoDO ano;
	
	@ManyToOne
	@JoinColumn(name = "fk_rango_estadistica_personal_ausencia", nullable = false)
	private RangoEstadisticaPersonalDO rangoEstadisticaPersonalAusencia;
	
	@ManyToOne
	@JoinColumn(name = "fk_rango_estadistica_personal_puntualidad", nullable = false)
	private RangoEstadisticaPersonalDO rangoEstadisticaPersonalPuntualidad;
	
	@ManyToOne
	@JoinColumn(name = "fk_rango_estadistica_personal_rotacion", nullable = false)
	private RangoEstadisticaPersonalDO rangoEstadisticaPersonalRotacion;
	
	@ManyToOne
	@JoinColumn(name = "fk_rango_estadistica_personal_retardo", nullable = false)
	private RangoEstadisticaPersonalDO rangoEstadisticaPersonalRetardo;
	
	public EstadisticaPersonalDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EstadisticaPersonalDO(Integer id, 
			TrimestreDO trimestre,
			AnoDO ano,
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalAusencia,
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalPuntualidad,
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalRotacion,
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalRetardo) {
		super();
		this.id = id;
		this.trimestre = trimestre;
		this.ano = ano;
		this.rangoEstadisticaPersonalAusencia = rangoEstadisticaPersonalAusencia;
		this.rangoEstadisticaPersonalPuntualidad = rangoEstadisticaPersonalPuntualidad;
		this.rangoEstadisticaPersonalRotacion = rangoEstadisticaPersonalRotacion;
		this.rangoEstadisticaPersonalRetardo = rangoEstadisticaPersonalRetardo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public TrimestreDO getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(TrimestreDO trimestre) {
		this.trimestre = trimestre;
	}

	public AnoDO getAno() {
		return ano;
	}

	public void setAno(AnoDO ano) {
		this.ano = ano;
	}

	public RangoEstadisticaPersonalDO getRangoEstadisticaPersonalAusencia() {
		return rangoEstadisticaPersonalAusencia;
	}

	public void setRangoEstadisticaPersonalAusencia(
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalAusencia) {
		this.rangoEstadisticaPersonalAusencia = rangoEstadisticaPersonalAusencia;
	}

	public RangoEstadisticaPersonalDO getRangoEstadisticaPersonalPuntualidad() {
		return rangoEstadisticaPersonalPuntualidad;
	}

	public void setRangoEstadisticaPersonalPuntualidad(
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalPuntualidad) {
		this.rangoEstadisticaPersonalPuntualidad = rangoEstadisticaPersonalPuntualidad;
	}

	public RangoEstadisticaPersonalDO getRangoEstadisticaPersonalRotacion() {
		return rangoEstadisticaPersonalRotacion;
	}

	public void setRangoEstadisticaPersonalRotacion(
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalRotacion) {
		this.rangoEstadisticaPersonalRotacion = rangoEstadisticaPersonalRotacion;
	}

	public RangoEstadisticaPersonalDO getRangoEstadisticaPersonalRetardo() {
		return rangoEstadisticaPersonalRetardo;
	}

	public void setRangoEstadisticaPersonalRetardo(
			RangoEstadisticaPersonalDO rangoEstadisticaPersonalRetardo) {
		this.rangoEstadisticaPersonalRetardo = rangoEstadisticaPersonalRetardo;
	}
}
