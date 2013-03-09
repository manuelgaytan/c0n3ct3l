package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioValidacionCostoOrdenCompraClienteDO")]
	public class ComentarioValidacionCostoOrdenCompraCliente
	{
		public var id:*;
		public var ordenCompraCliente:OrdenCompraCliente;
		public var comentarioValidacionAdministrativa:ComentarioValidacionAdministrativa;
		
		public function ComentarioValidacionCostoOrdenCompraCliente()
		{
		}
	}
}