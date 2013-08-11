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

@Entity
@Table(name = "ComentarioCobranza")
@NamedQueries({
	@NamedQuery(name = "ComentarioCobranzaDO.findAll", query = "select rc from ComentarioCobranzaDO rc")
	})
public class ComentarioCobranzaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -410900957912172626L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_cobranza", nullable = false)
	private CobranzaDO cobranza;
	
	@OneToOne
	@JoinColumn(name = "fk_comentario_tesoreria")
	private ComentarioTesoreriaDO comentarioTesoreria;

	public ComentarioCobranzaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComentarioCobranzaDO(Integer id, CobranzaDO cobranza,
			ComentarioTesoreriaDO comentarioTesoreria) {
		super();
		this.id = id;
		this.cobranza = cobranza;
		this.comentarioTesoreria = comentarioTesoreria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CobranzaDO getCobranza() {
		return cobranza;
	}

	public void setCobranza(CobranzaDO cobranza) {
		this.cobranza = cobranza;
	}

	public ComentarioTesoreriaDO getComentarioTesoreria() {
		return comentarioTesoreria;
	}

	public void setComentarioTesoreria(ComentarioTesoreriaDO comentarioTesoreria) {
		this.comentarioTesoreria = comentarioTesoreria;
	} 

	
	
	
}
