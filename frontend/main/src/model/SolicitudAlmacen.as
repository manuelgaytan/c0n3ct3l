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
		public var autorizaFinal:Colaborador;
		public var entrega:Colaborador;
		public var recibe:String;
		public var leyenda:String;
		public var fechaRetorno:Date;
		public var consumiblesSolicitudAlmacen:ArrayCollection;
		public var equipoMedicionSolicitudAlmacen:ArrayCollection;
		public var equipoTransporteSolicitudAlmacen:ArrayCollection;
		public var materialesSolicitudAlmacen:ArrayCollection;
		public var telefoniaMovilSolicitudAlmacen:ArrayCollection;
		public var hardwareSolicitudAlmacen:ArrayCollection;
		public var softwareSolicitudAlmacen:ArrayCollection;
		public var herramientasSolicitudAlmacen:ArrayCollection;
		
		public function SolicitudAlmacen()
		{
		}
	}
}