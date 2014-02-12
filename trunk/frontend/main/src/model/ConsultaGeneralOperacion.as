package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ConsultaGeneralOperacionDO")]
	public class ConsultaGeneralOperacion
	{
		public var id:*;
		public var proyecto:Proyecto;
		public var datosGeneralesProyecto:DatosGeneralesProyecto;
		public var desarrolloProyecto:DesarrolloProyecto;
		public var configuracionPruebaEntrega:ConfiguracionPruebaEntrega;
		
		public function ConsultaGeneralOperacion()
		{
		}
	}
}