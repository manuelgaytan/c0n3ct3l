package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProyectoPadreHijoDO")]
	public class ProyectoPadreHijo
	{
		public var id:*;
		public var proyectoPadre:ProyectoPadre;
		public var proyecto:Proyecto;
		
		public function ProyectoPadreHijo()
		{
		}
	}
}