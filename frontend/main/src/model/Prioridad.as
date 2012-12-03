package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PrioridadDO")]
	public class Prioridad
	{
		public var id:*;
		public var etiqueta:String;
		
		public function Prioridad()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}