package model
{
	//[RemoteClass(alias="mx.com.gahm.conenctel.entities.InformacionPrenominaDO")]
	public class RegistroDeduccion
	{
		public var id:*;
		public var contratacion:Contratacion;
		public var deduccion:Deduccion;
		public var retardos:*;
		public var fechaRetardo:Date;
		public var faltas:*;
		public var fechaFalta:Date;
		public var clasificacionFalta:ClasificacionFalta;
		public var fechaPermiso:Date;
		public var clasificacionPermiso:ClasificacionPermiso;
		public var tipoSancion:TipoSancion;
		public var formaPagoPrenomina:FormaPagoPrenomina;
		public var montoTotalDescuento:Number;
		public var descuentoParcial:*;
		public var fechaInicio:Date;
		public var fechaTermino:Date;
		
		public function RegistroDeduccion()
		{
		}
	}
}