package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoPersonaDO")]
	public class TipoPersona
	{
		public var id:*;
		public var tipo:String;
		public var etiqueta:String;
		
		public function TipoPersona()
		{
			id = undefined;
			etiqueta = "";
			
		}
	}
}