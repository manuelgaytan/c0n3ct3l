package model
{
	import mx.collections.ArrayCollection;

	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.PagoProveedorDO")]
	public class PagoProveedor
	{
		public var id:*;
		public var facturaProveedor:FacturaProveedor;
		public var folioFactura:String;
		public var notaCreditoProveedor:NotaCreditoProveedor;
		public var subtotal:Number;
		public var iva:Number;
		public var total:Number;
		public var bancoConectel:BancoConectel;
		public var fechaAbono:Date;
		public var monto:Number;
		public var referenciaAbono:*;
		public var comentariosPagoProveedor:ArrayCollection;
		
		public function PagoProveedor(){
			
		}
	}
}