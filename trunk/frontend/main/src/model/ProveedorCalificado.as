package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ProveedorCalificadoDO")]
	public class ProveedorCalificado
	{
		
		public var id:*;
		
		public var proveedorSeleccionado:ProveedorSeleccionado;
		
		public var formaPago:FormaPago;
		
		public var tipoPago:TipoPago;
		
		public var moneda:String;
		
		public var limiteCredito:Number;
		
		public var diasCredito:Number;
		
		public var descuentos:Number;
		
		public var datoBancario:DatoBancario;
		
		public var comentariosProovedor:ArrayCollection;	
	}
}