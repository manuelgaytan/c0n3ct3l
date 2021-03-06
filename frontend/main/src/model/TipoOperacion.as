package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoOperacionDO")]
	public class TipoOperacion
	{
		public static const ID_INGRESOS:Number = 1;
		public static const ID_EGRESOS:Number = 2;
		
		public var id:*;
		public var etiqueta:String;
		
		public function TipoOperacion()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemTipoOperacion(id:Number, etiqueta:String):TipoOperacion{
			var item:TipoOperacion = null;
			item = new TipoOperacion();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}