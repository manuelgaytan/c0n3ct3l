package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitanteSolicitudViaticosDO")]
	public class SolicitanteSolicitudViaticos
	{
		public var id:*;
		public var solicitudViaticos:SolicitudViaticos;
		public var colaborador:Colaborador;
		
		public function SolicitanteSolicitudViaticos()
		{
		}
	}
}