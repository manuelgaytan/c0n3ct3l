package mx.com.gahm.conenctel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla grupofamiliaf.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "GrupoFamiliaFDO.findAll", query = "select g from GrupoFamiliaFDO g") })
@Table(name="grupofamiliaf")
public class GrupoFamiliaFDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="grupo_familia")
	private String etiqueta;

//	@OneToMany(mappedBy="fkGrupoFamiliaF")
//	private List<TelefoniaMovilDO> telefoniamovils;

	public GrupoFamiliaFDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

//	public List<TelefoniaMovilDO> getTelefoniamovils() {
//		return this.telefoniamovils;
//	}
//
//	public void setTelefoniamovils(List<TelefoniaMovilDO> telefoniamovils) {
//		this.telefoniamovils = telefoniamovils;
//	}

}