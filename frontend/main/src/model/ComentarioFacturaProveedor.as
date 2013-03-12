package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioFacturaProveedorDO")]
	public class ComentarioFacturaProveedor
	{
		public var id:*;
		public var ordenCompraCliente:OrdenCompraCliente;
		public var comentarioCuentasPagarFacturacion:ComentarioCuentasPagarFacturacion;
		
		public function ComentarioFacturaProveedor()
		{
		}
	}
}