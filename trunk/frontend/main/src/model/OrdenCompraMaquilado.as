package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.OrdenCompraMaquiladoDO")]
	public class OrdenCompraMaquilado
	{
		public var id:*;
		public var fecha:Date;
		public var cantidad:Number;
		public var descripcion:String;
		public var costoUnitario:Number;
		public var importe:Number;
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
		public var proveedorMaquilador:ProveedorMaquilador;
		public var proyecto:Proyecto;
		public var requisicionCompra:RequisicionCompra;
		public var unidadOrdenCompra:UnidadOrdenCompra;
		
		public function OrdenCompraMaquilado()
		{
		}
	}
}