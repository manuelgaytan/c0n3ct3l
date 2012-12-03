package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.UsuarioDO")]
	public class Usuario
	{
		public var id:*;
		public var usuario:String;
		public var contrasena:String;
		public var nombreCompleto:String;
		public var activo:Boolean;
		
		public var perfil:Perfil;
		
		public function Usuario()
		{
		}
		
		public function allowed(idModule:String):Boolean
		{
			if( this.perfil == null ||
				this.perfil.perfilPantallas == null ||
				this.perfil.perfilPantallas.length == 0 || 
				idModule == null){
				return false;
			}
			for each (var i:PerfilPantalla in this.perfil.perfilPantallas) 
			{
				if( i.pantalla.pantalla == idModule ){
					return true;
				}
			}
			return false;
		}
	}
}