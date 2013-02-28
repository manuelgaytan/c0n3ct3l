package model
{
	import mx.collections.ArrayCollection;

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
		
		public static function getAll():ArrayCollection{
			var items:ArrayCollection = new ArrayCollection();
			var estatusRequisicionCompra:EstatusRequisicionCompra = null;
			estatusRequisicionCompra = new EstatusRequisicionCompra();
			estatusRequisicionCompra.id = ID_AUTORIZADA;
			estatusRequisicionCompra.estatus = AUTORIZADA;
			items.addItem( estatusRequisicionCompra );
			estatusRequisicionCompra = new EstatusRequisicionCompra();
			estatusRequisicionCompra.id = ID_RECHAZADA;
			estatusRequisicionCompra.estatus = RECHAZADA;
			items.addItem( estatusRequisicionCompra );
			estatusRequisicionCompra = new EstatusRequisicionCompra();
			estatusRequisicionCompra.id = ID_PENDIENTE;
			estatusRequisicionCompra.estatus = PENDIENTE;
			items.addItem( estatusRequisicionCompra );
			return items;
		}
	}
}