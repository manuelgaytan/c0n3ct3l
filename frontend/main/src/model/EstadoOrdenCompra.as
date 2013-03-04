package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoOrdenCompraDO")]
	public class EstadoOrdenCompra
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoOrdenCompra()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoOrdenCompra(id:Number, etiqueta:String):EstadoOrdenCompra{
			var item:EstadoOrdenCompra = null;
			item = new EstadoOrdenCompra();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}