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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "EquipoOficinaDomina")
@NamedQueries({
	@NamedQuery(name = "EquipoOficinaDominaDO.findAll", query = "select rc from EquipoOficinaDominaDO rc")
	})
public class EquipoOficinaDominaDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4003846544048748865L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "fk_datos_escolares_habilidades", nullable = false)
	private DatosEscolaresHabilidadesDO datosEscolaresHabilidades;
	
	@Column(name = "pc", nullable = false)
	private Boolean pc;
	
	@Column(name = "calculadora", nullable = false)
	private Boolean calculadora;
	
	@Column(name = "fax", nullable = false)
	private Boolean fax;
	
	@Column(name = "impresora", nullable = false)
	private Boolean impresora;
	
	@Column(name = "telefono", nullable = false)
	private Boolean telefono;
	
	@Column(name = "scanner", nullable = false)
	private Boolean scanner;
	
	@Column(name = "tablet", nullable = false)
	private Boolean tablet;
	
	@Column(name = "laptop", nullable = false)
	private Boolean laptop;
	
	@Column(name = "otros", nullable = false)
	private Boolean otros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DatosEscolaresHabilidadesDO getDatosEscolaresHabilidades() {
		return datosEscolaresHabilidades;
	}

	public void setDatosEscolaresHabilidades(
			DatosEscolaresHabilidadesDO datosEscolaresHabilidades) {
		this.datosEscolaresHabilidades = datosEscolaresHabilidades;
	}

	public Boolean getPc() {
		return pc;
	}

	public void setPc(Boolean pc) {
		this.pc = pc;
	}

	public Boolean getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(Boolean calculadora) {
		this.calculadora = calculadora;
	}

	public Boolean getFax() {
		return fax;
	}

	public void setFax(Boolean fax) {
		this.fax = fax;
	}

	public Boolean getImpresora() {
		return impresora;
	}

	public void setImpresora(Boolean impresora) {
		this.impresora = impresora;
	}

	public Boolean getTelefono() {
		return telefono;
	}

	public void setTelefono(Boolean telefono) {
		this.telefono = telefono;
	}

	public Boolean getScanner() {
		return scanner;
	}

	public void setScanner(Boolean scanner) {
		this.scanner = scanner;
	}

	public Boolean getTablet() {
		return tablet;
	}

	public void setTablet(Boolean tablet) {
		this.tablet = tablet;
	}

	public Boolean getLaptop() {
		return laptop;
	}

	public void setLaptop(Boolean laptop) {
		this.laptop = laptop;
	}

	public Boolean getOtros() {
		return otros;
	}

	public void setOtros(Boolean otros) {
		this.otros = otros;
	}
	
	
	
	
	
	
	
	
	
}
