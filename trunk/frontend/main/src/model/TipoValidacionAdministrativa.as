package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoValidacionAdministrativaDO")]
	public class TipoValidacionAdministrativa
	{
		public var id:*;
		public var etiqueta:String;
		
		public function TipoValidacionAdministrativa()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemTipoValidacionAdministrativa(id:Number, etiqueta:String):TipoValidacionAdministrativa{
			var item:TipoValidacionAdministrativa = null;
			item = new TipoValidacionAdministrativa();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}