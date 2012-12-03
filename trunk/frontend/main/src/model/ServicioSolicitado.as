package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ServicioSolicitadoDO")]
	public class ServicioSolicitado
	{
		public var id:*;
		public var etiqueta:String;
		
		public function ServicioSolicitado()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}