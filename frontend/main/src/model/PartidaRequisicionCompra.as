package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PartidaRequisicionCompraDO")]
	public class PartidaRequisicionCompra
	{
		public var id:*;
		public var requisicionCompra:RequisicionCompra;
		public var codigo:String;
		public var grupoFamilia:String;
		public var descripcion:String;
		public var cantidad:String;
		public var unidad:String;
		public var validacion:String;
		public var fkEstatus:Number = EstatusRequisicionCompra.ID_PENDIENTE;
		//public var estatusRequisicionCompra:EstatusRequisicionCompra;
		
		public function PartidaRequisicionCompra()
		{
		}
	}
}