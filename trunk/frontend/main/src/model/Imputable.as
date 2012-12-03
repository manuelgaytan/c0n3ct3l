package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ImputableDO")]
	public class Imputable
	{
		public var id:*;
		public var etiqueta:String;
		
		public function Imputable()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}