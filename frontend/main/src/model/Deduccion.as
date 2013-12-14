package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DeduccionDO")]
	public class Deduccion
	{
		public static const ID_RETARDOS:Number = 6;
		public static const ID_FALTA:Number = 7;
		public static const ID_PERMISO:Number = 15;
		
		public var id:*;
		public var deduccion:String;
		
		public function Deduccion()
		{
		}
	}
}