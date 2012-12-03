package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudAlmacenDO")]
	public class SolicitudAlmacen
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var folio:Number;
		public var fechaSolicitud:Date;
		public var motivo:String;
		public var fkPrioridad:*;
		public var fkAreaSolicitante:*;
		public var centralSitio:String;
		public var fkServicioSolicitado:*;
		public var descripcion:*;
		public var cantidad:Number;
		public var fkUnidadB:*;
		public var observaciones:String;
		public var autoriza:String;
		public var entrega:String;
		public var fechaAsignacion:Date;
		public var fechaRetorno:Date;
		public var valeAbiertoCerrado:String;
		
		public var nombresSolicitantes:ArrayCollection;//NombreSolicitante
		
		public var tipoAlmacen:TipoAlmacen;
		public var prioridad:Prioridad;
		public var areaSolicitante:AreaSolicitante;
		public var servicioSolicitado:ServicioSolicitado;
		public var descripcionAlmacen:DescripcionAlmacen;
		public var unidadB:UnidadB;
		
		public function SolicitudAlmacen()
		{
		}
	}
}