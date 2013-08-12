package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DatosUltimoEmpleoSolicitanteDO")]
	public class DatosUltimoEmpleoSolicitante
	{
		public var id:*;
		public var nombreEmpresa:String;
		public var domicilio:String;
		public var telefonos:String;
		public var puestoInicial:String;
		public var puestoFinal:String;
		public var sueldoInicial:*;
		public var sueldoFinal:*;
		public var motivoSeparacion:String;
		public var nombreJefeInmediato:String;
		public var actividadesDesempenadas:String;
		public var nombreEmpresaAnterior:String;
		public var domicilioAnterior:String;
		public var telefonosAnterior:String;
		public var puestoInicialAnterior:String;
		public var puestoFinalAnterior:String;
		public var sueldoInicialAnterior:*;
		public var sueldoFinalAnterior:*;
		public var motivoSeparacionAnterior:String;
		public var nombreJefeInmediatoAnterior:String;
		public var actividadesDesempenadasAnterior:String;
		
		public var reclutamientoSolicitudEmpleo:ReclutamientoSolicitudEmpleo;
		
		public function DatosUltimoEmpleoSolicitante()
		{
		}
	}
}