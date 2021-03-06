package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 *  @author lespinosa
 * The persistent class for the proveedormaquilador database table.
 * 
 */

@Entity
@NamedQueries({
	@NamedQuery(name = "ProveedorMaquiladorDO.findAll", query = "select p from ProveedorMaquiladorDO p") })
@Table(name="proveedormaquilador")
public class ProveedorMaquiladorDO  implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name="curp")
	private String curp;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_contrato")
	private Date fechaContrato;

	@JoinColumn(name="fk_categoria_proyecto")
	private  CategoriaDO categoriaProyecto;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_dato_bancario")
	private DatoBancarioDO datoBancario;

	@JoinColumn(name="fk_pago")
	private PagoDO pago;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "fk_proveedor", nullable = false)
	private ProveedorDO proveedor;

	@JoinColumn(name="fk_tipo_contrato")
	private TipoContratoDO tipoContrato;
	
	@Column(name="vigencia_contrato")
	private String vigenciaContrato;
	
	@Column(name="nss")
	private String nss;
	
	@OneToMany(mappedBy="proveedorMaquilador", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<DocumentoLiderProveedorMaquiladorDO> documentosLiderProveedorMaquilador;
	
	@OneToMany(mappedBy="proveedorMaquilador", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<AyudanteDO> ayudantes;

	public ProveedorMaquiladorDO() {
	}


	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Date getFechaContrato() {
		return this.fechaContrato;
	}

	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}


	public String getNss() {
		return this.nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	/**
	 * @return the categoriaProyecto
	 */
	public CategoriaDO getCategoriaProyecto() {
		return categoriaProyecto;
	}

	/**
	 * @param categoriaProyecto the categoriaProyecto to set
	 */
	public void setCategoriaProyecto(CategoriaDO categoriaProyecto) {
		this.categoriaProyecto = categoriaProyecto;
	}

	/**
	 * @return the datoBancario
	 */
	public DatoBancarioDO getDatoBancario() {
		return datoBancario;
	}

	/**
	 * @param datoBancario the datoBancario to set
	 */
	public void setDatoBancario(DatoBancarioDO datoBancario) {
		this.datoBancario = datoBancario;
	}

	/**
	 * @return the pago
	 */
	public PagoDO getPago() {
		return pago;
	}

	/**
	 * @param pago the pago to set
	 */
	public void setPago(PagoDO pago) {
		this.pago = pago;
	}

	/**
	 * @return the tipoContrato
	 */
	public TipoContratoDO getTipoContrato() {
		return tipoContrato;
	}

	/**
	 * @param tipoContrato the tipoContrato to set
	 */
	public void setTipoContrato(TipoContratoDO tipoContrato) {
		this.tipoContrato = tipoContrato;
	}


	/**
	 * @return the documentosLiderProveedorMaquilador
	 */
	public List<DocumentoLiderProveedorMaquiladorDO> getDocumentosLiderProveedorMaquilador() {
		return documentosLiderProveedorMaquilador;
	}


	/**
	 * @param documentosLiderProveedorMaquilador the documentosLiderProveedorMaquilador to set
	 */
	public void setDocumentosLiderProveedorMaquilador(
			List<DocumentoLiderProveedorMaquiladorDO> documentosLiderProveedorMaquilador) {
		this.documentosLiderProveedorMaquilador = documentosLiderProveedorMaquilador;
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
	 * @return the proveedor
	 */
	public ProveedorDO getProveedor() {
		return proveedor;
	}


	/**
	 * @param proveedor the proveedor to set
	 */
	public void setProveedor(ProveedorDO proveedor) {
		this.proveedor = proveedor;
	}


	public String getVigenciaContrato() {
		return vigenciaContrato;
	}


	public void setVigenciaContrato(String vigenciaContrato) {
		this.vigenciaContrato = vigenciaContrato;
	}


	public List<AyudanteDO> getAyudantes() {
		return ayudantes;
	}


	public void setAyudantes(List<AyudanteDO> ayudantes) {
		this.ayudantes = ayudantes;
	}
}