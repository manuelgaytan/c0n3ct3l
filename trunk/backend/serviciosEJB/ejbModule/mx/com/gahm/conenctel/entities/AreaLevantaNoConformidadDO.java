/**
 * 
 */
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
 * @author GUILLERMO
 *
 */
@Entity
@Table(name = "AreaLevantaNoConformidad")
@NamedQueries({
	@NamedQuery(name = "AreaLevantaNoConformidadDO.findAll", query = "select rc from AreaLevantaNoConformidadDO rc")
	})
public class AreaLevantaNoConformidadDO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1946337295827376159L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="area")
	private String area;

	public AreaLevantaNoConformidadDO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AreaLevantaNoConformidadDO(long id, String etiqueta) {
		super();
		this.id = id;
		this.area = etiqueta;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String etiqueta) {
		this.area = etiqueta;
	}
	
	
	
}
