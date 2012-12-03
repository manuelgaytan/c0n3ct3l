package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoMantenimientoDO")]
	public class TipoMantenimiento
	{
		public var id:*;
		public var etiqueta:String;
		
		public function TipoMantenimiento()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}