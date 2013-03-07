package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.OrdenCompraClienteDO")]
	public class OrdenCompraCliente
	{
		public var id:*;
		public var proyecto:Proyecto;
		public var ordenCompra:Boolean;
		public var numeroOrdenCompra:String;
		public var fecha:Date;
		public var costoOrdenCompra:Number;
		public var estadoValidacionCosto:EstadoValidacionCosto;
		public var comentariosEstadoValidacionCosto:ArrayCollection;
		public var estadoOrdenCompra:EstadoOrdenCompra;
		public var comentariosEstadoOrdenCompra:ArrayCollection;
	}
}