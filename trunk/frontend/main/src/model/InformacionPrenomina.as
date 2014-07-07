package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.InformacionPrenominaDO")]
	public class InformacionPrenomina
	{
		public var id:*;
		public var contratacion:InformacionConfidencialColaborador;
		public var fechaIncidenciaInicial:Date;
		public var fechaIncidenciaFinal:Date;
		public var claseIncidencia:ClaseIncidencia;
		public var tipoIncapacidad:TipoIncapacidad;
		public var montoImss:*;
		public var montoConectel:*;
		
		public function InformacionPrenomina()
		{
		}
	}
}