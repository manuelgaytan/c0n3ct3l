package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.HerramientaSolicitudAlmacenDO")]
	public class HerramientaSolicitudAlmacen
	{
		public var id:*;
		public var solicitudAlmacen:SolicitudAlmacen;
		public var herramienta:Herramienta;
		public var cantidadSolicitada:Number;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function HerramientaSolicitudAlmacen()
		{
		}
	}
}