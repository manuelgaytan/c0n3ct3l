package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioDO")]
	public class Comentario
	{
		public var id:*;
		public var comentario:String;
		public var fechaCaptura:Date;
		
		public var usuario:Usuario;
		
		public function Comentario()
		{
		}
	}
}