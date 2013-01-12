package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoPagoDO")]
	public class TipoPago
	{
		public var id:*;
		public var etiqueta:String;
		public var tipo:String;
		
		
		public function TipoPago()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}