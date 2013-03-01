package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ConcentradoOrdenCompraClienteDO")]
	public class ConcentradoOrdenCompraCliente
	{
		public var id:*;
		public var cliente:Cliente;
		public var ordenCompra:String;
		public var fechaOrdenCompra:Date;
		public var numRequisicion:Number;
		public var centralSitio:String;
		public var idSitio:String;
		public var localForaneo:String;
		public var condicionPago:String;
		public var partidasConcentradoOrdenCompraCliente:ArrayCollection;
		public var comentariosConcentradoOrdenCompraCliente:ArrayCollection;
	}
}