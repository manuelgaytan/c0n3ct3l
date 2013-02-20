package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ValidacionProyectoDO")]
	public class ValidacionProyecto
	{
		public var id:*;
		public var fecha:Date;
		public var estadoValidacionOperativa:EstadoValidacionOperativa;
		public var proyecto:Proyecto;
	}
}