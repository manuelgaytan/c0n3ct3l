package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MovimientoPagoContableServicioDO")]
	public class MovimientoPagoContableServicio
	{
		public var id:*;
		public var fecha:Date;
		public var descripcionPagoContableServicio:DescripcionPagoContableServicio;
		public var proveedorCalificado:ProveedorCalificado;
		public var proveedorMaquilador:ProveedorMaquilador;
		public var ingreso:*;
		public var egreso:*;
		public var folioDocumento:String;
		public var importe:*;
		public var descuentos:*;
		public var iva:*;
		public var redondeo:*;
		public var isrRetencion:*;
		public var ivaRetencion:*;
		public var otrosImpuestos:*;
		public var totalPagar:*;
		public var fechaLimitePago:Date;
		public var comentarios:ArrayCollection;
	}
}