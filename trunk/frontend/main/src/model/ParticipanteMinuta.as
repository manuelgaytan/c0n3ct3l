package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ParticipanteMinutaDO")]
	public class ParticipanteMinuta
	{
		public var id:*;
		public var colaborador:Colaborador;
		public var participante:String;
		public var empresa:String;
		public var puesto:String;
		
		public function ParticipanteMinuta()
		{
		}
	}
}