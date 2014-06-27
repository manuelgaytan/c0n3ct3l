/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Manuel Gayt&aacute;n
 *
 */
@Entity
@Table(name = "Ayudante")
@NamedQueries({
	@NamedQuery(name = "AyudanteDO.findAll", query = "select rc from AyudanteDO rc")
	})
public class AyudanteDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -26929716848830694L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "rfc", nullable = true)
	private String rfc;
	
	@Column(name = "curp", nullable = true)
	private String curp;
	
	@Column(name = "nss", nullable = true)
	private String nss;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_maquilador", nullable = false)
	private ProveedorMaquiladorDO proveedorMaquilador;

	@OneToMany(mappedBy="ayudante", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	private List<DocumentoAyudanteDO> documentosAyudante;
	
	public AyudanteDO() {
		super();
	}

	public AyudanteDO(Integer id,
						String nombre, 
						String rfc,
						String curp,
						String nss, 
						ProveedorMaquiladorDO proveedorMaquilador) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rfc = rfc;
		this.curp = curp;
		this.nss = nss;
		this.proveedorMaquilador = proveedorMaquilador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}

	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return proveedorMaquilador;
	}

	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
	}

	public List<DocumentoAyudanteDO> getDocumentosAyudante() {
		return documentosAyudante;
	}

	public void setDocumentosAyudante(List<DocumentoAyudanteDO> documentosAyudante) {
		this.documentosAyudante = documentosAyudante;
	}
}