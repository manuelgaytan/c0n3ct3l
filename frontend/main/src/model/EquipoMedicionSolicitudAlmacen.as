package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EquipoMedicionSolicitudAlmacenDO")]
	public class EquipoMedicionSolicitudAlmacen
	{
		public var id:*;
		public var solicitudAlmacen:SolicitudAlmacen;
		public var equipoMedicion:EquipoMedicion;
		public var cantidadSolicitada:Number;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function EquipoMedicionSolicitudAlmacen()
		{
		}
	}
}