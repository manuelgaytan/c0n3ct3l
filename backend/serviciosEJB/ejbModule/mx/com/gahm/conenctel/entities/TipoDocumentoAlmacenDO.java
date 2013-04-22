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

	public static final long ID_POLIZA_GARANTIA = 1L;
	public static final String POLIZA_GARANTIA = "Poliza de Garant’a";
	public static final long ID_POLIZA_SEGURO = 2L;
	public static final String POLIZA_SEGURO = "Poliza de Seguro";
	public static final long ID_CERTIFICADO_CALIBRACION = 3L;
	public static final String CERTIFICADO_CALIBRACION = "Certificado de Calibraci—n";
	public static final long ID_ORDEN_MANTENIMIENTO_SERVICIO = 4L;
	public static final String ORDEN_MANTENIMIENTO_SERVICIO = "Orden de Mantenimiento o Servicio";
	public static final long ID_TARJETA_CIRCULACION = 5L;
	public static final String TARJETA_CIRCULACION = "Tarjeta de Circulaci—n";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String tipo;

//	@OneToMany(mappedBy="fkTipoEntregable")
//	private List<DocumentoAlmacenDO> documentoalmacens;

	public TipoDocumentoAlmacenDO() {
		super();
	}
	
	public TipoDocumentoAlmacenDO(Long id, String tipo) {
		super();
		this.id = id;
		this.tipo = tipo;
	}
	
	public static TipoDocumentoAlmacenDO getPolizaGarantia(){
		TipoDocumentoAlmacenDO tipoDocumentoAlmacen = new TipoDocumentoAlmacenDO( ID_POLIZA_GARANTIA, POLIZA_GARANTIA );
		return tipoDocumentoAlmacen;
	}
	
	public static TipoDocumentoAlmacenDO getPolizaSeguro(){
		TipoDocumentoAlmacenDO tipoDocumentoAlmacen = new TipoDocumentoAlmacenDO( ID_POLIZA_SEGURO, POLIZA_SEGURO );
		return tipoDocumentoAlmacen;
	}
	
	public static TipoDocumentoAlmacenDO getCertificadoCalibracion(){
		TipoDocumentoAlmacenDO tipoDocumentoAlmacen = new TipoDocumentoAlmacenDO( ID_CERTIFICADO_CALIBRACION, CERTIFICADO_CALIBRACION );
		return tipoDocumentoAlmacen;
	}
	
	public static TipoDocumentoAlmacenDO getOrdenMantenimientoServicio(){
		TipoDocumentoAlmacenDO tipoDocumentoAlmacen = new TipoDocumentoAlmacenDO( ID_ORDEN_MANTENIMIENTO_SERVICIO, ORDEN_MANTENIMIENTO_SERVICIO );
		return tipoDocumentoAlmacen;
	}
	
	public static TipoDocumentoAlmacenDO getTarjetaCirculacion(){
		TipoDocumentoAlmacenDO tipoDocumentoAlmacen = new TipoDocumentoAlmacenDO( ID_TARJETA_CIRCULACION, TARJETA_CIRCULACION );
		return tipoDocumentoAlmacen;
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