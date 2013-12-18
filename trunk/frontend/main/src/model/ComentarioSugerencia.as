package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioSugerenciaDO")]
	public class ComentarioSugerencia
	{
		public var id:*;
		public var sugerencia:Sugerencia;
		public var comentarioSistemasGestion:ComentarioSistemasGestion;
		
		public function ComentarioSugerencia()
		{
		}
	}
}