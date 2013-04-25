package mx.com.gahm.conenctel.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * Clase de persistencia para la tabla documentoalmacen.
 * 
 * @author Carlos Leyva
 */
@Entity
@Table(name="documentoalmacen")
@NamedQueries({
	@NamedQuery(name = "DocumentoAlmacenDO.findAll", query = "select c from DocumentoAlmacenDO c where c.almacen=:almacen"),
	@NamedQuery(name = "DocumentoAlmacenDO.getDocumentosByTipo", query = "select c from DocumentoAlmacenDO c where c.almacen=:almacen and c.fkTipoEntregable.id=:tipoDocumento and c.fkTipoAlmacen.id =:tipoAlmacen") 
})
public class DocumentoAlmacenDO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	// TODO
	@Column(name="almacen")
	private Long almacen;

	@Column(name="nombre_archivo")
	private String nombreArchivo;

	@ManyToOne
	@JoinColumn(name="fk_tipo_entregable")
	private TipoDocumentoAlmacenDO fkTipoEntregable;

	@ManyToOne
	@JoinColumn(name="fk_tipo_almacen")
	private TipoAlmacenDO fkTipoAlmacen;

	public DocumentoAlmacenDO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreArchivo() {
		return this.nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public TipoDocumentoAlmacenDO getFkTipoEntregable() {
		return fkTipoEntregable;
	}

	public void setFkTipoEntregable(TipoDocumentoAlmacenDO fkTipoEntregable) {
		this.fkTipoEntregable = fkTipoEntregable;
	}

	public TipoAlmacenDO getFkTipoAlmacen() {
		return fkTipoAlmacen;
	}

	public void setFkTipoAlmacen(TipoAlmacenDO fkTipoAlmacen) {
		this.fkTipoAlmacen = fkTipoAlmacen;
	}

	public Long getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Long almacen) {
		this.almacen = almacen;
	}

}