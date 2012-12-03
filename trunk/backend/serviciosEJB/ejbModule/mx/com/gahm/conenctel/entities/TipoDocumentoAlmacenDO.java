package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * Clase de persistencia para la tabla tipodocumentoalmacen.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="tipodocumentoalmacen")
public class TipoDocumentoAlmacenDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String tipo;

//	@OneToMany(mappedBy="fkTipoEntregable")
//	private List<DocumentoAlmacenDO> documentoalmacens;

	public TipoDocumentoAlmacenDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

//	public List<DocumentoAlmacenDO> getDocumentoalmacens() {
//		return this.documentoalmacens;
//	}
//
//	public void setDocumentoalmacens(List<DocumentoAlmacenDO> documentoalmacens) {
//		this.documentoalmacens = documentoalmacens;
//	}

}