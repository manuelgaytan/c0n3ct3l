package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PerfilDO")]
	public class Perfil
	{
		public var id:*;
		public var etiqueta:String;
		public var perfilPantallas:ArrayCollection;
		
		public function Perfil()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}