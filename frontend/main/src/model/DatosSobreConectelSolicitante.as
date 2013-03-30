package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.DatosSobreConectelSolicitanteDO")]
	public class DatosSobreConectelSolicitante
	{
		public var id:*;
		public var fuenteReclutamiento:FuenteReclutamiento;
		public var conocidosConectel:Boolean;
		public var puedeViajar:Boolean;
		public var fecha_presentarse:Date;
		public var faseSeleccion:FaseSeleccion;
		
		public function DatosSobreConectelSolicitante()
		{
		}
	}
}