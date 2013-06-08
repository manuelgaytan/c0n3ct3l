package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.ConsumibleDO")]
	public class Consumible
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var fkGrupoFamiliaD:*;
		public var descripcion:String;
		public var existencia:Number;
		public var fkUnidadB:*;
		public var fkUbicacionC:*;
		public var fkResponsable:*;
		public var fkEstatusC:*;
		public var costo:*;
		
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoAlmacen:TipoAlmacen;
		public var grupoFamiliaD:GrupoFamiliaD;
		public var unidadB:UnidadB;
		public var ubicacionC:UbicacionC;
		public var responsable:Colaborador;
		public var estatusC:EstatusC;
		
		public function Consumible()
		{
		}
	}
}