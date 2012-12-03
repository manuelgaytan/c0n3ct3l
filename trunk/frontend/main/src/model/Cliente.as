package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ClienteDO")]
	public class Cliente
	{
		public var id:*;
		public var nombreComercial:String;
		public var razonSocial:String;
		public var rfc:String;
		public var domicilioFiscal:String;
		public var contacto:Contacto;
		public var datosComerciales:DatosComerciales;
		
		public function Cliente()
		{
		}
	}
}