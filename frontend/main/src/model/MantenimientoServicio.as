package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MantenimientoServicioDO")]
	public class MantenimientoServicio
	{
		public var id:*;
		public var etiqueta:String;
		
		public function MantenimientoServicio()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}