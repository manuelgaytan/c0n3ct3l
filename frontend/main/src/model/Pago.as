package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PagoDO")]
	public class Pago
	{
		public var id:*;
		public var pago:String;
		
		
		public function Pago()
		{
			id = undefined;
			pago = "";
		}
	}
}