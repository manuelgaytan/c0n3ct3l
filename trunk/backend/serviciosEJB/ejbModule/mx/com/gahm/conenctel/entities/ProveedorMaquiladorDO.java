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
@Cacheable(false)
@Entity
@PrimaryKeyJoinColumn(name="fk_proveedor")
@DiscriminatorValue("2")
@NamedQueries({
	@NamedQuery(name = "ProveedorMaquiladorDO.findAll", query = "select p from ProveedorMaquiladorDO p "),
	@NamedQuery(name = "ClienteDO.findByName", query = "select c from ClienteDO c where c.nombreComercial = :nombre") })
@Table(name="proveedormaquilador")
public class ProveedorMaquiladorDO extends ProveedorDO implements Serializable{
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int id;

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
	private TipoPagoDO pago;

//	@JoinColumn(name="fk_proveedor")
//	private int fkProveedor;

	@JoinColumn(name="fk_tipo_contrato")
	private TipoContratoDO tipoContrato;

	@Column(name="nss")
	private String nss;
	
	
	@OneToMany(mappedBy="proveedorMaquilador", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<DocumentoLiderProveedorMaquiladorDO> documentosLiderProveedorMaquilador;

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
	public TipoPagoDO getPago() {
		return pago;
	}

	/**
	 * @param pago the pago to set
	 */
	public void setPago(TipoPagoDO pago) {
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

}