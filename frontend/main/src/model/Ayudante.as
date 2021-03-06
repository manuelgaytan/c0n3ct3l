package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.AyudanteDO")]
	public class Ayudante
	{
		public var id:*;
		public var proveedorMaquilador:ProveedorMaquilador;
		public var nombre:String;
		public var rfc:String;
		public var curp:String;
		public var nss:String;
		public var documentosAyudante:ArrayCollection;
		
		public function Ayudante()
		{
		}
	}
}