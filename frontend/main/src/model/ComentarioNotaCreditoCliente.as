package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioNotaCreditoClienteDO")]
	public class ComentarioNotaCreditoCliente
	{
		public var id:*;
		public var notaCreditoCliente:NotaCreditoCliente;
		public var comentarioCuentasPagarFacturacion:ComentarioCuentasPagarFacturacion;
		
		public function ComentarioNotaCreditoCliente()
		{
		}
	}
}