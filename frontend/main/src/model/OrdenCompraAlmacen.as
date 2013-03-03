package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.OrdenCompraDO")]
	public class OrdenCompraAlmacen
	{
		public var id:*;
		public var fecha:Date;
		public var subtotal:Number;
		public var iva:Number;
		public var ieps:*;
		public var retencionIsr:*;
		public var retencionIva:*;
		public var otrosImpuestos:*;
		public var total:Number;
		public var fechaEntregaAlmacen:Date;
		
		public var comentarios:ArrayCollection;//Comentario
		
		public var cotizacion:Cotizacion;
		public var proveedorCalificado:ProveedorCalificado;
		public var proyecto:Proyecto;
		public var requisicionCompra:RequisicionCompra;
		
		public function OrdenCompraAlmacen()
		{
		}
	}
}