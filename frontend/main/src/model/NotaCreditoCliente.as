package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.NotaCreditoClienteDO")]
	public class NotaCreditoCliente
	{
		public var id:*;
		public var folio:String;
		public var factura:String;
		public var item:String;
		public var fecha:Date;
		public var subtotal:Number;
		public var iva:Number;
		public var total:Number;
		public var cliente:Cliente;
		
		public function NotaCreditoCliente(){
			
		}
	}
}