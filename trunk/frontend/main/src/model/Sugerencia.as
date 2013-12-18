package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SugerenciaDO")]
	public class Sugerencia
	{
		public var id:*;
		public var fecha:Date;
		public var colaborador:Colaborador;
		public var nombre:String;
		public var correoElectronico:String;
		public var telefono:String;
		public var sugerencia:String;
		public var requiereAccionInmediata:Boolean;
		public var accionInmediata:String;
		public var fechaImplementacion:Date;
		public var responsableImplementacion:String;
		public var resultadoImplementacion:ResultadoImplementacion;
		public var requiereAccionCorrectiva:Boolean;
		public var comentariosSugerencia:ArrayCollection;
		
		public function Sugerencia()
		{
		}
	}
}