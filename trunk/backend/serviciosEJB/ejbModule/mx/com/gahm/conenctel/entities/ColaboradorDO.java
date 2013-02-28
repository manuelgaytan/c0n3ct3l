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
 * Clase de persistencia para la tabla colaborador.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "ColaboradorDO.findAll", query = "select c from ColaboradorDO c"),
	@NamedQuery(name = "ColaboradorDO.getColaboradorByTipo", query = "select c from ColaboradorDO c where c.tipoColaborador.id=:idTipoColaborado")})
@Table(name="colaborador")
public class ColaboradorDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="nombre_completo")
	private String nombreCompleto;

	@ManyToOne
	@JoinColumn(name="id_tipo_colaborador")
	private TipoColaboradorDO tipoColaborador;

	public ColaboradorDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public TipoColaboradorDO getTipoColaborador() {
		return this.tipoColaborador;
	}

	public void setTipoColaborador(TipoColaboradorDO tipoColaborador) {
		this.tipoColaborador = tipoColaborador;
	}

}