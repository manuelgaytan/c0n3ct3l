package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.FacturaPorPagarDO")]
	public class FacturaPorPagar
	{
		public var id:*;
		public var ordenCompra:OrdenCompraAlmacen;
		public var ordenCompraMaquilado:OrdenCompraMaquilado;
		public var folio:String;
		public var fecha:Date;
		public var fechaPago:Date;
		public var fechaPago1:Date;
		public var porcentajePago1:String;
		public var fechaPago2:Date;
		public var porcentajePago2:String;
		
		public function FacturaPorPagar(){
			
		}
	}
}