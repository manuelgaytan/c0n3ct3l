package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DescripcionPagoContableServicioDO")]
	public class DescripcionPagoContableServicio
	{
		public var id:*;
		public var descripcion:String;
		public var tipoOperacion:TipoOperacion;
		
		public function DescripcionPagoContableServicio()
		{
			id = undefined;
			descripcion = "";
			tipoOperacion = null;
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemDescripcionPagoContableServicio(id:Number, etiqueta:String, tipoOperacion:TipoOperacion):DescripcionPagoContableServicio{
			var item:DescripcionPagoContableServicio = null;
			item = new DescripcionPagoContableServicio();
			item.id = id;
			item.descripcion = etiqueta;
			item.tipoOperacion = tipoOperacion;
			return item;
		}
	}
}