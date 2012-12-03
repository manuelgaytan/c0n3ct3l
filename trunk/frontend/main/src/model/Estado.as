package model
{
	[RemoteClass(alias="mx.com.gahm.conenctel.entities.EstadoDO")]
	public class Estado
	{
		public var id:*;
		public var etiqueta:String;
		public static var ID_ALTA:Number = 1;
		public static var ID_DATOS_GENERALES:Number = 2;
		public static var ID_DESARROLLO_PROYECTO_A_Y_B:Number = 3;
		public static var ID_CONFIGURACION_PRUEBA_Y_ENTREGA:Number = 4;
		public static var ID_CERRADO:Number = 5;
		public static var ID_CANCELADO:Number = 6;
		public static var ALTA:String = "Alta";
		public static var DATOS_GENERALES:String = "Datos Generales";
		public static var DESARROLLO_PROYECTO_A_Y_B:String = "Desarrollo Proyecto A y B";
		public static var CONFIGURACION_PRUEBA_Y_ENTREGA:String = "Confguración Prueba y Entrega";
		public static var CERRADO:String = "Cerrado";
		public static var CANCELADO:String = "Cancelado";
		
		public function Estado()
		{
		}
	}
}