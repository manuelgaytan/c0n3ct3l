package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.PartidaConcentradoOrdenCompraClienteDO")]
	public class PartidaConcentradoOrdenCompraCliente
	{
		public var id:*;
		public var concentradoOrdenCompraCliente:ConcentradoOrdenCompraCliente;
		public var item:Number;
		public var codigo:String;
		public var descripcion:String;
		public var precioUnitario:Number;
		public var centralSitio:String;
		public var idSitio:String;
		public var localForaneo:String;
		public var condicionPago:String;
		
		public function PartidaConcentradoOrdenCompraCliente()
		{
		}
	}
}