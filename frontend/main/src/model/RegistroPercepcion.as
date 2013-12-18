package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.RegistroPercepcionDO")]
	public class RegistroPercepcion
	{
		public var id:*;
		public var contratacion:Contratacion;
		public var percepcion:Percepcion;
		public var montoAportacion:*;
		public var variacion:Variacion;
		public var diasCorrespondientes:*;
		public var fechaInicio:Date;
		public var fechaTermino:Date;
		public var primaVacacional:Boolean;
		
		public function RegistroPercepcion()
		{
		}
	}
}