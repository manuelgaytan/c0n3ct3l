package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.FormaPagoDO")]
	public class FormaPago
	{
		public var id:*;
		public var etiqueta:String;
		public var forma:String;
		
		public function FormaPago()
		{
			id = undefined;
			etiqueta = "";
			
			
		}
	}
}