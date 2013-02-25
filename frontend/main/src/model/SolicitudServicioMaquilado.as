package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudServicioMaquiladoDO")]
	public class SolicitudServicioMaquilado
	{
		public var id:*;
		public var fecha:Date;
		public var proyectoPadre:ProyectoPadre;
		public var proyecto:Proyecto;
		public var comentariosSolicitudServicioMaquilado:ArrayCollection;
	}
}