package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion1DO")]
	public class ComentarioInformacionFacturacion1
	{
		public var id:*;
		public var informacionFacturacion:InformacionFacturacion;
		public var comentarioCuentasPagarFacturacion:ComentarioCuentasPagarFacturacion;
		
		public function ComentarioInformacionFacturacion1()
		{
		}
	}
}