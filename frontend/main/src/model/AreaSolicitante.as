package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.AreaSolicitanteDO")]
	public class AreaSolicitante
	{
		public var id:*;
		public var etiqueta:String;
		
		public function AreaSolicitante()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}