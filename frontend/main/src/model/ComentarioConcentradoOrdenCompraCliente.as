package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioConcentradoOrdenCompraClienteDO")]
	public class ComentarioConcentradoOrdenCompraCliente
	{
		public var id:*;
		public var concentradoOrdenCompraCliente:ConcentradoOrdenCompraCliente;
		public var comentarioValidacionAdministrativa:ComentarioValidacionAdministrativa;
		
		public function ComentarioConcentradoOrdenCompraCliente()
		{
		}
	}
}