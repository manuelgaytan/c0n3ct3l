package model
{
	import mx.collections.ArrayCollection;

	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.MinutaDO")]
	public class Minuta
	{
		public var id:*;
		public var fechaHora:Date;
		public var lugar:String;
		public var asunto:String;
		public var participantesMinuta:ArrayCollection;//List ParticipanteMinuta
		public var acuerdosMinuta:ArrayCollection;//List AcuerdoMinuta

		public function Minuta()
		{
		}
	}
}