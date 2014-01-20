package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.FacturaProveedorPagoProveedorDO")]
	public class FacturaProveedorPagoProveedor
	{
		public var id:*;
		public var pagoProveedor:PagoProveedor;
		public var facturaProveedor:FacturaProveedor;
		
		public function FacturaProveedorPagoProveedor()
		{
		}
	}
}