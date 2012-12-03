package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.model.Catalogo")]
	public class Catalogo
	{
		public var id:*;
		public var etiqueta:String;
		
		public function Catalogo()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}