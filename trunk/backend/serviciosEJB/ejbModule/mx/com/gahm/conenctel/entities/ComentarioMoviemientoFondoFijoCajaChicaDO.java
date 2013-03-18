/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ComentarioMoviemientoFondoFijoCajaChicaDO.findAll", query = "select c from ComentarioMoviemientoFondoFijoCajaChicaDO c")
	})
@Table(name="ComentarioMoviemientoFondoFijoCajaChica")
public class ComentarioMoviemientoFondoFijoCajaChicaDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2154726828630190855L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_solicitud_viaticos", nullable = false)
	private MoviemientoFondoFijoCajaChicaDO moviemientoFondoFijoCajaChica;
	
	@ManyToOne
	@JoinColumn(name = "fk_comentario_contabilidad", nullable = false)
	private ComentarioContabilidadDO comentarioContabilidad;

	public ComentarioMoviemientoFondoFijoCajaChicaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioMoviemientoFondoFijoCajaChicaDO(long id,
			MoviemientoFondoFijoCajaChicaDO moviemientoFondoFijoCajaChica,
			ComentarioContabilidadDO comentarioContabilidad) {
		super();
		this.id = id;
		this.moviemientoFondoFijoCajaChica = moviemientoFondoFijoCajaChica;
		this.comentarioContabilidad = comentarioContabilidad;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the moviemientoFondoFijoCajaChica
	 */
	public MoviemientoFondoFijoCajaChicaDO getMoviemientoFondoFijoCajaChica() {
		return moviemientoFondoFijoCajaChica;
	}

	/**
	 * @param moviemientoFondoFijoCajaChica the moviemientoFondoFijoCajaChica to set
	 */
	public void setMoviemientoFondoFijoCajaChica(
			MoviemientoFondoFijoCajaChicaDO moviemientoFondoFijoCajaChica) {
		this.moviemientoFondoFijoCajaChica = moviemientoFondoFijoCajaChica;
	}

	/**
	 * @return the comentarioContabilidad
	 */
	public ComentarioContabilidadDO getComentarioContabilidad() {
		return comentarioContabilidad;
	}

	/**
	 * @param comentarioContabilidad the comentarioContabilidad to set
	 */
	public void setComentarioContabilidad(
			ComentarioContabilidadDO comentarioContabilidad) {
		this.comentarioContabilidad = comentarioContabilidad;
	}
	
	
	
	
}

