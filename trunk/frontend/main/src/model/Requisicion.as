package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.RequisicionDO")]
	public class Requisicion
	{
		public var id:*;
		public var requisicion:String;
		public var proyecto:Proyecto;
		
		public function Requisicion()
		{
		}
	}
}