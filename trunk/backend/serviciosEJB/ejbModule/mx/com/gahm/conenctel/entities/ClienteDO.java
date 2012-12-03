package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla cliente.
 * 
 * @author Carlos Leyva
 */
@Cacheable(false)
@Entity
@NamedQueries({
	@NamedQuery(name = "ClienteDO.findAll", query = "select c from ClienteDO c"),
	@NamedQuery(name = "ClienteDO.findByName", query = "select c from ClienteDO c where c.nombreComercial = :nombre")})
@Table(name="cliente")
public class ClienteDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="domiciio_fiscal")
	private String domicilioFiscal;

	@Column(name="nombre_comercial")
	private String nombreComercial;

	@Column(name="razon_social")
	private String razonSocial;

	private String rfc;

	@JoinColumn(name = "id_contacto")
	private ContactoDO contacto;

	@JoinColumn(name = "id_datos")
	private DatosComercialesDO datosComerciales;

	public ClienteDO() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDomicilioFiscal() {
		return this.domicilioFiscal;
	}

	public void setDomicilioFiscal(String domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public ContactoDO getContacto() {
		return this.contacto;
	}

	public void setContacto(ContactoDO contacto) {
		this.contacto = contacto;
	}

	public DatosComercialesDO getDatosComerciales() {
		return this.datosComerciales;
	}

	public void setDatosComerciales(DatosComercialesDO datosComerciales) {
		this.datosComerciales = datosComerciales;
	}

}