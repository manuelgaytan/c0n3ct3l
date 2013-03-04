package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoValidacionCostoDO")]
	public class EstadoValidacionCosto
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoValidacionCosto()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoValidacionCosto(id:Number, etiqueta:String):EstadoValidacionCosto{
			var item:EstadoValidacionCosto = null;
			item = new EstadoValidacionCosto();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}