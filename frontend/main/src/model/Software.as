package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.SoftwareDO")]
	public class Software
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var descripcion:String;
		public var noSerie:String;
		public var existencia:*;
		public var unidad:String;
		public var fkUbicacionB:*;
		public var fkResponsable:*;
		public var licenciamientoInicial:Date;
		public var licenciamientoFinal:Date;
		public var costo:*;
		
		public var polizaGarantia:ArrayCollection;//DocumentoAlmacen
		public var polizaSeguro:ArrayCollection;//DocumentoAlmacen
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoAlmacen:TipoAlmacen;
		public var ubicacionB:UbicacionB;
		public var responsable:Colaborador;
		
		public function Software()
		{
		}
	}
}