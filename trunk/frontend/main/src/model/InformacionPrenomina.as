package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.InformacionPrenominaDO")]
	public class InformacionPrenomina
	{
		public var id:*;
		public var contratacion:Contratacion;
		public var fechaIncidencia:Date;
		public var claseIncidencia:ClaseIncidencia;
		public var tipoIncapacidad:TipoIncapacidad;
		public var montoImss:Number;
		public var montoConectel:Number;
		
		public function InformacionPrenomina()
		{
		}
	}
}