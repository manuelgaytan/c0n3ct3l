package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PagoOtraOperacionFinancieraDO")]
	public class PagoOtraOperacionFinanciera
	{
		public var id:*;
		public var conceptoOtraOperacionFinanciera:ConceptoOtraOperacionFinanciera;
		public var razonSocial:String;
		public var subtotal:Number;
		public var iva:Number;
		public var total:Number;
		public var bancoConectel:BancoConectel;
		public var fechaAbono:Date;
		public var monto:Number;
		public var referenciaAbono:*;
		public var cuentasDestino:String;
		public var tipoPago:TipoPago;
		public var observaciones:String;
		public var comentariosPagoOtraOperacionFinanciera:ArrayCollection;
		
		public function PagoOtraOperacionFinanciera(){
			
		}
	}
}