package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DescripcionFondoFijoCajaChicaDO")]
	public class DescripcionFondoFijoCajaChica
	{
		public var id:*;
		public var descripcion:String;
		
		public function DescripcionFondoFijoCajaChica()
		{
			id = undefined;
			descripcion = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemDescripcionFondoFijoCajaChica(id:Number, etiqueta:String):DescripcionFondoFijoCajaChica{
			var item:DescripcionFondoFijoCajaChica = null;
			item = new DescripcionFondoFijoCajaChica();
			item.id = id;
			item.descripcion = etiqueta;
			return item;
		}
	}
}