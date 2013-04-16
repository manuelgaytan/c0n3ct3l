package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.AccionPreventivaCorrectivaDO")]
	public class AccionPreventivaCorrectiva
	{
		public var id:*;
		public var noConformidad:NoConformidad;
		public var fechaApertura:Date;
		public var tipoAccion:TipoAccion;
		public var fuenteNoConformidad:FuenteNoConformidad;
		public var especificar:String;
		public var participantesAnalisis:String;
		public var determinacionCausas:String;
		public var responsableSeguimiento:String;
		public var accionesSeguimiento:String;
		public var accionTomadaEficaz:Boolean;
		public var estadoAccionPreventivaCorrectiva:EstadoAccionPreventivaCorrectiva;
		
		public function AccionPreventivaCorrectiva()
		{
		}
	}
}