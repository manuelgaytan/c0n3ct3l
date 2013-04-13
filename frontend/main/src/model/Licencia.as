package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.LicenciaDO")]
	public class Licencia
	{
		public var id:*;
		public var vigencia:Date;
		public var numeroLicencia:String;
		public var tipoLicencia:TipoLicencia;
		
		public function Licencia()
		{
		}
	}
}