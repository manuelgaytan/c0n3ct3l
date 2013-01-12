package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstatusRequisicionCompraDO")]
	public class EstatusRequisicionCompra
	{
		public var id:*;
		public var estatus:String;
		public static var ID_AUTORIZADA:Number = 1;
		public static var ID_RECHAZADA:Number = 2;
		public static var ID_PENDIENTE:Number = 3;
		public static var AUTORIZADA:String = "Autorizada";
		public static var RECHAZADA:String = "Rechazada";
		public static var PENDIENTE:String = "Pendiente";
		
		public function EstatusRequisicionCompra()
		{
			id = undefined;
			estatus = "";
		}
	}
}