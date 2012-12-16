package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.UnidadOrdenCompraDO")]
	public class UnidadOrdenCompra
	{
		public var id:*;
		public var etiqueta:String;
		
		public function UnidadOrdenCompra()
		{
			id = undefined;
			etiqueta = "";
		}
	}
}