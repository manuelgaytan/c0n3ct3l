package model
{
	public class Reportes
	{
		private static const REPORTING:String = "/serviciosWeb/reporting";
		private static const JSP:String = ".jsp";
		public static const SOLICITUD_ALMANCEN:String = loadURL( "SolicitudAlmacen" );
		public static const ORDEN_COMPRA_ALMANCEN:String = loadURL( "OrdenCompraAlmacen" );
		public static const ORDEN_COMPRA_MAQUILADO:String = loadURL( "OrdenCompraMaquilado" );
		public static const PRECIARIO_MAQUILADOR:String = loadURL( "PreciarioMaquilado" );
		
		public function Reportes()
		{
		}
		
		private static function loadURL( type:String ):String{
			return REPORTING + type + JSP;
		}
	}
}