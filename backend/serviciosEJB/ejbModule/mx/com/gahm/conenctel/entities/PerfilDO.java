package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * Clase de persistencia para la tabla perfil.
 * 
 * @author Carlos Leyva
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "PerfilDO.findAll", query = "select p from PerfilDO p") })
@Table(name="perfil")
public class PerfilDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final Integer ID_DIRECTOR_GENERAL = 1;
	public static final Integer ID_ADMINISTRADOR_CATALOGOS = 2;
	public static final Integer ID_ALMACEN = 3;
	public static final Integer ID_RECURSOS_HUMANOS = 4;
	public static final Integer ID_GERENTE_OPERATIVO = 5;
	public static final Integer ID_COORDINADOR_OPERATIVO = 6;
	public static final Integer ID_COMPRAS = 7;
	public static final Integer ID_PUBLICO = 8;
	public static final Integer ID_CUENTAS_POR_PAGAR = 9;
	public static final Integer ID_FACTURACION = 10;
	public static final Integer ID_CONTABILIDAD = 11;
	public static final Integer ID_TESORERIA = 12;
	//public static final Integer ID_RECURSOS_HUMANOS = 13;
	public static final Integer ID_SISTEMAS_GESTION = 14;
	public static final Integer ID_VALIDACION_ADMINISTRATIVA = 15;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="perfil")
	private String etiqueta;

	@OneToMany(mappedBy="perfil", fetch = FetchType.EAGER)
	private List<PerfilPantallaDO> perfilPantallas;

	public PerfilDO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public List<PerfilPantallaDO> getPerfilPantallas() {
		return perfilPantallas;
	}

	public void setPerfilPantallas(List<PerfilPantallaDO> perfilPantallas) {
		this.perfilPantallas = perfilPantallas;
	}

}