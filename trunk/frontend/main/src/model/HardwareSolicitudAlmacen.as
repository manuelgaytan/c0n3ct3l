package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.HardwareSolicitudAlmacenDO")]
	public class HardwareSolicitudAlmacen
	{
		public var id:*;
		public var solicitudAlmacen:SolicitudAlmacen;
		public var hardware:Hardware;
		public var cantidadSolicitada:Number;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function HardwareSolicitudAlmacen()
		{
		}
	}
}