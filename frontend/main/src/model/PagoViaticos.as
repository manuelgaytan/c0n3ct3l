package model
{
	import mx.collections.ArrayCollection;

	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.PagoViaticosDO")]
	public class PagoViaticos
	{
		public var id:*;
		public var comprobacionViaticos:ComprobacionViaticos;
		public var bancoConectel:BancoConectel;
		public var fechaAbono:Date;
		public var monto:Number;
		public var referenciaAbono:*;
		public var comentariosPagoViaticos:ArrayCollection;
		
		public function PagoViaticos(){
			
		}
	}
}