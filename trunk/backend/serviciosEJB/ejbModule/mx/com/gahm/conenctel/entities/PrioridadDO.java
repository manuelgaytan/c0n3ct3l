package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla prioridad.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "PrioridadDO.findAll", query = "select p from PrioridadDO p") })
@Table(name="prioridad")
public class PrioridadDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="prioridad")
	private String etiqueta;

//	@OneToMany(mappedBy="fkPrioridad")
//	private List<SolicitudAlmacenDO> solicitudalmacens;

	public PrioridadDO() {
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

//	public List<SolicitudAlmacenDO> getSolicitudalmacens() {
//		return this.solicitudalmacens;
//	}
//
//	public void setSolicitudalmacens(List<SolicitudAlmacenDO> solicitudalmacens) {
//		this.solicitudalmacens = solicitudalmacens;
//	}

}