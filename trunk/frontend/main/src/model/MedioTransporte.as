package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MedioTransporteDO")]
	public class MedioTransporte
	{
		public static const ID_AEREO:Number = 1;
		public static const ID_AUTOBUS:Number = 2;
		public static const ID_VEHICULO:Number = 3;
		public static const ID_OTRO:Number = 4;
		
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