package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.NotificacionDO")]
	public class Notificacion
	{
		public static const MATERIAL_COMPRADO:String = "Se ha comprado el material para la Solicitud Almacen con id: ";
		public static const MATERIAL_COMPRADO_ACUSE:String = "Se ha notificado que se ha comprado el material para la Solicitud Almacen con id: ";
		
		public var id:*;
		public var perfil:Perfil;
		public var fechaHoraCreacion:Date;
		public var fechaHoraModificacion:Date;
		public var notificacion:String;
		public var estado:EstadoNotificacion;
		public var usuarioCreacion:Usuario;
		public var usuarioModificacion:Usuario;

		public function Notificacion()
		{
		}
	}
}