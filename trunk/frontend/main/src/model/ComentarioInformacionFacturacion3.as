package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ComentarioInformacionFacturacion3DO")]
	public class ComentarioInformacionFacturacion3
	{
		public var id:*;
		public var informacionFacturacion:InformacionFacturacion;
		public var comentarioCuentasPagarFacturacion:ComentarioCuentasPagarFacturacion;
		
		public function ComentarioInformacionFacturacion3()
		{
		}
	}
}