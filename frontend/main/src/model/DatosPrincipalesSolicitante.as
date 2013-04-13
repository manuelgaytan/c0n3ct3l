package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DatosPrincipalesSolicitanteDO")]
	public class DatosPrincipalesSolicitante
	{
		public var id:*;
		public var fechaSolicitud:Date;
		public var puestoSolicitado:String;
		public var sueldoSolicitado:Number;
		public var objetivoLaboral:String;
		
		public function DatosPrincipalesSolicitante()
		{
		}
	}
}