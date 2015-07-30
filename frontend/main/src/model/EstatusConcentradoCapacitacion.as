package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstatusConcentradoCapacitacionDO")]
	public class EstatusConcentradoCapacitacion
	{
		public var id:*;
		public var estatus:String;
		public static var ID_PENDIENTE:Number = 1;
		public static var ID_NO_APLICA:Number = 2;
		public static var ID_EN_PROCESO:Number = 3;
		public static var ID_APROBADO:Number = 4;
		public static var ID_NO_APROBADO:Number = 5;
		
		public function EstatusDevolucion( id:* = undefined, estatus:String = "")
		{
			this.id = id;
			this.estatus = estatus;
		}
	}
}