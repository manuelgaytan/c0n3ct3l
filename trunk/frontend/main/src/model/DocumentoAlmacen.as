package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DocumentoAlmacenDO")]
	public class DocumentoAlmacen
	{
		public var id:*;
		public var fkTipoAlmacen:TipoAlmacen;
		public var fkAlmacen:*;
		public var fkTipoEntregable:TipoDocumentoAlmacen;
		public var nombreArchivo:String;
		
		public function DocumentoAlmacen()
		{
		}
	}
}