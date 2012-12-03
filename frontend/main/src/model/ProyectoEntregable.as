package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProyectoEntregableDO")]
	public class ProyectoEntregable
	{
		public var id:*;
		public var entregable:Entregable;
		public var proyecto:Proyecto;
		
		public function ProyectoEntregable()
		{
		}
	}
}