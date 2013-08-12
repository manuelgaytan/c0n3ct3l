package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DatosFamiliaresSolicitanteDO")]
	public class DatosFamiliaresSolicitante
	{
		public var id:*;
		public var viveCon:ViveCon;
		public var dependientes:Dependientes;
		
		public var reclutamientoSolicitudEmpleo:ReclutamientoSolicitudEmpleo;
		
		public function DatosFamiliaresSolicitante()
		{
		}
	}
}