package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.NombreSolicitanteDO")]
	public class NombreSolicitante
	{
		public var id:*;
		public var fkSolicitudAlmacen:*;
		public var fkColaborador:*;
		
		public var solicitudAlmacen:SolicitudAlmacen;
		public var colaborador:Colaborador;
		
		public function NombreSolicitante()
		{
		}
	}
}