package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioOrdenCompraClienteDO")]
	public class ComentarioOrdenCompraCliente
	{
		public var id:*;
		public var ordenCompraCliente:OrdenCompraCliente;
		public var comentarioValidacionAdministrativa:ComentarioValidacionAdministrativa;
		
		public function ComentarioOrdenCompraCliente()
		{
		}
	}
}