package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla entregable.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="entregable")
public class EntregableDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@JoinColumn(name="id_tipo_entregable")
	private TipoEntregableDO tipoEntregable;

	public EntregableDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public TipoEntregableDO getTipoEntregable() {
		return this.tipoEntregable;
	}

	public void setTipoEntregable(TipoEntregableDO tipoEntregable) {
		this.tipoEntregable = tipoEntregable;
	}

}