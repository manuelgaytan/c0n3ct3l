package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoValidacionOperativaDO")]
	public class EstadoValidacionOperativa
	{
		public var id:*;
		public var etiqueta:String;
		public static var ID_AUTORIZADO:Number = 1;
		public static var ID_RECHAZADO:Number = 2;
		public static var ID_PENDIENTE:Number = 3;
		public static var AUTORIZADO:String = "No Validado";
		public static var RECHAZADO:String = "Validado";
		public static var PENDIENTE:String = "Parcial";
		
		public function EstadoValidacionOperativa()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getComboList():ArrayCollection{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem( createItemEstadoValidacionOperativa( ID_PENDIENTE, PENDIENTE ) );
			array.addItem( createItemEstadoValidacionOperativa( ID_AUTORIZADO, AUTORIZADO ) );
			array.addItem( createItemEstadoValidacionOperativa( ID_RECHAZADO, RECHAZADO ) );
			return array;
		}
		
		private static function createItemEstadoValidacionOperativa(id:Number, etiqueta:String):EstadoSolicitudServicioMaquilado{
			var item:EstadoSolicitudServicioMaquilado = null;
			item = new EstadoSolicitudServicioMaquilado();
			item.id = id;
			item.etiqueta = etiqueta;
			return item;
		}
	}
}