package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ContactoDO")]
	public class Contacto
	{
		public var id:*;
		public var nombreCompleto:String;
		public var correoElectronico:String;
		public var telefono:String;
		public var paginaWeb:String;
		public var localidad:String;
		public var estado:String;
		
		public function Contacto()
		{
		}
	}
}