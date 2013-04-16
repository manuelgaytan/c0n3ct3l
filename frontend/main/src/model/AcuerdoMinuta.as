package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.AcuerdoMinutaDO")]
	public class AcuerdoMinuta
	{
		public var id:*;
		public var responsableMinuta:ResponsableMinuta;
		public var responsable:String;
		public var acuerdo:String;
		public var fechaCompromiso:Date;
		public var responsableElaboracion:String;
		
		public var minuta:Minuta;
		
		public function AcuerdoMinuta()
		{
		}
	}
}