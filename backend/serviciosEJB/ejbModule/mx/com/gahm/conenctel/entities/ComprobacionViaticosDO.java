package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ComprobacionViaticos")
@NamedQueries({
	@NamedQuery(name = "ComprobacionViaticosDO.findAll", query = "select rc from ComprobacionViaticosDO rc")
	})
public class ComprobacionViaticosDO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7291500181126516006L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "fk_solicitud_viaticos", nullable = false)
	private SolicitudViaticosDO solicitudViaticos;
	
	@Column(name = "total_autorizado", nullable = false)
	private Double totalAutorizado;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_subida_documentos", nullable = false, length = 10)
	private Date fechaSubidaDocumentos;

	@Column(name = "documento_formato", nullable = false)
	private String documentoFormato;
	
	@ManyToOne
	@JoinColumn(name = "fk_estado_comprobacion_viaticos", nullable = false)
	private EstadoComprobacionViaticosDO estadoComprobacionViaticos;
	
	@OneToMany(mappedBy="comprobacionViatico", fetch = FetchType.EAGER)
    private List<DocumentoComprobacionViaticosDO> documentosComprobacionViaticos;


	public ComprobacionViaticosDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComprobacionViaticosDO(long id,
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
	 * @return the solicitudViaticos
	 */
	public SolicitudViaticosDO getSolicitudViaticos() {
		return solicitudViaticos;
	}

	/**
	 * @param solicitudViaticos the solicitudViaticos to set
	 */
	public void setSolicitudViaticos(SolicitudViaticosDO solicitudViaticos) {
		this.solicitudViaticos = solicitudViaticos;
	}

	/**
	 * @return the totalAutorizado
	 */
	public Double getTotalAutorizado() {
		return totalAutorizado;
	}

	/**
	 * @param totalAutorizado the totalAutorizado to set
	 */
	public void setTotalAutorizado(Double totalAutorizado) {
		this.totalAutorizado = totalAutorizado;
	}

	/**
	 * @return the fechaSubidaDocumentos
	 */
	public Date getFechaSubidaDocumentos() {
		return fechaSubidaDocumentos;
	}

	/**
	 * @param fechaSubidaDocumentos the fechaSubidaDocumentos to set
	 */
	public void setFechaSubidaDocumentos(Date fechaSubidaDocumentos) {
		this.fechaSubidaDocumentos = fechaSubidaDocumentos;
	}

	/**
	 * @return the documentoFormato
	 */
	public String getDocumentoFormato() {
		return documentoFormato;
	}

	/**
	 * @param documentoFormato the documentoFormato to set
	 */
	public void setDocumentoFormato(String documentoFormato) {
		this.documentoFormato = documentoFormato;
	}

	/**
	 * @return the estadoComprobacionViaticos
	 */
	public EstadoComprobacionViaticosDO getEstadoComprobacionViaticos() {
		return estadoComprobacionViaticos;
	}

	/**
	 * @param estadoComprobacionViaticos the estadoComprobacionViaticos to set
	 */
	public void setEstadoComprobacionViaticos(
			EstadoComprobacionViaticosDO estadoComprobacionViaticos) {
		this.estadoComprobacionViaticos = estadoComprobacionViaticos;
	}

	public List<DocumentoComprobacionViaticosDO> getDocumentosComprobacionViaticos() {
		return documentosComprobacionViaticos;
	}

	public void setDocumentosComprobacionViaticos(
			List<DocumentoComprobacionViaticosDO> documentosComprobacionViaticos) {
		this.documentosComprobacionViaticos = documentosComprobacionViaticos;
	}
	
	
	
	
}
