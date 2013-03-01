package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "ComentarioPantallaValidacionAdministrativaDO.findAll", query = "select c from ComentarioPantallaValidacionAdministrativaDO c") })
@Table(name="ComentarioPantallaValidacionAdministrativa")
public class ComentarioPantallaValidacionAdministrativaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5327288389129482981L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_validacion_administrativa")
	private ValidacionAdministrativaDO validacionAdministrativa;
	
	@ManyToOne
	@JoinColumn(name="fk_validacion_administrativa")
	private ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa;

	public ComentarioPantallaValidacionAdministrativaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioPantallaValidacionAdministrativaDO(
			Long id,
			ValidacionAdministrativaDO validacionAdministrativa,
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa) {
		super();
		this.id = id;
		this.validacionAdministrativa = validacionAdministrativa;
		this.comentarioValidacionAdministrativa = comentarioValidacionAdministrativa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ValidacionAdministrativaDO getValidacionAdministrativa() {
		return validacionAdministrativa;
	}

	public void setValidacionAdministrativa(
			ValidacionAdministrativaDO validacionAdministrativa) {
		this.validacionAdministrativa = validacionAdministrativa;
	}

	public ComentarioValidacionAdministrativaDO getComentarioValidacionAdministrativa() {
		return comentarioValidacionAdministrativa;
	}

	public void setComentarioValidacionAdministrativa(
			ComentarioValidacionAdministrativaDO comentarioValidacionAdministrativa) {
		this.comentarioValidacionAdministrativa = comentarioValidacionAdministrativa;
	}
	
	
	
	
	
	
}
