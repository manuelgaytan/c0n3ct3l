package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * Clase de persistencia para la tabla ubicacionc.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "UbicacionCDO.findAll", query = "select u from UbicacionCDO u") })
@Table(name="ubicacionc")
public class UbicacionCDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="ubicacion")
	private String etiqueta;

//	@OneToMany(mappedBy="fkUbicacionC")
//	private List<ConsumibleDO> consumibles;

	public UbicacionCDO() {
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

//	public List<ConsumibleDO> getConsumibles() {
//		return this.consumibles;
//	}
//
//	public void setConsumibles(List<ConsumibleDO> consumibles) {
//		this.consumibles = consumibles;
//	}

}