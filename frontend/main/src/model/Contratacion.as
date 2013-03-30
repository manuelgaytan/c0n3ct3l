package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.ContratacionDO")]
	public class Contratacion
	{
		public var id:*;
		public var colaborador:Colaborador;
		public var sueldoInicial:Number;
		public var fechaExpedicionCertificado_medico:Date;
		public var fechaVencimientoCertificadoMedico:Date;
		public var tipoContratacion:TipoContratacion;
		public var tipoContrato:TipoContrato;
		public var vencimientoContratoEventual:String;
		public var fechaInicioContrato:Date;
		public var suspension:Suspension;
		public var motivoSuspension:String;
		public var fechaTermino_contrato:Date;
		public var motivoTerminoContrato:MotivoTerminoContrato;
		public var finiquito:Boolean;
		public var indemnizacion:Boolean;
		
		public function Contratacion()
		{
		}
	}
}