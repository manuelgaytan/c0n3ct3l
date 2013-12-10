package mx.com.gahm.conenctel.entities;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "SolicitanteSolicitudViaticos")
@NamedQueries({
	@NamedQuery(name = "SolicitanteSolicitudViaticosDO.findAll", 
			query = "select oc from SolicitanteSolicitudViaticosDO oc") })
public class SolicitanteSolicitudViaticosDO implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5103801106130001615L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="fk_solicitud_viaticos")
	private SolicitudViaticosDO solicitudViaticos;
	
	@ManyToOne
	@JoinColumn(name="fk_colaborador")
	private ColaboradorDO colaborador;

	public SolicitanteSolicitudViaticosDO() {
	}

	public SolicitanteSolicitudViaticosDO(SolicitudViaticosDO solicitudViaticosDO, ColaboradorDO colaboradorDO) {
		this.solicitudViaticos = solicitudViaticosDO;
		this.colaborador = colaboradorDO;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SolicitudViaticosDO getSolicitudViaticos() {
		return solicitudViaticos;
	}

	public void setSolicitudViaticos(SolicitudViaticosDO solicitudViaticosDO) {
		this.solicitudViaticos = solicitudViaticosDO;
	}

	public ColaboradorDO getColaborador() {
		return colaborador;
	}

	public void setColaborador(ColaboradorDO colaboradorDO) {
		this.colaborador = colaboradorDO;
	}

}