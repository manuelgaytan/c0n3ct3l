package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TelefoniaMovilSolicitudAlmacenDO")]
	public class TelefoniaMovilSolicitudAlmacen
	{
		public var id:*;
		public var solicitudAlmacen:SolicitudAlmacen;
		public var telefoniaMovil:TelefoniaMovil;
		public var cantidadSolicitada:Number;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function TelefoniaMovilSolicitudAlmacen()
		{
		}
	}
}