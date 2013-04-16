package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MinutaDO")]
	public class Minuta
	{
		public var id:*;
		public var fechaHora:Date;
		public var lugar:String;
		public var asunto:String;
		public var participanteMinuta:ArrayCollection;//List ParticipanteMinuta
		public var acuerdoMinuta:ArrayCollection;//List AcuerdoMinuta

		public function Minuta()
		{
		}
	}
}