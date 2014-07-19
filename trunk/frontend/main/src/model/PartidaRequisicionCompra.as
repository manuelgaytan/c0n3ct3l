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
		public var validacion:Colaborador;
		public var costo:*;
		public var importe:*;
		public var estatusRequisicionCompra:EstatusRequisicionCompra;
		public var ordenCompra:OrdenCompraAlmacen;
		
		public var partida:String;
		
		public function PartidaRequisicionCompra()
		{
		}
	}
}