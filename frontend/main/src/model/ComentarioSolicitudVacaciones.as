package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioSolicitudVacacionesDO")]
	public class ComentarioSolicitudVacaciones
	{
		public var id:*;
		public var solicitudVacaciones:SolicitudVacaciones;
		public var comentarioRecursosHumanos:ComentarioRecursosHumanos;
		
		public function ComentarioSolicitudVacaciones()
		{
		}
	}
}