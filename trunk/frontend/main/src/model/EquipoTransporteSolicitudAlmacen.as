package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EquipoTransporteSolicitudAlmacenDO")]
	public class EquipoTransporteSolicitudAlmacen
	{
		public var id:*;
		public var solicitudAlmacen:SolicitudAlmacen;
		public var equipoTransporte:EquipoTransporte;
		public var cantidadSolicitada:Number;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function EquipoTransporteSolicitudAlmacen()
		{
		}
	}
}