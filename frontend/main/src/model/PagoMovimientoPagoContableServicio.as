package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PagoMovimientoPagoContableServicioDO")]
	public class PagoMovimientoPagoContableServicio
	{
		public var id:*;
		public var movimientoPagoContableServicio:MovimientoPagoContableServicio;
		public var bancoConectel:BancoConectel;
		public var fechaAbono:Date;
		public var monto:Number;
		public var referenciaAbono:String;
		public var cuentasDestino:String;
		public var tipoPago:TipoPago;
		public var comentariosPagoMovimientoPagoContableServicio:ArrayCollection;
		
		public function PagoMovimientoPagoContableServicio(){
			
		}
	}
}