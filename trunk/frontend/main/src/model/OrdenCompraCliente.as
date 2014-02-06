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
		public var fechaOrdenCompra:Date;
		public var partida:String;
		public var costoOrdenCompra:*;
		public var validacionCosto:EstadoValidacionCosto;
		public var comentarioValidacionCostoOrdenCompraCliente:ArrayCollection;
		public var estadoOrdenCompra:EstadoOrdenCompra;
		public var comentarioOrdenCompraCliente:ArrayCollection;
		public var leyenda:String;
	}
}