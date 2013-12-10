package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.FacturaProveedorDO")]
	public class FacturaProveedor
	{
		public var id:*;
		public var fechaFactura:Date;
		public var estadoInvestigacionCalidad:EstadoInvestigacionCalidad;
		public var estadoTesoreria:EstadoTesoreria;
		public var semana:*;
		public var proveedorCalificado:ProveedorCalificado;
		public var ordenCompra:OrdenCompraAlmacen;
		public var proveedorMaquilador:ProveedorMaquilador;
		public var ordenCompraMaquilado:OrdenCompraMaquilado;
		public var numeroFactura:String;
		public var fechaRevision:Date;
		public var fechaPago:Date;
		public var comentariosFacturaProveedor:ArrayCollection;
		public var cantidad:Number;
		
		public function FacturaProveedor(){
			
		}
	}
}