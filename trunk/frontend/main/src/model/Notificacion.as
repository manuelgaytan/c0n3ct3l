package model
{
	import mx.collections.ArrayCollection;

	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.NotificacionDO")]
	public class Notificacion
	{
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