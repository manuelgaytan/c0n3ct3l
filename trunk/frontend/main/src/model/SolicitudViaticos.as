package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudViaticosDO")]
	public class SolicitudViaticos
	{
		public var id:*;
		public var fecha:Date;
		public var proyecto:Proyecto;
		public var solicitantes:ArrayCollection;
		public var medioTransporte:MedioTransporte;
		public var numeroVehiculo:String;
		public var kilometrajeInicial:String;
		public var combustible:*;
		public var casetas:*;
		public var pasajes:*;
		public var hospedaje:*;
		public var alimentos:*;
		public var materialesHerramienta:*;
		public var otros:*;
		public var totalSolicitado:Number;
	}
}