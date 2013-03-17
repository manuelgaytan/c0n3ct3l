package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DescripcionPagoContableServicioDO")]
	public class DescripcionPagoContableServicio
	{
		public var id:*;
		public var etiqueta:String;
		public var tipoOperacion:TipoOperacion;
		
		public function DescripcionPagoContableServicio()
		{
			id = undefined;
			etiqueta = "";
			tipoOperacion = null;
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemDescripcionPagoContableServicio(id:Number, etiqueta:String, tipoOperacion:TipoOperacion):DescripcionPagoContableServicio{
			var item:DescripcionPagoContableServicio = null;
			item = new DescripcionPagoContableServicio();
			item.id = id;
			item.etiqueta = etiqueta;
			item.tipoOperacion = tipoOperacion;
			return item;
		}
	}
}