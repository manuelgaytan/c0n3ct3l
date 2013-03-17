package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MedioTransporteDO")]
	public class MedioTransporte
	{
		public var id:*;
		public var etiqueta:String;
		
		public function MedioTransporte()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemMedioTransporte(id:Number, etiqueta:String):MedioTransporte{
			var item:MedioTransporte = null;
			item = new MedioTransporte();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}