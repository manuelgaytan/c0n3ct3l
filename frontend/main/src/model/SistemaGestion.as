package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SistemaGestionDO")]
	public class SistemaGestion
	{
		public var id:*;
		public var proyecto:Proyecto;
		public var aplicacionAuditoria:Boolean;
		public var tipoAuditoria:TipoAuditoria;
		public var formaAuditoria:FormaAuditoria;
		public var fechaAuditoria:Date;
		public var indiceCalidad:String;
		public var fechaEnvio:Date;
		public var fechaRecepcion:Date;
		public var formatoAuditoria:String;
		public var nombreAuditor:String;
		public var fechaRecepcionCorreccionesAuditoriasInternas:Date;
		public var fechaEnvioCorrecciones:Date;
		public var estadoSistemaGestion:EstadoSistemaGestion;
		public var correcciones:String;
		public var fechaCierreAuditoria:Date;
		public var observaciones:String;
		
		public function SistemaGestion()
		{
		}
	}
}