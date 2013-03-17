package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioMovimientoPagoContableServicioDO")]
	public class ComentarioMovimientoPagoContableServicio
	{
		public var id:*;
		public var movimientoPagoContableServicio:MovimientoPagoContableServicio;
		public var comentarioContabilidad:ComentarioContabilidad;
		
		public function ComentarioMovimientoPagoContableServicio()
		{
		}
	}
}