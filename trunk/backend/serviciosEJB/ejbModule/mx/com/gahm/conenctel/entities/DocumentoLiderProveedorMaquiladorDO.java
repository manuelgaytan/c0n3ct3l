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
@Table(name = "DocumentoLiderProveedorMaquilador")
@NamedQueries({
	@NamedQuery(name = "DocumentoLiderProveedorMaquiladorDO.findAll", query = "select rc from DocumentoLiderProveedorMaquiladorDO rc")
	})
public class DocumentoLiderProveedorMaquiladorDO implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "fk_proveedor_maquilador", nullable = false)
	private ProveedorMaquiladorDO proveedorMaquilador;

	@Column(name="documento")
	private String documento;

	public DocumentoLiderProveedorMaquiladorDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocumentoLiderProveedorMaquiladorDO(int id,
			ProveedorMaquiladorDO proveedorMaquilador, String documento) {
		super();
		this.id = id;
		this.proveedorMaquilador = proveedorMaquilador;
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
	 * @return the proveedorMaquilador
	 */
	public ProveedorMaquiladorDO getProveedorMaquilador() {
		return proveedorMaquilador;
	}

	/**
	 * @param proveedorMaquilador the proveedorMaquilador to set
	 */
	public void setProveedorMaquilador(ProveedorMaquiladorDO proveedorMaquilador) {
		this.proveedorMaquilador = proveedorMaquilador;
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

