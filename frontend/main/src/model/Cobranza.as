package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.CobranzaDO")]
	public class Cobranza
	{
		public var id:*;
		public var informacionFacturacion:InformacionFacturacion;
		public var folioFactura:String;
		public var notaCreditoCliente:NotaCreditoCliente;
		public var subtotal:Number;
		public var iva:Number;
		public var total:Number;
		public var bancoConectel:BancoConectel;
		public var fechaAbono:Date;
		public var monto:Number;
		public var referenciaAbono:*;
		public var comentariosCobranza:ArrayCollection;
		
		public function Cobranza(){
			
		}
	}
}