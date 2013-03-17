package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoComprobacionViaticosDO")]
	public class EstadoComprobacionViaticos
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoComprobacionViaticos()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoComprobacionViaticos(id:Number, etiqueta:String):EstadoComprobacionViaticos{
			var item:EstadoComprobacionViaticos = null;
			item = new EstadoComprobacionViaticos();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}