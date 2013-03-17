package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoColaboradorDO")]
	public class TipoColaborador
	{
		public static const ID_PROVEEDORES:Number = 1;
		public static const ID_NOMINA:Number = 2;
		public static const ID_EXTERNOS:Number = 3;
		
		public var id:*;
		public var tipo:String;
		
		public function TipoColaborador()
		{
		}
	}
}