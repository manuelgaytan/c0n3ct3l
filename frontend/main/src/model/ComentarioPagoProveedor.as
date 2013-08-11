package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioPagoProveedorDO")]
	public class ComentarioPagoProveedor
	{
		public var id:*;
		public var pagoProveedor:PagoProveedor;
		public var comentarioTesoreria:ComentarioTesoreria;
		
		public function ComentarioPagoProveedor()
		{
		}
	}
}