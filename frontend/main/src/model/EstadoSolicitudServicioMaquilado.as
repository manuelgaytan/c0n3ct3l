package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoSolicitudServicioMaquiladoDO")]
	public class EstadoSolicitudServicioMaquilado
	{
		public var id:*;
		public var etiqueta:String;
		public static var ID_AUTORIZADO:Number = 1;
		public static var ID_RECHAZADO:Number = 2;
		public static var ID_PENDIENTE:Number = 3;
		public static var AUTORIZADO:String = "Autorizado";
		public static var RECHAZADO:String = "Rechazado";
		public static var PENDIENTE:String = "Pendiente";
		
		public function EstadoSolicitudServicioMaquilado()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem( createItemEstadoSolicitudServicioMaquilado( ID_PENDIENTE, PENDIENTE ) );
			array.addItem( createItemEstadoSolicitudServicioMaquilado( ID_AUTORIZADO, AUTORIZADO ) );
			array.addItem( createItemEstadoSolicitudServicioMaquilado( ID_RECHAZADO, RECHAZADO ) );
			return array;
		}
		
		private static function createItemEstadoSolicitudServicioMaquilado(id:Number, etiqueta:String):EstadoSolicitudServicioMaquilado{
			var item:EstadoSolicitudServicioMaquilado = null;
			item = new EstadoSolicitudServicioMaquilado();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}