package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoAlmacenDO")]
	public class Reportes
	{
		public static const REPORTING:String = "/serviciosWeb/reporting.jsp?item=";
		public static const SOLICITUD_ALMANCEN:String = REPORTING + "solicitudAlmacen";
		
		public function Reportes()
		{
		}
	}
}