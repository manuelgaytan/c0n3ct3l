package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.NotaCreditoProveedorPagoProveedorDO")]
	public class NotaCreditoProveedorPagoProveedor
	{
		public var id:*;
		public var pagoProveedor:PagoProveedor;
		public var notaCreditoProveedor:NotaCreditoProveedor;
		
		public function NotaCreditoProveedorPagoProveedor()
		{
		}
	}
}