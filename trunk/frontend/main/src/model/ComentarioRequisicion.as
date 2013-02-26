package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioRequisicionDO")]
	public class ComentarioRequisicion
	{
		public var id:*;
		public var requisicionCompra:RequisicionCompra;
		public var comentarioCompras:ComentarioCompras;
		
		public function ComentarioRequisicion()
		{
		}
	}
}