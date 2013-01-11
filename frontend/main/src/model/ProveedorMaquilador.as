package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProveedorMaquiladorDO")]
	public class ProveedorMaquilador
	{
		public var id:*;
		public var moneda:Number;
		public var limiteCredito:Number;
		public var diasCredito:Number;
		public var descuentos:Number
		
		public var proveedorSeleccionado:ProveedorSeleccionado;
		public var formaPago:FormaPago;
		public var tipoPago:TipoPago;
		public var datoBancario:DatoBancario;
	}
}