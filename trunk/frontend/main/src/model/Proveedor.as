package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProveedorDO")]
	public class Proveedor
	{
		public function Proveedor()
		{
		}
		
		public var id:*;
		
		public var tipoPersona:TipoPersona;
		
		public var nombreComercial:String ;
		
		public var razonSocial:String;
		
		public var rfc:String;
		
		public var direccionFisica:String;
		
		public var direccionFiscal:String;
		
		public var telefonos:String;
	
		public var contacto:String;
		
		public var correo:String;
		
		public var paginaWeb:String;
	}
}