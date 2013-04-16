package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.InformacionFacturacionDO")]
	public class InformacionFacturacion
	{
		public var id:*;
		public var validacionAdministrativa:ValidacionAdministrativa;
		public var folioFactura1:String;
		public var subtotal1:*;
		public var iva1:*;
		public var total1:*;
		public var fechaEmision1:Date;
		public var fechaIngreso1:Date;
		public var diasCredito1:*;
		public var fechaProgramada1:Date;
		public var estadoPago1:String;
		public var comentariosInformacionFacturacion1:ArrayCollection;
		public var folioFactura2:String;
		public var subtotal2:*;
		public var iva2:*;
		public var total2:*;
		public var fechaEmision2:Date;
		public var fechaIngreso2:Date;
		public var diasCredito2:*;
		public var fechaProgramada2:Date;
		public var estadoPago2:String;
		public var comentariosInformacionFacturacion2:ArrayCollection;
		public var folioFactura3:String;
		public var subtotal3:*;
		public var iva3:*;
		public var total3:*;
		public var fechaEmision3:Date;
		public var fechaIngreso3:Date;
		public var diasCredito3:*;
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