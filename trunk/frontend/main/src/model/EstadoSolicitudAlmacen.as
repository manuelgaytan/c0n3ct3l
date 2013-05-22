package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoSolicitudAlmacenDO")]
	public class EstadoSolicitudAlmacen
	{
		public var id:*;
		public var etiqueta:String;
		public static var ID_ABIERTO:Number = 1;
		public static var ID_PENDIENTE:Number = 2;
		public static var ID_CERRADO:Number = 3;
		public static var ID_AUTORIZADO:Number = 4;
		public static var ABIERTO:String = "Abierto";
		public static var PENDIENTE:String = "Pendiente";
		public static var CERRADO:String = "Cerrado";
		public static var AUTORIZADO:String = "Autorizado";
		
		public function EstadoSolicitudAlmacen()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem( createItemEstadoSolicitudAlmacen( ID_ABIERTO, ABIERTO ) );
			array.addItem( createItemEstadoSolicitudAlmacen( ID_PENDIENTE, PENDIENTE ) );
			array.addItem( createItemEstadoSolicitudAlmacen( ID_CERRADO, CERRADO ) );
			return array;
		}
		
		private static function createItemEstadoSolicitudAlmacen(id:Number, etiqueta:String):EstadoSolicitudServicioMaquilado{
			var item:EstadoSolicitudServicioMaquilado = null;
			item = new EstadoSolicitudServicioMaquilado();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}