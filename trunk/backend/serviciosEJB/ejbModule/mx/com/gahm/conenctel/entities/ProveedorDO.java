/**
 * 
 */
package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author lespinosa
 * Clase de persistencia para la proveedor.
 */
@Cacheable(false)
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "proveedor")
public class ProveedorDO implements Serializable {
	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		
		@JoinColumn(name="fk_tipo_persona")
		private String tipoPersona;
		
		@Column(name="nombre_comercial")
		private String nombreComercial;
		
		@Column(name="razon_social")
		private String razonSocial;
		
		@Column(name="rfc")
		private String rfc;
		
		@Column(name="direccion_fisica")
		private String direccionFisica;
		
		
		@Column(name="direccion_fiscal")
		private String direccionFiscal;
		

		@Column(name="telefonos")
		private String telefonos;
		

		@Column(name="contacto")
		private String contacto;
		

		@Column(name="correo")
		private String correo;
		

		@Column(name="pagina_web")
		private String paginaWeb;


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getTipoPersona() {
			return tipoPersona;
		}


		public void setTipoPersona(String tipoPersona) {
			this.tipoPersona = tipoPersona;
		}


		public String getNombreComercial() {
			return nombreComercial;
		}


		public void setNombreComercial(String nombreComercial) {
			this.nombreComercial = nombreComercial;
		}


		public String getRazonSocial() {
			return razonSocial;
		}


		public void setRazonSocial(String razonSocial) {
			this.razonSocial = razonSocial;
		}


		public String getRfc() {
			return rfc;
		}


		public void setRfc(String rfc) {
			this.rfc = rfc;
		}


		public String getDireccionFisica() {
			return direccionFisica;
		}


		public void setDireccionFisica(String direccionFisica) {
			this.direccionFisica = direccionFisica;
		}


		public String getDireccionFiscal() {
			return direccionFiscal;
		}


		public void setDireccionFiscal(String direccionFiscal) {
			this.direccionFiscal = direccionFiscal;
		}


		public String getTelefonos() {
			return telefonos;
		}


		public void setTelefonos(String telefonos) {
			this.telefonos = telefonos;
		}


		public String getContacto() {
			return contacto;
		}


		public void setContacto(String contacto) {
			this.contacto = contacto;
		}


		public String getCorreo() {
			return correo;
		}


		public void setCorreo(String correo) {
			this.correo = correo;
		}


		public String getPaginaWeb() {
			return paginaWeb;
		}


		public void setPaginaWeb(String paginaWeb) {
			this.paginaWeb = paginaWeb;
		}
		

		

}
