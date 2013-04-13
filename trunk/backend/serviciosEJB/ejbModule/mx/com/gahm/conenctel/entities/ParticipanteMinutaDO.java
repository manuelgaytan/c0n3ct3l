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
import javax.persistence.Table;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "ParticipanteMinuta")
@NamedQueries({
	@NamedQuery(name = "ParticipanteMinutaDO.findAll", query = "select rc from ParticipanteMinutaDO rc")
	})
public class ParticipanteMinutaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6796934200684880381L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "fk_informacion_facturacion", nullable = false)
	private MinutaDO minuta;
	
	@ManyToOne
	@JoinColumn(name = "fk_colaborador", nullable = false)
	private ColaboradorDO colaborador;
	
	@Column(name = "participante", nullable = false)
	private String participante;
	
	@Column(name = "empresa", nullable = false)
	private String empresa;
	
	@Column(name = "puesto", nullable = false)
	private String puesto;

	public ParticipanteMinutaDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParticipanteMinutaDO(Integer id, MinutaDO minuta,
			ColaboradorDO colaborador, String participante, String empresa,
			String puesto) {
		super();
		this.id = id;
		this.minuta = minuta;
		this.colaborador = colaborador;
		this.participante = participante;
		this.empresa = empresa;
		this.puesto = puesto;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the minuta
	 */
	public MinutaDO getMinuta() {
		return minuta;
	}

	/**
	 * @param minuta the minuta to set
	 */
	public void setMinuta(MinutaDO minuta) {
		this.minuta = minuta;
	}

	/**
	 * @return the colaborador
	 */
	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	/**
	 * @param colaborador the colaborador to set
	 */
	public void setColaborador(ColaboradorDO colaborador) {
		this.colaborador = colaborador;
	}

	/**
	 * @return the participante
	 */
	public String getParticipante() {
		return participante;
	}

	/**
	 * @param participante the participante to set
	 */
	public void setParticipante(String participante) {
		this.participante = participante;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the puesto
	 */
	public String getPuesto() {
		return puesto;
	}

	/**
	 * @param puesto the puesto to set
	 */
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
	
	
}
