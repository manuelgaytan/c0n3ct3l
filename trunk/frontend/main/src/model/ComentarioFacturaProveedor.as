package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioFacturaProveedorDO")]
	public class ComentarioFacturaProveedor
	{
		public var id:*;
		public var facturaProveedor:FacturaProveedor;
		public var comentarioCuentasPagarFacturacion:ComentarioCuentasPagarFacturacion;
		
		public function ComentarioFacturaProveedor()
		{
		}
	}
}