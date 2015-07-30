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
 * Clase de persistencia para la tabla EstatusConcentradoCapacitacion.
 * 
 * @author Manuel Gayt&aacute;n
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "EstatusConcentradoCapacitacionDO.findAll", query = "select e from EstatusConcentradoCapacitacionDO e") })
@Table(name="EstatusConcentradoCapacitacion")
public class EstatusConcentradoCapacitacionDO implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final Long ID_PENDIENTE = 1l;
	public static final Long ID_NO_APLICA = 2l;
	public static final Long ID_EN_PROCESO = 3l;
	public static final Long ID_APROBADO = 4l;
	public static final Long ID_NO_APROBADO = 5l;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="estatus")
	private String estatus;

	public EstatusConcentradoCapacitacionDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
}