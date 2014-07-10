package model
{
	import mx.collections.ArrayCollection;

	public class PartidaSolicitudAlmacen
	{
		public var id:*;
		public var tipoAlmacen:TipoAlmacen;
		public var idAlmacen:*;
		public var codigo:String;
		public var grupoFamilia:String;
		public var descripcion:String;
		public var cantidad:Number;
		public var unidad:String;
		public var regresoAlmacen:Boolean;
		public var observacion:String;
		public var existencia:Number;
		public var cantidadDevuelta:*;
		public var estatusDevolucion:EstatusDevolucion;
		public var fechaDevolucion:Date;
		
		public function PartidaSolicitudAlmacen()
		{
		}
		
		public static function createPartidaSolicitudAlmacen(id:*, tipoAlmacen:TipoAlmacen, idAlmacen:*, codigo:String, 
																grupoFamilia:String, descripcion:String, cantidad:Number, 
																unidad:String, regresoAlmacen:Boolean, observacion:String,
																cantidadDevuelta:*, estatusDevolucion:EstatusDevolucion,
																fechaDevolucion:Date):PartidaSolicitudAlmacen
		{
			var item:PartidaSolicitudAlmacen = new PartidaSolicitudAlmacen();
			item.id = id;
			item.tipoAlmacen = tipoAlmacen;
			item.idAlmacen = idAlmacen;
			item.codigo = codigo;
			item.grupoFamilia = grupoFamilia;
			item.descripcion = descripcion;
			item.cantidad = cantidad;
			item.unidad = unidad;
			item.regresoAlmacen = regresoAlmacen;
			item.observacion = observacion;
			item.cantidadDevuelta = cantidadDevuelta;
			item.estatusDevolucion = estatusDevolucion;
			item.fechaDevolucion = fechaDevolucion;
			return item;
		}
	}
}