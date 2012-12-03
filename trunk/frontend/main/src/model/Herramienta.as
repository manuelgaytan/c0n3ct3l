package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.HerramientaDO")]
	public class Herramienta
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var fkGrupoFamiliaA:*;
		public var descripcion:String;
		public var noSerie:String;
		public var marca:String;
		public var modelo:String;
		public var existencia:Number;
		public var fkUnidadA:*;
		public var fkUbicacionA:*;
		public var fkResponsable:*;
		public var fkEstatusA:*;
		public var noCertificado:String;
		public var fechaCalibracion:Date;
		public var fechaProximaCalibracion:Date;
		public var fkTipoMantenimiento:*;
		public var fechaMantenimiento:Date;
		
		public var polizaGarantia:ArrayCollection;//DocumentoAlmacen
		public var polizaSeguro:ArrayCollection;//DocumentoAlmacen
		public var certificadoCalibracion:ArrayCollection;//DocumentoAlmacen
		public var ordenMantenimiento:ArrayCollection;//DocumentoAlmacen
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoAlmacen:TipoAlmacen;
		public var grupoFamiliaA:GrupoFamiliaA;
		public var unidadA:UnidadA;
		public var ubicacionA:UbicacionA;
		public var responsable:Colaborador;
		public var estatusA:EstatusA;
		public var tipoMantenimiento:TipoMantenimiento;
		
		public function Herramienta()
		{
		}
	}
}