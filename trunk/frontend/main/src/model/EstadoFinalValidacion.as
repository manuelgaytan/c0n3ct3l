package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoFinalValidacionDO")]
	public class EstadoFinalValidacion
	{
		public var id:*;
		public var etiqueta:String;
		
		public function EstadoFinalValidacion()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			return null;
		}
		
		private static function createItemEstadoFinalValidacion(id:Number, etiqueta:String):EstadoFinalValidacion{
			var item:EstadoFinalValidacion = null;
			item = new EstadoFinalValidacion();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}