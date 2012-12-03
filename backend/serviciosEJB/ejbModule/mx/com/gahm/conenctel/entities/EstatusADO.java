package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla estatusa.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EstatusADO.findAll", query = "select e from EstatusADO e") })
@Table(name="estatusa")
public class EstatusADO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="estatus")
	private String etiqueta;

//	@OneToMany(mappedBy="estatusa")
//	private List<EquipoMedicionDO> equipomedicions;
//
//	@OneToMany(mappedBy="fkEstatusA")
//	private List<HerramientaDO> herramientas;

	public EstatusADO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

//	public List<EquipoMedicionDO> getEquipomedicions() {
//		return this.equipomedicions;
//	}
//
//	public void setEquipomedicions(List<EquipoMedicionDO> equipomedicions) {
//		this.equipomedicions = equipomedicions;
//	}
//
//	public List<HerramientaDO> getHerramientas() {
//		return this.herramientas;
//	}
//
//	public void setHerramientas(List<HerramientaDO> herramientas) {
//		this.herramientas = herramientas;
//	}

}