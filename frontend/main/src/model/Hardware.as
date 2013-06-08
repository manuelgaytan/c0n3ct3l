package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.HardwareDO")]
	public class Hardware
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var fkGrupoFamiliaE:*;
		public var descripcion:String;
		public var noSerie:String;
		public var marca:String;
		public var modelo:String;
		public var existencia:Number;
		public var fkUnidadC:*;
		public var fkUbicacionB:*;
		public var fkResponsable:*;
		public var fkEstatusB:*;
		public var fkTipoMantenimiento:*;
		public var fechaMantenimiento:Date;
		public var costo:*;
		
		public var polizaGarantia:ArrayCollection;//DocumentoAlmacen
		public var polizaSeguro:ArrayCollection;//DocumentoAlmacen
		public var ordenMantenimiento:ArrayCollection;//DocumentoAlmacen
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoAlmacen:TipoAlmacen;
		public var grupoFamiliaE:GrupoFamiliaE;
		public var unidadC:UnidadC;
		public var ubicacionB:UbicacionB;
		public var responsable:Colaborador;
		public var estatusB:EstatusB;
		public var tipoMantenimiento:TipoMantenimiento;
		
		public function Hardware()
		{
		}
	}
}