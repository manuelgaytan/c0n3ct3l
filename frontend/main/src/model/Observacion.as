package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ObservacionDO")]
	public class Observacion
	{
		public var id:*;
		public var fechaCaptura:Date;
		public var requisicion:String;
		public var usuario:Usuario;
		public var proyecto:Proyecto;
		public var imputable:Imputable;
		public var estado:Estado;
		
		public function Observacion()
		{
		}
	}
}