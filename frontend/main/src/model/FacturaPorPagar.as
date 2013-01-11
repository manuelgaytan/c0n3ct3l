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
		
		public function FacturaPorPagar(){
			
		}
	}
}