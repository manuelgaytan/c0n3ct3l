package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla nombresolicitante.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="nombresolicitante")
public class NombreSolicitanteDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	// TODO
	@Column(name="fk_colaborador")
	private Long fkColaborador;

	@ManyToOne
	@JoinColumn(name="fk_solicitud_almacen")
	private SolicitudAlmacenDO fkSolicitudAlmacen;

	public NombreSolicitanteDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getFkColaborador() {
		return this.fkColaborador;
	}

	public void setFkColaborador(Long fkColaborador) {
		this.fkColaborador = fkColaborador;
	}

	public SolicitudAlmacenDO getFkSolicitudAlmacen() {
		return fkSolicitudAlmacen;
	}

	public void setFkSolicitudAlmacen(SolicitudAlmacenDO fkSolicitudAlmacen) {
		this.fkSolicitudAlmacen = fkSolicitudAlmacen;
	}

}