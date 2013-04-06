package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author MHDolores
 *
 */
@Entity
@Table(name = "ComprobacionViaticos")
@NamedQueries({
	@NamedQuery(name = "ComprobacionViaticosDO.findAll", query = "select rc from ComprobacionViaticosDO rc")
	})
public class ComprobacionViaticoaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3928620481238448184L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_solicitud_viaticos", nullable = false)
	private SolicitudViaticosDO solicitudViaticos;
	
	@Column(name = "total_autorizado", nullable = false)
	private Double totalAutorizado;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_subida_documentos")
	private Date fechaSubidaDocumentos;
	
	@Column(name = "documento_formato", nullable = false)
	private String documentoFormato;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_comprobacion_viaticos", nullable = false)
	private EstadoComprobacionViaticosDO estadoComprobacionViaticos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SolicitudViaticosDO getSolicitudViaticos() {
		return solicitudViaticos;
	}

	public void setSolicitudViaticos(SolicitudViaticosDO solicitudViaticos) {
		this.solicitudViaticos = solicitudViaticos;
	}

	public Double getTotalAutorizado() {
		return totalAutorizado;
	}

	public void setTotalAutorizado(Double totalAutorizado) {
		this.totalAutorizado = totalAutorizado;
	}

	public Date getFechaSubidaDocumentos() {
		return fechaSubidaDocumentos;
	}

	public void setFechaSubidaDocumentos(Date fechaSubidaDocumentos) {
		this.fechaSubidaDocumentos = fechaSubidaDocumentos;
	}

	public String getDocumentoFormato() {
		return documentoFormato;
	}

	public void setDocumentoFormato(String documentoFormato) {
		this.documentoFormato = documentoFormato;
	}

	public EstadoComprobacionViaticosDO getEstadoComprobacionViaticos() {
		return estadoComprobacionViaticos;
	}

	public void setEstadoComprobacionViaticos(
			EstadoComprobacionViaticosDO estadoComprobacionViaticos) {
		this.estadoComprobacionViaticos = estadoComprobacionViaticos;
	}

	public ComprobacionViaticoaDO(Integer id,
			SolicitudViaticosDO solicitudViaticos, Double totalAutorizado,
			Date fechaSubidaDocumentos, String documentoFormato,
			EstadoComprobacionViaticosDO estadoComprobacionViaticos) {
		super();
		this.id = id;
		this.solicitudViaticos = solicitudViaticos;
		this.totalAutorizado = totalAutorizado;
		this.fechaSubidaDocumentos = fechaSubidaDocumentos;
		this.documentoFormato = documentoFormato;
		this.estadoComprobacionViaticos = estadoComprobacionViaticos;
	}

	public ComprobacionViaticoaDO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
