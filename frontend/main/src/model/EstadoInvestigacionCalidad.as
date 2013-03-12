package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoInvestigacionCalidadDO")]
	public class EstadoInvestigacionCalidad
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoInvestigacionCalidad()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoInvestigacionCalidad(id:Number, etiqueta:String):EstadoInvestigacionCalidad{
			var item:EstadoInvestigacionCalidad = null;
			item = new EstadoInvestigacionCalidad();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}