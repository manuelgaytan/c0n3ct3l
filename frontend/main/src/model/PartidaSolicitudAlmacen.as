package model
{
	import mx.collections.ArrayCollection;

	public class PartidaSolicitudAlmacen
	{
		public var id:*;
		public var tipoAlmacen:TipoAlmacen;
		public var codigo:String;
		public var grupoFamilia:String;
		public var descripcion:String;
		public var cantidad:String;
		public var unidad:String;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		
		public function PartidaSolicitudAlmacen()
		{
		}
	}
}