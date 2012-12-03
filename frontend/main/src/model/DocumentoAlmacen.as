package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DocumentoAlmacenDO")]
	public class DocumentoAlmacen
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var fkAlmacen:*;
		public var fkTipoEntregable:*;
		public var nombreArchivo:String;
		
		public function DocumentoAlmacen()
		{
		}
	}
}