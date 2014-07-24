package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.FormaPagoPrenominaDO")]
	public class FormaPagoPrenomina
	{
		public static const ID_TOTAL:Number = 1;
		public static const ID_PARCIAL:Number = 2;
		
		public var id:*;
		public var tipo:String;
		
		public function FormaPagoPrenomina()
		{
		}
	}
}