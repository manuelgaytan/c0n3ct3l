package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PerfilPantallaDO")]
	public class PerfilPantalla
	{
		public var id:*;
		public var pantalla:Pantalla;
		
		public var perfil:Perfil;
		
		public function PerfilPantalla()
		{
		}
	}
}