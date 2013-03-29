package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioCobranzaDO")]
	public class ComentarioCobranza
	{
		public var id:*;
		public var cobranza:Cobranza;
		public var comentarioTesoreria:ComentarioTesoreria;
		
		public function ComentarioCobranza()
		{
		}
	}
}