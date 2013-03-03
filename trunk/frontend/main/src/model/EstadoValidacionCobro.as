package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoValidacionCobroDO")]
	public class EstadoValidacionCobro
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoValidacionCobro()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoValidacionCobro(id:Number, etiqueta:String):EstadoValidacionCobro{
			var item:EstadoValidacionCobro = null;
			item = new EstadoValidacionCobro();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}