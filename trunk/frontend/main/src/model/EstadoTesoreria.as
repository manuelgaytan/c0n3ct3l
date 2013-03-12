package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoTesoreriaDO")]
	public class EstadoTesoreria
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoTesoreria()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoTesoreria(id:Number, etiqueta:String):EstadoTesoreria{
			var item:EstadoTesoreria = null;
			item = new EstadoTesoreria();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}