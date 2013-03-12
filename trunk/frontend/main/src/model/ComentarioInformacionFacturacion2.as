package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion2DO")]
	public class ComentarioInformacionFacturacion2
	{
		public var id:*;
		public var informacionFacturacion:InformacionFacturacion;
		public var comentarioCuentasPagarFacturacion:ComentarioCuentasPagarFacturacion;
		
		public function ComentarioInformacionFacturacion2()
		{
		}
	}
}