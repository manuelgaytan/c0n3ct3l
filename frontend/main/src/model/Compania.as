package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.CompaniaDO")]
	public class Compania
	{
		public var id:*;
		public var etiqueta:String;
		
		public function Compania()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}