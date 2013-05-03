package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DocumentoLiderProveedorMaquiladorDO")]
	public class DocumentoLiderProveedorMaquilador
	{
		public var id:*;
		public var proveedorMaquilador:ProveedorMaquilador;
		public var documento:String;
		
		public function DocumentoLiderProveedorMaquilador()
		{
		}
	}
}