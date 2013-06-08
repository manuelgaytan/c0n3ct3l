package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EquipoMedicionDO")]
	public class EquipoMedicion
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var grupoFamilia:String;
		public var descripcion:String;
		public var noSerie:String;
		public var marca:String;
		public var modelo:String;
		public var fkUbicacionB:*;
		public var fkResponsable:*;
		public var fkEstatusA:*;
		public var noCertificado:String;
		public var fechaCalibracion:Date;
		public var fechaProximaCalibracion:Date;
		public var fkTipoMantenimiento:*;
		public var fechaMantenimiento:Date;
		public var costo:*;
		
		public var polizaGarantia:ArrayCollection;//DocumentoAlmacen
		public var polizaSeguro:ArrayCollection;//DocumentoAlmacen
		public var certificadoCalibracion:ArrayCollection;//DocumentoAlmacen
		public var ordenMantenimiento:ArrayCollection;//DocumentoAlmacen
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoalmacen:TipoAlmacen;
		public var ubicacionb:UbicacionB;
		public var responsable:Colaborador;
		public var estatusa:EstatusA;
		public var tipomantenimiento:TipoMantenimiento;
		
		public function EquipoMedicion()
		{
		}
	}
}