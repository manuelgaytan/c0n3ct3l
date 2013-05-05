package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.model.FiltroProyecto")]
	public class FiltroProyecto
	{
		public var idConectel:String;
		public var idCategoria:*;
		public var idCliente:*;
		public var tipoProyecto:String;
		public var tecnologia:String;
		public var equipo:String;
		public var actividadRealizar:String;
		public var modelo:String;
		public var descripcionServicio:String;
		public var tipoServicio:String;
		public var idCosto:*;
		public var proyectoPadre:String;
		
		public function FiltroProyecto()
		{
		}
	}
}