package model
{
	import mx.collections.ArrayCollection;

	[RemoteClass(alias="mx.com.gahm.conenctel.entities.MaterialDO")]
	public class Material
	{
		public var id:*;
		public var fkTipoAlmacen:*;
		public var codigo:String;
		public var fkGrupoFamiliaC:*;
		public var descripcion:String;
		public var existencia:Number;
		public var fkUnidadB:*;
		public var fkUbicacionB:*;
		public var fkResponsable:*;
		public var fkEstatusC:*;
		public var costo:*;
		
		public var comentarios:ArrayCollection;//Comentario
		
		public var tipoAlmacen:TipoAlmacen;
		public var grupoFamiliaC:GrupoFamiliaC;
		public var unidadB:UnidadB;
		public var ubicacionB:UbicacionB;
		public var responsable:Colaborador;
		public var estatusC:EstatusC;
		
		public function Material()
		{
		}
	}
}