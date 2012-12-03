package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla datosgeneralesproyectoimplementacion.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="datosgeneralesproyectoimplementacion")
public class DatosGrlsProyectoImplDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@ManyToOne
	@JoinColumn(name="id_datos_generales")
	private DatosGrlsProyectoDO datosgeneralesproyecto;

	@JoinColumn(name="id_colaborador")
	private ColaboradorDO colaborador;

	public DatosGrlsProyectoImplDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DatosGrlsProyectoDO getDatosgeneralesproyecto() {
		return this.datosgeneralesproyecto;
	}

	public void setDatosgeneralesproyecto(DatosGrlsProyectoDO datosgeneralesproyecto) {
		this.datosgeneralesproyecto = datosgeneralesproyecto;
	}

	public ColaboradorDO getColaborador() {
		return this.colaborador;
	}

	public void setColaborador(ColaboradorDO colaborador) {
		this.colaborador = colaborador;
	}

}