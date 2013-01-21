package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProyectoEntregableDO")]
	public class ProyectoEntregable
	{
		public var id:*;
		public var entregable:Entregable;
		public var proyecto:Proyecto;
		public var estatus:Number = EstatusProyectoEntregable.ID_PENDIENTE;
		
		public function ProyectoEntregable()
		{
		}
	}
}