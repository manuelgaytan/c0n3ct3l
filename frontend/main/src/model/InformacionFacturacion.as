package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.InformacionFacturacionDO")]
	public class InformacionFacturacion
	{
		public var id:*;
		public var validacionAdministrativa:ValidacionAdministrativa;
		public var folioFactura1:String;
		public var subtotal1:Number;
		public var iva1:Number;
		public var total1:Number;
		public var fechaEmision1:Date;
		public var fechaIngreso1:Date;
		public var diasCredito1:Number;
		public var fechaProgramada1:Date;
		public var estadoPago1:String;
		public var comentariosInformacionFacturacion1:ArrayCollection;
		public var folioFactura2:String;
		public var subtotal2:Number;
		public var iva2:Number;
		public var total2:Number;
		public var fechaEmision2:Date;
		public var fechaIngreso2:Date;
		public var diasCredito2:Number;
		public var fechaProgramada2:Date;
		public var estadoPago2:String;
		public var comentariosInformacionFacturacion2:ArrayCollection;
		public var folioFactura3:String;
		public var subtotal3:Number;
		public var iva3:Number;
		public var total3:Number;
		public var fechaEmision3:Date;
		public var fechaIngreso3:Date;
		public var diasCredito3:Number;
		public var fechaProgramada3:Date;
		public var estadoPago3:String;
		public var comentariosInformacionFacturacion3:ArrayCollection;
		public var estadoFactura:String;
		public var fechaEstadoFactura:Date;
		public var imputabilidad:String;
		
		public function InformacionFacturacion(){
			
		}
	}
}