package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProyectoDO")]
	public class Proyecto
	{
		public var id:*;
		public var categoria:Categoria;
		public var producto:Producto;
		public var centralSitio:String;
		public var estado:Estado;
		public var fechaCaptura:Date;
		public var requisiciones:ArrayCollection;
		public var observaciones:ArrayCollection;
		public var proyectoEntregables:ArrayCollection; //ProyectoEntregableDO
		public var proyectoPadreHijo:ProyectoPadreHijo;
		public var estadoSolicitudServicioMaquilado:EstadoSolicitudServicioMaquilado;
		public var validacionProyecto:ValidacionProyecto;
		
		public function Proyecto()
		{
		}
	}
}