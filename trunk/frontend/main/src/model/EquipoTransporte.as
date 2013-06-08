package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EquipoTransporteDO")]
	public class EquipoTransporte
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var fkGrupoFamiliaB:*;
		public var descripcion:String;
		public var noSerie:String;
		public var marca:String;
		public var modelo:String;
		public var noPlacas:String;
		public var noTarjetaCirculacion:String;
		public var fkUbicacionB:*;
		public var fkResponsable:*;
		public var fkEstatusB:*;
		public var fkTipoMantenimiento:*;
		public var fechaMantenimiento:Date;
		public var costo:*;
		
		public var tarjetaCirculacion:ArrayCollection;//DocumentoAlmacen
		public var polizaGarantia:ArrayCollection;//DocumentoAlmacen
		public var polizaSeguro:ArrayCollection;//DocumentoAlmacen
		public var ordenMantenimiento:ArrayCollection;//DocumentoAlmacen
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoalmacen:TipoAlmacen;
		public var grupofamiliab:GrupoFamiliaB;
		public var ubicacionb:UbicacionB;
		public var responsable:Colaborador;
		public var estatusb:EstatusB;
		public var tipomantenimiento:TipoMantenimiento;
		
		public function EquipoTransporte()
		{
		}
	}
}