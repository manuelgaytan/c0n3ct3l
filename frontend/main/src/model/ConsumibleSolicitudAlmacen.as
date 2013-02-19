package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ConsumibleSolicitudAlmacenDO")]
	public class ConsumibleSolicitudAlmacen
	{
		public var id:*;
		public var solicitudAlmacen:SolicitudAlmacen;
		public var consumible:Consumible;
		public var cantidadSolicitada:Number;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function ConsumibleSolicitudAlmacen()
		{
		}
	}
}