package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstatusDevolucionDO")]
	public class EstatusDevolucion
	{
		public var id:*;
		public var estatus:String;
		public static var ID_PENDIENTE:Number = 1;
		public static var ID_NA:Number = 2;
		public static var ID_CERRADO:Number = 3;
		public static var PENDIENTE:String = "Pendiente";
		public static var NA:String = "N/A";
		public static var CERRADO:String = "Cerrado";
		
		public function EstatusDevolucion( id:* = undefined, estatus:String = "")
		{
			this.id = id;
			this.estatus = estatus;
		}
		
		public static function getComboList():ArrayCollection{
			var array:ArrayCollection = new ArrayCollection();
			array.addItem( createItemEstatus( ID_PENDIENTE, PENDIENTE ) );
			array.addItem( createItemEstatus( ID_NA, NA ) );
			array.addItem( createItemEstatus( ID_CERRADO, CERRADO ) );
			return array;
		}
		
		private static function createItemEstatus(id:Number, estatus:String):EstatusDevolucion{
			var item:EstatusDevolucion = null;
			item = new EstatusDevolucion();
			item.id = id;
			item.estatus = estatus;
			return item;
		}
	}
}