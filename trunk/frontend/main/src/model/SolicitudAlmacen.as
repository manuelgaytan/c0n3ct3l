package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudAlmacenDO")]
	public class SolicitudAlmacen
	{
		public var id:*;
		public var usuario:Usuario;
		public var fechaSolicitud:Date;
		public var motivo:String;
		public var prioridad:Prioridad;
		public var areaSolicitante:AreaSolicitante;
		public var centralSitio:String;
		public var estadoSolicitudAlmacen:EstadoSolicitudAlmacen;
		public var nombreSolicitante:String;
		public var autoriza:Colaborador;
		public var entrega:Colaborador;
		public var recibe:String;
		
		public function SolicitudAlmacen()
		{
		}
	}
}