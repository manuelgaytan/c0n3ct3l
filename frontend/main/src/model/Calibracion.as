package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.CalibracionDO")]
	public class Calibracion
	{
		public var id:*;
		public var etiqueta:String;
		
		public function Calibracion()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}