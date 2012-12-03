package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ColaboradorDO")]
	public class Colaborador
	{
		public var id:*;
		public var nombreCompleto:String;
		public var tipoColaborador:TipoColaborador;
		
		public function Colaborador()
		{
			id = undefined;
			nombreCompleto = "";
		}
	}
}