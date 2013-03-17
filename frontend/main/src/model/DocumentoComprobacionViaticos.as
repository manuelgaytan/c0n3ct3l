package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DocumentoComprobacionViaticosDO")]
	public class DocumentoComprobacionViaticos
	{
		public var id:*;
		public var comprobacionViaticos:ComprobacionViaticos;
		public var documento:String;
		
		public function DocumentoComprobacionViaticos()
		{
			id = undefined;
			comprobacionViaticos = null;
			documento = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemDocumentoComprobacionViaticos(id:Number, comprobacionViaticos:ComprobacionViaticos, documento:String):DocumentoComprobacionViaticos{
			var item:DocumentoComprobacionViaticos = null;
			item = new DocumentoComprobacionViaticos();
			item.id = id;
			item.comprobacionViaticos = comprobacionViaticos;
			item.documento = documento;
			return item;
		}
	}
}