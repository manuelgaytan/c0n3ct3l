package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioPantallaValidacionAdministrativaDO")]
	public class ComentarioPantallaValidacionAdministrativa
	{
		public var id:*;
		public var validacionAdministrativa:ValidacionAdministrativa;
		public var comentarioValidacionAdministrativa:ComentarioValidacionAdministrativa;
		
		public function ComentarioPantallaValidacionAdministrativa()
		{
		}
	}
}