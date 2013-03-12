package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.NotaCreditoProveedorDO")]
	public class NotaCreditoProveedor
	{
		public var id:*;
		public var folio:String;
		public var fecha:Date;
		public var subtotal:Number;
		public var iva:*;
		public var total:Number;
		public var proveedorCalificado:ProveedorCalificado;
		public var proveedorMaquilador:ProveedorMaquilador;
		
		public function NotaCreditoProveedor(){
			
		}
	}
}