package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.TipoAlmacenDO")]
	public class TipoAlmacen
	{
		public var id:*;
		public var etiqueta:String;
		
		public function TipoAlmacen( id:* = undefined, etiqueta:String = "")
		{
			this.id = id;
			this.etiqueta = etiqueta;
		}
		
		public static function getHerramienta():TipoAlmacen{
			return new TipoAlmacen(1,"Herramienta");
		}
		
		public static function getEquipoMedicion():TipoAlmacen{
			return new TipoAlmacen(2,"Equipo de Medición");
		}
		
		public static function getEquipoTransporte():TipoAlmacen{
			return new TipoAlmacen(3,"Equipo de Transporte");
		}
		
		public static function getMateriales():TipoAlmacen{
			return new TipoAlmacen(4,"Materiales");
		}
		
		public static function getConsumibles():TipoAlmacen{
			return new TipoAlmacen(5,"Consumibles");
		}
		
		public static function getHardware():TipoAlmacen{
			return new TipoAlmacen(6,"Hardware");
		}
		
		public static function getSoftware():TipoAlmacen{
			return new TipoAlmacen(7,"Software");
		}
		
		public static function getTelefoniaMovil():TipoAlmacen{
			return new TipoAlmacen(8,"Telefonía Móvil");
		}
		
		public static function getSolicitudesAlmacen():TipoAlmacen{
			return new TipoAlmacen(9,"Solicitudes de Almacén");
		}
	}
}