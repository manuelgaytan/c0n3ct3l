package model
{
	public class Reportes
	{
		private static const REPORTING:String = "/serviciosWeb/reporting";
		private static const REPORTING_SERVLET:String = "/serviciosWeb/";
		private static const JSP:String = ".jsp";
		public static const IMPRIMIR_TODOS:Number = -1;
		public static const SOLICITUD_ALMANCEN:String = loadURL( "SolicitudAlmacen" );
		public static const ORDEN_COMPRA_ALMANCEN:String = loadURL( "OrdenCompraAlmacen" );
		public static const ORDEN_COMPRA_MAQUILADO:String = loadURLServlet( "ReporteOrdenCompraMaquilado" );
		public static const PRECIARIO_MAQUILADOR:String = loadURL( "PreciarioMaquilado" );
		public static const MINUTA_REUNION:String = loadURL( "MinutaReunion" );
		public static const FICHA_PRESENTACION:String = loadURL( "FichaPresentacion" );
		
		public function Reportes()
		{
		}
		
		private static function loadURL( type:String ):String{
			return REPORTING + type + JSP;
		}
		
		private static function loadURLServlet( type:String ):String{
			return REPORTING_SERVLET + type ;
		}
	}
}