package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitanteRequisicionDO")]
	public class SolicitanteRequisicion
	{
		public var id:*;
		public var requisicionCompra:RequisicionCompra;
		public var colaborador:Colaborador;
		
		public function SolicitanteRequisicion()
		{
		}
	}
}