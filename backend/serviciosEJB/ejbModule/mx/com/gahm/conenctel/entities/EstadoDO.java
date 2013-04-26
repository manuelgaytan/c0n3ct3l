package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla estadoproyecto.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="estadoproyecto")
public class EstadoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final long ID_ALTA = 1L;
	public static final long ID_DATOS_GENERALES = 2;
	public static final long ID_DESARROLLO_PROYECTO_AB = 3;
	public static final long ID_CONFIGURACION_PRUEBA_ENTREGA = 4;
	public static final long ID_CERRADO = 5;
	public static final long ID_CANCELADO = 6;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="estado")
	private String etiqueta;

	
	public EstadoDO() {
	}

	public EstadoDO(long id) {
		this.id = id;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

}