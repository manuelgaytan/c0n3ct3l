package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ValidacionAdministrativaDO")]
	public class ValidacionAdministrativa
	{
		public var id:*;
		public var estadoValidacionAdministrativa:EstadoValidacionAdministrativa;
		public var tipoValidacionAdministrativa:TipoValidacionAdministrativa;
		public var porcentaje1:*;
		public var claveValidacion1:String;
		public var fechaValidacion1:Date;
		public var etadoValidacionCobro1:EstadoValidacionCobro;
		public var porcentaje2:*;
		public var claveValidacion2:String;
		public var fechaValidacion2:Date;
		public var etadoValidacionCobro2:EstadoValidacionCobro;
		public var porcentaje3:*;
		public var claveValidacion3:String;
		public var fechaValidacion3:Date;
		public var etadoValidacionCobro3:EstadoValidacionCobro;
		public var porcentajeTotalCobro:*;
		public var etadoValidacionFinal:EstadoFinalValidacion;
		public var imputable:Imputable;
		public var comentariosPantallaValidacionAdministrativa:ArrayCollection;
		public var proyectoPadre:ProyectoPadre;
		public var proyecto:Proyecto;
	}
}