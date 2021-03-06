package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudPermisoDO")]
	public class SolicitudPermiso
	{
		public var id:*;
		public var fechaRegistro:Date;
		public var contratacion:InformacionConfidencialColaborador;
		public var fecha:Date;
		public var formaPagoPrenomina:FormaPagoPrenomina;
		public var fechaHoraSalida:Date;
		public var fechaHoraRetorno:Date;
		public var permisoSinGoceSueldo:PermisoSinGoceSueldo;
		public var permisoConGoceSueldo:PermisoConGoceSueldo;
		public var vistoBuenoJefeInmediato:Boolean;
		public var autorizacion:Boolean;		
		public var comentarios:ArrayCollection;
		public var perfil:Perfil;
				
		public function SolicitudPermiso()
		{
		}
	}
}