package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.CotizacionDO")]
	public class Cotizacion
	{
		public var id:*;
		public var descripcion:String;
		public var emisor:String;
		public var fecha:Date;
		public var nombreArchivo:String;
		public var comentariosCotizacion:ArrayCollection;
	}
}