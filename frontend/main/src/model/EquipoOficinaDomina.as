package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EquipoOficinaDominaDO")]
	public class EquipoOficinaDomina
	{
		public var id:*;
		public var pc:Boolean;
		public var calculadora:Boolean;
		public var impresora:Boolean;
		public var fax:Boolean;
		public var telefono:Boolean;
		public var scanner:Boolean;
		public var tablet:Boolean;
		public var laptop:Boolean;
		public var otros:Boolean;
		
		public function EquipoOficinaDomina()
		{
		}
	}
}