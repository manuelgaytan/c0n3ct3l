package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SolicitudViaticosDO")]
	public class SolicitudViaticos
	{
		public var id:*;
		public var fecha:Date;
		public var proyecto:Proyecto;
		public var colaborador:Colaborador;
		public var medioTransporte:MedioTransporte;
		public var numeroVehiculo:String;
		public var kilometrajeInicial:String;
		public var combustible:Number;
		public var casetas:Number;
		public var pasajes:Number;
		public var hospedaje:Number;
		public var alimentos:Number;
		public var materialesHerramienta:Number;
		public var otros:Number;
		public var totalSolicitado:Number;
	}
}