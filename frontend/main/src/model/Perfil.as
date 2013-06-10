package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PerfilDO")]
	public class Perfil
	{
		public static const ID_DIRECTOR_GENERAL:Number = 1;
		public static const ID_ADMINISTRADOR_CATALOGOS:Number = 2;
		public static const ID_ALMACEN:Number = 3;
		public static const ID_RECURSOS_HUMANOS:Number = 4;
		public static const ID_GERENTE_OPERATIVO:Number = 5;
		public static const ID_COORDINADOR_OPERATIVO:Number = 6;
		public static const ID_COMPRAS:Number = 7;
		public static const ID_PUBLICO:Number = 8;
		public static const ID_CUENTAS_POR_PAGAR:Number = 9;
		public static const ID_FACTURACION:Number = 10;
		public static const ID_CONTABILIDAD:Number = 11;
		public static const ID_TESORERIA:Number = 12;
		//public static const ID_RECURSOS_HUMANOS:Number = 13;
		public static const ID_SISTEMAS_GESTION:Number = 14;
		public static const ID_VALIDACION_ADMINISTRATIVA:Number = 15;
		
		public var id:*;
		public var etiqueta:String;
		public var perfilPantallas:ArrayCollection;
		
		public function Perfil()
		{
			id = undefined;
			etiqueta = "";
		}
		
		public static function getPerfil( idPerfil:Number ):Perfil{
			var perfil:Perfil = new Perfil();
			perfil.id = idPerfil;
			return perfil;
		}
	}
}