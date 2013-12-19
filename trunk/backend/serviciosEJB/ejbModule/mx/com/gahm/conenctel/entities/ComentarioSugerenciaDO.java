/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Guillermo
 *
 */
@Entity
@Table(name = "ComentarioSugerencia")
@NamedQueries({
	@NamedQuery(name = "ComentarioSugerenciaDO.findAll", 
			query = "select rc from ComentarioSugerenciaDO rc")
	})
public class ComentarioSugerenciaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4082846414729825324L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_sugerencia", nullable = false)
	private SugerenciaDO sugerencia;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_sistemas_gestion", nullable = false)
	private ComentarioSistemasGestionDO comentarioSistemasGestion;

	public ComentarioSugerenciaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioSugerenciaDO(Integer id, SugerenciaDO sugerencia,
			ComentarioSistemasGestionDO comentarioSistemasGestion) {
		super();
		this.id = id;
		this.sugerencia = sugerencia;
		this.comentarioSistemasGestion = comentarioSistemasGestion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SugerenciaDO getSugerencia() {
		return sugerencia;
	}

	public void setSugerencia(SugerenciaDO sugerencia) {
		this.sugerencia = sugerencia;
	}

	public ComentarioSistemasGestionDO getComentarioSistemasGestion() {
		return comentarioSistemasGestion;
	}

	public void setComentarioSistemasGestion(
			ComentarioSistemasGestionDO comentarioSistemasGestion) {
		this.comentarioSistemasGestion = comentarioSistemasGestion;
	}
	
}
