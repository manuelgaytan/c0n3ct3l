package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DesarrolloProyectoABDO")]
	public class DesarrolloProyecto
	{
		public var id:*;
		public var proyecto:Proyecto;
		public var bastidorGabinete:String;
		public var repisa:String;
		public var version:String;
		public var controladora:String;
		public var tarjeta1:String;
		public var tarjeta2:String;
		public var tarjeta3:String;
		public var tarjeta4:String;
		public var tarjeta5:String;
		public var tarjeta6:String;
		public var puertosOt:String;
		public var noCables:String;
		public var noPares:String;
		public var noPuertos:String;
		public var slotsCables:String;
		public var longitudCable:String;
		public var champeado:String;
		public var timbrado:String;
		public var aterrizaje:String;
		public var alimentacion:String;
		public var paresFo:String;
		public var cableado:String;
		public var rotulo:String;
		public var soportes:Seguimiento;
		public var antena:Seguimiento;
		public var radio:Seguimiento;
		public var radioCable:Seguimiento;
		public var aterrizajeSeguimiento:Seguimiento;
		public var alimentacionSeguimiento:Seguimiento;
		public var fibraClienteFinal:Seguimiento;
		public var planchaBase:Seguimiento;
		public var observaciones:ArrayCollection;
		public var tipoDesarrolloProyecto:TipoDesarrolloProyecto;
		
		public function DesarrolloProyecto()
		{
		}
	}
}