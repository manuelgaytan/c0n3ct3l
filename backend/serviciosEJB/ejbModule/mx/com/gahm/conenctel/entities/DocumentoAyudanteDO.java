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

@Entity
@Table(name = "DocumentoAyudante")
@NamedQueries({
	@NamedQuery(name = "DocumentoAyudanteDO.findAll", query = "select rc from DocumentoAyudanteDO rc")
	})
public class DocumentoAyudanteDO implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fk_ayudante", nullable = false)
	private AyudanteDO ayudante;

	@Column(name="documento")
	private String documento;

	public DocumentoAyudanteDO() {
		super();
	}

	public DocumentoAyudanteDO(int id,
			AyudanteDO ayudante, String documento) {
		super();
		this.id = id;
		this.ayudante = ayudante;
		this.documento = documento;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the ayudante
	 */
	public AyudanteDO getAyudante() {
		return ayudante;
	}

	/**
	 * @param ayudante the ayudante to set
	 */
	public void setAyudante(AyudanteDO ayudante) {
		this.ayudante = ayudante;
	}

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
}

