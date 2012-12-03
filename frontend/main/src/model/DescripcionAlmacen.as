package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DescripcionAlmacenDO")]
	public class DescripcionAlmacen
	{
		public var id:*;
		public var etiqueta:String;
		
		public function DescripcionAlmacen()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}