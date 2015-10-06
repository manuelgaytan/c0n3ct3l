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
		public var combustibleAutorizado:*;
		public var casetas:*;
		public var casetasAutorizado:*;
		public var pasajes:*;
		public var pasajesAutorizado:*;
		public var hospedaje:*;
		public var hospedajeAutorizado:*;
		public var alimentos:*;
		public var alimentosAutorizado:*;
		public var materialesHerramienta:*;
		public var materialesHerramientaAutorizado:*;
		public var otros:*;
		public var otrosAutorizado:*;
		public var totalSolicitado:Number;
		public var totalAutorizado:Number;
		public var perfil:Perfil;
	}
}