package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.RequisicionCompraDO")]
	public class RequisicionCompra
	{
		public var id:*;
		public var fechaSolicitud:Date;
		public var motivo:String;
		public var prioridad:Prioridad;
		public var areaSolicitante:AreaSolicitante;
		public var centralSitio:String;
		public var estatusRequisicionCompra:EstatusRequisicionCompra;
		public var solicitantesRequisicion:ArrayCollection;
		public var partidasRequisicionCompra:ArrayCollection;
		public var comentariosRequisicion:ArrayCollection;
		public var fechaEstatusRequisicion:Date;
		
		public function RequisicionCompra()
		{
		}
	}
}