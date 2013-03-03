package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoValidacionAdministrativaDO")]
	public class EstadoValidacionAdministrativa
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoValidacionAdministrativa()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoValidacionAdministrativa(id:Number, etiqueta:String):EstadoValidacionAdministrativa{
			var item:EstadoValidacionAdministrativa = null;
			item = new EstadoValidacionAdministrativa();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}