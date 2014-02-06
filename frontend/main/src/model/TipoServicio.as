package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoServicioDO")]
	public class TipoServicio
	{
		public static const ID_LOCAL:Number = 1;
		public static const ID_FORANEO:Number = 2;
		public static const LOCAL:String = "LOCAL";
		public static const FORANEO:String = "FORANEO";
		
		public var id:*;
		public var tipo:String;
		
		public function TipoServicio()
		{
		}
	}
}