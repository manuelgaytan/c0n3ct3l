package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.NoConformidadDO")]
	public class NoConformidad
	{
		public var id:*;
		public var areaLevantaNoConformidad:AreaLevantaNoConformidad;
		public var usuario:Usuario;
		public var fechaSuceso:Date;
		public var areaNombreSeLevanta:String;
		public var sucesoEvento:String;
		public var dondeOcurrio:String;
		public var cuantoAfecto:String;
		public var causas:String;
		public var correccion:String;
		public var observaciones:String;
		public var requiereAccionCorrectiva:Boolean;
		
		public function NoConformidad()
		{
		}
	}
}