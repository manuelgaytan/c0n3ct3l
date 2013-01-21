package model
{
	import mx.collections.ArrayCollection;

	public class EstatusProyectoEntregable
	{
		public var id:*;
		public var estatus:String;
		public static var ID_AUTORIZADO:Number = 1;
		public static var ID_RECHAZADO:Number = 2;
		public static var ID_PENDIENTE:Number = 3;
		public static var AUTORIZADO:String = "Autorizado";
		public static var RECHAZADO:String = "Rechazado";
		public static var PENDIENTE:String = "Pendiente";
		
		public function EstatusProyectoEntregable()
		{
			id = undefined;
			estatus = "";
		}
		
		public static function getComboList():ArrayCollection{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem( createItemEstatusProyectoEntregable( ID_PENDIENTE, PENDIENTE ) );
			array.addItem( createItemEstatusProyectoEntregable( ID_AUTORIZADO, AUTORIZADO ) );
			array.addItem( createItemEstatusProyectoEntregable( ID_RECHAZADO, RECHAZADO ) );
			return array;
		}
		
		private static function createItemEstatusProyectoEntregable(id:Number, estatus:String):EstatusProyectoEntregable{
			var item:EstatusProyectoEntregable = null;
			item = new EstatusProyectoEntregable();
			item.id = id;
			item.estatus = estatus;
			return item;
		}
	}
}