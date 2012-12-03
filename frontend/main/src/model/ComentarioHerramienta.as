package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioHerramientaDO")]
	public class ComentarioHerramienta
	{
		public var id:*;
		public var comentario:String;
		public var fechaCaptura:Date;
		
		public var usuario:Usuario;
		public var herramiena:Herramienta;
		
		public function Comentario()
		{
		}
	}
}