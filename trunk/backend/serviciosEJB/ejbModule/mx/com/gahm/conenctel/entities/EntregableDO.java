package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@Column(name="id_tipo_entregable")
	private int idTipoEntregable;

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

	public int getIdTipoEntregable() {
		return idTipoEntregable;
	}

	public void setIdTipoEntregable(int idTipoEntregable) {
		this.idTipoEntregable = idTipoEntregable;
	}

}