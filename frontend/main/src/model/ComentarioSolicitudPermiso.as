package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioSolicitudPermisoDO")]
	public class ComentarioSolicitudPermiso
	{
		public var id:*;
		public var solicitudPermiso:SolicitudPermiso;
		public var comentarioRecursosHumanos:ComentarioRecursosHumanos;
		
		public function ComentarioSolicitudPermiso()
		{
		}
	}
}