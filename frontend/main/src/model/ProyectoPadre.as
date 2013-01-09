package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProyectoPadreDO")]
	public class ProyectoPadre
	{
		public var id:*;
		public var descripcion:String;
		public var proyectoPadreHijos:ArrayCollection;
		
		public function ProyectoPadre()
		{
		}
	}
}