package model
{
	import mx.collections.ArrayCollection;
	
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.DatosGrlsProyectoDO")]
	public class DatosGeneralesProyecto
	{
		public var id:*;
		public var proyecto:Proyecto;
		public var divisionRegion:String;
		public var areaGoa:String;
		public var clienteFinal:String;
		public var clienteId:String;
		public var nodoId:String;
		public var grafo:String;
		public var pedidoCliente:String;
		public var elementoPep:String;
		public var responsableCliente:String;
		public var semana:String;
		public var fechaAsignacionCliente:Date;
		public var fechaInicioProgramada:Date;
		public var fechaTerminoProgramada:Date;
		public var reponsableConectel:Colaborador;
		public var material:Aplica;
		public var herramienta:Aplica;
		public var equipo:Aplica;
		public var unidad:Aplica;
		public var viaticos:Aplica;
		public var fechaInicioReal:Date;
		public var fechaTerminoReal:Date;
		public var siteSurvey:String;
		public var entregablesIngenieria:ArrayCollection;
		public var observaciones:ArrayCollection;
		
		public var datosGrlsProyectoImplList:ArrayCollection;
		
		public function DatosGeneralesProyecto()
		{
		}
	}
}