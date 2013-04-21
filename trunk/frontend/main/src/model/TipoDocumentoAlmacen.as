package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoDocumentoAlmacenDO")]
	public class TipoDocumentoAlmacen
	{
		public var id:*;
		public var tipo:String;
		
		public function TipoDocumentoAlmacen(id:* = undefined, tipo:String = "")
		{
			this.id = id;
			this.tipo = tipo;
		}
		
		public static function getPolizaGarantia():TipoDocumentoAlmacen{
			return new TipoDocumentoAlmacen(1,"Poliza de Garantía");
		}
		
		public static function getPolizaSeguro():TipoDocumentoAlmacen{
			return new TipoDocumentoAlmacen(2,"Poliza de Seguro");
		}
		
		public static function getCertificadoCalibracion():TipoDocumentoAlmacen{
			return new TipoDocumentoAlmacen(3,"Certificado de Calibración");
		}
		
		public static function getOrdenMantenimientoServicio():TipoDocumentoAlmacen{
			return new TipoDocumentoAlmacen(4,"Orden de Mantenimiento o Servicio");
		}
		
		public static function getTarjetaCirculacion():TipoDocumentoAlmacen{
			return new TipoDocumentoAlmacen(5,"Tarjeta de Circulación");
		}
	}
}